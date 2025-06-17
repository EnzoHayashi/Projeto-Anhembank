package view;

import javax.swing.*;
import java.awt.event.*;
import model.Cliente;
import java.util.HashMap;

public class TelaRegistro extends JFrame {
    private JTextField nomeField, emailField;
    private JPasswordField senhaField;
    private HashMap<String, Cliente> usuarios;

    public TelaRegistro(HashMap<String, Cliente> usuarios) {
        this.usuarios = usuarios;

        setTitle("Registrar - AnhemBank");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        nomeField = new JTextField(20);
        emailField = new JTextField(20);
        senhaField = new JPasswordField(20);
        JButton registrarBtn = new JButton("Registrar");

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(registrarBtn);

        add(panel);

        registrarBtn.addActionListener(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());

            if (!usuarios.containsKey(email)) {
                Cliente novo = new Cliente(nome, email, senha);
                usuarios.put(email, novo);
                JOptionPane.showMessageDialog(this, "Registrado com sucesso!");
                dispose();
                new TelaLogin(usuarios).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Email já cadastrado!");
            }
        });
    }
}