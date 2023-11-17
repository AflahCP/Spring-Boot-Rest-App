package com.let.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class Contact {
	
	@Id
	@NotNull(message = "Contact ID is required")
	@Min(value = 1, message = "Contact ID cannot be zero or negative")
	private Integer contactId;
	
	@Column(name = "Name")
	@NotNull(message = "Full name is required")
	@NotBlank(message = "Full name is required")
	@Size(min = 5, max = 25, message = "Name charaters should be between 5 and 25")
	private String fullName;
	
	@Column(name = "DOB")
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message = "Date of birth cannot be future date")
	private LocalDate dateOfBirth;
	
	@Column(name = "Mobile")
	@NotNull(message = "Please fill with your number")
	@NotBlank(message = "Cannot leave this field empty")
	@Pattern(regexp = "[1-9][0-9]{9}", message = "Enter Valid mobile number")
	private String mobile;
	
	@Column(name = "Grp")
	private String group;
	
	@Column(name = "Married")
	private boolean married;

	public Contact() {
//		super();
	}

	public Contact(
			Integer contactId,
			String fullName,
			LocalDate dateOfBirth,
			String mobile,
			String group,
			boolean married) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
		this.group = group;
		this.married = married;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return String.format("Contact [contactId=%s, fullName=%s, dateOfBirth=%s, mobile=%s, group=%s, married=%s]",
				contactId, fullName, dateOfBirth, mobile, group, married);
	}
	
	
	
	
	
	
}
