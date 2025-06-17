package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Cliente;
import java.util.HashMap;

public class TelaLogin extends JFrame {
    private HashMap<String, Cliente> usuarios;
    private JTextField emailField;
    private JPasswordField senhaField;

    public TelaLogin(HashMap<String, Cliente> usuarios) {
        this.usuarios = usuarios;

        setTitle("Login - AnhemBank");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        emailField = new JTextField(20);
        senhaField = new JPasswordField(20);
        JButton loginBtn = new JButton("Login");
        JButton registrarBtn = new JButton("Registrar");

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(loginBtn);
        panel.add(registrarBtn);

        add(panel);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());

            if (usuarios.containsKey(email) && usuarios.get(email).getSenha().equals(senha)) {
                dispose();
                new TelaPrincipal(usuarios.get(email)).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Credenciais inválidas.");
            }
        });

        registrarBtn.addActionListener(e -> {
            dispose();
            new TelaRegistro(usuarios).setVisible(true);
        });
    }
}