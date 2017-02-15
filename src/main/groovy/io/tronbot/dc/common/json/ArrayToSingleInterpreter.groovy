package io.tronbot.dc.common.json

import org.apache.commons.lang3.builder.ReflectionToStringBuilder

import groovy.util.logging.Log4j

/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a> 
 * @date Feb 13, 2017
 */
@Log4j
class ArrayToSingleInterpreter implements Interpreter<String> {
	String interpret(Object raw){
		if(raw instanceof List){
			if(raw){
				return raw.first().toString()
			}else{
				return null;
			}
		}else{
			log.warn "${ReflectionToStringBuilder.toString(raw)} is not JSON array!"
		}
		return raw
	}
}
