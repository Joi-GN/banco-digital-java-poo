import banco.Cliente;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        Cliente joice = new Cliente("Joice");
        Conta corrente = new ContaCorrente(joice);
        Conta poupanca = new ContaPoupanca(joice);

        corrente.depositar(2000);
        corrente.transferencia(1000, poupanca);
        corrente.sacar(600);
        corrente.consultarSaldo();

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
