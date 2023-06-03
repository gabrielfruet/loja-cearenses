package br.ufc.stock.exception;

import br.ufc.stock.Request;

public class RequestNegativePriceException extends Exception{
    private Request req;
    public RequestNegativePriceException(Request req){
        this.req = req;
    }

    @Override
    public String getMessage() {
        return String.format("Request should not have negative values as total price: %s", req.toString());
    }
}
