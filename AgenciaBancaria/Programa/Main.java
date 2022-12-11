package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //NOVOS---------------------------------------------------------------//
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    //MAIN---------------------------------------------------------------//
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }
    //MENU ---------------------------------------------------------------//
    public static void operacoes(){
        System.out.println("|**** • Selecione uma operação • ****|");
        System.out.println("|   1. Criar Conta   |");
        System.out.println("|   2. Depositar     |");
        System.out.println("|   3. Sacar         |");
        System.out.println("|   4. Transferir    |");
        System.out.println("|   5. Listar        |");
        System.out.println("|   6. Sair          |");

        int operacao = input.nextInt();

        switch (operacao){

            case 1: criarConta();
            break;
            case 2: depositar();
                break;
            case 3: sacar();
                break;
            case 4: transferir();
                break;
            case 5: listar();
                break;
            case 6:
                System.out.println("Obrigado por usar nosso sistema!");
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                operacoes();
                break;

        }

    }
    //FUNCTIONS---------------------------------------------------------------//
    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome,cpf,email);
        Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);
        System.out.println("Parabéns sua conta foi criada!");

        operacoes();
    }
    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if (contasBancarias.size()>0){
            for(Conta c: contasBancarias){
                if(c.getNumeroConta()== numeroConta){
                conta =c;
                }
            }
        }
        return conta;
    }
    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            System.out.println("Qual valor deseja depositar?");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso");
        }else{
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }
    public static void sacar(){
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if(conta != null){
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            //System.out.println("Saque realizado com sucesso!");
        }else{
            System.out.println("Conta não encontrada.");
        }
        operacoes();
    }
    public static void transferir(){
        System.out.println("Insira o número da sua conta");
        int numeroEnviando = input.nextInt();
        Conta contaEnviando = encontrarConta(numeroEnviando);
        if(contaEnviando != null){
            System.out.println("Insira o número da conta do destinatário: ");
            int numeroReceber = input.nextInt();
            Conta contaReceber = encontrarConta(numeroReceber);
            if(contaReceber != null){
                System.out.println("Qual o valor da transferência:");
                double valor = input.nextDouble();
                contaEnviando.transferir(contaReceber, valor);
            }else {
                System.out.println("A conta não foi encontrada");
            }
        }
        operacoes();
    }
    public static void listar(){
        if(contasBancarias.size() > 0){
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
            }else{
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
    //---------------------------------------------------------------//