package payall.model;

import payall.CardBanner;
import payall.Client;
import payall.interfaces.Payment;

public class VisaPayment implements Payment {

	@Override
	public String pay(double value, Client client) {
		if(acceptFlag(client))
			return String.format("Value %s paid on Visa card banner in cash with discount of 5%%", value);
		return getNext().pay(value, client);
	}
	
	public Payment getNext(){
		return new HipercardPayment();
	}

	@Override
	public boolean acceptFlag(Client client) {
		return client.getCardBanner().equals(CardBanner.VISA);
	}

}
