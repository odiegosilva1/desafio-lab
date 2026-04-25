package Etapa2;

import java.util.Arrays;

public class OrdenarCandidatos {

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        Arrays.sort(candidatos, (c1, c2) -> c1.getNome().compareTo(c2.getNome()));
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos) {
        Arrays.sort(candidatos, (c1, c2) -> Integer.compare(c1.getIntencoesVotos(), c2.getIntencoesVotos()));
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        Arrays.sort(candidatos, (c1, c2) -> c1.getPartido().compareTo(c2.getPartido()));
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int esquerda = 0;
        int direita = candidatos.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            String nomeMeio = candidatos[meio].getNome();
            int comparacao = nomeMeio.compareTo(nome);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}