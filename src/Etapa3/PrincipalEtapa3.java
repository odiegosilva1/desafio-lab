package Etapa3;

public class PrincipalEtapa3 {
    public static void main(String[] args) {
        System.out.println("=== Demonstracao da Etapa 3 ===\n");

        StaticList<String> lista = new StaticList<>(10);
        System.out.println("Lista criada com capacidade 10");

        lista.insert("Primeiro", 0);
        lista.insert("Segundo", 1);
        lista.insert("Terceiro", 2);
        System.out.println("Elementos inseridos: " + lista.numElements());

        System.out.println("Elemento na posicao 1: " + lista.get(1));
        System.out.println("Posicao de 'Terceiro': " + lista.search("Terceiro"));

        String removido = lista.remove(1);
        System.out.println("Elemento removido: " + removido);
        System.out.println("Elementos restantes: " + lista.numElements());

        System.out.println("Contagem iterativa: " + lista.contaElementos());
        System.out.println("Contagem recursiva: " + lista.contaElementosRecursivo());

        System.out.println("\n=== Demonstracao da Pilha ===\n");

        StaticStack<Integer> pilha = new StaticStack<>(5);
        System.out.println("Pilha criada com capacidade 5");

        try {
            pilha.push(10);
            pilha.push(20);
            pilha.push(30);
            System.out.println("Elementos empilhados: " + pilha.numElements());
            System.out.println("Topo: " + pilha.top());

            int topo = pilha.pop();
            System.out.println("Desempilhado: " + topo);
            System.out.println("Elementos restantes: " + pilha.numElements());
        } catch (OverflowException | UnderflowException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n=== Validacao de Colchetes ===\n");

        String expressao1 = "{[()]}";
        String expressao2 = "{[(])}";
        String expressao3 = "((()))";
        String expressao4 = "([{}])";

        System.out.println("Expressao: " + expressao1 + " -> Valida: " + Etapa3.checkBrackets(new StaticStack<>(expressao1.length()), expressao1));
        System.out.println("Expressao: " + expressao2 + " -> Valida: " + Etapa3.checkBrackets(new StaticStack<>(expressao2.length()), expressao2));
        System.out.println("Expressao: " + expressao3 + " -> Valida: " + Etapa3.checkBrackets(new StaticStack<>(expressao3.length()), expressao3));
        System.out.println("Expressao: " + expressao4 + " -> Valida: " + Etapa3.checkBrackets(new StaticStack<>(expressao4.length()), expressao4));
    }
}