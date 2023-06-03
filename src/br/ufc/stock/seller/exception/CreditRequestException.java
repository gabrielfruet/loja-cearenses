package br.ufc.stock.seller.exception;

import br.ufc.stock.Request;

public class CreditRequestException extends RuntimeException {
    Request req;
    public CreditRequestException(Request req) {
        this.req = req;
    }

    @Override
    public String getMessage() {
        return String.format("Credit requests shouldn't be denied. Request: %s", this.req.toString());
    }
}
