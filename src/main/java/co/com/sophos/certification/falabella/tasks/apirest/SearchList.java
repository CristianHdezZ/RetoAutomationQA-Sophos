package co.com.sophos.certification.falabella.tasks.apirest;

import co.com.sophos.certification.falabella.interactions.apirest.SearchListOfEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SearchList implements Task {

    public static SearchList ofEmpleyee() {
        return Tasks.instrumented(SearchList.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                SearchListOfEmployee.inTheAPI()
        );

    }
}
