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