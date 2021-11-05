package co.com.sophos.certification.falabella.interactions.apirest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.codehaus.groovy.util.ListHashMap;

import java.util.Map;
import java.util.logging.Level;

import static co.com.sophos.certification.falabella.util.Constant.hmDatosEmployee;
import static co.com.sophos.certification.falabella.util.Constant.hmFiltroDatosEmployees;
import static co.com.sophos.certification.falabella.util.MetodosComunes.adicionarLog;

public class FilterListEmployees implements Interaction {
    private String strFilterSalary;

    public FilterListEmployees(String strFilterSalary) {
        this.strFilterSalary = strFilterSalary;
    }

    public static FilterListEmployees withKeySalary(String strFilterSalary) {
        return Tasks.instrumented(FilterListEmployees.class,strFilterSalary);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        hmFiltroDatosEmployees = new ListHashMap<>();

        adicionarLog(Level.INFO,String.format("----- Lista de Employees con salario menor a el valor: %s ------",strFilterSalary));
        for (Map<String, Object> mapaInformacionEmployee : hmDatosEmployee) {
            if (Integer.parseInt(mapaInformacionEmployee.get("employee_salary").toString())<Integer.parseInt(strFilterSalary)){

                adicionarLog(Level.INFO,String.format("\n Id: %s - employee_name: %s - Salary: %s -  Age: %s",
                mapaInformacionEmployee.get("id"),
                mapaInformacionEmployee.get("employee_name"),
                mapaInformacionEmployee.get("employee_salary"),
                mapaInformacionEmployee.get("employee_age")));

                hmFiltroDatosEmployees.put(Integer.parseInt(mapaInformacionEmployee.get("id").toString()),mapaInformacionEmployee.get("employee_name").toString());
            }
        }

    }
}
