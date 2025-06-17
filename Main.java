import view.TelaLogin;
import model.Cliente;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Cliente> usuarios = new HashMap<>();
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TelaLogin(usuarios).setVisible(true);
        });
    }
}