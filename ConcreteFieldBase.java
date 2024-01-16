import java.util.ArrayList;

public class ConcreteFieldBase extends FieldBase {
	
	private Encryption e;
	private ArrayList<Spy> spies = new ArrayList<Spy>(); 
	private ArrayList<Spy> deadSpies = new ArrayList<Spy>(); 
	
	private HomeBase home;
	
	public ConcreteFieldBase(HomeBase h) {
		home = h;
		home.add(this);
	};
	
	@Override
	public void send(Sender entity, String s) {
		sendInternal(entity, s, e);
	};
	
	@Override
	public void recieve() {
		receiveInternal(e);
	};
	
	@Override
	public void add(Spy s) {
		if (!(deadSpies.contains(s))) {
			if (!(spies.contains(s))) {
				spies.add(s);
				s.update(e);
				System.out.println("Spy Added");
			}
			else System.out.println("Spy already in system.");
		}
		else 
			System.out.println("That spy is dead.");
		
	}

	@Override
	public void remove(Spy s) {
		spies.remove(s);
		deadSpies.add(s);
		
	}

	@Override
	protected void update(Encryption e) {
		this.e = e;
		
		for (Spy s : spies) { 
		    s.update(e);
		}
	}

	@Override
	public void goDark() {
		home.remove(this);
		
	}

	@Override
	public void undoGoDark() {
		home.add(this);
	}
	

}
