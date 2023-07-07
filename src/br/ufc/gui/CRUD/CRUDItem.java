package br.ufc.gui.CRUD;

import br.ufc.gui.exception.ExceptionDialog;
import br.ufc.gui.login.TelaLoginCadastro;
import br.ufc.stock.Item;
import br.ufc.stock.ItemManager;
import br.ufc.user.VendorUser;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;
import java.util.Vector;

public class CRUDItem extends CRUDAbstract<Item>
{
    ItemManager itemManager;
    public CRUDItem(ItemManager items){
        super();
        itemManager = items;
        add(new JLabel("CRUD Item"), BorderLayout.NORTH);
        loadElements();
    }

    public void addElement(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameItemLabel = new JLabel("Nome:");
        JTextField nameItemField = new JTextField();
        JLabel descItemLabel = new JLabel("Descrição:");
        JTextField descItemField = new JTextField();

        panel.add(nameItemLabel);
        panel.add(nameItemField);
        panel.add(descItemLabel);
        panel.add(descItemField);

        int option = JOptionPane.showOptionDialog(null, panel, "Criar Item", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Login", "Cancelar"}, null);

        if (option == 0) {
            String name = nameItemField.getText();
            String desc = descItemField.getText();

            try {
                Item item = new Item(name,desc);
                itemManager.register(item);
                listModel.addElement(item.toString());
            } catch (Exception e) {
                new ExceptionDialog(e);
            }
        }

    }
    public void editElement(){
        // Obtém o índice do produto selecionado na lista
        int selectedIndex = elementList.getSelectedIndex();

        if (selectedIndex != -1) {
            // Obtém o produto selecionado
            Optional<Item> itemSearched = itemManager.getByIndex(selectedIndex);
            Item item = itemSearched.get();
            // Exibe as caixas de diálogo preenchidas com os dados do produto selecionado
            String newName = JOptionPane.showInputDialog("Digite o novo nome do produto:", item.getName());
            String newDesc = JOptionPane.showInputDialog("Digite a nova descrição do item:", item.getDescriptor());

            // Verifica se o usuário cancelou a entrada de dados
            if (newName != null && newDesc != null) {
                newName = newName.trim();
                newDesc = newDesc.trim();

                // Atualiza os dados do produto
                item.setName(newName);
                item.setDescriptor(newDesc);

                // Atualiza o modelo da lista
                listModel.set(selectedIndex, item.toString());
            }
        }
    }


    protected void loadElements()
    {
        Vector<Item> items = itemManager.getItems();
        for (Item current : items) {
            listModel.addElement(current.toString());
        }
    }
}
