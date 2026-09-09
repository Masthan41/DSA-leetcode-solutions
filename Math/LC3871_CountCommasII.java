class LC3871_CountCommasII{
    public long countCommas(long n) {
        long result = 0;
        long start = 1000;

        while (start <= n) {
            result += (n - start + 1);
            start *= 1000;
        }
        return result;
    }
    public static void main(String[] a){
        LC3871_CountCommasII solution = new LC3871_CountCommasII();
        System.out.println(solution.countCommas(1000)); // Output: 1
        System.out.println(solution.countCommas(999)); // Output: 0
        System.out.println(solution.countCommas(1500)); // Output: 501
        System.out.println(solution.countCommas(1000000)); // Output: 1001
    }
}