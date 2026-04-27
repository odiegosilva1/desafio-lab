package Etapa4;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;
    private int numElements;

    public LinkedQueue() {
        this.first = null;
        this.last = null;
        this.numElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public void enqueue(E element) throws OverflowException {
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

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = first.getElement();
        first = first.getNext();
        numElements--;
        if (isEmpty()) {
            last = null;
        }
        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return first.getElement();
    }

    public E first() throws UnderflowException {
        return front();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return last.getElement();
    }
}