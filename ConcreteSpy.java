public class ConcreteSpy extends Spy {
	
	private Encryption e;
	private FieldBase fieldBase;
	
	public ConcreteSpy(FieldBase f) {
		fieldBase = f;
		f.add(this);
	}
	
	@Override
	protected void update(Encryption e) {
		this.e = e;
	}
	
	@Override
	public void send(Sender entity, String s) {
		sendInternal(entity, s, e);
	};
	
	@Override
	public void recieve() {
		receiveInternal(e);
		
	}

	@Override
	public void die() {
		fieldBase.remove(this);
		
	};

}
