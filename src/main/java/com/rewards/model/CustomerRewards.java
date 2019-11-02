package com.rewards.model;

public class CustomerRewards {

    private Long customerId;
    private Long firstMonthRewards;
    private Long secondMonthRewards;
    private Long thirdMonthRewards;
    private Long totalRewards;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getFirstMonthRewards() {
        return firstMonthRewards;
    }

    public void setFirstMonthRewards(Long firstMonthRewards) {
        this.firstMonthRewards = firstMonthRewards;
    }

    public Long getSecondMonthRewards() {
        return secondMonthRewards;
    }

    public void setSecondMonthRewards(Long secondMonthRewards) {
        this.secondMonthRewards = secondMonthRewards;
    }

    public Long getThirdMonthRewards() {
        return thirdMonthRewards;
    }

    public void setThirdMonthRewards(Long thirdMonthRewards) {
        this.thirdMonthRewards = thirdMonthRewards;
    }

    public Long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Long totalRewards) {
        this.totalRewards = totalRewards;
    }

    @Override
    public String toString() {
        return "CustomerRewards{" +
                "customerId=" + customerId +
                ", firstMonthRewards=" + firstMonthRewards +
                ", secondMonthRewards=" + secondMonthRewards +
                ", thirdMonthRewards=" + thirdMonthRewards +
                ", totalRewards=" + totalRewards +
                '}';
    }
}
