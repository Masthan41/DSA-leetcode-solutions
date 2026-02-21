class LC168_ConvertToTitle {
    public String convertToTitle(int colNum) {
        StringBuilder res = new StringBuilder();
        while (colNum > 0) {
            // shifts to 0 base indexing
            colNum--;
            int rem = colNum % 26;
            char ch = (char) ('A' + rem);
            res.append(ch);
            colNum = colNum / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LC168_ConvertToTitle obj = new LC168_ConvertToTitle();
        System.out.println(obj.convertToTitle(1)); // A
        System.out.println(obj.convertToTitle(28)); // AB
        System.out.println(obj.convertToTitle(701)); // ZY
    }
}