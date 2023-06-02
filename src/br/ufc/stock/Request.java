package br.ufc.stock;

import java.math.BigDecimal;

public class Request {
    private BigDecimal value;
    private RequestStatus status;

    public BigDecimal getValue(){
        return this.value;
    }

    public Request(BigDecimal value){
        this.status = RequestStatus.PROCESSING;
        this.value = value;
    }

    public void conclude() {
        if(this.status.equals(RequestStatus.PROCESSING)){
            this.status = RequestStatus.CONCLUDED;
        }
    }

    public void decline() {
        if(this.status.equals(RequestStatus.PROCESSING)){
            this.status = RequestStatus.DECLINED;
        }
    }

}
