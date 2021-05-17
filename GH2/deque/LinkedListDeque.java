package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> { 

    private class Node {

        private T item;
        private Node next;
        private   Node prev;

        Node(T i, Node p, Node n) {
            
            item = i;
            next = n;
            prev = p;
        } 

    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListDeque() { 
        
        head = new Node(null, null, null);
        tail = head;
        size = 0; 
        
    }

/*
    public LinkedListDeque(T item) { 
        
        head = new node(item, null, null);
        tail = head;
        size = 1;
 
    }

 */

    @Override
    public void addFirst(T item) { 

        if (size == 0) {
            
            head = new Node(item, null, null);
            tail = head;

        } else {
            
            Node newNode = new Node(item, null, head);
            head.prev = newNode;
            head = newNode;
        }

        size += 1;
        
    }

    @Override
    public void addLast(T item) { 

        if (size == 0) {
            
            head = new Node(item, null, null);
            tail = head;

        } else {
            
            Node newNode = new Node(item, tail, null);
            tail.next = newNode;
            tail = newNode;
        } 

        size += 1;
    }

    /*
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

     */

    @Override
    public int size() { 

        return size;
    } 

    @Override
    public T removeFirst() { 

        if (isEmpty()) { 
            
            return null;
        } 
        
        T returnVal = head.item;
        
        if (head.next != null) {
            
            head = head.next;
            head.prev = null;
            
        } else {
            
            head = null;
        } 

        size -= 1;

        return returnVal; 
        
    }

    @Override
    public T removeLast() { 

        if (isEmpty()) {

            return null;
        } 

        T returnVal = tail.item;
        
        if (tail.prev != null) { 
            
            tail = tail.prev;
            tail.next = null;

        } else {

            tail = null;
        } 

        size -= 1;
        return returnVal;

    }

    @Override
    public T get(int index) { 

        Node temp = head;
        if (index <= size) { 
 
            for (int i = 0; i < size; i += 1) {

                if (i == index) { 
                    
                    return temp.item;

                } else {
                    
                    temp = temp.next;
                }
            }
        }
        return null;
    }

    public T getRecursive(int index) { 
        
        if (index > size) {
            return null;

        } else if (index == 0) {
            
            return head.item;

        } else {

            return getRecursiveHelper(head.next, index - 1);
        }

    }
    private T getRecursiveHelper(Node next, int index) {

        if (index == 0) { 
            
            return next.item;

        } else {
            
            return getRecursiveHelper(next.next, index - 1);
        } 

    } 

    public void printDeque() {
         
        if (isEmpty()) { 
            
            return;
        }

        Node temp = head;
        while (temp != null) { 

            System.out.print(temp.item + " ");
            temp = temp.next;
        } 

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

            if (other.size() == 0 && this.size() == 0) {

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

        return new LinkedListDequeIterator();
    } 
    
    private class LinkedListDequeIterator implements Iterator<T> { 

        private Node position;

        LinkedListDequeIterator() {

            position = head;
        } 
        
        public boolean hasNext() { 
            
            if (isEmpty()) {
                
                return false;
            } 

            return position != null;
        } 
        
        public T next() { 

            T returnItem = position.item;
            position = position.next;
            return returnItem;
        } 

    }

}


