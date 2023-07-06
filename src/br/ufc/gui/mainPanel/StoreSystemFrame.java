package br.ufc.gui.mainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreSystemFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel profilePanel;
    private List<String> sales;

    public StoreSystemFrame() {
        setTitle("Sistema de Stock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        sales = new ArrayList<>();

        createMenuBar();
        createMainPanel();
        createProfilePanel();

        showMainPanel();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu itemMenu = new JMenu("Item");

        JMenuItem createItem = new JMenuItem("Criar Item");
        createItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateItemDialog();
            }
        });
        itemMenu.add(createItem);

        JMenuItem viewItems = new JMenuItem("Ver Itens");
        viewItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação executada ao clicar em "Ver Itens"
                JOptionPane.showMessageDialog(null, "Ver Itens selecionado");
            }
        });
        itemMenu.add(viewItems);

        menuBar.add(itemMenu);

        JMenu stockMenu = new JMenu("Stock");

        JMenuItem createStock = new JMenuItem("Criar Stock");
        createStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateStockDialog();
            }
        });
        stockMenu.add(createStock);

        JMenuItem viewStocks = new JMenuItem("Ver Stocks");
        viewStocks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação executada ao clicar em "Ver Stocks"
                JOptionPane.showMessageDialog(null, "Ver Stocks selecionado");
            }
        });
        stockMenu.add(viewStocks);

        menuBar.add(stockMenu);

        JMenu sellerMenu = new JMenu("Seller");

        JMenuItem createSeller = new JMenuItem("Criar Seller");
        createSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreateSellerDialog();
            }
        });
        sellerMenu.add(createSeller);

        JMenuItem viewSellers = new JMenuItem("Ver Sellers");
        viewSellers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação executada ao clicar em "Ver Sellers"
                JOptionPane.showMessageDialog(null, "Ver Sellers selecionado");
            }
        });
        sellerMenu.add(viewSellers);

        menuBar.add(sellerMenu);

        JMenu saleMenu = new JMenu("Sale");

        JMenuItem makeSale = new JMenuItem("Realizar Venda");
        makeSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMakeSaleDialog();
            }
        });
        saleMenu.add(makeSale);

        menuBar.add(saleMenu);

        JMenu profileMenu = new JMenu("Profile");

        JMenuItem viewProfile = new JMenuItem("Ver Perfil");
        viewProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProfilePanel();
            }
        });
        profileMenu.add(viewProfile);

        menuBar.add(profileMenu);

        setJMenuBar(menuBar);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menu Principal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel totalRevenueLabel = new JLabel("Saldo Total: R$ " + calculateTotalRevenue());
        infoPanel.add(totalRevenueLabel);

        JLabel lastSaleDateLabel = new JLabel("Última Venda: " + getLastSaleDate());
        infoPanel.add(lastSaleDateLabel);

        mainPanel.add(infoPanel, BorderLayout.CENTER);
    }

    private void createProfilePanel() {
        profilePanel = new JPanel();
        profilePanel.setLayout(new BorderLayout());

        JTextArea salesTextArea = new JTextArea();
        salesTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(salesTextArea);
        profilePanel.add(scrollPane, BorderLayout.CENTER);

        sales.add("Item: Item1\nQuantidade: 2\nValor Total: R$ 50.00\nData: 2023-06-28");
        sales.add("Item: Item2\nQuantidade: 3\nValor Total: R$ 150.00\nData: 2023-06-29");
        sales.add("Item: Item3\nQuantidade: 1\nValor Total: R$ 25.00\nData: 2023-06-30");
        sales.add("Item: Item4\nQuantidade: 5\nValor Total: R$ 200.00\nData: 2023-07-01");
        sales.add("Item: Item5\nQuantidade: 2\nValor Total: R$ 80.00\nData: 2023-07-02");

        StringBuilder salesInfo = new StringBuilder();
        salesInfo.append("Vendas realizadas:\n\n");
        for (String sale : sales) {
            salesInfo.append(sale).append("\n\n");
        }
        salesTextArea.setText(salesInfo.toString());

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });
        profilePanel.add(menuButton, BorderLayout.SOUTH);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new GridLayout(2, 2));

        JLabel totalSalesLabel = new JLabel("Total de Vendas: " + sales.size());
        dashboardPanel.add(totalSalesLabel);

        double totalRevenue = calculateTotalRevenue();
        JLabel totalRevenueLabel = new JLabel("Receita Total: R$ " + totalRevenue);
        dashboardPanel.add(totalRevenueLabel);

        int averageQuantity = calculateAverageQuantity();
        JLabel averageQuantityLabel = new JLabel("Quantidade Média: " + averageQuantity);
        dashboardPanel.add(averageQuantityLabel);

        LocalDate lastSaleDate = getLastSaleDate();
        JLabel lastSaleDateLabel = new JLabel("Data da Última Venda: " + lastSaleDate.toString());
        dashboardPanel.add(lastSaleDateLabel);

        profilePanel.add(dashboardPanel, BorderLayout.NORTH);
    }

    private void showMainPanel() {
        setContentPane(mainPanel);
        validate();
        repaint();
    }

    private void showProfilePanel() {
        setContentPane(profilePanel);
        validate();
        repaint();
    }

    private void showCreateItemDialog() {
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nome:"));
        panel.add(nameField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descriptionField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Criar Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String description = descriptionField.getText();

            JOptionPane.showMessageDialog(null, "Item criado com sucesso!");
        }
    }

    private void showCreateStockDialog() {
        JComboBox<String> itemComboBox = new JComboBox<>();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Item:"));
        panel.add(itemComboBox);
        panel.add(new JLabel("Quantidade:"));
        panel.add(quantityField);
        panel.add(new JLabel("Preço de compra:"));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Criar Stock",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedItem = (String) itemComboBox.getSelectedItem();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());


            JOptionPane.showMessageDialog(null, "Stock criado com sucesso!");
        }
    }

    private void showCreateSellerDialog() {
        JComboBox<String> stockComboBox = new JComboBox<>();
        JTextField priceField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Stock:"));
        panel.add(stockComboBox);
        panel.add(new JLabel("Preço de compra:"));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Criar Seller",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedStock = (String) stockComboBox.getSelectedItem();
            double price = Double.parseDouble(priceField.getText());

            JOptionPane.showMessageDialog(null, "Seller criado com sucesso!");
        }
    }

    private void showMakeSaleDialog() {
        JComboBox<String> sellerComboBox = new JComboBox<>();
        JTextField priceField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Seller:"));
        panel.add(sellerComboBox);
        panel.add(new JLabel("Preço de venda:"));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Realizar Venda",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedSeller = (String) sellerComboBox.getSelectedItem();
            double price = Double.parseDouble(priceField.getText());

            sales.add(LocalDate.now().toString());
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
        }
    }

    private double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (String sale : sales) {
            String[] saleInfo = sale.split("\n");
            String totalPriceStr = saleInfo[2].substring(saleInfo[2].indexOf(":") + 2);
            double totalPrice = Double.parseDouble(totalPriceStr.substring(2));
            totalRevenue += totalPrice;
        }
        return totalRevenue;
    }

    private int calculateAverageQuantity() {
        int totalQuantity = 0;
        for (String sale : sales) {
            String[] saleInfo = sale.split("\n");
            String quantityStr = saleInfo[1].substring(saleInfo[1].indexOf(":") + 2);
            int quantity = Integer.parseInt(quantityStr);
            totalQuantity += quantity;
        }
        return totalQuantity / sales.size();
    }

    private LocalDate getLastSaleDate() {
        if (sales.isEmpty()) {
            return LocalDate.now();
        } else {
            String lastSale = sales.get(sales.size() - 1);
            String[] saleInfo = lastSale.split("\n");
            String dateStr = saleInfo[3].substring(saleInfo[3].indexOf(":") + 2);
            return LocalDate.parse(dateStr);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StoreSystemFrame().setVisible(true);
            }
        });
    }
}
