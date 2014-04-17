package payall.model;

import static java.lang.String.format;
import static payall.CardBanner.*;
import payall.Client;
import payall.interfaces.Payment;

public class HipercardPayment implements Payment {

	public String pay(double value, Client client) {
		if(acceptFlag(client))
			return format("Value %s paid on Hipercard card banner in 12 times", value);
		return getNext().pay(value, client);
	}
	
	@Override
	public boolean acceptFlag(Client client) {
		return HIPERCARD.equals(client.getCardBanner());
	}

	@Override
	public Payment getNext() {
		return new MasterCard();
	}
	
}
