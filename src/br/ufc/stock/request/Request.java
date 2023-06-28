package br.ufc.stock.request;

import br.ufc.stock.exception.RequestNegativePriceException;

import java.math.BigDecimal;

public class Request {

    //Resolver se a request vai guardar a exceção
    private BigDecimal value;
    private RequestStatus status;

    public BigDecimal getValue(){
        return this.value;
    }

    public Request(BigDecimal value){
        this.status = RequestStatus.PROCESSING;
        if(value.compareTo(BigDecimal.ZERO) < 0){
            throw new RequestNegativePriceException(value);
        }
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
    public boolean isConcluded(){
        return this.status==RequestStatus.CONCLUDED;
    }
    public boolean isDeclined(){
        return this.status==RequestStatus.DECLINED;
    }


    public boolean isConcluded(){
        return this.status.equals(RequestStatus.CONCLUDED);
    }

    @Override
    public String toString() {
        return "Request{" +
                "value=" + value +
                ", status=" + status +
                '}';
    }
}
