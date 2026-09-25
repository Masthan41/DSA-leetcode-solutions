import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class LC1096_BraceExpansionII {
    String s;
    int n;
    int idx = 0;

    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
        idx = 0;

        Set<String> st = performUnion();
        return new ArrayList<>(st); // TreeSet is already sorted
    }

    private Set<String> getUnit() {
        Set<String> result;

        if (s.charAt(idx) == '{') {
            idx++;
            result = performUnion();
        } else { // alphabet
            result = new TreeSet<>();
            result.add(String.valueOf(s.charAt(idx)));
        }

        idx++;
        return result;
    }

    private Set<String> performConcat() {
        Set<String> result = new TreeSet<>();
        result.add(""); // seed value: "" glued onto anything leaves it unchanged

        while (idx < n && (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))) {
            Set<String> temp = getUnit();

            Set<String> concatResult = new TreeSet<>();
            for (String left : result) {
                for (String right : temp) {
                    concatResult.add(left + right);
                }
            }

            result = concatResult;
        }

        return result;
    }

    private Set<String> performUnion() {
        Set<String> result = new TreeSet<>();

        while (true) {
            Set<String> temp = performConcat();
            result.addAll(temp);

            if (idx < n && s.charAt(idx) == ',') {
                idx++;
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC1096_BraceExpansionII solution = new LC1096_BraceExpansionII();
        String expression = "{a,b}{c,{d,e}}";
        List<String> result = solution.braceExpansionII(expression);
        System.out.println(result); // Output: [ac, ad, ae, bc, bd, be]
    }
}
