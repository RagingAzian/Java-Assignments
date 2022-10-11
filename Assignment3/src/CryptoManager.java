
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_RANGE and UPPER_RANGE characters
	 * 
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *                  bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean isStringInBounds(String plainText) {
		for (int x = 0; x < plainText.length(); x++) {
			if (plainText.charAt(x) > UPPER_RANGE || plainText.charAt(x) < LOWER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if (isStringInBounds(plainText)) {
			char[] msgChar = plainText.toCharArray();
			for (int x = 0; x < msgChar.length; x++) {
				while (key > UPPER_RANGE) {
					key -= (95 - 32 + 1);
				}
				msgChar[x] += key;
				while (msgChar[x] > UPPER_RANGE) {
					msgChar[x] -= RANGE;
				}
			}
			String encryptedText = new String(msgChar);
			return encryptedText;
		} else
			return "The selected string is not in bounds, Try again.";
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		if (!isStringInBounds(plainText)) {
			return "The selected string is not in bounds, Try again.";
		}

		int charInt = 0;
		while (bellasoStr.length() < plainText.length())
			bellasoStr += bellasoStr.charAt(charInt++);
		String encryptedText = "";
		for (int x = 0; x < plainText.length(); x++) {
			int tempNum = plainText.charAt(x) + bellasoStr.charAt(x);
			while (tempNum > UPPER_RANGE)
				tempNum -= RANGE;
			char tempChar = (char) tempNum;
			encryptedText += tempChar;
		}
		return encryptedText;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key           an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		if (!isStringInBounds(encryptedText)) {
			return "The selected string is not in bounds, Try again.";
		}
		char[] msgChar = encryptedText.toCharArray();
		for (int x = 0; x < msgChar.length; x++) {
			while (key > UPPER_RANGE) {
				key -= (95 - 32 + 1);
			}
			msgChar[x] -= key;
			while (msgChar[x] < LOWER_RANGE) {
				msgChar[x] += RANGE;
			}
		}
		String plainText = new String(msgChar);
		return plainText;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String plainText = "";
		int bellasoStrLength = bellasoStr.length();
		for (int index = 0; index < encryptedText.length(); index++) {
			char thisChar = encryptedText.charAt(index);
			int plainChar = ((int) thisChar - (int) bellasoStr.charAt(index % bellasoStrLength));
			while (plainChar < (int) LOWER_RANGE) {
				plainChar += RANGE;
			}
			plainText += (char) plainChar;
		}
		return plainText;
	}
}
