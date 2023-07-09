package br.ufc.gui.storeSystemFrame;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.jar.JarEntry;

public class MainPanel extends JPanel{
    JLabel totalRevenueLabel = new JLabel();
    public MainPanel(){
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menu Principal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        infoPanel.add(totalRevenueLabel);

        JLabel lastSaleDateLabel = new JLabel("Última Venda: ");
        infoPanel.add(lastSaleDateLabel);

        this.add(infoPanel, BorderLayout.CENTER);
    }
    public void updateTotalRevenueLabel(BigDecimal revenue){
        totalRevenueLabel.setText("Saldo: R$"+revenue.toString());
    }
}
