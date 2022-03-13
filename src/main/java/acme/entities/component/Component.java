package acme.entities.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Component extends AbstractEntity{
	
	// Serialisation identifier

	protected static final long	serialVersionUID	= 1L;
		
	// Attributes
	@NotBlank
	@Size(min= 1, max = 101)
	protected String name;
	
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	private String code;
	
	@NotBlank
	@Size(min= 1, max = 101)
	protected String technology;
	
	@NotBlank
	@Size(min= 1, max = 256)
	protected String description;
	
	@Positive
	protected String retailPrice;
	
	private String optionalLink;
	
	


}
