package com.cognizant.hi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.hi.entity.AppointmentEntity;
import com.cognizant.hi.entity.ClinicEntity;
import com.cognizant.hi.entity.DoctorEntity;
import com.cognizant.hi.entity.UserEntity;
import com.cognizant.hi.model.Clinic;
import com.cognizant.hi.model.Doctor;
import com.cognizant.hi.model.UserLogin;
import com.cognizant.hi.service.AppointmentService;
import com.cognizant.hi.service.ClinicService;
import com.cognizant.hi.service.DoctorService;

@Controller
@SessionAttributes("doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	ClinicService clinicService;
	
	@Autowired
	AppointmentService appointmentService;
	
	@ModelAttribute("doctor")
	public Doctor getDoctor() {
		return new Doctor();
	}
	

	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String createClinic(Model model, @SessionAttribute("userLogin") UserLogin usr) {
		model.addAttribute("doctor", new Doctor());
		model.addAttribute("userid",usr.getUserid());
		List<ClinicEntity> clinicList=clinicService.fetchClinicDetails();
		model.addAttribute("clinicList", clinicList);
		return "updateDoctor";
		// return new ModelAndView("login", "command", new User());
	}
	
	@RequestMapping(value = "/savedoctor", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor,RedirectAttributes attributes) {
		System.out.println("clinic id="+doctor.getClinicId());
		boolean result = doctorService.addDoctor(doctor);
		System.out.println("result=" + result);
		// model.addAttribute("user", new UserDto());
		attributes.addFlashAttribute("message", "New user created successfully.");
		return "redirect:/home";
		// return new ModelAndView("login", "command", new User());
	}
	
	
	
	
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String search(Model model)
	{
            return "search";
	}
	
	@RequestMapping(value = "/SbS", method = RequestMethod.GET)
	public String SbS(Model model,@ModelAttribute("doctor") Doctor doctor,RedirectAttributes attributes)
	{
		model.addAttribute("doctor", new Doctor());
		List<String> specialityList=doctorService.fetchSpeciality();
		model.addAttribute("specialityList", specialityList);
	//	model.addAttribute("doctor",new Doctor());
		return "searchSpeciality";
	}
	
	@RequestMapping(value = "/getDoctors", method = RequestMethod.POST)
	public String getDoctors(Model model,@RequestBody String speciality,RedirectAttributes attributes)
	{
		speciality=speciality.substring(11,speciality.length());
		List<DoctorEntity> doctorList=doctorService.fetchDoctorBySpeciality(speciality);
		List<UserEntity> doctors=new ArrayList<>();
		if(doctorList!=null) {
			doctorList.forEach(doctor1->{
				UserEntity user=doctor1.getUserid();
				boolean flag=true;
				for(UserEntity uniqueDoctor:doctors) {
					if(uniqueDoctor.getUserid()==user.getUserid())
						flag=false;
				}
				if(flag)
					doctors.add(user);
			});
		}
		model.addAttribute("doctorModel", new UserEntity());
		model.addAttribute("doctorList", doctors);
		return "doctorsList";
	}
	
	

	
	
	@RequestMapping(value = "/SbF", method = RequestMethod.GET)
	public String SbF(Model model,@ModelAttribute("clinic") Clinic clinic,RedirectAttributes attributes)
	{
	
		List<ClinicEntity> clinicList=clinicService.fetchClinicDetails();
		model.addAttribute("clinicList", clinicList);
		return "searchFacility";
	}
	
	
//	@RequestMapping(value = "/SbL", method = RequestMethod.GET)
//	public String SbL(Model model)
//	{
//	return "searchLocality";
//	}
	
	
	@RequestMapping(value="/SbL",method = RequestMethod.GET)
	public ModelAndView findLocality(Model model,RedirectAttributes attributes)
	{
		model.addAttribute("clinic",new Clinic());
		return new ModelAndView("searchLocality","command",new ClinicEntity());
		
	}
	
	@RequestMapping(value="/findLocality",method=RequestMethod.POST)
	public  String findClinicByLocality
	(@ModelAttribute("clinic") ClinicEntity clinic,Model model,RedirectAttributes attributes)
	{
		//String name=request.getParameter("firstName");
		List<ClinicEntity> clinics=clinicService.findClinicByLocality(clinic.getLocality());
		System.out.println("clinics"+clinics);
//		if(employee==null)
//			throw new RecordNotFoundException();
	System.out.println("Employee found");
		model.addAttribute("clinic",clinics);
		return "clinics";
		
	}
	
	

	
	
	@RequestMapping(value="/changeStatus",method=RequestMethod.POST)
	public  String changeStatus
	(@ModelAttribute("appointment") AppointmentEntity appointment,RedirectAttributes attributes)
	{
		System.out.println(appointment);
		appointmentService.updateAppointment(appointment.getAppointmentId(),appointment.getAppointmentStatus());
		attributes.addFlashAttribute("message", "Appointment updated successfully.");
		return "redirect:/home";
	}
	
	
	
	
	
}
