package br.ufc.user;

import br.ufc.stock.sale.Sale;
import br.ufc.stock.sale.manager.SaleManager;

import java.io.Serializable;

public class VendorUser implements Serializable {
    private SaleManager saleManager;
    private int passwordHash;
    private String username;

    public VendorUser(String username, String password){
        this.username = username;
        this.passwordHash = password.hashCode();
    }

    public int getPasswordHash(){
        return this.passwordHash;
    }

    public void registerSale(Sale sale){
        saleManager.register(sale);
    }

}
