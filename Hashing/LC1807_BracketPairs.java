/*
LeetCode 1807 - Evaluate the bracket pairs of a string
Approach: Use a hash map to store the key-value pairs from the knowledge list. Iterate through the string and whenever a '(' is encountered, find the corresponding ')' and extract the substring between them. Check if this substring exists in the hash map and append the corresponding value to the result. If it doesn't exist, append '?' instead. Continue this process until the end of the string.
Time Complexity: O(n + m) where n is the length of the string and m is the number of key-value pairs in the knowledge list
Space Complexity: O(m) for the hash map
*/

class LC1807_BracketPairs {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> mp = new HashMap<>();

        for (List<String> vec : knowledge) {
            mp.put(vec.get(0), vec.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(")", i + 1);
                String temp = s.substring(i + 1, j);
                result.append(mp.getOrDefault(temp, "?"));
                i = j;
            } else {
                result.append(s.charAt(i));
            }

            i++;
        }
        return result.toString();
    }

    public static void main(String a[]) {
        LC1807_BracketPairs obj = new LC1807_BracketPairs();
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(Arrays.asList("name", "bob"));
        String s = "hi(name)";
        System.out.println(obj.evaluate(s, knowledge));
    }
}