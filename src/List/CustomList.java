package List;

public class CustomList<T> {
    private Object[] data;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public CustomList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomList(int capacity) {
        this.data = new Object[capacity > 0 ? capacity : DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T o) {
        if (this.size == this.data.length) {
            this.grow();
        }
        this.data[size++] = o;
    }

    public void add(int index, T o) {
        if (this.checkIndex(index)) {
            this.shiftForward(index);
            this.data[index] = o;
            this.size++;
        } else {
            wrongMessage(index);
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }

    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(T o) {
        int index = -1;
        for (int i = 0; i < this.data.length; i++) {
            if (o.equals(this.data[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Object get(int index) {
        if (this.checkIndex(index)) {
            return this.data[index];
        } else {
            wrongMessage(index);
            return null;
        }
    }

    public void set(int index, T o) {
        if (this.checkIndex(index)) {
            this.data[index] = o;
        } else {
            wrongMessage(index);
        }
    }

    public void remove(int index) {
        if (this.checkIndex(index)) {
            if (index != this.data.length - 1) {
                this.shiftBack(index);
            }
            this.data[--this.size] = null;
        } else {
            wrongMessage(index);
        }
    }

    public void remove(T o) {
        this.remove(this.indexOf(o));
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (this.size == 0) {
            result.append("]");
            return result.toString();
        } else {
            for (int i = 0; i < this.size; i++) {
                if (i < this.size - 1) {
                    result.append(this.data[i]).append(", ");
                } else if (i == this.size - 1) {
                    result.append(this.data[i]).append("]");
                }
            }
        }
        return result.toString();
    }

    private boolean checkIndex(int index) {
        return index < this.size;
    }

    private void grow() {
        Object[] newArray = new Object[(int) (this.data.length * 1.6)];
        System.arraycopy(this.data, 0, newArray, 0, this.data.length);
        this.data = newArray;
    }

    private void shiftForward(int index) {
        if (this.size == this.data.length) {
            this.grow();
        }
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void shiftBack(int index) {
        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    private void wrongMessage(int index) {
        System.out.printf("Wrong index %d for size %d%n", index, this.size);
    }

}
