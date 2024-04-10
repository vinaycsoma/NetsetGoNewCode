package Set.ty;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Data {
    public static boolean dropdown(List<WebElement> val, String s) {
        for (WebElement v : val) {
            if (v.getText().equals(s)) {
                v.click();
                return true;
            }
        }
        return false;
    }
}

