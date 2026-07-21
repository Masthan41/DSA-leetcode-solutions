
import java.util.*;
import java.util.*;

class LC3499_MaximizeSelectionI {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // existing count
        int activeBlocks = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                activeBlocks++;
            }
        }

        List<Integer> inactiveBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0')
                    i++;

                inactiveBlocks.add(i - start);
            } else {
                i++;
            }
        }
        int maxPairSum = 0;
        for (int j = 1; j < inactiveBlocks.size(); j++) {
            maxPairSum = Math.max(maxPairSum, inactiveBlocks.get(j) + inactiveBlocks.get(j - 1));
        }
        return maxPairSum + activeBlocks;
    }

    public static void main(String[] a) {
        LC3499_MaximizeSelectionI solution = new LC3499_MaximizeSelectionI();
        String s = "110001100";
        int result = solution.maxActiveSectionsAfterTrade(s);
        System.out.println("Max active sections after trade: " + result);
    }
}
