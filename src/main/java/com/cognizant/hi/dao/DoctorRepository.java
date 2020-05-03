package com.cognizant.hi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.hi.entity.DoctorEntity;


public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> 
{
	@Query("select u from DoctorEntity u join fetch u.userid where u.speciality=?1 ")
	List<DoctorEntity> fetchDoctorBySpeciality(String speciality);

}
