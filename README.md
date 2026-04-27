# Desafio Lab - Estruturas de Dados

Este projeto contém 4 desafios de estruturas de dados implementados em Java.

## Estrutura do Projeto

```
desafio-lab/
├── README.md
└── src/
    ├── Etapa1/    - Labirinto (Backtracking)
    ├── Etapa2/    - Ordenacao e Pesquisa
    ├── Etapa3/    - Lista Estatica e Pilha Estatica
    └── Etapa4/    - Lista Encadeada, Fila e Pilha Dinamicas
```

---

## Requisito

- Java JDK 8 ou superior

---

## Como Compilar e Executar

### Compilar tudo

```bash
javac -d src src/Etapa1/*.java src/Etapa2/*.java src/Etapa3/*.java src/Etapa4/*.java
```

### Executar o programa principal de cada etapa

```bash
# Etapa 1 - Labirinto
java -cp src Etapa1.PrincipalLabirinto

# Etapa 2 - Candidatos
java -cp src Etapa2.PrincipalCandidatos

# Etapa 3 - Lista e Pilha Estatica
java -cp src Etapa3.PrincipalEtapa3

# Etapa 4 - Lista Encadeada, Fila e Pilha Dinamicas
java -cp src Etapa4.PrincipalEtapa4
```

### Executar o validador de cada etapa

```bash
# Etapa 1
java -cp src Etapa1.ValidadorEtapa1EstudanteMRK

# Etapa 2
java -cp src Etapa2.ValidadorEtapa2MRK

# Etapa 3
java -cp src Etapa3.ValidadorEtapa3EstudanteMRK

# Etapa 4
java -cp src Etapa4.ValidadorEtapa4MRK
```

---

## Etapa 1 - Labirinto (Backtracking)

### Conceitos
- Recursao e Backtracking
- Manipulacao de arquivos
- Arrays bidimensionais

### Arquivos
- `Labirinto.java` - Classe principal com algoritmos
- `PrincipalLabirinto.java` - Classe main
- `ValidadorEtapa1EstudanteMRK.java` - Validador
- `labirinto.txt` - Arquivo de entrada

### Formato do labirinto.txt

| Caractere | Significado |
|-----------|-------------|
| `X` | Parede |
| ` ` | Caminho aberto |
| `D` | Destino/Saida |

### Comandos

```bash
javac -d src src/Etapa1/*.java
java -cp src Etapa1.PrincipalLabirinto
java -cp src Etapa1.ValidadorEtapa1EstudanteMRK
```

---

## Etapa 2 - Ordenacao e Pesquisa

### Conceitos
- Ordenacao (BubbleSort)
- Pesquisa binaria
- Classes model

### Arquivos
- `Candidato.java` - Classe modelo
- `OrdenarCandidatos.java` - Metodos de ordenacao
- `PrincipalCandidatos.java` - Classe main
- `ValidadorEtapa2MRK.java` - Validador

### Metodos implementados
- `ordenaCandidatosPorNome()`
- `ordenaCandidatosPorVotos()`
- `ordenaCandidatosPorPartido()`
- `pesquisaBinariaCandidatos()`

### Comandos

```bash
javac -d src src/Etapa2/*.java
java -cp src Etapa2.PrincipalCandidatos
java -cp src Etapa2.ValidadorEtapa2MRK
```

---

## Etapa 3 - Lista e Pilha Estatica

### Conceitos
- Listas lineares com array fixo
- Pilha (Stack) com capacidade limitada
- Interface generica
- Metodo recursivo
- Validacao de colchetes

### Arquivos
- `List.java` - Interface da lista
- `Stack.java` - Interface da pilha
- `StaticList.java` - Implementacao da lista
- `StaticStack.java` - Implementacao da pilha
- `PrincipalEtapa3.java` - Classe main
- `Etapa3.java` - Validador de colchetes
- `ValidadorEtapa3EstudanteMRK.java` - Validador

### Metodos da StaticList
- `insert(E, pos)` - Insere elemento na posicao
- `remove(pos)` - Remove elemento da posicao
- `get(pos)` - Retorna elemento na posicao
- `search(E)` - Busca elemento
- `contaElementos()` - Contagem iterativa
- `contaElementosRecursivo()` - Contagem recursiva

### Metodos da StaticStack
- `push(E)` - Empilha elemento
- `pop()` - Desempilha elemento
- `top()` - Retorna topo
- `isEmpty()` - Verifica se vazia
- `isFull()` - Verifica se cheia
- `numElements()` - Quantidade de elementos

### Comandos

```bash
javac -d src src/Etapa3/*.java
java -cp src Etapa3.PrincipalEtapa3
java -cp src Etapa3.Etapa3
java -cp src Etapa3.ValidadorEtapa3EstudanteMRK
```

---

## Etapa 4 - Estruturas Dinamicas

### Conceitos
- Listas encadeadas (LinkedList)
- Pilha dinamica (LinkedStack)
- Fila dinamica (LinkedQueue)
- Nodes encadeados

### Arquivos
- `Node.java` - Classe Node generica
- `Stack.java` - Interface da pilha
- `Queue.java` - Interface da fila
- `LinkedList.java` - Implementacao da lista
- `LinkedStack.java` - Implementacao da pilha
- `LinkedQueue.java` - Implementacao da fila
- `PrincipalEtapa4.java` - Classe main
- `ValidadorEtapa4MRK.java` - Validador

### Metodos da LinkedList
- `insertFirst(E)` - Insere no inicio
- `insertLast(E)` - Insere no fim
- `insert(E, pos)` - Insere na posicao
- `removeFirst()` - Remove do inicio
- `removeLast()` - Remove do fim
- `remove(pos)` - Remove da posicao
- `get(pos)` - Retorna elemento
- `search(E)` - Busca elemento
- `isEmpty()` - Verifica se vazia
- `isFull()` - Sempre falso (dinamico)
- `numElements()` - Quantidade

### Metodos da LinkedStack
- `push(E)` - Empilha elemento
- `pop()` - Desempilha elemento
- `top()` - Retorna topo
- `isEmpty()` - Verifica se vazia
- `isFull()` - Sempre falso (dinamico)
- `numElements()` - Quantidade

### Metodos da LinkedQueue
- `enqueue(E)` - Insere no fim
- `dequeue()` - Remove do inicio
- `first()` - Primeiro elemento
- `front()` - Primeiro elemento
- `back()` - Ultimo elemento
- `isEmpty()` - Verifica se vazia
- `isFull()` - Sempre falso (dinamico)
- `numElements()` - Quantidade

### Comandos

```bash
javac -d src src/Etapa4/*.java
java -cp src Etapa4.PrincipalEtapa4
java -cp src Etapa4.ValidadorEtapa4MRK
```

---

## Resumo dos Validadores

| Etapa | Nota Maxima | Testes |
|-------|-------------|--------|
| Etapa 1 | 1.50 | 12 |
| Etapa 2 | 1.50 | - |
| Etapa 3 | 1.50 | 15 |
| Etapa 4 | 1.50 | 22 |