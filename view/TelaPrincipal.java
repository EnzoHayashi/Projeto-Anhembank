package view;

import model.Cliente;
import model.Conta;
import model.AgendadorDePagamentos;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class TelaPrincipal extends JFrame {
    private Cliente cliente;
    private AgendadorDePagamentos agendador = new AgendadorDePagamentos();
    private JLabel saldoLabel;
    private JTextArea extratoArea;

    public TelaPrincipal(Cliente cliente) {
        this.cliente = cliente;
        setTitle("AnhemBank");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        saldoLabel = new JLabel();
        atualizarSaldo();

        JButton agendarBtn = new JButton("Agendar");
        agendarBtn.addActionListener(e -> {
            new TelaAgendamento(cliente.getConta(), agendador, this).setVisible(true);
        });

        JButton simularTempoBtn = new JButton("Simular Pagamento");
        simularTempoBtn.addActionListener(e -> {
            agendador.simular(LocalDateTime.now().plusDays(1), cliente.getConta());
            atualizarSaldo();
            atualizarExtrato();
        });

        extratoArea = new JTextArea(10, 30);
        extratoArea.setEditable(false);
        atualizarExtrato();

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 1));
        top.add(new JLabel("Olá, " + cliente.getNome()));
        top.add(saldoLabel);
        top.add(agendarBtn);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(extratoArea), BorderLayout.CENTER);
        add(simularTempoBtn, BorderLayout.SOUTH);
    }

    public void atualizarSaldo() {
        saldoLabel.setText("Saldo da Conta: R$ " + String.format("%.2f", cliente.getConta().getSaldo()));
    }

    public void atualizarExtrato() {
        StringBuilder sb = new StringBuilder();
        for (String mov : cliente.getConta().getHistorico()) {
            sb.append(mov).append("\n");
        }
        extratoArea.setText(sb.toString());
    }
}