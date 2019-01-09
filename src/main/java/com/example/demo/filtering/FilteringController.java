package com.example.demo.filtering;

import java.util.List;

import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListBean() {
		//make sure u import java.util.arrays here
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value10","value20","value30")
				);
	}
}
