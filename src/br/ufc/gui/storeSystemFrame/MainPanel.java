package br.ufc.gui.storeSystemFrame;

import br.ufc.stock.sale.Sale;
import br.ufc.store.Store;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class MainPanel extends JPanel{
    JLabel totalRevenueLabel = new JLabel();
    JLabel lastSaleDateLabel = new JLabel();
    public MainPanel(){
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menu Principal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        infoPanel.add(totalRevenueLabel);

        infoPanel.add(lastSaleDateLabel);

        this.add(infoPanel, BorderLayout.CENTER);
    }
    public void updateTotalRevenueLabel(BigDecimal revenue){
        totalRevenueLabel.setText("Saldo: R$"+revenue.toString());
    }
    public void updateLastSaleLabel(Optional<Sale> optionalSale){
        if(optionalSale.isPresent()){
            LocalDate SaleDate = optionalSale.get().getDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = SaleDate.format(formatter);
            lastSaleDateLabel.setText("Ultima venda: "+SaleDate);
        }
        else{
            lastSaleDateLabel.setText("Ultima venda:");
        }

    }
}
