class LC3296_MinSeconds {
    public boolean check(long mid, int wt[], int mh) {
        long h = 0;
        for (int t : wt) {
            h += (long) (Math.sqrt(2.0 * mid / t + 0.25) - 0.5);
        }
        return h >= mh;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime = 0;
        for (int i : workerTimes) {
            maxTime = Math.max(maxTime, i);
        }

        long l = 1;
        long r = (long) maxTime * mountainHeight * (mountainHeight + 1) / 2;
        long res = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (check(mid, workerTimes, mountainHeight)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LC3296_MinSeconds obj = new LC3296_MinSeconds();
        int[] workerTimes = {2, 1, 1};
        int mountainHeight = 4;
        System.out.println(obj.minNumberOfSeconds(mountainHeight, workerTimes)); // output: 3
    }
}
