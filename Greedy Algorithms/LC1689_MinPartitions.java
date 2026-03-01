class LC1689_MinPartitions {
    public int minPartitions(String n) {
        int maxDig = 0;
        for (char c : n.toCharArray()) {
            maxDig = Math.max(maxDig, c - '0');
        }
        if (maxDig > 9) { // cant go higher
            return 9;
        }
        return maxDig;
    }

    public static void main(String[] args) {
        LC1689_MinPartitions obj = new LC1689_MinPartitions();
        String n = "32";
        System.out.println(obj.minPartitions(n)); // Output: 3
    }
}
