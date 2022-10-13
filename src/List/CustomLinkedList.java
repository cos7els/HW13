package List;

public class CustomLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public CustomLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    private void linkFirst(E e) {
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

    private void linkBefore(int index, E e) {
        checkIndex(index);
        Node<E> n = getNode(index);
        Node<E> p = getNode(--index);
        Node<E> element = new Node<>(p, e, n);
        p.next = element;
        n.prev = element;
        size++;
    }

    private void linkLast(E e) {
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

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    public boolean add(int index, E e) {
        if (index == 0) {
            linkFirst(e);
        } else if (index == size) {
            linkLast(e);
        } else {
            linkBefore(index, e);
        }
        return true;
    }

    public E getFirst() {
        return first.value;
    }

    public E get(int index) {
        return getNode(index).value;
    }

    public E getLast() {
        return last.value;
    }

    public boolean contains(E e) {
        Node<E> ref = first;
        boolean result = false;
        while (ref != null) {
            if (ref.value.equals(e)) {
                result = true;
                break;
            }
            ref = ref.next;
        }
        return result;
    }

    public int indexOf(E e) {
        int index = -1;
        Node<E> ref = first;
        for (int i = 0; i < size; i++) {
            if (ref.value.equals(e)) {
                index = i;
                break;
            }
            ref = ref.next;
        }
        return index;
    }

    public int lastIndexOf(E e) {
        int index = -1;
        Node<E> ref = last;
        for (int i = size - 1; i >= 0; i--) {
            if (ref.value.equals(e)) {
                index = i;
                break;
            }
            ref = ref.prev;
        }
        return index;
    }

    public void set(int index, E e) {
        Node<E> ref = getNode(index);
        ref.value = e;
    }

    public void remove(int index) {
        Node<E> ref = getNode(index);
        if (size == 1) {
            first = null;
            last = null;
        } else if (first == ref) {
            first = ref.next;
            first.prev = null;
        } else if (last == ref) {
            last = ref.prev;
            last.next = null;
        } else {
            ref.prev.next = ref.next;
            ref.next.prev = ref.prev;
        }
        ref.next = null;
        ref.prev = null;
        ref.value = null;
        size--;
    }

    public void clear() {
        Node<E> c = first;
        while (c != null) {
            Node<E> n = c.next;
            c.prev = null;
            c.next = null;
            c.value = null;
            c = n;
        }
        first = null;
        last = null;
        size = 0;
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

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getNode(int index) {
        checkIndex(index);
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
        return ref;
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
