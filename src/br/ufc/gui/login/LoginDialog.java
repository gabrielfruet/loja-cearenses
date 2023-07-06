package br.ufc.gui.login;

import javax.swing.*;

public class LoginDialog {

    public static void showLoginDialog() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Usuário:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        int option = JOptionPane.showOptionDialog(null, panel, "login", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"login", "Cancelar"}, null);

        if (option == 0) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (isValidLogin(username, password)) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                //Store(vendor);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
                showLoginDialog();
            }
        }
    }

    private static boolean isValidLogin(String username, String password) {

        return username.equals("admin") && password.equals("password123");//VendorManager.login(username,password);
    }
}