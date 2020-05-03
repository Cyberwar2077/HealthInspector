package com.cognizant.hi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.hi.entity.AppointmentEntity;
import com.cognizant.hi.model.Clinic;
import com.cognizant.hi.model.Doctor;
import com.cognizant.hi.model.User;
import com.cognizant.hi.model.UserLogin;
import com.cognizant.hi.service.AppointmentService;
import com.cognizant.hi.service.ClinicService;
import com.cognizant.hi.service.DoctorService;
import com.cognizant.hi.service.UserService;

@Controller
//@RequestMapping("/customer")
@SessionAttributes({ "user", "userLogin" })
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	ClinicService clinicService;

	@Autowired
	AppointmentService appointmentService;

	// for the first time,container checks whether user attribute is exists in the
	// session.If not this method will be called,
	// user object created and stored in the session. For the next request, user
	// object will be retrieved from the syste

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@ModelAttribute("userLogin")
	public UserLogin getUserLogin() {
		return new UserLogin();
	}

	@ModelAttribute("doctor")
	public Doctor getDoctor() {
		return new Doctor();
	}

	@ModelAttribute("clinic")
	public Clinic getClinic() {
		return new Clinic();
	}

	@RequestMapping(value = "/showregister", method = RequestMethod.GET)
	public String createRegistration(Model model) {
		model.addAttribute("user", new User());
		return "register";
		// return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		boolean result = userService.saveUser(user);
		System.out.println("result=" + result);
		// model.addAttribute("user", new UserDto());
		return "NewUser";
		// return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String createLogin(Model model) {
		model.addAttribute("userLogin", new UserLogin());
		return "login";
		// return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute("redirect") String redirect, RedirectAttributes redirectAttributes,
			@SessionAttribute(name = "userLogin", required = false) UserLogin usr, ModelMap model,
			@ModelAttribute("message") String message) {
		if (redirect != null && !redirect.equals("")) {
			if (redirect.equals("doctorHome")) {
				List<AppointmentEntity> appointments = appointmentService.fetchPendingAppointments(usr.getUserid());
				model.addAttribute("appointments", appointments);
				model.addAttribute("appointment", new AppointmentEntity());
			}
			return redirect;
		}
		if (usr == null || usr.getUserid() == null || usr.getPassword() == null) {
			return "redirect:/login";
		}
		UserLogin user = usr;
		String result = "";
		String result1 = extracted(user, model, redirectAttributes, usr, result);
		if (result1.contains("Home"))
			model.addAttribute("message", message);
		if (result1.equals("doctorHome")) {
			List<AppointmentEntity> appointments = appointmentService.fetchPendingAppointments(usr.getUserid());
			model.addAttribute("appointments", appointments);
			model.addAttribute("appointment", new AppointmentEntity());
		}
		return result1;
		// return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateLogin(@Valid @ModelAttribute("userLogin") UserLogin user, BindingResult bresult,
			ModelMap model, RedirectAttributes redirectAttributes, @SessionAttribute("userLogin") UserLogin usr) {
		String result = "";
		if (bresult.hasErrors()) {

			return "login";
		}

		else {
			String result1 = extracted(user, model, redirectAttributes, usr, result);
			if (result1.contains("Home"))
				return "redirect:home";
			return "redirect:/" + result1;
		}

	}

	private String extracted(UserLogin user, ModelMap model, RedirectAttributes redirectAttributes, UserLogin usr,
			String result) {
		// System.out.println("method called");
		String user_category = userService.validateUser(user);
		System.out.println("category=" + user_category);
		if (user_category != null) {
//			model.addAttribute("msg",usr.getUserid());

			if (user_category.equals("Admin")) {

				result = "adminHome";
			}

			else if (user_category.equals("Doctor")) {
				result = "doctorHome";
			}

			else if (user_category.equals("Patient")) {
				result = "patientHome";
			}
			redirectAttributes.addFlashAttribute("redirect", result);
			return result;
		}

		else {
			redirectAttributes.addFlashAttribute("uname", "Invalid username/password");
			return "login";
		}
	}

	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String returnHome(Model model) {
		return "adminHome";
	}

}
