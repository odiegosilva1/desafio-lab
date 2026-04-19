package Etapa1;

import java.lang.reflect.Method;
import java.io.IOException;

public class ValidadorEtapa1EstudanteMRK {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_VERDE = "\u001B[32m";
    private static final String ANSI_VERMELHO = "\u001B[31m";
    private static final String ANSI_LARANJA = "\u001B[38;5;208m";

    private static int totalTestes = 0;
    private static int acertos = 0;

    public static void main(String[] args) {
        imprimeLinhaAlinhada("",300);
        imprimeLinhaAlinhada("+---------------------------------------------------------------------------+", 60);
        imprimeLinhaAlinhada("|                Validador Etapa 1 Estudante                                |", 60);
        imprimeLinhaAlinhada("+---------------------------------------------------------------------------+", 60);

        validaClasse("Labirinto");

        Object instanciaLabirinto = criaInstanciaClasse("Labirinto");

        boolean labirintoCriado = validaExecucaoMetodoComParametro(instanciaLabirinto, "criaLabirinto", "src/Etapa1/labirinto.txt");

        if (labirintoCriado) {
            System.out.println(ANSI_LARANJA + "[OK] Labirinto foi criado com sucesso. Tentando percorrer o labirinto..." + ANSI_RESET);
            contabilizaTeste(true);
            validaExecucaoMetodo(instanciaLabirinto, "percorreLabirinto");
        } else {
            System.out.println(ANSI_VERMELHO + "[NOK] O labirinto não foi criado. Verifique se o arquivo labirinto.txt existe no caminho correto." + ANSI_RESET);
            contabilizaTeste(false);
        }

        validaMetodo("Labirinto", "imprimeLabirinto");
        validaAtributo("Labirinto", "PAREDE");
        validaAtributo("Labirinto", "CAMINHO_ABERTO");
        validaAtributo("Labirinto", "SAIDA");
        validaAtributo("Labirinto", "CAMINHO_SOLUCAO");
        validaClasse("PrincipalLabirinto");
        validaExecucaoClassePrincipal("PrincipalLabirinto", "Solução encontrada");
        validaRecursao("Labirinto");
        validaTryCatch("Labirinto", "criaLabirinto");

        System.out.println(ANSI_LARANJA + "+---------------------------------------------------------------------------+" + ANSI_RESET);
        double notaFinal = totalTestes > 0 ? 1.5 * ((double) acertos / totalTestes) : 0.0;
        System.out.println(ANSI_LARANJA + "+---------------------------------------------------------------------------+" + ANSI_RESET);
        System.out.printf(ANSI_LARANJA + "| Nota final: %.2f/1.50 (%d acertos em %d testes) |%n", notaFinal, acertos, totalTestes);
        System.out.println(ANSI_LARANJA + "+---------------------------------------------------------------------------+" + ANSI_RESET);
    }

    private static Object criaInstanciaClasse(String nomeClasse) {
        try {
            Class<?> classe = Class.forName("Etapa1." + nomeClasse);
            return classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Erro ao criar instância da classe " + nomeClasse + ": " + e.getCause() + ANSI_RESET);
            return null;
        }
    }

    private static void contabilizaTeste(boolean sucesso) {
        totalTestes++;
        if (sucesso) acertos++;
    }

    private static boolean validaExecucaoMetodoComParametro(Object instancia, String nomeMetodo, String parametro) {
        try {
            Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo, String.class);
            metodo.invoke(instancia, parametro);
            System.out.println(ANSI_VERDE + "[OK] Método " + nomeMetodo + " executado com sucesso." + ANSI_RESET);
            contabilizaTeste(true);
            return true;
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Erro ao executar método " + nomeMetodo + ": " + e.getCause() + ANSI_RESET);
            contabilizaTeste(false);
            return false;
        }
    }

    private static void validaExecucaoMetodo(Object instancia, String nomeMetodo) {
        try {
            Method metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
            Object resultado = metodo.invoke(instancia);
            if (resultado instanceof Boolean && (Boolean) resultado) {
                System.out.println(ANSI_VERDE + "[OK] Método " + nomeMetodo + " executado com sucesso." + ANSI_RESET);
                contabilizaTeste(true);
            } else {
                System.out.println(ANSI_VERMELHO + "[NOK] Método " + nomeMetodo + " não encontrou a saída." + ANSI_RESET);
                contabilizaTeste(false);
            }
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Erro ao executar método " + nomeMetodo + ": " + e.getCause() + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void validaClasse(String nomeClasse) {
        try {
            Class.forName("Etapa1." + nomeClasse);
            System.out.println(ANSI_VERDE + "[OK] Classe " + nomeClasse + " encontrada." + ANSI_RESET);
            contabilizaTeste(true);
        } catch (ClassNotFoundException e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Classe " + nomeClasse + " não encontrada." + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void validaMetodo(String nomeClasse, String nomeMetodo) {
        try {
            Class<?> classe = Class.forName("Etapa1." + nomeClasse);
            classe.getDeclaredMethod(nomeMetodo);
            System.out.println(ANSI_VERDE + "[OK] Método " + nomeMetodo + " encontrado." + ANSI_RESET);
            contabilizaTeste(true);
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Método " + nomeMetodo + " não encontrado." + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void validaAtributo(String nomeClasse, String nomeAtributo) {
        try {
            Class<?> classe = Class.forName("Etapa1." + nomeClasse);
            classe.getDeclaredField(nomeAtributo);
            System.out.println(ANSI_VERDE + "[OK] Atributo " + nomeAtributo + " encontrado." + ANSI_RESET);
            contabilizaTeste(true);
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Atributo " + nomeAtributo + " não encontrado." + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void validaExecucaoClassePrincipal(String nomeClasse, String textoEsperado) {
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            java.io.PrintStream oldOut = System.out;
            System.setOut(ps);

            Class<?> classe = Class.forName("Etapa1." + nomeClasse);
            Method metodoMain = classe.getMethod("main", String[].class);
            metodoMain.invoke(null, (Object) new String[]{});

            System.out.flush();
            System.setOut(oldOut);

            String saidaConsole = baos.toString();
            if (saidaConsole.contains(textoEsperado)) {
                System.out.println(ANSI_VERDE + "[OK] Classe " + nomeClasse + " executada com sucesso." + ANSI_RESET);
                contabilizaTeste(true);
            } else {
                System.out.println(ANSI_VERMELHO + "[NOK] Classe " + nomeClasse + " não encontrou a solução." + ANSI_RESET);
                contabilizaTeste(false);
            }
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Erro ao executar classe " + nomeClasse + ": " + e.getCause() + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void validaRecursao(String nomeClasse) {
        try {
            Class<?> classe = Class.forName("Etapa1." + nomeClasse);
            Method[] metodos = classe.getDeclaredMethods();
            boolean recursivo = false;

            for (Method metodo : metodos) {
                String metodoName = metodo.getName();
                String bytecode = metodo.toString();
                if (bytecode.contains(nomeClasse + "." + metodoName + "(")) {
                    recursivo = true;
                    break;
                }
            }

            if (recursivo) {
                System.out.println(ANSI_VERDE + "[OK] Método recursivo encontrado na classe " + nomeClasse + "." + ANSI_RESET);
                contabilizaTeste(true);
            } else {
                System.out.println(ANSI_VERMELHO + "[NOK] Nenhum método recursivo encontrado na classe " + nomeClasse + "." + ANSI_RESET);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Classe " + nomeClasse + " não encontrada." + ANSI_RESET);
            contabilizaTeste(false);
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Erro ao verificar recursão na classe " + nomeClasse + ": " + e.getCause() + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void validaTryCatch(String nomeClasse, String nomeMetodo) {
        try {
            Class<?> classe = Class.forName("Etapa1." + nomeClasse);
            Method metodo = classe.getDeclaredMethod(nomeMetodo, String.class);
            Object instancia = classe.getDeclaredConstructor().newInstance();

            try {
                metodo.invoke(instancia, "arquivo_inexistente.txt");
                System.out.println(ANSI_VERMELHO + "[NOK] Método " + nomeMetodo + " deveria ter tratado a exceção." + ANSI_RESET);
                contabilizaTeste(false);
            } catch (Exception e) {
                if (e.getCause() instanceof IOException) {
                    System.out.println(ANSI_VERDE + "[OK] Método " + nomeMetodo + " contém try-catch." + ANSI_RESET);
                    contabilizaTeste(true);
                } else {
                    System.out.println(ANSI_VERMELHO + "[NOK] Método " + nomeMetodo + " lançou uma exceção inesperada: " + e.getCause().getClass().getSimpleName() + ANSI_RESET);
                    contabilizaTeste(false);
                }
            }
        } catch (Exception e) {
            System.out.println(ANSI_VERMELHO + "[NOK] Erro ao validar try-catch no método " + nomeMetodo + "." + ANSI_RESET);
            contabilizaTeste(false);
        }
    }

    private static void imprimeLinhaAlinhada(String linha, int comprimentoTotal) {
        StringBuilder sb = new StringBuilder(linha);
        while (sb.length() < comprimentoTotal) {
            sb.append(" ");
        }
        System.out.println(ANSI_LARANJA + sb.toString() + ANSI_RESET);
    }
}