# 🧩 Projeto Labirinto - Etapa 1

## 📖 Sobre o Projeto

Implementação em Java de um **solucionador de labirintos** utilizando **recursão e backtracking**. O programa lê um labirinto de um arquivo de texto e encontra automaticamente o caminho até a saída, marcando a rota com `#`.

### 🧠 Conceitos aplicados

- Recursão e Backtracking
- Manipulação de arquivos (try-with-resources)
- Arrays bidimensionais
- Programação orientada a objetos

---

## 📁 Estrutura do Projeto

```
projeto/
├── src/
│   └── Etapa1/
│       ├── Labirinto.java
│       ├── PrincipalLabirinto.java
│       ├── ValidadorEtapa1EstudanteMRK.java
│       └── labirinto.txt
```

---

## 🗺️ Formato do Arquivo `labirinto.txt`

| Caractere | Significado               |
|-----------|---------------------------|
| `X`       | Parede (bloqueado)        |
| ` `       | Caminho aberto (espaço)   |
| `D`       | Destino / Saída           |

### Exemplo:

```
XXXXXX  XXXXXX
  X XX XXXXXX X
X  X XXX   XXXX
  XX X XXX XXXX
X     XX XXXX X
XX  XXX XXXX XX
XX     DXXXXXXX
```

---

## 🚀 Como Executar

### ✅ Pré-requisitos

- Java JDK 8 ou superior

### 🔧 Comandos

```bash
# 1. Compilar
javac src/Etapa1/*.java

# 2. Executar o programa principal
java -cp src Etapa1.PrincipalLabirinto

# 3. Executar o validador
java -cp src Etapa1.ValidadorEtapa1EstudanteMRK
```

---

## 📊 Exemplo de Saída

### Labirinto inicial:
```
XXXXXX  XXXXXX
  X XX XXXXXX X
X  X XXX   XXXX
  XX X XXX XXXX
X     XX XXXX X
XX  XXX XXXX XX
XX     DXXXXXXX
```

### Labirinto com solução:
```
#XXXXXX  XXXXXX
##X XX XXXXXX X
X# X XXX   XXXX
 #XX X XXX XXXX
X##   XX XXXX X
XX# XXX XXXX XX
XX#####DXXXXXXX
```

---

## ✅ Testes do Validador

O validador executa **12 testes** automatizados:

| # | Teste | Descrição |
|---|-------|-----------|
| 1 | `validaClasse` | Verifica se a classe `Labirinto` existe |
| 2 | `validaExecucaoMetodoComParametro` | Testa o método `criaLabirinto` |
| 3 | `validaExecucaoMetodo` | Testa o método `percorreLabirinto` |
| 4 | `validaMetodo` | Verifica método `imprimeLabirinto` |
| 5 | `validaAtributo` | Verifica atributo `PAREDE` |
| 6 | `validaAtributo` | Verifica atributo `CAMINHO_ABERTO` |
| 7 | `validaAtributo` | Verifica atributo `SAIDA` |
| 8 | `validaAtributo` | Verifica atributo `CAMINHO_SOLUCAO` |
| 9 | `validaClasse` | Verifica classe `PrincipalLabirinto` |
| 10 | `validaExecucaoClassePrincipal` | Executa `PrincipalLabirinto` e busca "Solução encontrada" |
| 11 | `validaRecursao` | Verifica se existe método recursivo |
| 12 | `validaTryCatch` | Verifica tratamento de exceção no `criaLabirinto` |

### Resultado esperado:

```
[OK] Classe Labirinto encontrada.
[OK] Método criaLabirinto executado com sucesso.
[OK] Labirinto foi criado com sucesso.
[OK] Método percorreLabirinto executado com sucesso.
[OK] Método imprimeLabirinto encontrado.
[OK] Atributo PAREDE encontrado.
[OK] Atributo CAMINHO_ABERTO encontrado.
[OK] Atributo SAIDA encontrado.
[OK] Atributo CAMINHO_SOLUCAO encontrado.
[OK] Classe PrincipalLabirinto encontrada.
[OK] Classe PrincipalLabirinto executada com sucesso.
[OK] Método recursivo encontrado.
[OK] Método criaLabirinto contém try-catch.
+---------------------------------------------------------------------------+
| Nota final: 1,50/1.50 (12 acertos em 12 testes) |
+---------------------------------------------------------------------------+
```

---

## 📚 Principais Métodos da Classe `Labirinto`

| Método | Descrição |
|--------|-----------|
| `criaLabirinto(String filename)` | Lê o arquivo e carrega o labirinto |
| `percorreLabirinto()` | Inicia a busca recursiva pela saída |
| `resolverLabirinto(int x, int y)` | Método recursivo que explora o labirinto |
| `imprimeLabirinto()` | Exibe o labirinto no console |

---

## 🧠 Explicação do Algoritmo

1. Começa na posição `[0][0]`
2. Marca a posição atual com `#`
3. Tenta mover para: **cima, baixo, esquerda, direita**
4. Se encontrar `'D'` → solução encontrada
5. Se encontrar parede `'X'` ou já visitado → volta (backtracking)
6. Repete até encontrar a saída ou explorar todo o labirinto

---

## 🐛 Possíveis Erros e Soluções

| Erro | Solução |
|------|---------|
| `ClassNotFoundException` | Execute da **RAIZ** com `-cp src` |
| `FileNotFoundException` | Verifique se `labirinto.txt` está em `src/Etapa1/` |
| Try-catch não reconhecido | Use `catch (Exception e)` |

---

## 👨‍💻 Autor

Desenvolvido para a disciplina de Programação - **UNISINOS**

---

## 🎯 Resumo

✅ Leitura de arquivo  
✅ Busca recursiva com backtracking  
✅ Marcação do caminho da solução  
✅ Tratamento de exceções  
✅ 12/12 testes no validador  
✅ Nota máxima: 1.50/1.50