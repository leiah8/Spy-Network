import java.util.ArrayList;

public abstract class Sender {
	
	private ArrayList<String> stored = new ArrayList<String>();
	protected ArrayList<String> recieved = new ArrayList<String>();
	
	public abstract void send(Sender entity, String s);
	public abstract void recieve();
	protected abstract void update(Encryption e);
		
	protected void sendInternal(Sender entity, String s, Encryption e) {
		String encrypted = e.encrypt(s);
		System.out.println("Sent Message: "+ encrypted);
		entity.recieved.add(encrypted);
		entity.recieve();
	}

	protected void receiveInternal(Encryption e) {
		String decryptedS = e.decrypt(recieved.get(0)); 
		recieved.remove(0);
		stored.add(decryptedS);
		System.out.println("Recieved Message: "+ decryptedS);
	}
	
}
