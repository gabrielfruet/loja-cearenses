package br.ufc.store;

import br.ufc.stock.Item;
import br.ufc.stock.Request;
import br.ufc.stock.Stock;
import br.ufc.stock.sale.Sale;
import br.ufc.user.VendorManager;
import br.ufc.user.VendorUser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Store implements Serializable {
    private BigDecimal cash;
    private VendorManager vendorManager;
    private VendorUser activeUser;

    public void debit(BigDecimal value) {
    }

    public void credit(BigDecimal value) {

    }

    public void login(String username, String password) {

    }

    public void register(String username, String password) {

    }

    public VendorUser getActiveUser() {
        return activeUser;
    }

    public BigDecimal getCash() {
        return null;
    }

    public List<Sale> getLastTransactions() {
        return null;
    }

    public void createItem(String name, String descriptor) {

    }

    public void updateItem(String descriptor) {

    }

    public List<Item> getItems() {
        return null;
    }

    public void createStock(Item itemType, int amount, BigDecimal buyPrice, StoreRequester requester) {

    }

    public List<Stock> getStocks() {
        return null;
    }

    public void createSeller(Stock stock, BigDecimal price) {

    }

    public List<Item> getSellers() {
        return null;
    }

}
