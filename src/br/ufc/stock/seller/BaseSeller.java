package br.ufc.stock.seller;

import br.ufc.stock.Item;
import br.ufc.stock.Request;
import br.ufc.stock.Stock;
import br.ufc.stock.sale.Sale;
import br.ufc.stock.seller.exception.CreditRequestException;
import br.ufc.stock.seller.exception.SellerNegativeAmountException;
import br.ufc.store.StoreRequester;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class BaseSeller implements Seller{
    protected Stock stock;
    protected BigDecimal price;
    protected StoreRequester requester;

    public Sale sell(int amount) throws SellerNegativeAmountException {
        if(amount < 0){
            throw new SellerNegativeAmountException(amount);
        }

        BigDecimal totalPrice = this.price(amount);
        Request req = new Request(totalPrice);

        this.requester.credit(req);

        if(!req.isConcluded()){
            throw new CreditRequestException(req);
        }

        stock.decreaseAmount(amount);

        return new Sale(
                this.getItemType(),
                amount,
                totalPrice,
                LocalDate.now()
        );
    }

    public abstract BigDecimal price(int amount) throws SellerNegativeAmountException;

    @Override
    public Item getItemType() {
        return this.stock.getItemType();
    }
}
