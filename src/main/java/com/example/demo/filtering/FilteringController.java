package com.example.demo.filtering;

import java.util.List;

import java.util.Arrays;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		
		//this is dynamic filtering
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		//after this you have to defin the list of valid filters inside the SomeBean class
		return mapping;
	}
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListBean() {
		//make sure u import java.util.arrays here
		List<SomeBean>  list = Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value10","value20","value30")
				);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}
}
