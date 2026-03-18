/*
LeetCode 205 - Isomorphic Strings

Approach: Use two arrays to keep track of the last seen index of each character in both strings. As we iterate through the characters of both strings simultaneously, we check if the last seen indices match for the corresponding characters. If they don't match, it means the strings are not isomorphic. If they match, we update the last seen indices for both characters.

Time Complexity: O(n) where n is the length of the strings, since we need to iterate through both strings once.

Space Complexity: O(1) since we are using fixed-size arrays of length 256 to keep track of the last seen indices, which does not grow with the input size.
*/

class LC205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        int mapST[] = new int[256];
        int mapTS[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST[c1] != mapTS[c2]) {
                return false;
            }

            mapST[c1] = i + 1;
            mapTS[c2] = i + 1;

        }
        return true;
    }
    public static void main(String[] args) {
        LC205_IsomorphicStrings s = new LC205_IsomorphicStrings();
        String str1 = "egg";
        String str2 = "add";
        System.out.println(s.isIsomorphic(str1, str2)); // Output: true

        String str3 = "foo";
        String str4 = "bar";
        System.out.println(s.isIsomorphic(str3, str4)); // Output: false

        String str5 = "paper";
        String str6 = "title";
        System.out.println(s.isIsomorphic(str5, str6)); // Output: true
    }
}
