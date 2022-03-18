package acme.forms;
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
public class AdministratorDashboard {
	
		// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		Integer								totalNumComponents;
		Map<String,List<Double>>			priceOfComponentsStats;
		Map<String,List<Double>>			priceOfToolsStats;
		Map<String,Integer>					numberOfPatronages;
		Map<String,List<Double>>			patronagesStats;
		


}
