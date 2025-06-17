package view;

import model.Conta;
import model.AgendadorDePagamentos;
import model.PagamentoProgramado;

import javax.swing.*;
import java.time.LocalDateTime;

public class TelaAgendamento extends JFrame {
    private Conta conta;
    private AgendadorDePagamentos agendador;
    private TelaPrincipal telaPrincipal;

    public TelaAgendamento(Conta conta, AgendadorDePagamentos agendador, TelaPrincipal telaPrincipal) {
        this.conta = conta;
        this.agendador = agendador;
        this.telaPrincipal = telaPrincipal;

        setTitle("Novo Agendamento");
        setSize(300, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JTextField valorField = new JTextField(10);
        JTextField descricaoField = new JTextField(10);
        JTextField dataField = new JTextField(10); // formato: AAAA-MM-DD
        JTextField horaField = new JTextField(5);  // formato: HH:mm
        JButton confirmar = new JButton("Agendar");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Data (AAAA-MM-DD):"));
        panel.add(dataField);
        panel.add(new JLabel("Hora (HH:mm):"));
        panel.add(horaField);
        panel.add(confirmar);

        add(panel);

        confirmar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(valorField.getText());
                String descricao = descricaoField.getText();
                LocalDateTime dataHora = LocalDateTime.parse(dataField.getText() + "T" + horaField.getText());

                PagamentoProgramado pagamento = new PagamentoProgramado(valor, dataHora, descricao);
                agendador.agendar(pagamento);

                JOptionPane.showMessageDialog(this, "Pagamento agendado!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao agendar. Verifique os campos.");
            }
        });
    }
}