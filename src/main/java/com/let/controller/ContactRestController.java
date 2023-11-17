package com.let.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.let.entity.Contact;
import com.let.exception.ContactException;
import com.let.service.ContactService;

@RestController
@RequestMapping(path = "/contacts")
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() throws ContactException {
		return new ResponseEntity<List<Contact>>(contactService.getAllContacts(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable int cid) throws ContactException {
		ResponseEntity<Contact> entity = null;
		
		Contact contact = contactService.getContact(cid);
		
		if(contact != null) entity = new ResponseEntity<Contact>(contact, HttpStatus.OK);
		else entity = new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteContactById(@PathVariable int cid) throws ContactException {
		contactService.deleteContact(cid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) throws ContactException {
		return new ResponseEntity<Contact>(contactService.add(contact), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) throws ContactException {
		return new ResponseEntity<Contact>(contactService.save(contact), HttpStatus.OK);
	}
}
