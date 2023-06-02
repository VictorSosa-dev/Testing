import org.example.MoneyUtil;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoneyUtilTest {

    @Test
    public void moneyTest() {
        String money = MoneyUtil.format(1000);
        assertEquals("$1000.00", money);
    }

    @Test
    public void negativeMoneyTest() {
        String money = MoneyUtil.format(-1000);
        assertEquals("-$1000.00", money);
    }

    @Test
    public void euroMoneyTest() {
        String money = MoneyUtil.format(-1000, "€");
        assertEquals("-€1000.00", money);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullExceptionMoneyTest() {
        MoneyUtil.format(-1000, null);
    }


}
