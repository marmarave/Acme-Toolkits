package acme.forms;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdministratorDashboard {
	
		// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		Integer								totalNumComponents;
		Integer								totalNumTools;
		Map<String,Integer>					numberOfPatronages;
		
		Map<String,Double>			priceOfComponentsStats;
		Map<String,Double>			priceOfToolsStats;
		Map<String,Double>			patronagesStats;
		


}
