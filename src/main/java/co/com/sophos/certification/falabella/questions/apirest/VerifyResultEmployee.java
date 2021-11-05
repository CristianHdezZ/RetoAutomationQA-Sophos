package co.com.sophos.certification.falabella.questions.apirest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.logging.Level;

import static co.com.sophos.certification.falabella.util.Constant.employee;
import static co.com.sophos.certification.falabella.util.MetodosComunes.adicionarLog;

public class VerifyResultEmployee implements Question<Boolean> {
    private String strId;
    private String strName;
    private String strSalary;
    private String strAge;

    public VerifyResultEmployee(String strId, String strName, String strSalary, String strAge) {
        this.strId = strId;
        this.strName = strName;
        this.strSalary = strSalary;
        this.strAge = strAge;
    }

    public static VerifyResultEmployee with(String strId, String strName, String strSalary, String strAge) {
        return new VerifyResultEmployee(strId,strName,strSalary,strAge);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        if(employee.getId().equalsIgnoreCase(strId)&&employee.getName().equalsIgnoreCase(strName)&&employee.getSalary().equalsIgnoreCase(strSalary)&&employee.getAge().equalsIgnoreCase(strAge)){
            adicionarLog(Level.INFO,String.format("Se verifico sobre el employee resultante,lo siguiente: \nId:%s \nName:%s \nSalary:%s \nAge:%s",
                    employee.getId(),
                    employee.getName(),
                    employee.getSalary(),
                    employee.getAge()));
        }

        return employee.getId().equalsIgnoreCase(strId)&&employee.getName().equalsIgnoreCase(strName)&&employee.getSalary().equalsIgnoreCase(strSalary)&&employee.getAge().equalsIgnoreCase(strAge);
    }
}
