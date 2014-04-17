package payall.interfaces;

import payall.Client;

public interface Payment {

	public String pay(double value, Client client);
	
	public boolean acceptFlag(Client client);
	
	public Payment getNext();
	
}
