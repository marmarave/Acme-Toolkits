package acme.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PatronDashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		Map<String,Integer>						numberOfPatronages;
		Map<String,List<Double>>				patronageStats;


		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
	
}
