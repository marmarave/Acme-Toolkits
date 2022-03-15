package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity{

	// A toolkit may have several instances of the same component, but only one instance of a given tool.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	private String code;
	
	@NotBlank
	@Column(length=101)
	private String title;
	
	@NotBlank
	@Column(length=256)
	private String description;
	
	@NotBlank
	@Column(length=256)
	private String assemblyNotes;
	
	@URL
	private String moreInfo;
	
//	@ManyToMany
//	private Tool tool;
	
//	@ManyToMany
//	private Component component;

   
}
