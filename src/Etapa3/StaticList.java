package Etapa3;

public class StaticList<E> implements List<E> {
    private E[] elements;
    private int numElements;

    @SuppressWarnings("unchecked")
    public StaticList(int capacity) {
        this.elements = (E[]) new Object[capacity];
        this.numElements = 0;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return numElements == elements.length;
    }

    @Override
    public void insert(E element, int pos) {
        if (pos < 0 || pos > numElements) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        if (isFull()) {
            throw new RuntimeException("Lista cheia");
        }
        for (int i = numElements; i > pos; i--) {
            elements[i] = elements[i - 1];
        }
        elements[pos] = element;
        numElements++;
    }

    @Override
    public E remove(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        E removed = elements[pos];
        for (int i = pos; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[numElements - 1] = null;
        numElements--;
        return removed;
    }

    @Override
    public E get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        return elements[pos];
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int contaElementos() {
        return numElements();
    }

    private int contaElementosRecursivo(Object dummy, int index) {
        if (index >= numElements) {
            return 0;
        }
        return 1 + contaElementosRecursivo(null, index + 1);
    }

    public int contaElementosRecursivo() {
        return contaElementosRecursivo(null, 0);
    }
}