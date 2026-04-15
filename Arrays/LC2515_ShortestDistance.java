class LC2515_ShortestDistance {
    public int closestTarget(String[] words, String target, int startIndex) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int StraightDistance = Math.abs(i - startIndex);
                int CircularDistance = words.length - StraightDistance;
                result = Math.min(result, Math.min(StraightDistance, CircularDistance));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        LC2515_ShortestDistance sol = new LC2515_ShortestDistance();
        String[] words = { "hello", "i", "am", "leetcode" };
        String target = "hello";
        int startIndex = 1;
        System.out.println(sol.closestTarget(words, target, startIndex));
    }
}
