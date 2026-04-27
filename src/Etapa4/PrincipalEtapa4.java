package Etapa4;

public class PrincipalEtapa4 {
    public static void main(String[] args) {
        System.out.println("=== Demonstracao da Etapa 4 ===\n");

        System.out.println("--- LinkedList ---");
        LinkedList<Integer> lista = new LinkedList<>();
        lista.insertFirst(10);
        lista.insertLast(30);
        lista.insertFirst(5);
        lista.insert(20, 2);
        lista.insertLast(40);
        System.out.println("Lista criada: ");
        for (int i = 0; i < lista.numElements(); i++) {
            System.out.print(lista.get(i) + " ");
        }
        System.out.println();
        System.out.println("Elementos: " + lista.numElements());
        System.out.println("Posicao do 20: " + lista.search(20));
        System.out.println("Removido: " + lista.remove(2));
        System.out.println("Elementos restantes: " + lista.numElements());

        System.out.println("\n--- LinkedStack ---");
        LinkedStack<String> pilha = new LinkedStack<>();
        try {
            pilha.push("A");
            pilha.push("B");
            pilha.push("C");
            System.out.println("Topo: " + pilha.top());
            System.out.println("Elementos: " + pilha.numElements());
            System.out.println("Pop: " + pilha.pop());
            System.out.println("Pop: " + pilha.pop());
            System.out.println("Topo atual: " + pilha.top());
        } catch (OverflowException | UnderflowException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n--- LinkedQueue ---");
        LinkedQueue<Double> fila = new LinkedQueue<>();
        try {
            fila.enqueue(1.5);
            fila.enqueue(2.5);
            fila.enqueue(3.5);
            System.out.println("Primeiro: " + fila.front());
            System.out.println("Ultimo: " + fila.back());
            System.out.println("Elementos: " + fila.numElements());
            System.out.println("Dequeue: " + fila.dequeue());
            System.out.println("Dequeue: " + fila.dequeue());
            System.out.println("Primeiro atual: " + fila.front());
        } catch (OverflowException | UnderflowException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}