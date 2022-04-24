package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.framework.datatypes.Money;
import acme.testing.TestHarness;

public class InventorToolkitListMineTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/tool/tool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String moreInfo, final Money totalPrice) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my toolkits");

		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, assemblyNotes);
		super.checkColumnHasValue(recordIndex, 4, assemblyNotes);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
	}
}
