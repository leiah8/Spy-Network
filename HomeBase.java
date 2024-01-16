
public abstract class HomeBase extends Sender {
	
	protected static HomeBase instance;
	
	public abstract void add(FieldBase f);
	public abstract void remove(FieldBase f);
	
	@Override
	public abstract void update(Encryption e);
	
	public abstract void changeKey(int key);
	
}
