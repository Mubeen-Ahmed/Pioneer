package com.pioneer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.pioneer.model.Pioneer;
import com.pioneer.model.PioneerCredentials;
import com.pioneer.service.PioneerService;

@Controller
public class MyController {
	
	
	
	@Autowired
	private PioneerService pioneerservice;

	public PioneerService getPioneerservice() {
		return pioneerservice;
	}

	public void setPioneerservice(PioneerService pioneertservice) {
		this.pioneerservice = pioneerservice;
	}


	

	
	@RequestMapping(value = { "/", "/home" },method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}
	@RequestMapping(value = { "/", "/list" },method=RequestMethod.GET)
	public String listPage(){
		return "list";
	}
	@RequestMapping(value = { "/", "/contact" },method=RequestMethod.GET)
	public String contactPage(){
		return "contact";
	}
	@RequestMapping(value = { "/", "/about" },method=RequestMethod.GET)
	public String aboutPage(){
		return "about";
	}
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("pioneercredentials", new PioneerCredentials());
		return "login";
	}
	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("pioneer", new Pioneer());
		return "register";
	}

	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("pioneer") Pioneer pioneer,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		getPioneerservice().registerPioneer(pioneer);
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("pioneer", pioneer);
		return modelAndView;
	}
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("pioneercredentials") PioneerCredentials pioneercredentials,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("list");
		Pioneer pioneer = getPioneerservice().validatePioneerCredential(pioneercredentials.getEmail(), pioneercredentials.getPassword());
		if(pioneer!= null){
			modelAndView.addObject("pioneer", pioneer);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}
	
	
	@ModelAttribute
	public void headerMessage(Model model){

		
		
		
		List<String> stateList = new ArrayList<>();
	
stateList.add("Alabama"); 
stateList.add("Alaska");
stateList.add("Arizona"); 
stateList.add("Arkansas");
stateList.add("California"); 
stateList.add("Colorado"); 
stateList.add("Connecticut"); 
stateList.add("Delaware"); 
stateList.add("Florida"); 
stateList.add("Georgia"); 
stateList.add("Hawaii"); 
stateList.add("Idaho"); 
stateList.add("Illinois Indiana"); 
stateList.add("Iowa"); 
stateList.add("Kansas"); 
stateList.add("Kentucky"); 
stateList.add("Louisiana"); 
stateList.add("Maine"); 
stateList.add("Maryland"); 
stateList.add("Massachusetts"); 
stateList.add("Michigan"); 
stateList.add("Minnesota"); 
stateList.add("Mississippi"); 
stateList.add("Missouri"); 
stateList.add("Montana Nebraska"); 
stateList.add("Nevada"); 
stateList.add("New Hampshire"); 
stateList.add("New Jersey"); 
stateList.add("New Mexico"); 
stateList.add("New York"); 
stateList.add("North Carolina"); 
stateList.add("North Dakota"); 
stateList.add("Ohio"); 
stateList.add("Oklahoma"); 
stateList.add("Oregon"); 
stateList.add("Pennsylvania Rhode Island"); 
stateList.add("South Carolina"); 
stateList.add("South Dakota"); 
stateList.add("Tennessee"); 
stateList.add("Texas"); 
stateList.add("Utah"); 
stateList.add("Vermont"); 
stateList.add("Virginia"); 
stateList.add("Washington"); 
stateList.add("West Virginia"); 
stateList.add("Wisconsin"); 
stateList.add("Wyoming");
		
	
		model.addAttribute("stateList", stateList);
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "home";
    }
	
	/*@RequestMapping(value = "/experience", method = RequestMethod.GET)
	public String experiencePage(Model model){
		model.addAttribute("experience", new Experience());
		return "experience";
	}
	
	@RequestMapping(value="/etchingitt", method=RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("etchingit")EtchingIT etchingit, BindingResult bindingResult)
	 {
		if(bindingResult.hasErrors()){
			return new ModelAndView("home");
		}
	  
		getEtchingitservice().registerEtchingIT(etchingit);
		ModelAndView modelAndView = new ModelAndView("etchingit");
		modelAndView.addObject("etchingit", etchingit);
		return modelAndView;
	 }*/
	
	@RequestMapping(value = "/")
    public ModelAndView listPioneer(ModelAndView model) throws IOException {
        List<Pioneer> listPioneer = pioneerservice.getAll();
        model.addObject("listPioneer", listPioneer);
        model.setViewName("home");
        return model;
    }
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
		Pioneer pioneer = new Pioneer();
        model.addObject("pioneer", pioneer);
        model.setViewName("register");
        return model;
    }
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Pioneer pioneer) {
        if (pioneer.getId() != 0) { // if employee id is 0 then creating the
            // employee other updating the employee
        	pioneerservice.addPioneer(pioneer);
        } else {
        	pioneerservice.updatePioneer(pioneer);
        }
        return new ModelAndView("list");
    }
 
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deletePioneer(HttpServletRequest request) {
        int pioneerId = Integer.parseInt(request.getParameter("id"));
        pioneerservice.deletePioneer(pioneerId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int pioneerId = Integer.parseInt(request.getParameter("id"));
        Pioneer pioneer = pioneerservice.getPioneer(pioneerId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("pioneer", pioneer);
 
        return model;
    }
}
