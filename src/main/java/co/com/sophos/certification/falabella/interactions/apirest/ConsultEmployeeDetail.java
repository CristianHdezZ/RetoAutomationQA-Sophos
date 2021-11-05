package co.com.sophos.certification.falabella.interactions.apirest;

import co.com.sophos.certification.falabella.model.apirest.Employee;
import co.com.sophos.certification.falabella.util.Constant;
import co.com.sophos.certification.falabella.util.ConsumoServicios;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.codehaus.groovy.util.ListHashMap;

import java.util.Map;
import java.util.logging.Level;

import static co.com.sophos.certification.falabella.util.Constant.*;
import static co.com.sophos.certification.falabella.util.MetodosComunes.addEmployeeDetail;
import static co.com.sophos.certification.falabella.util.MetodosComunes.adicionarLog;


public class ConsultEmployeeDetail implements Interaction {
    private String strSalary;
    private String strUrlDetalleEmployee;
    private int intStatusCode;
    private int intContador;

    public ConsultEmployeeDetail(String strSalary) {
        this.strSalary = strSalary;
    }

    public static ConsultEmployeeDetail withTheSalary(String strSalary) {
        return Tasks.instrumented(ConsultEmployeeDetail.class,strSalary);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        hmDetalleEmployee = new ListHashMap<>();
        intContador = 0;

        try {
            adicionarLog(Level.INFO, Constant.MSG_CONSULTA_SERVICIO_REST);

            for (Map.Entry<Integer,String> entry: hmFiltroDatosEmployees.entrySet() ) {

                intContador = intContador+1;
                strUrlDetalleEmployee = String.format(URL_PARA_OBTENER_DETALLE_EMPLOYEE,entry.getKey());
                adicionarLog(Level.INFO, String.format("Url del servicio: %s", strUrlDetalleEmployee));
                Response obtenerDetalleDeEmpleado = ConsumoServicios.servicioRestGet(strUrlDetalleEmployee);

               if (obtenerDetalleDeEmpleado !=null){

                    intStatusCode = obtenerDetalleDeEmpleado.statusCode();
                    adicionarLog(Level.INFO,"Status code: "+intStatusCode);

                    if (intStatusCode==200){

                        adicionarLog(Level.INFO,obtenerDetalleDeEmpleado.body().asString());
                        System.out.println("contador: "+intContador);
                        addEmployeeDetail(intContador,obtenerDetalleDeEmpleado);

                        /*hmDetalleEmployee.put(intContador,new Employee(
                                obtenerDetalleDeEmpleado.path("data.id").toString(),
                                obtenerDetalleDeEmpleado.path("data.employee_name").toString(),
                                obtenerDetalleDeEmpleado.path("data.employee_salary").toString(),
                                obtenerDetalleDeEmpleado.path("data.employee_age").toString())
                        );*/

                    }else {
                        do{
                            strUrlDetalleEmployee = String.format(URL_PARA_OBTENER_DETALLE_EMPLOYEE,entry.getKey());
                            adicionarLog(Level.INFO, String.format("Url del servicio: %s", strUrlDetalleEmployee));
                            obtenerDetalleDeEmpleado = ConsumoServicios.servicioRestGet(strUrlDetalleEmployee);
                            intStatusCode = obtenerDetalleDeEmpleado.statusCode();
                            adicionarLog(Level.INFO,"Status code: "+intStatusCode);

                            System.out.println("contador: "+intContador);

                            addEmployeeDetail(intContador,obtenerDetalleDeEmpleado);


                            /*hmDetalleEmployee.put(intContador,new Employee(
                                    obtenerDetalleDeEmpleado.path("data.id").toString(),
                                    obtenerDetalleDeEmpleado.path("data.employee_name").toString(),
                                    obtenerDetalleDeEmpleado.path("data.employee_salary").toString(),
                                    obtenerDetalleDeEmpleado.path("data.employee_age").toString())
                            );*/

                        }while (intStatusCode!=200);


                    }
                }
            }

            for (Map.Entry<Integer,Employee> entryDetalleEmployee : hmDetalleEmployee.entrySet()) {
                adicionarLog(Level.INFO,String.format("\n Id: %s \nName: %s \nSalary:%s \nAge:%s \n---------------------------------------------------",
                        entryDetalleEmployee.getValue().getId(),
                        entryDetalleEmployee.getValue().getName(),
                        entryDetalleEmployee.getValue().getSalary(),
                        entryDetalleEmployee.getValue().getAge()));
            }

            adicionarLog(Level.INFO,String.format("------------- Se toma solo aquel que contenga Salary = %s ------------",strSalary));
            for (Map.Entry<Integer, Employee> entryDetalleEmployee : hmDetalleEmployee.entrySet()) {

                if (entryDetalleEmployee.getValue().getSalary().equalsIgnoreCase(strSalary)){
                    employee = new Employee(entryDetalleEmployee.getValue().getId(),
                            entryDetalleEmployee.getValue().getName(),
                            entryDetalleEmployee.getValue().getSalary(),
                            entryDetalleEmployee.getValue().getAge());

                    adicionarLog(Level.INFO,String.format("\n Id: %s \nName: %s \nSalary:%s \nAge:%s \n---------------------------------------------------",
                            entryDetalleEmployee.getValue().getId(),
                            entryDetalleEmployee.getValue().getName(),
                            entryDetalleEmployee.getValue().getSalary(),
                            entryDetalleEmployee.getValue().getAge()));
                }

            }

        } catch (NullPointerException e) {
            adicionarLog(Level.SEVERE, String.format("No se pudo acceder al servicio employees, se obtuvo el siguiente error: %s", e));
        }

    }
}
