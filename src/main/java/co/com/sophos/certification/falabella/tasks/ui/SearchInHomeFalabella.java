package co.com.sophos.certification.falabella.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sophos.certification.falabella.userinterface.SearchFalabellaPage.BUTTON_NO_GRACIAS;
import static co.com.sophos.certification.falabella.userinterface.SearchFalabellaPage.INPUT_CONSULTAR;

public class SearchInHomeFalabella implements Task {
    private String strKeyWord;

    public SearchInHomeFalabella(String strKeyWord) {
        this.strKeyWord = strKeyWord;
    }

    public static SearchInHomeFalabella withKeyword(String strKeyWord) {
        return Tasks.instrumented(SearchInHomeFalabella.class,strKeyWord);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_NO_GRACIAS),
                Enter.keyValues(strKeyWord).into(INPUT_CONSULTAR)
        );
        // getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
}