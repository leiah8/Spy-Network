
public class SymmetricEncryption implements Encryption {
	
	//CHANGE BACK TO PRIVATE
	public int key; 
	
	public SymmetricEncryption(int k) {
		this.key = k;
	}
	
	@Override
	public String encrypt(String s) {

		char[] chars = s.toCharArray();
		
		for (int i = 0; i < chars.length; i++) { 
		    chars[i] = (char) (((int) chars[i]) + key);
			
		}
				
		String newS = charArrToString(chars);
		
		return newS;
	}

	@Override
	public String decrypt(String s) {
		
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < chars.length; i++) { 
		    chars[i] = (char) (((int) chars[i]) - key);
			
		}
		
		String newS = charArrToString(chars);
		
				
		return newS;
	}
	
	public void setKey(int k) {
		this.key = k;
	}
	
	private String charArrToString(char[] chars) {
		String s = "";
		
		for (char c : chars) { 
		    s += c;
		}
		
		return s;
	}

}
