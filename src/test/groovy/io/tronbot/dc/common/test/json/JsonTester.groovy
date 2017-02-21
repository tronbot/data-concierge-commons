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
	public void testBusiness() throws Exception{
		URL url = new URL('https://maps.googleapis.com/maps/api/place/details/json?key=AIzaSyCzR2RLfJp-fF1Ui0tPRwKXLNWTDXDUu3E&placeid=ChIJP_65xt8G3IARg_RH0jTJpHY')
		JsonPathReflector jr = new JsonPathReflector()
		Business biz = jr.from(IOUtils.toString(url), new Business())
		println ReflectionToStringBuilder.reflectionToString(biz);
	}

	@Test
	public void testPhysician() throws Exception{
		URL url = new URL('https://npiregistry.cms.hhs.gov/api?number=&enumeration_type=NPI-1&taxonomy_description=&first_name=TONY&last_name=HWANG&organization_name=&address_purpose=&city=INDIO&state=CA&postal_code=92201&country_code=US&limit=20&skip=&pretty=')
		JsonPathReflector jr = new JsonPathReflector()
		Physician obj = jr.from(IOUtils.toString(url), new Physician())
		println ReflectionToStringBuilder.reflectionToString(obj);
	}
}
