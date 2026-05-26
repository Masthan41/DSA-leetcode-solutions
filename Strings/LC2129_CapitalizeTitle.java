/*
Leetcode 2129: Capitalize the Title
Approach: Convert each word to the appropriate case based on its length
Time Complexity: O(n) - where n is the length of the title string
Space Complexity: O(n) - we are using a StringBuilder to store the result
*/

class LC2129_CapitalizeTitle {
    public String capitalizeTitle(String title) {
        String words[] = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (w.length() <= 2) {
                w = w.toLowerCase();
                sb.append(w).append(" ");
            } else {
                w = w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase();
                sb.append(w).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LC2129_CapitalizeTitle obj = new LC2129_CapitalizeTitle();
        System.out.println(obj.capitalizeTitle("capiTalIze tHe titLe")); // "Capitalize The Title"
        System.out.println(obj.capitalizeTitle("First leTTeR of EACH Word")); // "First Letter of Each Word"
        System.out.println(obj.capitalizeTitle("i lOve leetcode")); // "i Love Leetcode"
    }
}
