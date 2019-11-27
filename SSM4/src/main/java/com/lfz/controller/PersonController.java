package com.lfz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lfz.entity.Person;

@Controller
@RequestMapping(value = "/hello")
public class PersonController {
	@RequestMapping(value = "/testPerson", method = RequestMethod.POST)
	public String testPerson(Person person) {

		System.out.println(person);
		return "success";
	}

}
