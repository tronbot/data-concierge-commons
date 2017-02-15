package io.tronbot.dc.common.test.json

import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.junit.Test

import groovy.util.logging.Log4j
import io.tronbot.dc.common.json.JsonPathReflector

/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a> 
 * @date Feb 13, 2017
 */
@Log4j
class JsonTester {
	@Test
	public void testReflector() throws Exception{
		URL url = new URL('https://maps.googleapis.com/maps/api/place/details/json?key=AIzaSyCzR2RLfJp-fF1Ui0tPRwKXLNWTDXDUu3E&placeid=ChIJP_65xt8G3IARg_RH0jTJpHY')
		JsonPathReflector jr = new JsonPathReflector()
		Business biz = jr.from(IOUtils.toString(url), new Business())
		println ReflectionToStringBuilder.reflectionToString(biz);
	}
}
