import org.junit.Assert;
import org.junit.Test;
import ru.scooter.PageObject.RentalDetailsForm;

import java.util.concurrent.TimeUnit;


public class OrderPageTest extends BaseConstractTest{
    private final boolean expected = true;

    @Test
    public void CheckOrderPageOnHeader(){
        RentalDetailsForm rentalDetailsForm = new RentalDetailsForm(driver);
        rentalDetailsForm.clickONButtonOrderInHeaderPage();
        rentalDetailsForm.shapeForWhomScooter("Алексей","Громов","Смоленская 11Ф",2,"78005553535");
        rentalDetailsForm.formAboutRent("22.11.2024","сутки","Черный","Не спешите и не звоните!");
        rentalDetailsForm.clickForButtonYesInFinalFormCreateOrder();
        Assert.assertEquals(expected, rentalDetailsForm.checkTextFinishOrder());
    }

    @Test
    public void CheckOrderPageOnMain(){
        RentalDetailsForm rentalDetailsForm = new RentalDetailsForm(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        rentalDetailsForm.clickONButtonOrderInCenterPage();
        rentalDetailsForm.shapeForWhomScooter("Алексей","Громов","Смоленская 11Ф",2,"78005553535");
        rentalDetailsForm.formAboutRent("22.11.2024","сутки","Черный","Не спешите и не звоните!");
        rentalDetailsForm.clickForButtonYesInFinalFormCreateOrder();
        Assert.assertEquals(expected, rentalDetailsForm.checkTextFinishOrder());
    }


}
