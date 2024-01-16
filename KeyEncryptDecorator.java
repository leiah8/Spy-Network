
public class KeyEncryptDecorator extends EncryptDecorator {
	
	private int key; 
	
	public KeyEncryptDecorator(Encryption e, int key) {
		this.e = e;
		this.key = key;
	}

	@Override
	public String encrypt(String s) {
		String input = e.encrypt(s);
		
		char[] chars = input.toCharArray();
		
		for (int i = 0; i < chars.length; i++) { 
		    chars[i] = (char) (((int) chars[i]) + key);
			
		}
				
		String output = charArrToString(chars);
						
		return output;
	}

	@Override
	public String decrypt(String s) {		
		//String input = e.decrypt(s);
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < chars.length; i++) { 
		    chars[i] = (char) (((int) chars[i]) - key);
			
		}
				
		String output = charArrToString(chars);	
		
		
		return e.decrypt(output);
	}
	
	private String charArrToString(char[] chars) {
		String s = "";
		
		for (char c : chars) { 
		    s += c;
		}
		
		return s;
	}

}
