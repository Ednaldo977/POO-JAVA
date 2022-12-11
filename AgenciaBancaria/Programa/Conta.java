package Programa;

import Utilitarios.Utils;

public class Conta {
    //---------------------------------------------------------------//
    private static int contadorConta = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0;
    //CONSTRUCTOR---------------------------------------------------------------//
    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorConta;
        this.pessoa = pessoa;
        contadorConta += 1;
    }
    //GETTERS AND SETTERS ---------------------------------------------------------------//
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //METODO TOSTRING---------------------------------------------------------------//
    public String toString(){
        return "\nNúmero da conta: " + this.getNumeroConta()+
        "\nNome: " + this.pessoa.getNome()+
        "\nCPF: " + this.pessoa.getCpf()+
        "\nEmail: " + this.pessoa.getEmail()+
        "\nSaldo: " + Utils.doubleToString(this.getSaldo())+
                "\n";

    }
    //METODOS---------------------------------------------------------------//
    public void depositar(double valor){
        if(valor > 0){
            setSaldo(getSaldo()+valor);
            System.out.println("Depósito Autorizado com sucesso!");
        }else{
            System.out.println("Depósito recusado");
        }
    }
    public void sacar(double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque Autorizado com sucesso!");
        }else{
            System.out.println("Saque recusado pelo banco");
        }
    }
    public void transferir(Conta contaDestino, double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaDestino.saldo = contaDestino.getSaldo() + valor;
            System.out.println("Transferência Autorizada com Sucesso!");
        }else {
            System.out.println("Transação recusada!");
        }
    }
}
