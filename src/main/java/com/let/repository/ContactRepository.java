package com.let.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.let.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	boolean existsByMobile(String mobile);
	
	Contact findByMobile(String mobile);
	
	List<Contact> findAllByGroup(String group);
	
	@Query("Select c from Contact c where c.dateOfBirth between :start and :end")
	List<Contact> findAllBornInRange(@DateTimeFormat(iso = ISO.DATE) LocalDate start, @DateTimeFormat(iso = ISO.DATE) LocalDate end);
}
