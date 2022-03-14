package acme.entities;


import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@NotNull
	protected PatronageStatus 			status;
	
	@NotBlank
	@Column(unique=true)
	@Pattern(regexp=("^[A-Z]{3}-[0-9]{3}(-[A-Z])?$"))
	protected String			code;
	
	@NotBlank
	protected String 			legalStuff;
	
	@NotNull
	@Positive
	protected double 			budget;
	
	@NotNull
	protected Period 			period;
	
	@URL
	protected String 			moreInfo;

	// Derived attributes -----------------------------------------------------


	@Transient
	public boolean spam ;
		
	

	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Patron patron;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Inventor inventor;
	
}
