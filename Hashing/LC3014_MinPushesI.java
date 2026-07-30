import java.util.HashMap;

class LC3014_MinPushesI {
    public int minimumPushes(String word) {
        int n = word.length();
        if (n <= 8) {
            return n;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int assign = 2;

        int count = 0;
        for (char ch : word.toCharArray()) {
            if (assign > 9) {
                assign = 2;
            }

            map.put(assign, map.getOrDefault(assign, 0) + 1);
            count += map.get(assign);
            assign++;
        }
        return count;
    }
    public static void main(String[] args) {
        LC3014_MinPushesI solution = new LC3014_MinPushesI();
        String word = "abcdefghijklmno";
        int result = solution.minimumPushes(word);
        System.out.println("Minimum pushes for the word '" + word + "': " + result);
    }    
}
