package co.com.sophos.certification.falabella.tasks.ui;

import co.com.sophos.certification.falabella.userinterface.HomePageFalabella;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenThePage implements Task {
    private HomePageFalabella homePageFalabella;

    public static OpenThePage homeTheFalabella() {
        return Tasks.instrumented(OpenThePage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(homePageFalabella)
        );

    }
}