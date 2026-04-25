package Etapa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {
        String[] nomes = lerArquivo("src/Etapa2/nomes.txt");
        String[] partidos = lerArquivo("src/Etapa2/partidos.txt");

        Random random = new Random();
        int tamanho = random.nextInt(100) + 1;

        Candidato[] candidatos = new Candidato[tamanho];

        for (int i = 0; i < tamanho; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            String partido = partidos[random.nextInt(partidos.length)];
            int votos = random.nextInt(1000) + 1;
            candidatos[i] = new Candidato(nome, partido, votos);
        }

        System.out.println("===========================================================================");
        System.out.println("RELATÓRIO DE VOTAÇÃO");
        System.out.println("===========================================================================");
        System.out.println("Nome");
        System.out.println("Partido");
        System.out.println("Intenções de Votos");
        System.out.println("===========================================================================");

        System.out.println("Candidatos ordenados por nome:");
        ordenaPorNome(candidatos);

        System.out.println("\nCandidatos ordenados por partido:");
        ordenaPorPartido(candidatos);

        System.out.println("\nCandidatos ordenados por votos:");
        ordenaPorVotos(candidatos);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInforme o nome para pesquisa: ");
        String nomePesquisa = scanner.nextLine();

        OrdenarCandidatos.ordenaCandidatosPorNome(candidatos);
        int posicao = OrdenarCandidatos.pesquisaBinariaCandidatos(candidatos, nomePesquisa);

        if (posicao >= 0) {
            System.out.println("[OK] Candidato encontrado na posição " + posicao);
            System.out.println(candidatos[posicao].toString());
        } else {
            System.out.println("[NOK] Candidato não encontrado");
        }

        scanner.close();
    }

    private static void ordenaPorNome(Candidato[] candidatos) {
        Candidato[] copia = candidatos.clone();
        OrdenarCandidatos.ordenaCandidatosPorNome(copia);
        for (Candidato c : copia) {
            System.out.println(c.toString());
        }
    }

    private static void ordenaPorPartido(Candidato[] candidatos) {
        Candidato[] copia = candidatos.clone();
        OrdenarCandidatos.ordenaCandidatosPorPartido(copia);
        for (Candidato c : copia) {
            System.out.println(c.toString());
        }
    }

    private static void ordenaPorVotos(Candidato[] candidatos) {
        Candidato[] copia = candidatos.clone();
        OrdenarCandidatos.ordenaCandidatosPorVotos(copia);
        for (Candidato c : copia) {
            System.out.println(c.toString());
        }
    }

    private static String[] lerArquivo(String caminho) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + caminho);
        }
        return linhas.toArray(new String[0]);
    }
}