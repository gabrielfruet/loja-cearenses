package br.ufc.serializing;

import br.ufc.gui.storeSystemFrame.StoreStarterMoneyDialog;
import br.ufc.store.Store;

import java.io.*;
import java.math.BigDecimal;


public class ReadStore {
    public static Store desserialize(){
        File arquivo = new File("store.bin");

        if (arquivo.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(arquivo);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                Store store = (Store) objectInputStream.readObject();
                return store;

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        StoreStarterMoneyDialog starterMoneyDialog = new StoreStarterMoneyDialog();
        return starterMoneyDialog.showStoreStarterMoneyDialog();
    }
}
