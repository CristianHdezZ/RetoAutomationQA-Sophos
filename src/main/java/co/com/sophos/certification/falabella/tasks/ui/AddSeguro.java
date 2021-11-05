package co.com.sophos.certification.falabella.tasks.ui;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.concurrent.TimeUnit;

import static co.com.sophos.certification.falabella.userinterface.ListProductFalabellaPage.BUTTON_SEGURO;
import static co.com.sophos.certification.falabella.userinterface.ListProductFalabellaPage.BUTTON_VER_BOLSA_COMPRA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AddSeguro implements Task {
    private String strDescripcionSeguro;

    public AddSeguro(String strDescripcionSeguro) {
        this.strDescripcionSeguro = strDescripcionSeguro;
    }

    public static AddSeguro inTheShoppingElement(String strDescripcionSeguro) {
        return Tasks.instrumented(AddSeguro.class,strDescripcionSeguro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().manage().timeouts().implicitlyWait(220, TimeUnit.SECONDS);

        actor.attemptsTo(
                WaitUntil.the(BUTTON_SEGURO.of(strDescripcionSeguro),isClickable()).forNoMoreThan(6000).milliseconds(),
                Click.on(BUTTON_SEGURO.of(strDescripcionSeguro))
        );
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        actor.attemptsTo(
                Click.on(BUTTON_VER_BOLSA_COMPRA)
        );
    }
}
