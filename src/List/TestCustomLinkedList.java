package List;

import java.util.Random;

public class TestCustomLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        System.out.println(list);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer value = random.nextInt(100);
            System.out.print(value+", ");
            list.add(value);
        }
        System.out.println();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list + " " +list.size());
        list.add(list.size(), 666666666);
        System.out.println(list + " " +list.size());
        list.add(list.size() - 1, 666666666);
        System.out.println(list + " " +list.size());
        System.out.println(list.indexOf(666666666));
        System.out.println(list.lastIndexOf(0));
        CustomLinkedList<Integer> list2 = new CustomLinkedList<>();
        list2.add(10000);
        System.out.println(list2.get(0));

        /*LinkedList<String> list2 = new LinkedList<>();
        list2.addLast("Hello");
        list2.addLast("World");
        list2.addLast("Java");
        list2.addLast("Dev");
        System.out.println(list2);*/
    }
}
