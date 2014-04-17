package payall.model;

import static java.lang.String.format;
import static payall.CardBanner.*;
import payall.Client;
import payall.interfaces.Payment;

public class MasterCard implements Payment {

	@Override
	public String pay(double value, Client client) {
		if(acceptFlag(client))
			return format("Value %s paid on MasterCard card banner in 3 times without discount", value);
		return getNext().pay(value, client);
	}

	@Override
	public boolean acceptFlag(Client client) {
		return MASTERCARD.equals(client.getCardBanner());
	}

	@Override
	public Payment getNext() {
		throw new RuntimeException(format("Card banner is not suported!")); 
	}

}
