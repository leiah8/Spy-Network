import java.util.ArrayList;

public class ConcreteHomeBase extends HomeBase {
	
	private Encryption e;
	private ArrayList<FieldBase> fieldBases = new ArrayList<FieldBase>();
	
		
	private ConcreteHomeBase(Encryption e) {
		this.e = e;
	}
	
	
	public static HomeBase getInstance(Encryption e) {
		if (instance == null) {
			instance = new ConcreteHomeBase(e);
		}
		return instance;
	}
	
	@Override
	public void send(Sender entity, String s) {
		sendInternal(entity, s, e);
	};
	
	@Override
	public void recieve() {
		receiveInternal(e);
		
	};

	@Override
	public void add(FieldBase f) {
		if (!(fieldBases.contains(f))) {
			fieldBases.add(f);
			f.update(e);
			System.out.println("Field Base Added");
		}
		else
		System.out.println("Field Base already in system.");
	}

	@Override
	public void remove(FieldBase f) {
		fieldBases.remove(f);
		
	}

	@Override
	public void update(Encryption e) {
		this.e = e;
		
		for (FieldBase f : fieldBases) { 
		    f.update(e);
		}
		
	}
	
	@Override
	public void changeKey(int key) {
		if (e instanceof SymmetricEncryption) {
			((SymmetricEncryption) e).setKey(key);
			//update(e);
		}
	}
	

}
