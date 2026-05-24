/*
LeetCode 3941 - Password Strength
Approach: We iterate through the password string and assign points to each character based on its type. We use a boolean array to track which characters have been seen to avoid counting duplicates.
Time Complexity: O(n) due to the single pass through the string.
Space Complexity: O(1) as no additional space for the operations calculation.
*/


class LC3941_PasswordStrength {
    public int passwordStrength(String password) {
        int points = 0;
        boolean seen[] = new boolean[128];
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (seen[ch]) {
                continue;
            }

            seen[ch] = true;

            if (ch >= 'a' && ch <= 'z') {
                points += 1;
            } else if (ch >= 'A' && ch <= 'Z') {
                points += 2;
            } else if (ch >= '0' && ch <= '9') {
                points += 3;
            } else if (ch == '!' || ch == '@' || ch == '#' || ch == '$') {
                points += 5;
            }
        }
        return points;
    }

    public static void main(String[] args) {
        LC3941_PasswordStrength obj = new LC3941_PasswordStrength();
        System.out.println(obj.passwordStrength("abc")); // 1 + 1 + 1 = 3
        System.out.println(obj.passwordStrength("ABC")); // 2 + 2 + 2 = 6
        System.out.println(obj.passwordStrength("123")); // 3 + 3 + 3 = 9
        System.out.println(obj.passwordStrength("!@#")); // 5 + 5 + 5 = 15
    }
}
    