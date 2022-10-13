package List;

import java.util.Random;

public class TestCustomStack {
    public static void main(String[] args) {
        Random random = new Random();
        CustomStack<Integer> stack = new CustomStack<>();
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(34);
        stack.push(24);
        stack.push(11);
        stack.push(19);
        stack.push(21);
        System.out.println(stack);
        System.out.println(stack.contains(111));
        System.out.println(stack.size());
        System.out.println(stack.pop(stack.indexOf(24)));
        System.out.println(stack);
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack);
        System.out.println(stack.size());
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(1, 100));
        }
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop(4));
        System.out.println(stack);
        System.out.println(stack.size());

    }
}
