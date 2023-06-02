package org.example;

import java.math.BigDecimal;

public class MoneyUtil {
    public static String format(double salary) {
        return format(salary, "$");
    }

    public static String format(double money, String symbol) {
        if(symbol == null) {
            throw new IllegalArgumentException("Symbol cannot be null");
        }
        if (money < 0) {
            symbol = "-" + symbol;
            money *= (-1);
        }
        BigDecimal rounded = new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP);
        return symbol + rounded;
    }
}
