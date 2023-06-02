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

    }

    public Optional<VendorUser> login(String username, String password){
        return Optional.empty();
    }
}
