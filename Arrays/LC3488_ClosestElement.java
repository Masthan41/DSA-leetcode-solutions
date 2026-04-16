class LC3488_ClosestElement{
     public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //store indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int qi : queries) {
            int element = nums[qi];
            List<Integer> vec = map.get(element);

            int size = vec.size();

            if (size == 1) {
                result.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(vec, qi);
            int res = Integer.MAX_VALUE;

            //right side
            int right = vec.get((pos + 1) % size);
            int d = Math.abs(qi - right);
            int CircularDist = n - d;
            res = Math.min(res, Math.min(d, CircularDist));

            //left side
            int left = vec.get((pos - 1 + size) % size);
            d = Math.abs(qi - left);
            CircularDist = n - d;
            res = Math.min(res, Math.min(d, CircularDist));

            result.add(res);
        }
        return result;
    }
    public static void main(String args[]){
        LC3488_ClosestElement obj = new LC3488_ClosestElement();
        int[] nums = {1, 2, 3, 4, 2};
        int[] queries = {0, 1, 2, 3, 4};
        List<Integer> result = obj.solveQueries(nums, queries);
        System.out.println(result);
    }
}