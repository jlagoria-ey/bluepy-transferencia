package com.project.ey.bluepy.transfer.dtos;

public class TransferApiDto {

    private Float amount;
    private Long accountRecivierNumber;
    private Long accountSenderNumber;

    public TransferApiDto() {
    }

    public TransferApiDto(Float amount, Long accountRecivierNumber, Long accountSenderNumber) {
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
