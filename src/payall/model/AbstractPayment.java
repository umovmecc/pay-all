package payall.model;

import payall.Client;
import payall.interfaces.Payment;

public abstract class AbstractPayment implements Payment  {

	public AbstractPayment() {
		super();
	}

	@Override
	public String pay(double value, Client client) {
		if(acceptFlag(client))
			return getMessage(value);
		return getNext().pay(value, client);
	}

	public abstract String getMessage(double value);

	public abstract boolean acceptFlag(Client client);

	public abstract Payment getNext();

}