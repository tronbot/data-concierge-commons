package com.chpinfo.dc.commons.json

import org.apache.commons.lang3.builder.ReflectionToStringBuilder

import groovy.util.logging.Log4j

/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a> 
 * @date Feb 13, 2017
 */
@Log4j
class ArrayToStringInterpreter implements Interpreter<String> {
	String interpret(Object raw){
		if(null != raw){
			if(raw instanceof List){
				return raw.join(', ')
			}else{
				throw new UnexpectedValueException(List.class, raw?.getClass())
			}
		}
		return raw
	}
}
