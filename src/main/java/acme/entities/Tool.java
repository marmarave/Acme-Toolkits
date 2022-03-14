package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tool extends AbstractEntity{
	
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@NotBlank
	@Column(length=101)
	private String name;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	private String code;
	
	@NotBlank
	@Column(length=101)
	private String technology;
	
	@NotBlank
	//@Column(length=256)
	private String description;
	
	@NotNull
	@PositiveOrZero
	private double retailPrice;
	
	@URL
	private String moreInfo;
	
	// A tool may have a relation OneToMany with Component

}
