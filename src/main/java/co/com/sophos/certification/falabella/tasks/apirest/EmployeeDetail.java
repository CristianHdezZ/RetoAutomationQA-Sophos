package co.com.sophos.certification.falabella.tasks.apirest;

import co.com.sophos.certification.falabella.interactions.apirest.ConsultEmployeeDetail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EmployeeDetail implements Task {
    private String strSalary;

    public EmployeeDetail(String strSalary) {
        this.strSalary = strSalary;
    }

    public static EmployeeDetail withTheSalary(String strSalary) {
        return Tasks.instrumented(EmployeeDetail.class,strSalary);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ConsultEmployeeDetail.withTheSalary(strSalary)
        );

    }
}