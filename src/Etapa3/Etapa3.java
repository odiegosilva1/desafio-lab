package Etapa3;

public class Etapa3 {
    public static void main(String[] args) {
        String expressao = "{[()]}";
        StaticStack<Character> stack = new StaticStack<>(100);
        boolean valido = checkBrackets(stack, expressao);
        System.out.println("Expressao: " + expressao + " -> Valida: " + valido);
    }

    public static boolean checkBrackets(Stack<Character> stack, String expression) {
        try {
            for (char c : expression.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char topo = stack.pop();
                    if (!saoPares(topo, c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        } catch (OverflowException | UnderflowException e) {
            return false;
        }
    }

    private static boolean saoPares(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '[' && fechamento == ']') ||
               (abertura == '{' && fechamento == '}');
    }
}