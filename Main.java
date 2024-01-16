
public class Main {

	public static void main(String[] args) {
		
		Encryption encrypt = new SymmetricEncryption(-3);
		HomeBase home = ConcreteHomeBase.getInstance(encrypt);
		FieldBase f1 = new ConcreteFieldBase(home);
		Spy s1 = new ConcreteSpy(f1);
		
		home.send(s1, "hello");
		f1.send(home, "hi home");
		s1.send(f1, "hello field ");
		
		System.out.println("\n CHANGE ENCRYPTION ALGORITHM \n");
		
		home.changeKey(1);
		//Encryption encrypt2 = new SymmetricEncryption(-1);
		//home.update(encrypt2);
		
		Spy s2 = new ConcreteSpy(f1);
		
		home.send(s2, "hi spy");
		home.send(s1, "hi spy");
		f1.send(home, "hi home");
		s1.send(f1, "hello field ");
		s2.send(home, "hi again");

		
		System.out.println("\n CHANGE ENCRYPTION ALGORITHM \n");
		
		Encryption encrypt3 = new KeyEncryptDecorator (new SymmetricEncryption(-2), 1);
		home.update(encrypt3);
		
	
		s1.send(s2, "hello");
		//s2.send(home, "hi again");
	}

}
