import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.scooter.PageObject.MainPageObject;

import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class MainPageObjectTest extends BaseConstractTest{
    private final int numberQuestions;
    private final boolean expected;
    private final int numberTextQuestions;

    public MainPageObjectTest(int numberQuestions, int numberTextQuestions, boolean expected) {
        this.expected = expected;
        this.numberQuestions = numberQuestions;
        this.numberTextQuestions = numberTextQuestions;
    }

    @Parameterized.Parameters
    public static Object[][] getNumberListFAQ() {
        return new Object[][] {
                {1, 1, true},
                {6, 6, true},
                {3, 3, true},
                {5, 6, false},
                {7, 3, false},
        };
    }

    @Test
    public void CheckButtonOrderDo(){
        MainPageObject checkOrderButton = new MainPageObject(driver);
        checkOrderButton.scrollForFAQ();
        checkOrderButton.clickingOnQuestions(numberQuestions);
        assertEquals(expected, checkOrderButton.textFAQAnswerIsVisibale(numberTextQuestions));
    }

}


