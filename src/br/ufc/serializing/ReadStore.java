package br.ufc.serializing;

import br.ufc.store.Store;

import java.io.*;


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

        return new Store();
    }
}
