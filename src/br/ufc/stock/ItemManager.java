package br.ufc.stock;

import java.io.Serializable;
import java.util.Optional;
import java.util.Vector;
import br.ufc.stock.exception.ItemAlreadyExists;


/**
 * The ItemManager class manages the registration and retrieval of items.
 * It keeps track of a collection of items and provides methods to register and search for items.
 *
 * @author Kelvin Leandro
 */
public class ItemManager implements Serializable {
    private Vector<Item> items;

    /**
     * Constructs an ItemManager object with an empty collection of items.
     */
    public ItemManager(){
        this.items = new Vector<Item>();
    }

    /**
     * Registers an item in the item manager if it does not already exist.
     *
     * @param item The item to be registered.
     */
    public void register(Item item) throws ItemAlreadyExists{
        boolean alreadyExists = false;
        for(Item current : items){
            if(current.getName().equals(item.getName()))
                alreadyExists = true;
        }

        if(!alreadyExists)
            this.items.add(item);
        else
            throw new ItemAlreadyExists();

    }

    /**
     * Retrieves an item by its name.
     *
     * @param name The name of the item to be retrieved.
     * @return An Optional containing the item if found, or an empty Optional otherwise.
     */
    public Optional<Item> getByName(String name){
        Item item = null;
        for(Item current : items){
            if(current.getName().equals(name)) {
                item = current;
                break;
            }
        }
        return Optional.ofNullable(item);
    }

    /**
     * Retrieves an item by its ID.
     *
     * @param id The ID of the item to be retrieved.
     * @return An Optional containing the item if found, or an empty Optional otherwise.
     */
    public Optional<Item> getById(String id){
        Item item = null;
        for(Item current : items){
            if(current.getId().equals(id)) {
                item = current;
                break;
            }
        }
        return Optional.ofNullable(item);
    }

    public Optional<Vector<Item>> getItems() {
        return Optional.of(items);
    }
}
