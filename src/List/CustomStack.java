package List;

public class CustomStack<E> {
    private Element<E> peek;
    private int size;

    public CustomStack() {
        peek = null;
        size = 0;
    }

    public boolean push(E e) {
        peek = new Element<>(peek, e);
        size++;
        return true;
    }

    public E pop() {
        E value = peek.value;
        peek = peek.next;
        size--;
        return value;
    }

    public E pop(int index) {
        checkIndex(index);
        E value = null;
        for (int i = 0; i <= index; i++)
            value = pop();
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return peek == null;
    }

    public boolean contains(E e) {
        for (Element<E> ref = peek; ref != null; ref = ref.next)
            if (ref.value.equals(e)) return true;
        return false;
    }

    public int indexOf(E e) {
        int index = 0;
        for (Element<E> ref = peek; ref != null; ref = ref.next) {
            if (ref.value.equals(e)) return index;
            index++;
        }
        return -1;
    }

    public boolean clear() {
        for (Element<E> ref = peek, next = ref.next; next != null; ref = next, next = ref.next) {
            ref.next = null;
            ref.value = null;
        }
        peek = null;
        size = 0;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(peek != null ? "[" : "[]");
        for (Element<E> ref = peek; ref != null; ref = ref.next)
            result.append(ref.value).append(ref.next != null ? ", " : "]");
        return result.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private static class Element<E> {
        private Element<E> next;
        private E value;

        public Element(Element<E> next, E value) {
            this.next = next;
            this.value = value;
        }
    }

}
