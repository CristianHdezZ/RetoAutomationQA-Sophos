package co.com.sophos.certification.falabella.util;


import co.com.sophos.certification.falabella.model.apirest.Employee;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;

import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import static co.com.sophos.certification.falabella.util.Constant.hmDetalleEmployee;


public class MetodosComunes {

    private static Handler fileHandler;


    private static void generarLogger(String strNombreLoger) {
        try {
            // crearCarpetaLogger();
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler = new FileHandler("./target/site/serenity/_" + strNombreLoger + ".log", false);
            fileHandler.setFormatter(simpleFormatter);
            Constant.LOG_SOPHOS.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void cerrarLogger() {
        try {
            fileHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void adicionarLog(Level level, String strMensaje) {
        Constant.LOG_SOPHOS.log(level, strMensaje);
        if (level.equals(Level.SEVERE)) {
            MatcherAssert.assertThat(String.format("Fallo el escenario debido a: %s", strMensaje), false);
        }else {
            MatcherAssert.assertThat(String.format("Escenario Exitoso debido a: %s", strMensaje), true);
        }
    }
    public static void viewEmployee(List<Map<String, Object>> hmDatosEmployeeObtenido) {
        for (Map<String, Object> mapaInformacionEmployee : hmDatosEmployeeObtenido) {
            adicionarLog(Level.INFO, String.format("\n Id: %s - employee_name: %s - Salary: %s -  Age: %s",
                    mapaInformacionEmployee.get("id"),
                    mapaInformacionEmployee.get("employee_name"),
                    mapaInformacionEmployee.get("employee_salary"),
                    mapaInformacionEmployee.get("employee_age")));
        }
    }
    public static void addEmployeeDetail(int intContador, Response DetalleDeEmpleadoAdd){
        hmDetalleEmployee.put(intContador,new Employee(
                DetalleDeEmpleadoAdd.path("data.id").toString(),
                DetalleDeEmpleadoAdd.path("data.employee_name").toString(),
                DetalleDeEmpleadoAdd.path("data.employee_salary").toString(),
                DetalleDeEmpleadoAdd.path("data.employee_age").toString())
        );

    }
}