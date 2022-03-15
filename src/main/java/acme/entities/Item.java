package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item extends AbstractEntity{
	
	// Serialisation identifier

	protected static final long	serialVersionUID	= 1L;
		
	// Attributes
	@NotBlank
	@Length(min=1,max=101)
	protected String name;
	
	@NotNull
	protected ItemType type;
	
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	private String code;
	
	@NotBlank
	@Length(min=1,max=101)
	protected String technology;
	
	@NotBlank
	@Length(min=1,max=256)
	protected String description;
	
	@NotNull
	@Min(0)
	protected Integer retailPrice;
	
	@URL
	private String moreInfo;
	
	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected ItemQuantity itemQuantity;
	
	


}
