package co.com.sophos.certification.falabella.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sophos.certification.falabella.userinterface.ListProductFalabellaPage.*;

public class AddElement implements Task {
    private String strNameElement;

    public AddElement(String strNameElement) {
        this.strNameElement = strNameElement;
    }

    public static AddElement inTheShoppingBag(String strNameElement) {
        return Tasks.instrumented(AddElement.class,strNameElement);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MODAL_CONTENTS_INFO_TARJETA_CRM),
                Scroll.to(LIST_ELEMENT_PRODUCTO.of(strNameElement))
        );
        //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actor.attemptsTo(
                Click.on(LIST_ELEMENT_PRODUCTO.of(strNameElement)),
                Click.on(MODAL_CONTENTS_INFO_TARJETA_CRM),
                Click.on(BUTTON_AGREGAR_BOLSA_COMPRA)
        );

    }
}