package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class kuohao {

    public static void main(String[] ars) {
        List<String> tmp = new ArrayList(Arrays.asList(")))))((((((()".split("")));

//        Stack<String> stack = new Stack<>();
//        boolean isFirst = true;
//        for (String s : tmp) {
//            if (isFirst && "(".equalsIgnoreCase(s)) {
//                stack.push(s);
//                isFirst = false;
//            } else if (isFirst && ")".equalsIgnoreCase(s)) {
//                continue;
//            }
//        }

        Stack<String> stack = new Stack<>();
        boolean isFirst = true;
        for (String s : tmp) {
            if ("(".equals(s) && isFirst) {
                stack.push(s);
                isFirst = false;
            } else if (")".equals(s) && isFirst) {
                continue;
            } else {
                stack.push(s);
            }
        }
        if (!stack.contains(")")) {
            stack.clear();
        }
        while (stack.size() != 0 && stack.empty()) {
            if (")".equalsIgnoreCase(stack.pop())) {
                break;
            }
        }
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
