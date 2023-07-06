package br.ufc.gui.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginCadastro extends JFrame {
    private JButton btnLogin;
    private JButton btnCadastro;

    public TelaLoginCadastro() {
        setTitle("Tela de Login e Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        btnLogin = new JButton("Login");
        btnCadastro = new JButton("Cadastro");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaLogin();
            }
        });

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaCadastro();
            }
        });

        add(btnLogin);
        add(btnCadastro);
    }

    private void exibirTelaLogin() {
        LoginDialog.showLoginDialog();
    }

    private void exibirTelaCadastro() {
        RegisterDialog.showRegisterDialog();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro();
                telaLoginCadastro.setVisible(true);
            }
        });
    }

}

