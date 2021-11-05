package co.com.sophos.certification.falabella.tasks.apirest;

import co.com.sophos.certification.falabella.interactions.apirest.FilterListEmployees;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FilterList implements Task {
    private String strFilterSalary;

    public FilterList(String strFilterSalary) {
        this.strFilterSalary = strFilterSalary;
    }

    public static FilterList withKeySalary(String listValueSalary) {
        return Tasks.instrumented(FilterList.class,listValueSalary);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                FilterListEmployees.withKeySalary(strFilterSalary)
        );
    }
}
