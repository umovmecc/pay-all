package payall.model;

import static java.lang.String.format;
import static payall.CardBanner.MASTERCARD;
import payall.Client;
import payall.interfaces.Payment;

public class MasterCard extends AbstractPayment {

	@Override
	public boolean acceptFlag(Client client) {
		return MASTERCARD.equals(client.getCardBanner());
	}

	@Override
	public Payment getNext() {
		throw new RuntimeException(format("Card banner is not suported!")); 
	}

	@Override
	public String getMessage(double value) {
		return format("Value %s paid on MasterCard card banner in 3 times without discount", value);
	}

}
