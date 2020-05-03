package com.cognizant.hi.service;

import java.util.List;

import com.cognizant.hi.entity.AppointmentEntity;

public interface AppointmentService {

	public boolean bookAppointment(AppointmentEntity appointment);

	public List<AppointmentEntity> fetchPendingAppointments(String userid);

	public void updateAppointment(int appointmentId, String appointmentStatus);

}
