package com.project.ey.bluepy.dtos;

public class TransferDto {

    private Float amount;
    private Long accountRecivierNumber;
    private Long accountSenderNumber;

    public TransferDto(Float amount, Long accountRecivierNumber, Long accountSenderNumber) {
        this.amount = amount;
        this.accountRecivierNumber = accountRecivierNumber;
        this.accountSenderNumber = accountSenderNumber;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getAccountRecivierNumber() {
        return accountRecivierNumber;
    }

    public void setAccountRecivierNumber(Long accountRecivierNumber) {
        this.accountRecivierNumber = accountRecivierNumber;
    }

    public Long getAccountSenderNumber() {
        return accountSenderNumber;
    }

    public void setAccountSenderNumber(Long accountSenderNumber) {
        this.accountSenderNumber = accountSenderNumber;
    }
}
