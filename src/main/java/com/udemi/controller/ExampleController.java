package com.udemi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemi.component.ExampleComponent;
import com.udemi.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	// primera forma
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}

	// segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mv = new ModelAndView(EXAMPLE_VIEW);
		mv.addObject("people", exampleService.getListPeople());
		return mv;
	}
}
