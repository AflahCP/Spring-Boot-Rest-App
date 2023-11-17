package com.let.service;

import java.util.List;

import com.let.entity.Contact;
import com.let.exception.ContactException;

public interface ContactService {
	
	Contact add(Contact contact) throws ContactException;
	Contact save(Contact contact) throws ContactException;
	
	boolean deleteContact(int contactId) throws ContactException;
	
	Contact getContact(int contactId) throws ContactException;
	List<Contact> getAllContacts() throws ContactException;
}
