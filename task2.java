package lap_1;

public class task2 {
	public static class MyCaesar {
	    public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
	            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	    private int n; // shift steps (right shift)
		private char key;

	    public MyCaesar(int shiftSteps) {
	        this.n = shiftSteps;
	    }

	    // Encrypt a character according to the given shift steps.
	    // Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET array
	    public char encryptChar(char c) {
	    	//kiểm tra xem c có phải chữ cái hay ko
	        if (!Character.isLetter(c)) {
	            return c; // trả về ko thay đổi nếu đó ko phải là một chữ cái
	        }
	        char uppercaseC = Character.toUpperCase(c);//chuyển kí tự thành chữ in hoa
	        int index = uppercaseC - 'A';  // tính toán chỉ số index
	        int Index = (index + n) % 26;
	        return ALPHABET[Index];
	    }
	    

	    // Encrypt a text using the above function for encrypting a character.
	    public String encrypt(String input) {
	        StringBuilder encryptedText = new StringBuilder();
	        for (char c : input.toCharArray()) { // toCharArray(): chuyển đổi chuỗi thành 1 mảng các kí tự
	            encryptedText.append(encryptChar(c));
	        }
	        return encryptedText.toString(); //toString : chuyển về chuỗi
	    }

	    public char decryptChar(char c) {
	        if (!Character.isLetter(c)) {
	            return c; // return unchanged if it's not a letter
	        }
	        char uppercaseC = Character.toUpperCase(c);
	        int index = (uppercaseC - 'A' - n + 26) % 26;
	        return ALPHABET[index];
	    }

	    // Decrypt an encrypted text using the above function for decrypting a character.
	    public String decrypt(String input) {
	        StringBuilder decryptedText = new StringBuilder();
	        for (char c : input.toCharArray()) {
	            decryptedText.append(decryptChar(c));
	        }
	        return decryptedText.toString();
	    }

	    public static void main(String[] args) {
	        MyCaesar caesar= new MyCaesar(3); // shift steps = 3
	        System.out.println(caesar.encryptChar('A'));
	        System.out.println(caesar.decryptChar('A'));
	        // Test encryption
	        String plaintext = "KDLZ JXF";
	        String encrypted = caesar.encrypt(plaintext);
	        System.out.println("Encrypted: " + encrypted); // Output: NGOC MAI

	        // Test decryption
	        String decrypted = caesar.decrypt(encrypted);
	        System.out.println("Decrypted: " + decrypted); // Output: KDLZ JXF

	        // Test encryption and decryption of non-alphabetic characters
	        MyCaesar caesar2 = new MyCaesar(5);
	        String text2 = "NGOC MAI 123";
	        String encryptedSpecialChars = caesar2.encrypt(text2);
	        System.out.println(encryptedSpecialChars); 
	        
	        String decryptedSpecialChars = caesar2.decrypt(text2);
	        System.out.println( decryptedSpecialChars); 
	    }
	}
}
