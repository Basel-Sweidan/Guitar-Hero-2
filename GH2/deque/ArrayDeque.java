package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>  {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {

        items = (T[]) new Object[1];
        nextFirst = -1;
        nextLast = -1;
        size = 0;
    }


    //done
    private void resize(int capacity) {

        T[] copy = (T[]) new Object[capacity];
        int copyFirst = 0;
        int copyLast = 0;
        while (nextFirst != nextLast) {

            copy[copyLast] = items[nextFirst];
            copyLast += 1;
            nextFirst = (nextFirst + 1) % items.length;
        }

        copy[copyLast] = items[nextLast];
        items = copy;
        nextFirst = copyFirst;
        nextLast = copyLast;
    }

    //done
    //adds item to the head of the array
    @Override
    public void addFirst(T item) {

        if (size == items.length) {

            resize(size * 2);
        }

        if (isEmpty()) {

            nextLast = 0;
            nextFirst = (nextFirst + 1) % items.length;
            items[nextFirst] = item;

        } else if (nextFirst == 0) {

            nextFirst = items.length - 1;
            items[nextFirst] = item;
        } else {

            nextFirst -= 1;
            items[nextFirst] = item;
        }

        size += 1;
    }

    //done
    //adds item to the end of the array
    @Override
    public void addLast(T item) {

        if (size == items.length) {

            resize(size * 2);

        } else if (isEmpty()) {

            nextFirst = 0;
        }

        nextLast = (nextLast + 1) % items.length;
        items[nextLast] = item;
        size += 1;
    }

    /*

    //returns true if size = 0 and false is size is not 0
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
     */


    //returns the size
    @Override
    public int size() {

        return size;
    }

    //done
    //removes and return the first element of the array
    @Override
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        T returnVal = items[nextFirst];
        items[nextFirst] = null;
        if (size == 1) {

            nextFirst = -1;
            nextLast = -1;

        } else {

            nextFirst = (nextFirst + 1) % items.length;
        }

        size -= 1;
        if ((size < items.length / 4) && (size > 4)) {

            resize(items.length / 4);
        }

        return  returnVal;
    }

    //done
    //removes and returns the last element of the array
    @Override
    public T removeLast() {

        if (isEmpty()) {

            return null;
        }

        T returnVal = items[nextLast];
        items[nextLast] = null;

        if (nextLast == 0) {

            nextLast = items.length - 1;

        } else if (size == 1) {

            nextLast = -1;
            nextFirst = -1;

        } else {

            nextLast = nextLast - 1;
        }

        size -= 1;

        if ((size < items.length / 4) && (size > 4)) {

            resize(items.length / 4);
        }

        return returnVal;
    }

    @Override
    public T get(int index) {

        if (isEmpty()) {

            return null;

        } else {

            return items[(nextFirst + index) % items.length];
        }
    }

    @Override
    public void printDeque() {

        if (isEmpty()) {

            return;
        }

        int index = nextFirst;
        while (index != nextLast) {

            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }

        System.out.print(items[nextLast]);
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {

        boolean same = true;

        if (this == o) {

            same = true;
        }

        if (o instanceof Deque) {

            Deque<T> other = (Deque<T>) o;

            if (other.size() == 0 && this.size == 0) {

                return true;

            } else if (other.size() == this.size()) {

                for (int i = 0; i < this.size(); i += 1) {

                    if (other.get(i).equals(this.get(i))) {

                        continue;

                    } else {

                        return false;
                    }
                }

            } else {

                same = false;
            }
        }

        return same;

    }


    public Iterator<T> iterator() {

        return new ArrayDequeIterator();
    }

    public class ArrayDequeIterator implements Iterator<T> {

        private int position;

        ArrayDequeIterator() {

            position = nextFirst;
        }

        public boolean hasNext() {

            if (isEmpty()) {

                return false;

            } else {

                return items[((position + 1) % items.length)] != null;

            }

        }
        public T next() {

            T returnItem = items[position];
            position = (position + 1) % items.length;
            return returnItem;

        }

    }


}

