package List;

public class CustomLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public CustomLinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    public void add(E e) {
        Node<E> element = new Node<>(last, e, null);
        if (last == null) {
            first = element;
        } else {
            last.next = element;
            element.prev = last;
        }
        last = element;
        size++;
    }

    public void addFirst(E e) {
        Node<E> element = new Node<>(null, e, first);
        if (first == null) {
            last = element;
        } else {
            first.prev = element;
            element.next = first;
        }
        first = element;
        size++;
    }

    public E get(int index) {
        Node<E> ref;
        if (index < size / 2) {
            ref = first;
            for (int i = 0; i < index; i++) {
                ref = ref.next;
            }
        } else {
            ref = last;
            for (int i = size - 1; i > index; i--) {
                ref = ref.prev;
            }
        }
        return ref.value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> ref = first;
        StringBuilder result = new StringBuilder("[");
        if (ref == null) {
            return "[]";
        } else {
            do {
                result.append(ref.value).append(ref.next != null ? ", " : "]");
                ref = ref.next;
            } while (ref != null);
        }
        return result.toString();
    }

    private boolean checkIndex(int index) {
        return index < size && index >= 0;
    }

    private static class Node<E> {
        private Node<E> prev;
        private E value;
        private Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

}
