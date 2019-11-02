package com.rewards.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

public class CustomerTransaction {

    private Long customerId;
    private Long transactionId;
    private Date transactionDate;
    private Double transactionAmount;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CustomerTransaction that = (CustomerTransaction) o;

        return new EqualsBuilder()
                .append(customerId, that.customerId)
                .append(transactionId, that.transactionId)
                .append(transactionDate, that.transactionDate)
                .append(transactionAmount, that.transactionAmount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(customerId)
                .append(transactionId)
                .append(transactionDate)
                .append(transactionAmount)
                .toHashCode();
    }
}
