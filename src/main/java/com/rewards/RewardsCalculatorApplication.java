package com.rewards;

import com.rewards.business.RewardsCalculator;
import com.rewards.domain.CustomerTransaction;
import com.rewards.model.CustomerRewards;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class RewardsCalculatorApplication {

	@Autowired
	private RewardsCalculator rewardsCalculator;

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(RewardsCalculatorApplication.class, args);

		RewardsCalculatorApplication application = applicationContext.getBean(RewardsCalculatorApplication.class);
		application.start();
	}

	private void start() {
		System.out.println("***** Welcome to customer rewards calculator *****");

		//Here I am assuming that we are getting request to calculate rewards for specific customer.
		//Generally we get the data from database by customer ID but here I am creating last 3 months transaction
		//data for a customer.

		long customerId = 1001;
		List<CustomerTransaction> firstMonthTransactions = buildCustomerTransactions(customerId, 30);
		List<CustomerTransaction> secondMonthTransactions = buildCustomerTransactions(customerId, 60);
		List<CustomerTransaction> thirdMonthTransactions = buildCustomerTransactions(customerId, 90);

		CustomerRewards customerRewards = new CustomerRewards();
		customerRewards.setCustomerId(customerId);
		customerRewards.setFirstMonthRewards(rewardsCalculator.calculate(firstMonthTransactions));
		customerRewards.setSecondMonthRewards(rewardsCalculator.calculate(secondMonthTransactions));
		customerRewards.setThirdMonthRewards(rewardsCalculator.calculate(thirdMonthTransactions));
		customerRewards.setTotalRewards(customerRewards.getFirstMonthRewards()
				+ customerRewards.getSecondMonthRewards() + customerRewards.getThirdMonthRewards());

		//Here we can return "customerRewards" as a response to caller.

		System.out.println(customerRewards); //Just to verify
	}


	private List<CustomerTransaction> buildCustomerTransactions(Long customerId, Integer daysDifference) {

		List<CustomerTransaction> customerTransactions = new ArrayList<>();

		Date currentDate = new Date();
		Date startDate = DateUtils.addDays(currentDate, -daysDifference);
		Date endDate = DateUtils.addDays(currentDate, 30-daysDifference);

		for (int i = 0; i < 10; i++) {
			CustomerTransaction customerTransaction = new CustomerTransaction();
			customerTransaction.setCustomerId(customerId);
			customerTransaction.setTransactionId(RandomUtils.nextLong(1000, 5000));
			customerTransaction.setTransactionAmount(new BigDecimal(RandomUtils.nextDouble(5, 300))
					.setScale(2, RoundingMode.HALF_DOWN).doubleValue());
			Date transactionDate = new Date(RandomUtils.nextLong(startDate.getTime(), endDate.getTime()));
			customerTransaction.setTransactionDate(transactionDate);

			customerTransactions.add(customerTransaction);
		}

		return customerTransactions;
	}

}
