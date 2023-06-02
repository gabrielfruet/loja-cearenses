package br.ufc.store;

import br.ufc.stock.manager.StockManager;
import br.ufc.stock.seller.manager.SellerManager;
import br.ufc.user.VendorManager;
import br.ufc.user.VendorUser;

import java.io.Serializable;
import java.math.BigDecimal;

public class Store implements Serializable {
    private BigDecimal cash;
    private SellerManager sellerManager;
    private StockManager stockManager;
    private VendorManager vendorManager;

    private VendorUser activeUser;

    public void debit(BigDecimal value){

    }

    public void credit(BigDecimal value){

    }
}
