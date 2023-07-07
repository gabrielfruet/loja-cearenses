package br.ufc.gui.storeSystemFrame;

import br.ufc.gui.CRUD.CRUDItem;
import br.ufc.gui.CRUD.CRUDSeller;
import br.ufc.gui.CRUD.CRUDStock;
import br.ufc.serializing.SaveStore;
import br.ufc.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class StoreSystemFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel profilePanel;
    private JPanel itemPanel;
    private JPanel stockPanel;
    private JPanel sellerPanel;
    private JPanel salePanel;

    private List<String> sales;

    private Store store;

    public StoreSystemFrame(Store storeVar) {

        store = storeVar;
        setTitle("Sistema de estoque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        sales = new ArrayList<>();

        createMenuBar();

        mainPanel = new MainPanel();
        profilePanel = new ProfilePanel();
        itemPanel = new CRUDItem(store.getItemMananger());
        stockPanel = new CRUDStock(
                store.getStockManager(),
                store.getItemMananger(),
                store.getStoreRequester()
        );
        sellerPanel = new CRUDSeller(
                store.getStockManager(),
                store.getSellerManager(),
                store.getStoreRequester()
        );

        showMainPanel();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SaveStore.saveData(store);
            }
        });
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenuItem itemMenu = new JMenuItem("Item");
        itemMenu.addActionListener(e -> showItemPanel());
        menuBar.add(itemMenu);

        JMenuItem stockMenu = new JMenuItem("Stock");
        stockMenu.addActionListener(e -> showStockPanel());
        menuBar.add(stockMenu);

        JMenuItem sellerMenu = new JMenuItem("Seller");
        sellerMenu.addActionListener(e -> {showSellerPanel();});
        menuBar.add(sellerMenu);

        JMenuItem salesMenu = new JMenuItem("Sales");
        salesMenu.addActionListener(e -> {
            // Ação executada ao clicar em "Sales"
            JOptionPane.showMessageDialog(null, "Sales selecionado");
        });
        menuBar.add(salesMenu);

        JMenuItem profileMenu = new JMenuItem("Profile");
        profileMenu.addActionListener(e -> showProfilePanel());
        menuBar.add(profileMenu);

        JMenuItem menuMenu = new JMenuItem("Menu");
        menuMenu.addActionListener(e -> showMainPanel());
        menuBar.add(menuMenu);

        setJMenuBar(menuBar);
    }

    public void showMainPanel() {
        setContentPane(mainPanel);
        validate();
        repaint();
    }

    private void showItemPanel() {
        setContentPane(itemPanel);
        validate();
        repaint();
    }

    private void showStockPanel() {
       setContentPane(stockPanel);
       validate();
       repaint();
    }
    private void showSellerPanel() {
        setContentPane(sellerPanel);
        validate();
        repaint();
    }
    private void showProfilePanel() {
        setContentPane(profilePanel);
        validate();
        repaint();
    }

    public Store getStore(){
        return store;
    }
}
