package com.cognizant.hi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.hi.model.Clinic;
import com.cognizant.hi.service.ClinicService;




@Controller
//@RequestMapping("/customer")
@SessionAttributes("clinic")
public class ClinicController
{
	
		@Autowired
		ClinicService clinicService;

		// for the first time,container checks whether user attribute is exists in the
		// session.If not this method will be called,
		// user object created and stored in the session. For the next request, user
		// object will be retrieved from the system
		@ModelAttribute("clinic")
		public Clinic getClinic() {
			return new Clinic();
		}

//		
//		@RequestMapping("/getClinic")
//		public String getProducts(ModelMap model)
//		{   
//			List <Clinic> clinicList=clinicService.fetchClinics();
////				if(clinicList.isEmpty())
////			throw new NoDataFoundException();
//			model.addAttribute("clinicList",clinicList);
//			//return "updateDoctor";
//		}

		

		@RequestMapping(value = "/showclinic", method = RequestMethod.GET)
		public String createClinic(Model model) {
			model.addAttribute("clinic", new Clinic());
			return "addclinic";
			// return new ModelAndView("login", "command", new User());
		}

		@RequestMapping(value = "/saveclinic", method = RequestMethod.POST)
		public String addClinic(@ModelAttribute("clinic") Clinic clinic,RedirectAttributes attributes) {
			boolean result = clinicService.addClinic(clinic);
			System.out.println("result=" + result);
			// model.addAttribute("user", new UserDto());
			attributes.addFlashAttribute("message", "New Clinic Added successfully.");
			return "redirect:/home";
			// return new ModelAndView("login", "command", new User());
		}
		
		
		


}
