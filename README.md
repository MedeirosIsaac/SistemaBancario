# 🏦 Sistema de Gerenciamento Bancário em Java

Este é um sistema de gerenciamento bancário via console desenvolvido em **Java**. O objetivo principal do projeto é aplicar e consolidar os pilares fundamentais da **Programação Orientada a Objetos (POO)** na criação de uma arquitetura flexível, escalável e de fácil manutenção.

## 🚀 Funcionalidades

O sistema possui um menu interativo que permite realizar as seguintes operações:
- **Abertura de Contas:** Criação de Conta Corrente ou Conta Poupança.
- **Operações Financeiras:** Depósitos, Saques e Transferências entre contas.
- **Relatórios:** Listagem de todas as contas ativas no banco.
- **Gestão de Tributos:** Consulta de impostos de uma conta específica ou o cálculo do recolhimento total de tributos do banco.

## 🧠 Arquitetura e Conceitos de POO Aplicados

O projeto foi estruturado para evitar repetição de código e permitir a fácil adição de novos tipos de contas no futuro. Os seguintes conceitos foram aplicados:

* **Abstração:** Criação da classe abstrata `Conta`, que define o "molde" básico (atributos como saldo, cliente, número) e métodos comuns, impedindo que uma conta genérica seja instanciada.
* **Herança:** As classes `ContaCorrente` e `ContaPoupanca` herdam da classe `Conta`, reaproveitando a lógica de depósito, mas implementando suas próprias regras de negócio para saques (ex: Conta Corrente possui taxa de 5% por transação).
* **Interfaces (Contratos):** Implementação da interface `Tributavel`. Apenas contas que possuem obrigações fiscais (como a Conta Corrente) assinam este contrato, garantindo flexibilidade caso o banco passe a oferecer novos serviços tributáveis (como Seguros).
* **Polimorfismo:** Utilização de uma lista única genérica (`ArrayList<Conta>`) no método principal. O sistema invoca métodos como `sacar()` ou verifica instâncias com `instanceof Tributavel` durante laços de repetição, e o Java executa o comportamento correto dinamicamente com base no tipo real do objeto.

## 🛠️ Estrutura do Código

- `Conta.java`: Classe base abstrata.
- `ContaCorrente.java`: Herda de Conta e implementa a interface Tributavel.
- `ContaPoupanca.java`: Herda de Conta (isenta de taxas e tributos).
- `Tributavel.java`: Interface com o método `calcularTributos()`.
- `Main.java`: Classe principal com o menu interativo, o laço de execução e a lista de armazenamento de dados.

## 💻 Como Executar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado na sua máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/sistema-bancario-java.git](https://github.com/SEU_USUARIO/sistema-bancario-java.git)
