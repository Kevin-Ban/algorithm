package algorithm;

public class RevertWords {

    //Given an input string, reverse the string word by word.
    //For example,
    //Given s = "the sky is blue",
    //return "blue is sky the".
    public static void main(String[] args){
        String origin = "this sky    is blue";
        System.out.println(origin);
        System.out.println(revert(origin));
    }

    public static String revert(String origin){
        StringBuilder result = new StringBuilder();
        String[] words = origin.split("\\s+");
        for(int i = words.length - 1; i >= 0; i--){
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString();
    }
}
