package br.ufc.store;

import br.ufc.stock.Item;
import br.ufc.stock.ItemManager;
import br.ufc.stock.Stock;
import br.ufc.stock.manager.StockManager;
import br.ufc.stock.sale.Sale;
import br.ufc.stock.seller.manager.SellerManager;
import br.ufc.user.VendorManager;
import br.ufc.user.VendorUser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class Store implements Serializable {
    private Vector<Sale> sales;
    private BigDecimal cash;
    private ItemManager itemManager;
    private StockManager stockManager;
    private SellerManager sellerManager;
    private VendorManager vendorManager;
    private VendorUser activeUser;
    private StoreRequester storeRequester;



    public Store(){
        sales = new Vector<Sale>();
        cash = new BigDecimal(0);
        vendorManager = new VendorManager();
        itemManager = new ItemManager();
        stockManager = new StockManager();
        storeRequester = new StoreRequester(this);
        sellerManager = new SellerManager();
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
        cash = cash.subtract(value);
    }

    public void credit(BigDecimal value) {
        cash = cash.add(value);
    }

    public void login(String username, String password) {

    }

    public void register(String username, String password) {

    }

    public VendorUser getActiveUser() {
        return activeUser;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void registerSale(Sale sale){sales.add(sale);}
    public Optional<Sale> getLastTransaction() {
        if(sales.isEmpty())
            return Optional.ofNullable(null);
        return Optional.ofNullable(sales.lastElement());
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

    public StockManager getStockManager() {
        return stockManager;
    }

    public StoreRequester getStoreRequester() {
        return storeRequester;
    }

    public SellerManager getSellerManager(){return sellerManager;}
}