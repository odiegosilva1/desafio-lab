package Etapa1;

public class PrincipalLabirinto {
    public static void main(String[] args) {
        System.out.println("=== LABIRINTO ===");
        System.out.println();
        
        Labirinto labirinto = new Labirinto();
        
        System.out.println("Carregando labirinto...");
        labirinto.criaLabirinto("src/Etapa1/labirinto.txt");
        
        System.out.println("\nLabirinto inicial:");
        labirinto.imprimeLabirinto();
        
        System.out.println("\nBuscando solução...");
        boolean encontrouSaida = labirinto.percorreLabirinto();
        
        if (encontrouSaida) {
            System.out.println("\nSolução encontrada");
            System.out.println("\nLabirinto com o caminho da solução (#):");
            labirinto.imprimeLabirinto();
        } else {
            System.out.println("\nSolução não encontrada");
        }
    }
}