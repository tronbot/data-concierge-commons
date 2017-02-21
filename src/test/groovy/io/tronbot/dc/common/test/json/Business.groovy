package io.tronbot.dc.common.test.json

import io.tronbot.dc.common.json.ArrayToSingleInterpreter
import io.tronbot.dc.common.json.ArrayToStringInterpreter
import io.tronbot.dc.common.json.JsonPathElement


/**
 * @author <a href='mailto:juanyo
 import com.jayway.jsonpath.JsonPathng.zhang@gmail.com'>Juanyong Zhang</a> 
 * @date Feb 6, 2017
 */
@JsonPathElement('$.result')
public class Business{
	Long id
	@JsonPathElement('$.place_id')
	String placeId
	@JsonPathElement('$.name')
	String name
	@JsonPathElement('$.website')
	String website
	@JsonPathElement('$.url')
	String googleMapURL
	@JsonPathElement('$.formatted_phone_number')
	String phone
	@JsonPathElement('$.formatted_address')
	String address
	@JsonPathElement
	Address addr
	@JsonPathElement(value = '$.address_components[?(\'street_number\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String streetNumber
	@JsonPathElement(value = '$.address_components[?(\'route\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String streetName
	@JsonPathElement(value = '$.address_components[?(\'locality\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String city
	@JsonPathElement(value = '$.address_components[?(\'administrative_area_level_2\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String county
	@JsonPathElement(value = '$.address_components[?(\'administrative_area_level_1\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String state
	@JsonPathElement(value = '$.address_components[?(\'postal_code\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String postalCode
	@JsonPathElement(value = '$.address_components[?(\'postal_code_suffix\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String postalCodeSuffix
	@JsonPathElement(value = '$.address_components[?(\'country\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String country
	@JsonPathElement(value = '$.types', interpreter=ArrayToStringInterpreter.class)
	String types
	@JsonPathElement('$.geometry.location.lat')
	Double latitude
	@JsonPathElement('$.geometry.location.lng')
	Double longitude
	Date timestamp = new Date()
}

class Address{
	@JsonPathElement(value = '$.address_components[?(\'street_number\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String streetNumber
	@JsonPathElement(value = '$.address_components[?(\'route\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String streetName
	@JsonPathElement(value = '$.address_components[?(\'locality\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String city
	@JsonPathElement(value = '$.address_components[?(\'administrative_area_level_2\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String county
	@JsonPathElement(value = '$.address_components[?(\'administrative_area_level_1\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String state
	@JsonPathElement(value = '$.address_components[?(\'postal_code\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String postalCode
	@JsonPathElement(value = '$.address_components[?(\'postal_code_suffix\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String postalCodeSuffix
	@JsonPathElement(value = '$.address_components[?(\'country\' in @.types )].long_name', interpreter=ArrayToSingleInterpreter.class)
	String country
}