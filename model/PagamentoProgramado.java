package model;

import java.time.LocalDateTime;

public class PagamentoProgramado {
    private double valor;
    private LocalDateTime dataHora;
    private String descricao;
    private boolean executado;

    public PagamentoProgramado(double valor, LocalDateTime dataHora, String descricao) {
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.executado = false;
    }

    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    public boolean isExecutado() { return executado; }

    public void executar(Conta conta) {
        if (!executado) {
            conta.sacar(valor, descricao);
            executado = true;
        }
    }
}