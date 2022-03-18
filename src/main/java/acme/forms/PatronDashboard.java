package acme.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/*
@Entity
@Getter
@Setter
*/
public class PatronDashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		Map<String,Integer>						numberOfPatronages;
		Map<String,List<Double>>				patronageStats;


		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
	
}
