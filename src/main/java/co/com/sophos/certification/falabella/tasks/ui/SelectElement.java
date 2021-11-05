package co.com.sophos.certification.falabella.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sophos.certification.falabella.userinterface.SearchFalabellaPage.SELECT_CATEGORIA;

public class SelectElement implements Task {
    private String strCategoria;

    public SelectElement(String strCategoria) {
        this.strCategoria = strCategoria;
    }

    public static SelectElement fromTheFilterWith(String strCategoria) {
        return Tasks.instrumented(SelectElement.class,strCategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actor.attemptsTo(
                Click.on(SELECT_CATEGORIA.of(strCategoria))
        );
    }
}