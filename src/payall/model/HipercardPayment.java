package payall.model;

import static java.lang.String.format;
import static payall.CardBanner.HIPERCARD;
import payall.Client;
import payall.interfaces.Payment;

public class HipercardPayment extends AbstractPayment {

	@Override
	public boolean acceptFlag(Client client) {
		return HIPERCARD.equals(client.getCardBanner());
	}

	@Override
	public Payment getNext() {
		return new MasterCard();
	}

	@Override
	public String getMessage(double value) {
		return format("Value %s paid on Hipercard card banner in 12 times", value);
	}
}
