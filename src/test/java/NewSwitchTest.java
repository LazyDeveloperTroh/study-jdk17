import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Month;

import static java.time.Month.*;

public class NewSwitchTest {
    @Test
    public void oldStyleSwitchExpression() {
        int result ;
        Month month = FEBRUARY;//
        switch(month) {
            case JANUARY :
            case JUNE :
            case JULY :
                result = 3;
                break;
            case FEBRUARY:
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                result = 1;
                break;
            case MARCH:
            case MAY:
            case APRIL:
            case AUGUST:
                result = 2;
                break;
            default :
                result = 0;
        }
        Assertions.assertEquals(1, result);
    }

    @Test
    public void newSwitchExpressionReturnToValue() {
        Month month = FEBRUARY;
        var result1 = switch (month) {
            case JANUARY, JUNE, JULY -> 3;
            case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
            case MARCH, MAY, APRIL, AUGUST -> 2;
            default -> 0;
        };

        Assertions.assertEquals(1, result1);
    }
    @Test
    public int newSwitchExpressionReturnMethod() {
        Month month = FEBRUARY;
        switch (month) {
            case JANUARY, JUNE, JULY -> { return 3;}
            case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> { return 1;}
            case MARCH, MAY, APRIL, AUGUST -> { return 2;}
            default -> { return 0;}
        }
    }

    @Test
    public void newSwitchExpressionYield() {
        Month month = MARCH;
        var result = switch (month) {
            case JANUARY, JUNE, JULY -> 3;
            case FEBRUARY, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> 1;
            case MARCH, MAY, APRIL, AUGUST -> {
                System.out.println("code block result");
                yield 2;
            }
            default -> 0;
        };
        Assertions.assertEquals(2, result);
    }
}
