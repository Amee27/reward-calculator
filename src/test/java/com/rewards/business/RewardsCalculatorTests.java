package com.rewards.business;

import com.rewards.domain.CustomerTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class RewardsCalculatorTests {

    @Test
    void returnsZeroRewardPointsIfNoCustomerTransactions() {

        List<CustomerTransaction> customerTransactions = new ArrayList<>();

        Long rewardPoints = new RewardsCalculator().calculate(customerTransactions);

        Assertions.assertEquals(0, rewardPoints);
    }

    @Test
    void returnsRewardPointsForGivenCustomerTransactions() {

        List<CustomerTransaction> customerTransactions = new ArrayList<>();
        customerTransactions.add(getCustomerTransaction(101, 3701, 45.20));
        customerTransactions.add(getCustomerTransaction(101, 3702, 68.45));
        customerTransactions.add(getCustomerTransaction(101, 3703, 140));

        Long rewardPoints = new RewardsCalculator().calculate(customerTransactions);

        Assertions.assertEquals(148, rewardPoints);
    }

    private CustomerTransaction getCustomerTransaction(long customerId, long transactionId, double amount) {
        CustomerTransaction customerTransaction = new CustomerTransaction();
        customerTransaction.setCustomerId(customerId);
        customerTransaction.setTransactionId(transactionId);
        customerTransaction.setTransactionAmount(amount);
        customerTransaction.setTransactionDate(new Date());

        return customerTransaction;
    }
}
