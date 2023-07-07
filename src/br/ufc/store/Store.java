package br.ufc.store;

import br.ufc.stock.Item;
import br.ufc.stock.ItemManager;
import br.ufc.stock.Stock;
import br.ufc.stock.sale.Sale;
import br.ufc.user.VendorManager;
import br.ufc.user.VendorUser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Store implements Serializable {
    private BigDecimal cash;
    private ItemManager itemManager;
    private VendorManager vendorManager;
    private VendorUser activeUser;

    public Store(){
        vendorManager = new VendorManager();
        itemManager = new ItemManager();
        try{
            vendorManager.register(new VendorUser("admin","admin"));
        }
        catch(Exception e){

        }
    }
    public void setVendor(VendorUser user){
        activeUser = user;
    }
    public VendorManager getVendorManager(){
        return vendorManager;
    }
    public ItemManager getItemMananger(){
        return itemManager;
    }
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


    public List<Stock> getStocks() {
        return null;
    }

    public void createSeller(Stock stock, BigDecimal price) {

    }

    public List<Item> getSellers() {
        return null;
    }

    public void updateItem(String descriptor){

    }

    public List<Item> getItems(){

        return null;
    }

    public void createStock(Item itemType, int amount, BigDecimal buyPrice, StoreRequester requester){

    }
}