# Anhembank – Banco Digital com Pagamentos Agendados

![Java](https://img.shields.io/badge/Java-8%2B-red)
![Swing](https://img.shields.io/badge/GUI-Java_Swing-blue)
![POO](https://img.shields.io/badge/Paradigma-POO-green)

Simulação de um banco digital em Java, com foco em **pagamentos agendados** executados automaticamente conforme uma data simulada. Inclui interface gráfica em Java Swing.

## Objetivo e contexto

Projeto acadêmico para praticar **Programação Orientada a Objetos**: modelagem de classes de domínio, responsabilidades bem definidas e separação entre regras de negócio (`model`) e interface (`view`).

## Funcionalidades

- Cadastro de clientes
- Cadastro de contas vinculadas aos clientes
- Programação de pagamentos futuros
- Avanço do tempo simulado (em dias)
- Execução automática dos pagamentos quando a data agendada é alcançada
- Tela de login e interface gráfica em Swing para operar o sistema

## Arquitetura e organização do código

```
Projeto-Anhembank/
├── Main.java    # ponto de entrada: inicia a tela de login
├── model/       # classes de domínio e regras de negócio
└── view/        # telas em Java Swing (ex.: TelaLogin)
```

Classes de domínio:

| Classe | Responsabilidade |
|---|---|
| `Cliente` | Representa a pessoa usuária do banco |
| `Conta` | Conta bancária com saldo e operações de débito |
| `PagamentoProgramado` | Pagamento agendado, com valor, data de execução e conta associada |
| `AgendadorDePagamentos` | Armazena os pagamentos agendados e os executa conforme a data simulada |

## Tecnologias e decisões técnicas

- **Java (POO):** o domínio é modelado em classes com responsabilidades separadas, o que facilita manutenção e evolução.
- **Java Swing:** biblioteca de interface gráfica já incluída no JDK, sem dependências externas.
- **Data simulada em vez do relógio real:** permite testar o agendamento avançando dias manualmente, sem esperar o tempo passar.
- **Armazenamento em memória:** os clientes ficam em um `HashMap`, mantido durante a execução. Isso simplifica o projeto, que tem como foco a modelagem orientada a objetos, mas significa que os dados não são persistidos ao fechar o programa.

## Como executar

**Pré-requisito:** JDK 8 ou superior.

Pela linha de comando, na raiz do projeto:

```bash
javac -d out Main.java model/*.java view/*.java
java -cp out Main
```

Alternativamente, abrir a pasta em uma IDE (IntelliJ IDEA, Eclipse ou VS Code com extensão Java) e executar a classe `Main`.

## Fluxo de uso

1. Iniciar a aplicação e acessar a tela de login.
2. Cadastrar um cliente e uma conta.
3. Programar um pagamento com valor e data futura.
4. Avançar os dias simulados.
5. Conferir a execução automática do pagamento na data agendada.

<!-- Evidências: adicionar prints das telas em docs/ e referenciar aqui.
![Tela de login](docs/login.png) -->

## Desafios e aprendizados

- Modelagem das responsabilidades entre `Conta`, `PagamentoProgramado` e `AgendadorDePagamentos`.
- Implementação de uma lógica de tempo simulado para disparar eventos agendados.
- Integração entre a interface Swing e as classes de domínio, mantendo as regras de negócio fora das telas.

## Melhorias futuras

- Persistência dos dados (arquivo ou banco relacional).
- Testes unitários (JUnit) para o agendador e para as operações de débito.
- Tratamento e exibição de erros de negócio, como saldo insuficiente.
- Migração para um sistema de build (Maven ou Gradle).
