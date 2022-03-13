package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Announcement extends AbstractEntity{
	
	protected static final long    serialVersionUID    = 1L;
	

	@Past
	protected Date creationMoment;
	
	@NotBlank
	@Max(101)
	protected String title;
	
	@NotBlank
	@Max(256)
	protected String body;
	
	@NotNull
	protected boolean flag;
	
	@URL
	protected String moreInfo;
}
