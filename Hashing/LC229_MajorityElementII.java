import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LC229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > nums.length / 3) {
                l.add(i);
            }
        }
        return l;
    }
    public static void main(String[] args){
        LC229_MajorityElementII solution = new LC229_MajorityElementII();
        int[] nums = {3, 2, 3};
        System.out.println(solution.majorityElement(nums)); // Output: [3]
    }
}
