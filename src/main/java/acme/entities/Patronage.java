package acme.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
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
	@Length(min=1,max=255)
	protected String 			legalStuff;
	
	@NotNull
	@Valid
	//@Min(value = 1) Habrá que hacer custom constraint para ponerle un mínimo a la cantidad
	protected Money 			budget;
	
	//La validación de las fechas se hará más adelante, cuando se vean en clase las custom constraints
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 				creationMoment;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 				startDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 				endDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date 				period;
	
	@URL
	protected String 			moreInfo;

	// Derived attributes -----------------------------------------------------
	
	@Transient
	protected void getPeriod() {
		this.period = new Date(this.endDate.getTime()-this.startDate.getTime());
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
