package br.ufc.serializing;
import br.ufc.store.Store;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
public class SaveStore {

    public static void serialize(Store store) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try (FileOutputStream fileOut = new FileOutputStream("store.bin");
                     ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(store);
                    out.close();
                    fileOut.close();
                    System.out.println("Classe serializada com sucesso.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        timer.schedule(task, 0, 5000);
    }
}
