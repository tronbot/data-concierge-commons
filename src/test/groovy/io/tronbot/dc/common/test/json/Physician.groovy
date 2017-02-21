package io.tronbot.dc.common.test.json


import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.builder.ReflectionToStringBuilder

import io.tronbot.dc.common.json.JsonPathElement
import io.tronbot.dc.common.json.JsonPathReflector

/**
 * @author <a href="mailto:juanyong.zhang@gmail.com">Juanyong Zhang</a> 
 * @date Feb 17, 2017
 */

@JsonPathElement('$.results[0]')
public class Physician  {
	@JsonPathElement('$.number')
	Integer npi
	@JsonPathElement('$.basic.first_name')
	String firstName
	@JsonPathElement('$.basic.last_name')
	String lastName
	@JsonPathElement('$.basic.name')
	String orgName
	@JsonPathElement('$.basic.gender')
	String gender
	@JsonPathElement('$.taxonomies')
	List<License> licenses
	@JsonPathElement('$.taxonomies')
	List<License> licenses2
	//	@JsonPathElement(value='$.taxonomies')
	License[] licenseArray
	@JsonPathElement(value='$.taxonomies')
	List<String> licenseStrs
	@JsonPathElement(value='$.taxonomies')
	List<?> licenseJsons
	@JsonPathElement('$.identifiers')
	List<ProductType> productTypes
	Business business
	@JsonPathElement('$.basic')
	Basic basicInfo
}

public class Basic{
	@JsonPathElement('$.status')
	String status
	@JsonPathElement('$.credential')
	String credential
	@JsonPathElement('$.first_name')
	String first_name
	@JsonPathElement('$.last_name')
	String last_name
	@JsonPathElement('$.last_updated')
	String last_updated
	@JsonPathElement('$.name')
	String name
}

class License{
	@JsonPathElement('$.license')
	String license
	@JsonPathElement('$.state')
	String state
	@JsonPathElement('$.desc')
	String speciality
	@JsonPathElement('$.primary')
	Boolean primary
}

class ProductType{
	String desc
	String id
	String state
}