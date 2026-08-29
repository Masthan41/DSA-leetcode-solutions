import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LC2948_SmallestArray {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] vec = nums.clone();
        Arrays.sort(vec);

        int groupNum = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();

        numToGroup.put(vec[0], groupNum);
        groupToList.putIfAbsent(groupNum, new LinkedList<>());
        groupToList.get(groupNum).add(vec[0]);

        for (int i = 1; i < n; i++) {
            if (Math.abs(vec[i] - vec[i - 1]) > limit) {
                groupNum++;
            }
            numToGroup.put(vec[i], groupNum);
            groupToList.putIfAbsent(groupNum, new LinkedList<>());
            groupToList.get(groupNum).add(vec[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            result[i] = groupToList.get(group).pollFirst(); // Use and remove the smallest element
        }
        return result;
    }

    public static void main(String[] args) {
        LC2948_SmallestArray solution = new LC2948_SmallestArray();
        int[] nums = { 4, 3, 1, 2 };
        int limit = 1;
        int[] result = solution.lexicographicallySmallestArray(nums, limit);
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 3, 4]
    }
}