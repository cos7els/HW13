package List;

import java.util.LinkedList;
import java.util.Random;

public class TestCustomLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        Random random = new Random();
        /*for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);*/
        list.addFirst(100);
        list.addFirst(300);
        list.add(200);
        System.out.println(list);
        System.out.println(list.get(1));

        /*LinkedList<String> list2 = new LinkedList<>();
        list2.addLast("Hello");
        list2.addLast("World");
        list2.addLast("Java");
        list2.addLast("Dev");
        System.out.println(list2);*/
    }
}
