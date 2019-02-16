package algorithm;

public class ReverseString {

    /**
     * https://leetcode-cn.com/problems/reverse-string/
     *
     * @param args
     */
    public static void main(String[] args){
        char[] array = new char[]{ 'h', 'j', 'l', '2' };
        reverseString(array);
    }

    public static void reverseString(char[] s){
        System.out.println(s);
        if(s.length > 0){
            char c;
            int length = s.length - 1;
            for(int i = 0; i < s.length / 2; i++){
                c = s[length];
                s[length] = s[i];
                s[i] = c;
                length--;
            }
        }
        System.out.println(s);
    }
}
