package br.ufc.gui.CRUD;

import br.ufc.gui.exception.ExceptionDialog;
import br.ufc.gui.login.TelaLoginCadastro;
import br.ufc.user.VendorUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.util.Vector;

public abstract class CRUDAbstract<T> extends JPanel {
    protected final Vector<T> elements;
    protected JList<String> elementList;
    protected DefaultListModel<String> listModel;

    JScrollPane scrollPane;

    public CRUDAbstract() {
        elements = new Vector<>();
        listModel = new DefaultListModel<>();

        setLayout(new BorderLayout());

        elementList = new JList<>(listModel);
        scrollPane = new JScrollPane(elementList);
        add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Adicionar");
        JButton editButton = new JButton("Editar");
        JButton deleteButton = new JButton("Excluir");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ação do botão Adicionar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addElement();
            }
        });

        // Ação do botão Editar
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //editElement();
            }
        });

        // Ação do botão Excluir
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //deleteElement();
            }
        });

    }

    public abstract void addElement();

    protected abstract void loadElements();
}