package com.let.service;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.let.entity.Contact;
import com.let.exception.ContactException;
import com.let.repository.ContactRepository;

import jakarta.transaction.Transactional;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	@Override
	@Transactional
	public Contact add(Contact contact) throws ContactException {
		if(contact != null) {
			if(contactRepository.existsById(contact.getContactId())) {
				throw new ContactException("Contact Id already in use");
			}
			if(contactRepository.existsByMobile(contact.getMobile())) {
				throw new ContactException("Mobile is already in use");
			}
			
			contactRepository.save(contact);
			return contact;
		}
		return null;
	}

	@Override
	@Transactional
	public Contact save(Contact contact) throws ContactException {
		if(contact != null) {
			if(!contactRepository.existsById(contact.getContactId())) {
				throw new ContactException("Contact Id not found");
			}
			contactRepository.save(contact);
			return contact;
		}
		
		return null;
	}

	@Override
	@Transactional
	public boolean deleteContact(int contactId) throws ContactException {
			if(!contactRepository.existsById(contactId)) {
				throw new ContactException("Id not found");
			}
			contactRepository.deleteById(contactId);
			return true;
	}

	@Override
	@Transactional
	public Contact getContact(int contactId) throws ContactException {
		if(!contactRepository.existsById(contactId)) {
			throw new ContactException("Contact Not Found");
		}
		return contactRepository.findById(contactId).orElse(null);
	}

	@Override
	public List<Contact> getAllContacts() throws ContactException {
		return contactRepository.findAll();
	}

}
