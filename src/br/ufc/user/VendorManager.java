package br.ufc.user;

import java.io.Serializable;
import java.util.Optional;
import java.util.Vector;

public class VendorManager implements Serializable {
    Vector<VendorUser> vendors;

    public VendorManager(){
        this.vendors = new Vector<VendorUser>();
    }

    public void register(VendorUser user){
        for(VendorUser current : vendors){
            /*if(current.getUsername().equals(user.getUsername()))
                throw VendorUsernameAlreadyExists(user.getUsername());*/
        }
        this.vendors.add(user);

    }

    public Optional<VendorUser> getVendorByUsername(String username){
        VendorUser user = null;
        for(VendorUser current : vendors){
            if(current.getUsername().equals(username)) {
                user = current;
            }
        }
        return Optional.ofNullable(user);
    }

    public Optional<VendorUser> login(String username, String password){
        Optional<VendorUser> user = getVendorByUsername(username);

        if(user.isEmpty()) {
            return Optional.empty();
        }
        /*else if(user.get().getPasswordHash() != password.hashCode()){
            throw VendorPasswordTypedInvalid();
        }*/
        else{
            return user;
        }
    }
}
