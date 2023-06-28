package br.ufc.store;

import br.ufc.stock.request.Request;

import java.io.Serializable;
import java.math.BigDecimal;

public class StoreRequester implements Serializable {
    private Store store;

    public void credit(BigDecimal value){
        store.credit(value);
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
