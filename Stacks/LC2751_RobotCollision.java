import java.util.*;

class LC2751_RobotCollision {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer idx[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Stack<Integer> s = new Stack<>();

        Arrays.sort(idx, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer> res = new ArrayList<>();

        for (int currentIdx : idx) {
            if (directions.charAt(currentIdx) == 'R') {
                s.push(currentIdx);
            } else {
                while (!s.isEmpty() && healths[currentIdx] > 0) {
                    int topIdx = s.pop();
                    if (healths[topIdx] > healths[currentIdx]) {
                        healths[topIdx] -= 1;
                        healths[currentIdx] = 0;
                        s.push(topIdx);
                    } else if (healths[topIdx] < healths[currentIdx]) {
                        healths[currentIdx] -= 1;
                        healths[topIdx] = 0;
                    } else {
                        healths[topIdx] = 0;
                        healths[currentIdx] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC2751_RobotCollision obj = new LC2751_RobotCollision();
        int positions[] = { 1, 2, 3, 4 };
        int healths[] = { 10, 15, 8, 16 };
        String directions = "RLRL";
        System.out.println(obj.survivedRobotsHealths(positions, healths, directions));
        // Output: [14, 15]
    }
}