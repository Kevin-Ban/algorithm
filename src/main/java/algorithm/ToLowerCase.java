package algorithm;

public class ToLowerCase {

    /**
     * https://leetcode.com/problems/to-lower-case/
     *
     * @param args
     */

    public static void main(String[] args) {
        String s = "AbDf";
        System.out.println(toLowerCase(s));
    }


    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char) (str.charAt(i) - 'A' + 'a'));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
