package acme.entities;


import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@Min(1)
	protected double 			budget;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	protected LocalDate 		startDate;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	protected LocalDate 		endDate;
	
	@URL
	protected String 			moreInfo;

	// Derived attributes -----------------------------------------------------

	protected Integer getPeriod() {
		return Period.between(this.startDate, this.endDate).getDays();
	}
	
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
