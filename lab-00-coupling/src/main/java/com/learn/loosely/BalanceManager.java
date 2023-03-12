package com.learn.loosely;

import java.math.BigDecimal;

public class BalanceManager {
    public boolean checkout( Balance balance, BigDecimal checkoutAmount   ){
        BigDecimal customerBalanceAmount = balance.getAmount();

        return customerBalanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}