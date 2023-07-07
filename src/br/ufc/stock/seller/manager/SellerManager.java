package br.ufc.stock.seller.manager;

import br.ufc.stock.Item;
import br.ufc.stock.seller.BaseSeller;
import br.ufc.stock.seller.Seller;
import br.ufc.stock.seller.manager.exception.ExistentSellerException;

import java.io.Serializable;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * Manages a collection of sellers and provides operations to register sellers, retrieve sellers by item type name,
 * and retrieve all products associated with the registered sellers.
 *
 * @author Gabriel Fruet
 */
public class SellerManager implements Serializable {
    private final Vector<BaseSeller> sellers;

    /**
     * Constructs a new instance of SellerManager.
     */
    public SellerManager() {
        sellers = new Vector<BaseSeller>();
    }

    /**
     * Registers a new seller.
     *
     * @param seller the seller to register
     * @throws ExistentSellerException if a seller already exists in the manager
     */
    public void register(BaseSeller seller) throws ExistentSellerException {
        boolean exists = false;
        for (Seller s : this.sellers) {
            if (seller.equals(s)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            throw new ExistentSellerException(seller);
        } else {
            this.sellers.add(seller);
        }
    }

    /**
     * Retrieves a Seller object by the name of the associated item type.
     *
     * @param name the name of the item type
     * @return an Optional containing the Seller object if found, or an empty Optional if not found
     */
    public Optional<Seller> get(String name) {
        for (Seller s : sellers) {
            if (s.getItemType().getName().equals(name)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    /**
     * Retrieves all products associated with the registered sellers.
     *
     * @return a Vector containing all products associated with the registered sellers
     */
    public Vector<Item> getProducts() {
        return new Vector<>(
                this.sellers
                        .stream()
                        .map(Seller::getItemType)
                        .collect(Collectors.toList())
        );
    }
    public Vector<BaseSeller> getSellers(){
        return sellers;
    }
}
