package Etapa4;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int numElements;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.numElements = 0;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return false;
    }

    public int numElements() {
        return numElements;
    }

    public void insertFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        numElements++;
    }

    public void insertLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        numElements++;
    }

    public void insert(E element, int pos) {
        if (pos < 0 || pos > numElements) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        if (pos == 0) {
            insertFirst(element);
        } else if (pos == numElements) {
            insertLast(element);
        } else {
            Node<E> newNode = new Node<>(element);
            Node<E> current = first;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            numElements++;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        E element = first.getElement();
        first = first.getNext();
        numElements--;
        if (isEmpty()) {
            last = null;
        }
        return element;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }
        E element = last.getElement();
        if (first == last) {
            first = null;
            last = null;
        } else {
            Node<E> current = first;
            while (current.getNext() != last) {
                current = current.getNext();
            }
            current.setNext(null);
            last = current;
        }
        numElements--;
        return element;
    }

    public E remove(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        if (pos == 0) {
            return removeFirst();
        } else if (pos == numElements - 1) {
            return removeLast();
        } else {
            Node<E> current = first;
            for (int i = 0; i < pos - 1; i++) {
                current = current.getNext();
            }
            E element = current.getNext().getElement();
            current.setNext(current.getNext().getNext());
            numElements--;
            return element;
        }
    }

    public E get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        Node<E> current = first;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    public int search(E element) {
        Node<E> current = first;
        int pos = 0;
        while (current != null) {
            if (current.getElement().equals(element)) {
                return pos;
            }
            current = current.getNext();
            pos++;
        }
        return -1;
    }
}