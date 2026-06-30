/*
LeetCode 948 - Bag of Tokens
Approach: Sort the array of tokens and use two pointers to maximize the score by either playing a token face-up (gain score, lose power) or face-down (lose score, gain power).
Time Complexity: O(n log n) due to sorting.
Space Complexity: O(1) since we are only using a constant amount of extra space.
*/

class LC948_BagOfTokens{
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(score, maxScore);
            } else if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                return maxScore;
            }
        }
        return maxScore;
    }
    public static void main(String[] args){
        LC948_BagOfTokens solution = new LC948_BagOfTokens();
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        int result = solution.bagOfTokensScore(tokens, power);
        System.out.println("Maximum score achievable: " + result);
    }
}