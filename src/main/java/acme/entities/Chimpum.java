package acme.entities;


import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chimpum extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------
	
	protected static final long    serialVersionUID    = 1L;
		
	// Attributes -------------------------------------------------------------

	//^[A-Z]{5}(-[0-9]{2}[/][0][1-9]|[1][12][/][1-9]|[12][0-9]|3[01])$
	//@Column(unique = true)
	//@Pattern(regexp = "^[A-Z]{5}(-[0-9]{2}[/][0][1-9]|[1][12][/][1-9]|[12][0-9]|3[01])$")
	private String code;
	
	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationMoment;
	
	@NotBlank
	@Length(min=1,max=101)
	protected String title;
	
	@NotBlank
	@Length(min=1,max=256)
	protected String description;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date startDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date endDate;
	
	@NotNull
	@Valid
	protected Money budget;
	
	@URL
	protected String 			moreInfo;
	
	
	
	public static Boolean verifyPeriod(Date startDate,Date endDate) {
		Date d = new Date(System.currentTimeMillis());
		Long l = startDate.getTime()-d.getTime();
		boolean res = (l>(30*1000*3600*24)) && (endDate.getTime()-startDate.getTime() >(7*1000*3600*24));
		return res;
	}


}
