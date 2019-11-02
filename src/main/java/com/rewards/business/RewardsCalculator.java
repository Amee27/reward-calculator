package com.rewards.business;

import com.rewards.domain.CustomerTransaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RewardsCalculator {

    public static final int FIFTY_POINTS = 50;
    public static final int HUNDRED_POINTS = 100;

    public Long calculate(List<CustomerTransaction> customerTransactions) {
        return customerTransactions.stream().map(customerTransaction -> calculateRewardPoints(customerTransaction))
                .collect(Collectors.summingLong(rewards -> rewards));
    }

    private Long calculateRewardPoints(CustomerTransaction customerTransaction) {
        long rewardPoints = 0;

        if (customerTransaction.getTransactionAmount() > FIFTY_POINTS && customerTransaction.getTransactionAmount() <= HUNDRED_POINTS) {
            rewardPoints = Math.round(customerTransaction.getTransactionAmount() - FIFTY_POINTS);
        } else if (customerTransaction.getTransactionAmount() > HUNDRED_POINTS) {
            rewardPoints = FIFTY_POINTS + 2 * Math.round(customerTransaction.getTransactionAmount() - HUNDRED_POINTS);
        }

        return rewardPoints;
    }
}
