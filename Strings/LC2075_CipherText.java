/*
Leetcode 2075 - Decode Slanted ciphertext
Approach - Simulating the reverse process of a slanted transposition cipher by iterating through matrix diagonals.

Time Complexity - O(n) where n is the length of the encoded text.
Space Complexity - O(n) for the StringBuilder storing the decoded text.
*/

class LC2075_CipherText {
    public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();
        int col = l / rows;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < col; i++) {
            for (int j = i; j < l; j += (col + 1)) {
                sb.append(encodedText.charAt(j));
            }
        }

        // removing spaces at end
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC2075_CipherText obj = new LC2075_CipherText();
        System.out.println(obj.decodeCiphertext("ch   ie   pr", 3));
        System.out.println(obj.decodeCiphertext("fb ia rs ee", 4));
    }
}