package payall.model;

import static payall.CardBanner.VISA;
import static java.lang.String.format;

import payall.Client;
import payall.interfaces.Payment;

public class VisaPayment extends AbstractPayment {
	
	@Override
	public Payment getNext(){
		return new HipercardPayment();
	}

	@Override
	public boolean acceptFlag(Client client) {
		return client.getCardBanner().equals(VISA);
	}

	@Override
	public String getMessage(double value) {
		return format("Value %s paid on Visa card banner in cash with discount of 5%%", value);
	}

}
