class LC1386_CinemaSeat {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int reserved[] : reservedSeats) {
            int row = reserved[0];
            int seat = reserved[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
        }

        int result = (n - map.size()) * 2;

        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            HashSet<Integer> bookedSeats = entry.getValue();

            boolean groupA = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4)
                    && !bookedSeats.contains(5);
            boolean groupB = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6)
                    && !bookedSeats.contains(7);
            boolean groupC = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8)
                    && !bookedSeats.contains(9);

            if (groupA && groupC) {
                result += 2;
            } else if (groupA || groupB || groupC) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1386_CinemaSeat solution = new LC1386_CinemaSeat();
        int n = 3;
        int[][] reservedSeats = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };
        int result = solution.maxNumberOfFamilies(n, reservedSeats);
        System.out.println("Maximum number of families that can be seated: " + result);
    }
}