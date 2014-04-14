package payall;

import static java.lang.String.format;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PayAllTest {
	
	@InjectMocks
	private PayAll payAll;
	@Mock
	private Printer printer;
	
	@Before
	public void setUp() {
		initMocks(this);
		payAll = new PayAll(printer);
	}
	
	@Test
	public void shouldPayForClientWithVisaCardBanner() {
		Client client = new Client();
		client.setCardBannerType(CardBanner.VISA);
		double value = 100.0;
		
		payAll.payFor(client, value);
		
		verify(printer).printMessage(format("Value %s paid on Visa card banner in cash with discount of 5%%", value));
	}
	
	@Test
	public void shouldPayForClientWithMasterCardBanner() {
		Client client = new Client();
		client.setCardBannerType(CardBanner.MASTERCARD);
		double value = 35.0;
		
		payAll.payFor(client, value);
		
		verify(printer).printMessage(format("Value %s paid on MasterCard card banner in 3 times without discount", value));
	}
	
	@Test
	public void shouldPayForClientWithHiperCardBanner() {
		Client client = new Client();
		client.setCardBannerType(CardBanner.HIPERCARD);
		double value = 72.5;
		
		payAll.payFor(client, value);
		
		verify(printer).printMessage(format("Value %s paid on Hipercard card banner in 12 times", value));
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenTryingToPayForClientWithAmericanExpressCardBanner() {
		Client client = new Client();
		client.setCardBannerType(CardBanner.AMERICAN_EXPRESS);
		double value = 470.5;
		
		payAll.payFor(client, value);
	}
	
}
