package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index(){
		return "viral";
	}
	
	@RequestMapping("/challange")
	public String challange(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name", name);
		return "challange";
	}
	
	@RequestMapping(value = {"/challange", "/challange/{name}"})
	public String challangePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challange";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value="a", defaultValue = "0") String jmlA, 
			@RequestParam(value="b", defaultValue = "0") String jmlB, Model model) {
		model.addAttribute("jmlA", jmlA);
		model.addAttribute("jmlB", jmlB);
		
		String val = "hm";
		for (int a = 1; a < Integer.parseInt(jmlA); a++) {
			val = val + "m";
		}
		String output = val;
		for (int b = 1; b < Integer.parseInt(jmlB); b++) {
			output = output + " " + val;
		}
		model.addAttribute("output", output);
		return "generator";
	}
}
