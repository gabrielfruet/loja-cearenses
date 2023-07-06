package br.ufc.gui.login;

import br.ufc.gui.storeSystemFrame.StoreSystemFrame;
import br.ufc.user.VendorManager;

import javax.swing.*;
import java.awt.*;
import br.ufc.store.Store;
import br.ufc.user.VendorUser;

import java.util.Optional;

public class TelaLoginCadastro extends JFrame {
    private JButton btnLogin;
    private JButton btnCadastro;

    private Store mainStore;

    public TelaLoginCadastro(Store store) {
        mainStore = store;
        VendorManager vendorManager = store.getVendorManager();
        setTitle("Tela de Login e Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        btnLogin = new JButton("Login");
        btnCadastro = new JButton("Cadastro");

        btnLogin.addActionListener(e -> exibirTelaLogin(vendorManager));

        btnCadastro.addActionListener(e -> exibirTelaCadastro(vendorManager));

        add(btnLogin);
        add(btnCadastro);
    }

    private void exibirTelaLogin(VendorManager vendorManager) {
        LoginDialog.showLoginDialog(this,vendorManager);
    }

    private void exibirTelaCadastro(VendorManager vendorManager) {
        RegisterDialog.showRegisterDialog(vendorManager);
    }

    public void sucessLogin(Optional<VendorUser> user)
    {
        mainStore.setVendor(user.get());
        SwingUtilities.invokeLater(() -> {
            StoreSystemFrame mainFrame = new StoreSystemFrame(mainStore);
            mainFrame.setVisible(true);
        });
        this.dispose();
    }

}

