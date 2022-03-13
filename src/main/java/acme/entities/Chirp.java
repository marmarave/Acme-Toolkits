package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chirp extends AbstractEntity {
	
	protected static final long    serialVersionUID    = 1L;
	
	@NotNull
	@Past
	protected Date creationMoment;
	
	@NotBlank
	@Max(101)
	protected String title;
	
	@NotBlank
	@Max(101)
	protected String author;
	
	@NotBlank
	@Max(256)
	protected String body;
	
	@Email
	protected String email;
	
}
