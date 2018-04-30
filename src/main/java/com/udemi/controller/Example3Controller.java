package com.udemi.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemi.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	public static final String FORM_VIEW="form";
	public static final String RESULT_VIEW="result";
	
	private static final Log LOGGER=LogFactory.getLog(Example3Controller.class);
	
	// PRIMERA FORMA
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	}*/
	
	// SEGUNDA FORMA MEDIANTE EL OBJETO REDIRECT
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		
		model.addAttribute("persona",new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("persona") Person person, 
			BindingResult bindingResult){
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '"+person+"'");
		ModelAndView mv=new ModelAndView(RESULT_VIEW);
		if(bindingResult.hasErrors()) {
			mv.setViewName(FORM_VIEW);
		}else {
			mv.setViewName(RESULT_VIEW);
			mv.addObject("person",person);
		}
		LOGGER.info("TEMPLATE: '"+RESULT_VIEW+"' -- DATA: '"+person+"'");
		return mv;
	}
}
