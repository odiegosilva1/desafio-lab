package Etapa3;

public class StaticStack<E> implements Stack<E> {
    private E[] elements;
    private int numElements;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize) {
        this.maxSize = maxSize;
        this.elements = (E[]) new Object[maxSize];
        this.numElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return numElements == maxSize;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public void push(E element) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }
        elements[numElements] = element;
        numElements++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        numElements--;
        E element = elements[numElements];
        elements[numElements] = null;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return elements[numElements - 1];
    }
}