package co.grandcircus.Lab24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Lab24.dao.PersonDAO;
import co.grandcircus.Lab24.model.Person;

@Controller
public class HomeController {

	@Autowired
	PersonDAO dao;

	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("registration");
		return mv;
	}

	@RequestMapping("/summary")
	public ModelAndView formDeets(Person p) {
		ModelAndView mv = new ModelAndView("summary");
		mv.addObject("user", "Hello " + p.getFirstName() + " " + p.getLastName() + "! Thanks for registering");
		mv.addObject("email", "Email: " + p.getEmail());
		mv.addObject("phoneNumber", "Phone Number: " + p.getPhoneNumber());
		return mv;
	}

	@RequestMapping("/summary")
	public ModelAndView addUser(Person p) {
		dao.addPerson(p.getFirstName(), p.getLastName(), p.getEmail(), p.getPhoneNumber(), p.getPassword());
		return new ModelAndView("redirect:/summary");
	}

}