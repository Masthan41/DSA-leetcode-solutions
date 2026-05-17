class LC594_FindLHS{
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxLen = 0;

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, map.get(key) + map.get(key + 1));
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        
    }
}