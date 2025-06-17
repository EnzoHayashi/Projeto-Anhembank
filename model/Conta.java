package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private double saldo;
    private List<String> historico;

    public Conta() {
        this.saldo = 5750.00;
        this.historico = new ArrayList<>();
    }

    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        saldo += valor;
        historico.add("Recebimento: R$ " + valor);
    }

    public void sacar(double valor, String descricao) {
        if (saldo >= valor) {
            saldo -= valor;
            historico.add(descricao + ": R$ " + valor);
        }
    }

    public List<String> getHistorico() {
        return historico;
    }
}