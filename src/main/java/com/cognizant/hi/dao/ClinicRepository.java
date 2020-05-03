package com.cognizant.hi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.hi.entity.ClinicEntity;


public interface ClinicRepository extends JpaRepository<ClinicEntity, String> 
{
	@Query("Select e from ClinicEntity e where e.locality=?1")
	List<ClinicEntity> findClinicByLocality(String Locality);

}
