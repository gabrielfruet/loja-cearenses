package br.ufc.gui.CRUD;

import br.ufc.gui.exception.ExceptionDialog;
import br.ufc.stock.Item;
import br.ufc.stock.ItemManager;
import br.ufc.stock.Stock;
import br.ufc.stock.manager.StockManager;
import br.ufc.stock.seller.Seller;
import br.ufc.store.StoreRequester;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class CRUDStock extends CRUDAbstract<Seller>
{
    private final StockManager stockManager;
    private final ItemManager itemManager;
    private final StoreRequester storeRequester;

    public CRUDStock(StockManager stockManager, ItemManager itemManager, StoreRequester storeRequester){
        super();
        add(new JLabel("CRUD Stock"), BorderLayout.NORTH);
        this.stockManager = stockManager;
        this.itemManager = itemManager;
        this.storeRequester = storeRequester;
    }

    public void addElement(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel quantidadeInicialLabel = new JLabel("Quantidade inicial:");
        JTextField quantidadeInicialField = new JTextField();
        JLabel precoRestoqueLabel = new JLabel("Preço de restoque:");
        JTextField precoRestoqueField = new JTextField();

        panel.add(quantidadeInicialLabel);
        panel.add(quantidadeInicialField);
        panel.add(precoRestoqueLabel);
        panel.add(precoRestoqueField);

        List<Item> itemList = itemManager.getItems().get(); // Obtém a lista de itens do ItemManager

        JList<String> itemSelector = new JList<>(itemList.stream()
                .map(Item::getName)
                .toArray(String[]::new));

        panel.add(new JScrollPane(itemSelector));

        int option = JOptionPane.showOptionDialog(null, panel, "Criar Stock", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Login", "Cancelar"}, null);

        if (option == 0) {
            int amount = Integer.parseInt(quantidadeInicialField.getText());
            BigDecimal buyPrice = new BigDecimal(precoRestoqueField.getText());


            int selectedIndex = itemSelector.getSelectedIndex();
            if (selectedIndex != -1) {
                Item selectedItem = itemList.get(selectedIndex);

                try {
                    Stock stock = new Stock(selectedItem, amount, buyPrice, storeRequester);
                    stockManager.registerByStock(stock);
                    listModel.addElement(stock.toString());
                } catch (Exception e) {
                    new ExceptionDialog(e);
                }
            }
        }
    }
    public void editElement(){

    }
    protected void loadElements() {
        List<Stock> elems = this.stockManager.getStocks();
        for (Stock current : elems) {
            listModel.addElement(current.toString());
        }
    }

}
