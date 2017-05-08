package com.chpinfo.dc.commons.json;
/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a> 
 * @date Feb 13, 2017
 */
public interface Interpreter<T> {
	T interpret(Object raw) throws UnexpectedValueException;
}
