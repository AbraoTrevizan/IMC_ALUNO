import java.util.Scanner;

// classe que representa uma pessoa
class Pessoa {
    private String nome;      // Nome 
    private String cpf;       // CPF 
    private double peso;      // Peso 
    private double altura;     // Altura 

    // cria a classe pessoa
    public Pessoa(String nome, String cpf, double peso, double altura) {
        this.nome = nome;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
    }

    // métodos getters para acessar os atributos
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}

// classe aluno
class Aluno extends Pessoa {
    private double nota;                  // nota 
    private double percentualPresenca;    // presença 

    // Construtor da classe Aluno
    public Aluno(String nome, String cpf, double peso, double altura, double nota, double percentualPresenca) {
        super(nome, cpf, peso, altura); // Chama o construtor da classe mãe (Pessoa)
        this.nota = nota;
        this.percentualPresenca = percentualPresenca;
    }

    // métodos getters para acessar os atributos do aluno
    public double getNota() {
        return nota;
    }

    public double getPercentualPresenca() {
        return percentualPresenca;
    }
}

// Funçoes para a classe pessoa e aluno

class FuncoesUteis {
    // vai verificar o cpf e se tem 11 numeros
    public boolean verificarCpf(String cpf) {
        return cpf.length() == 11;
    }

    // vai calcular o IMC
    public double calcularIMC(Pessoa pessoa) {
        return pessoa.getPeso() / (pessoa.getAltura() * pessoa.getAltura());
    }

    // vai validar o percentual de presença
    public String avaliarAluno(Aluno aluno) {
        if (aluno.getNota() >= 5 && aluno.getPercentualPresenca() >= 75) {
            return "Aprovado"; // aluno aprovado
        } else {
            return "Reprovado"; // aluno reprovado
        }
    }
}

// classe principal 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicia o scanner
        FuncoesUteis funcoes = new FuncoesUteis(); 

        // faz perguntas ao usuario
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF da pessoa (11 dígitos): ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o peso da pessoa: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a altura da pessoa: ");
        double altura = scanner.nextDouble();

        // Cria uma interface pesssoa
        Pessoa pessoa = new Pessoa(nome, cpf, peso, altura);

        // calcula o IMC
        double imc = funcoes.calcularIMC(pessoa);
        System.out.printf("IMC de %s: %.2f%n", pessoa.getNome(), imc);

        // faz perguntas ao usuario
        System.out.print("Digite a nota do aluno: ");
        double nota = scanner.nextDouble();
        System.out.print("Digite o percentual de presença do aluno: ");
        double presenca = scanner.nextDouble();

        // cria uma interface aluno
        Aluno aluno = new Aluno(nome, cpf, peso, altura, nota, presenca);
        
        // vai estar avaliando o aluno
        String resultado = funcoes.avaliarAluno(aluno);
        System.out.printf("Resultado da avaliação do aluno: %s%n", resultado);

        scanner.close(); 
    }
}
