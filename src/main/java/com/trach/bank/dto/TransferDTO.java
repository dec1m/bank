package com.trach.bank.dto;


import org.springframework.context.annotation.Scope;

import java.util.Objects;

@Scope("session")
public class TransferDTO {
//todo validator and messae

    private  long idTarget;

    private  long idSender;

    private int countMoney;



    public long getIdTarget() {
        return idTarget;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public void setIdTarget(long idTarget) {
        this.idTarget = idTarget;
    }

    public long getIdSender() {
        return idSender;
    }


    public int getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }


    @Override
    public String toString() {
        return "TransferDTO{" +
                "idTarget=" + idTarget +
                ", idSender=" + idSender +
                ", countMoney=" + countMoney +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferDTO that = (TransferDTO) o;
        return idTarget == that.idTarget &&
                idSender == that.idSender &&
                countMoney == that.countMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarget, idSender, countMoney);
    }
}
