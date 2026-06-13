/*
Leetcode 3838 - Weighted word mapping
Approach - Iterate through each word and calculate the weight of the word by summing up the weights of its characters. Then, find the corresponding character by using the formula 'z' - (weight % 26) and append it to the result string.
Time Complexity - O(n * m) where n is the number of words and m is the average length of the words.
Space Complexity - O(n) for the result string.
*/

class LC3838_WeightedWord {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            int temp = 0;
            for (int i = 0; i < s.length(); i++) {
                temp += weights[s.charAt(i) - 'a'];
            }
            sb.append((char) ('z' - (temp % 26)));
        }
        return sb.toString();
    }

    public static void public static void main(String[] args) {
        LC3838_WeightedWord obj = new LC3838_WeightedWord();
        String[] words = {"abc", "bcd"};
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        System.out.println(obj.mapWordWeights(words, weights));
    }
}