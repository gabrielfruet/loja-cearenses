package br.ufc.store;

import br.ufc.stock.request.Request;

import java.io.Serializable;

public class StoreRequester implements Serializable {
    private Store store;

    public void credit(Request request){
        try{
            store.credit(request.getValue());
            request.conclude();
        }
        catch(Exception e){
            //Fazer algo com a exceção;
            request.decline();
        }
    }

    public void debit(Request request){
        try{
            store.debit(request.getValue());
            request.conclude();
        }
        catch(Exception e){
            //Fazer algo com a exceção;
            request.decline();
        }

    }
}
