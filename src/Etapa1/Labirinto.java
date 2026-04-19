package Etapa1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {
    private final char PAREDE = 'X';
    private final char CAMINHO_ABERTO = ' ';
    private final char SAIDA = 'D';
    private final char CAMINHO_SOLUCAO = '#';
    
    private char[][] labirinto;
    
    public void criaLabirinto(String filename) {
        List<String> linhas = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.replaceAll("\\s+$", "");
                if (linha.length() > 0) {
                    linhas.add(linha);
                }
            }
            br.close();
            
            if (linhas.isEmpty()) {
                labirinto = new char[0][0];
                return;
            }
            
            int larguraMax = 0;
            for (String l : linhas) {
                larguraMax = Math.max(larguraMax, l.length());
            }
            
            labirinto = new char[linhas.size()][larguraMax];
            
            for (int i = 0; i < linhas.size(); i++) {
                String linhaAtual = linhas.get(i);
                for (int j = 0; j < larguraMax; j++) {
                    if (j < linhaAtual.length()) {
                        labirinto[i][j] = linhaAtual.charAt(j);
                    } else {
                        labirinto[i][j] = CAMINHO_ABERTO;
                    }
                }
            }
            
        } catch (Exception e) {
            labirinto = new char[0][0];
        }
    }
    
    public boolean percorreLabirinto() {
        if (labirinto == null || labirinto.length == 0) {
            return false;
        }
        
        if (labirinto[0][0] == PAREDE) {
            return false;
        }
        
        if (labirinto[0][0] == SAIDA) {
            return true;
        }
        
        return resolverLabirinto(0, 0);
    }
    
    private boolean resolverLabirinto(int x, int y) {
        if (x < 0 || x >= labirinto.length || y < 0 || y >= labirinto[0].length) {
            return false;
        }
        
        char celula = labirinto[x][y];
        
        if (celula == SAIDA) {
            return true;
        }
        
        if (celula == PAREDE || celula == CAMINHO_SOLUCAO) {
            return false;
        }
        
        labirinto[x][y] = CAMINHO_SOLUCAO;
        
        if (resolverLabirinto(x - 1, y)) return true;
        if (resolverLabirinto(x + 1, y)) return true;
        if (resolverLabirinto(x, y - 1)) return true;
        if (resolverLabirinto(x, y + 1)) return true;
        
        labirinto[x][y] = CAMINHO_ABERTO;
        return false;
    }
    
    public void imprimeLabirinto() {
        if (labirinto == null || labirinto.length == 0) {
            System.out.println("Labirinto vazio");
            return;
        }
        
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }
}