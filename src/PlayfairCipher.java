import java.util.*;

/**
 * Playfair Cipher Encryption Tool
 * Developed for Computer Security Course - King Faisal University
 * Author: Atekah Hussain
 */
public class PlayfairCipher {
    private char[][] keyTable = new char[5][5];

    // Step 1 & 2: Generate the 5x5 key table
    public void generateKeyTable(String key) {
        key = key.toLowerCase().replaceAll("[^a-z]", "").replace("j", "i");
        String alphabet = "abcdefghiklmnopqrstuvwxyz"; // 'j' is excluded
        String combined = key + alphabet;
        
        StringBuilder uniqueKey = new StringBuilder();
        for (char c : combined.toCharArray()) {
            if (uniqueKey.indexOf(String.valueOf(c)) == -1) {
                uniqueKey.append(c);
            }
        }

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyTable[i][j] = uniqueKey.charAt(idx++);
            }
        }
    }

    // Step 3: Prepare text into pairs (digraphs)
    private String prepareText(String text) {
        text = text.toLowerCase().replaceAll("[^a-z]", "").replace("j", "i");
        StringBuilder sb = new StringBuilder(text);
        
        for (int i = 0; i < sb.length() - 1; i += 2) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'x');
            }
        }
        if (sb.length() % 2 != 0) {
            sb.append('x');
        }
        return sb.toString();
    }

    // Helper to find position of character in matrix
    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyTable[i][j] == c) return new int[]{i, j};
            }
        }
        return null;
    }

    // Step 4: Encryption
    public String encrypt(String text, String key) {
        generateKeyTable(key);
        String prepared = prepareText(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < prepared.length(); i += 2) {
            int[] pos1 = findPosition(prepared.charAt(i));
            int[] pos2 = findPosition(prepared.charAt(i + 1));

            if (pos1[0] == pos2[0]) { // Same Row
                result.append(keyTable[pos1[0]][(pos1[1] + 1) % 5]);
                result.append(keyTable[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) { // Same Column
                result.append(keyTable[(pos1[0] + 1) % 5][pos1[1]]);
                result.append(keyTable[(pos2[0] + 1) % 5][pos2[1]]);
            } else { // Rectangle Swap
                result.append(keyTable[pos1[0]][pos2[1]]);
                result.append(keyTable[pos2[0]][pos1[1]]);
            }
        }
        return result.toString().toUpperCase();
    }

    // Decryption Logic
    public String decrypt(String ciphertext, String key) {
        generateKeyTable(key);
        ciphertext = ciphertext.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            int[] pos1 = findPosition(ciphertext.charAt(i));
            int[] pos2 = findPosition(ciphertext.charAt(i + 1));

            if (pos1[0] == pos2[0]) { // Same Row: Move Left
                result.append(keyTable[pos1[0]][(pos1[1] + 4) % 5]);
                result.append(keyTable[pos2[0]][(pos2[1] + 4) % 5]);
            } else if (pos1[1] == pos2[1]) { // Same Column: Move Up
                result.append(keyTable[(pos1[0] + 4) % 5][pos1[1]]);
                result.append(keyTable[(pos2[0] + 4) % 5][pos2[1]]);
            } else { // Rectangle Swap
                result.append(keyTable[pos1[0]][pos2[1]]);
                result.append(keyTable[pos2[0]][pos1[1]]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PlayfairCipher cipher = new PlayfairCipher();
        String key = "KEYWORD";
        String text = "HELP";
        
        String encrypted = cipher.encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + cipher.decrypt(encrypted, key));
    }
}
