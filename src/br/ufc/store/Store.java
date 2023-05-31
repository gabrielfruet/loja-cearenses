package br.ufc.store;

import br.ufc.stock.seller.manager.SellerManager;
import br.ufc.user.VendorManager;
import br.ufc.user.VendorUser;

import java.math.BigDecimal;

public class Store {
    BigDecimal cash;
    SellerManager sellerManager;
    VendorManager vendorManager;

    VendorUser activeUser;
}
