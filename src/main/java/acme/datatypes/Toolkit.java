package acme.datatypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Toolkit {

	// A toolkit may have several instances of the same component, but only one instance of a given tool.
	
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	private String code;
	
	@NotBlank
	@Size(max = 100)
	private String title;
	
	@NotBlank
	@Size(max = 255)
	private String description;
	
	@NotBlank
	@Size(max = 255)
	private String assemblyNotes;
	
	private String optionalLink;
	
//	@ManyToMany
//	private Tool tool;
	
//	@ManyToMany
//	private Component component;

   
}
