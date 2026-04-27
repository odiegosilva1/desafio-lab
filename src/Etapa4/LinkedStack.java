package Etapa4;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int numElements;

    public LinkedStack() {
        this.top = null;
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
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        numElements++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = top.getElement();
        top = top.getNext();
        numElements--;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return top.getElement();
    }
}