/*
LeetCode 1249 - Minimum Remove to Make Valid Parentheses
Approach: Stack of indices to track unmatched brackets
Time complexity: O(n)
Space complexity: O(n)
*/

import java.util.*;

class LC1249_MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String str) {
        Stack<Integer> s = new Stack<>();
        Set<Integer> re = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                s.push(i);
            } else if (ch == ')') {
                if (!s.isEmpty()) {
                    s.pop();
                } else {
                    re.add(i);
                }
            }
        }
        while(!s.isEmpty()){
            re.add(s.pop());
        }

        //String builder for result
        StringBuilder ans=new StringBuilder();
        for(int i=0; i<str.length();i++){
            if(!re.contains(i)){
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }
}
