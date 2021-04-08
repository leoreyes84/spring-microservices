package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//Approach 1 - Static filtering
//	@GetMapping("/filtering")
//	public SomeBean retreiveSomeBean() {
//		return new SomeBean("value1", "value2", "value3", "value4");
//	}
//	
//	@GetMapping("/filtering-list")
//	public List<SomeBean> retreiveListOfSomeBean() {
//		return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4"),
//				new SomeBean("value12", "value22", "value32", "value42"));
//	}
	
	//Approach 2 -  Dynamic filtering
	@GetMapping("/filtering")
	public MappingJacksonValue retreiveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retreiveListOfSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3", "value4"),
				new SomeBean("value12", "value22", "value32", "value42"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
	

}
