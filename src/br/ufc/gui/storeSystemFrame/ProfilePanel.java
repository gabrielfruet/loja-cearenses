package br.ufc.gui.storeSystemFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePanel extends JPanel{

    public ProfilePanel(){
        this.setLayout(new BorderLayout());

        JTextArea salesTextArea = new JTextArea();
        salesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(salesTextArea);
        this.add(scrollPane, BorderLayout.CENTER);
    }

}
