package contas;

import banco.Cliente;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int sequencial = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferencia(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Número: " + this.getNumero());
        System.out.println("Saldo: " + this.getSaldo());
    }

    public void consultarSaldo() {
        System.out.println("Saldo Disponível:");
        System.out.print(this.getSaldo());
    }
}
