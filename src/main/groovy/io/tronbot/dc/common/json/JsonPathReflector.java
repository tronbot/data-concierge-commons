package io.tronbot.dc.common.json;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import io.tronbot.dc.common.json.JsonPathField.EmptyInterpreter;

/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a>
 * @date Feb 13, 2017
 */
public class JsonPathReflector {
	private static final Logger logger = LoggerFactory.getLogger(JsonPathReflector.class);

	private final Configuration configuration;

	public JsonPathReflector() {
		super();
		this.configuration = Configuration.defaultConfiguration();
	}

	public JsonPathReflector(Configuration configuration) {
		super();
		this.configuration = configuration;
	}

	public <T> T from(String json, T obj) {
		return eval(JsonPath.parse(json, configuration), obj);
	}

	public static <T> T read(String json, String jsonPath, Predicate... filters) {
		return JsonPath.read(json, jsonPath, filters);
	}

	private <T> T eval(DocumentContext doc, T obj) {
		// Handle for java lang type fields
		FieldUtils.getAllFieldsList(obj.getClass()).stream()
				.filter(f -> null != f.getAnnotation(JsonPathField.class)
						&& Package.getPackage("java.lang").equals(f.getType().getPackage()))
				.forEach(f -> {
					JsonPathField jpath = f.getAnnotation(JsonPathField.class);
					try {
						Object value = readValue(doc, jpath);
						FieldUtils.writeField(f, obj, value, true);
					} catch (Exception e) {
						logger.info("Json path field %s:%s can't not be evaluated",
								f.getName(), f.getType());
						if (jpath.required()) {
							throw new RuntimeException(e);
						}
					}
				});
		// Handle for Custom type fields
		FieldUtils.getAllFieldsList(obj.getClass()).stream()
				.filter(f -> null != f.getAnnotation(JsonPathField.class)
						&& !Package.getPackage("java.lang").equals(f.getType().getPackage()))
				.forEach(f -> {
					JsonPathField jpath = f.getAnnotation(JsonPathField.class);
					try {
						// Invoke the default constructor
						Object rawObj = ConstructorUtils.invokeConstructor(f.getType());
						// Recursively invoke eval for custom object
						FieldUtils.writeField(f, obj, eval(doc, rawObj), true);
					} catch (ReflectiveOperationException e) {
						logger.warn("Json path field %s:%s must have a default public constructor",
								f.getName(), f.getType());
						if (jpath.required()) {
							throw new RuntimeException(e);
						}
					}
				});
		return obj;
	}

	private Object readValue(DocumentContext doc, JsonPathField jpath) throws ReflectiveOperationException {
		Object val = doc.read(jpath.value());
		if (!jpath.interpreter().equals(EmptyInterpreter.class)) {
			val = ConstructorUtils.invokeConstructor(jpath.interpreter()).interpret(val);
		}
		return val;
	}
}
