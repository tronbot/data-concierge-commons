package io.tronbot.dc.common.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a>
 * @date Feb 13, 2017
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonPathField {
	String value();

	Class<? extends Interpreter<?>> interpreter() default EmptyInterpreter.class;

	boolean required() default false;

	class EmptyInterpreter implements Interpreter<Object> {
		public Object interpret(Object raw) {
			return raw;
		}
	}
}
