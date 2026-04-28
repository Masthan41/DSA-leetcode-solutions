class LC2033_MinOperations{
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> list = new ArrayList<>();

        // Flatten the grid into a list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }

        int L = list.size();

        // Find the median using sorting
        Collections.sort(list);
        int target = list.get(L / 2);

        int result = 0;
        for (int num : list) {
            if (num % x != target % x) {
                return -1;
            }
            result += Math.abs(target - num) / x;
        }
        return result;
    }
    public static void main(String[] args){
        LC2033_MinOperations obj = new LC2033_MinOperations();
        int grid[][]={{2,4},{6,8}};
        System.out.println(minOperations(grid, 2));
    }
}