package com.example.test.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("titulo", "Soy el titulo");
		model.addAttribute("saludo", "Soy el titulo");
		model.addAttribute("show", false);
		// List<String> series = List.of("Dexter", "Games of Thrones", "Vikings");
		// model.addAttribute("series", series);
		return "index";
	}

	@GetMapping(value = "/index-mv")
	public ModelAndView indexMV(ModelAndView mv) {
		mv.addObject("titulo", "Titulo de MV");
		mv.addObject("saludo", "Saludo de MV");
		mv.addObject("show", true);

		// List<String> series = List.of("Dexter", "Games of Thrones", "Vikings");
		// mv.addObject("series", series);

		mv.setViewName("index");

		return mv;
	}

	@ModelAttribute("series")
	public List<String> getSeries() {
		return List.of("Dexter", "Games of Thrones", "Vikings", "Flash", "The Last Of Us");
	}

	@PostMapping(value = "/index-post")
	public String indexRequestMapping() {
		return "index";
	}
}