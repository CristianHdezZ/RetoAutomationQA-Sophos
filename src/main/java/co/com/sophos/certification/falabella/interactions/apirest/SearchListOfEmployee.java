package co.com.sophos.certification.falabella.interactions.apirest;

import co.com.sophos.certification.falabella.util.Constant;
import co.com.sophos.certification.falabella.util.ConsumoServicios;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;
import java.util.logging.Level;

import static co.com.sophos.certification.falabella.util.Constant.URL_PARA_OBTENER_INFORMACION_EMPLOYEE;
import static co.com.sophos.certification.falabella.util.Constant.hmDatosEmployee;
import static co.com.sophos.certification.falabella.util.MetodosComunes.adicionarLog;
import static co.com.sophos.certification.falabella.util.MetodosComunes.viewEmployee;

public class SearchListOfEmployee implements Interaction {
    private int intStatusCode;
    private String strUrlListaEmployee;

    public static SearchListOfEmployee inTheAPI() {
        return Tasks.instrumented(SearchListOfEmployee.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        strUrlListaEmployee = String.format(URL_PARA_OBTENER_INFORMACION_EMPLOYEE);
        hmDatosEmployee = new ArrayList<>();
        try{
            adicionarLog(Level.INFO, Constant.MSG_CONSULTA_SERVICIO_REST);
            adicionarLog(Level.INFO, String.format("Url del servicio: %s", strUrlListaEmployee));
            Response obtenerInformacionEmployee = ConsumoServicios.servicioRestGet(strUrlListaEmployee);

            if (obtenerInformacionEmployee != null) {
                intStatusCode = obtenerInformacionEmployee.statusCode();
                adicionarLog(Level.INFO,"Status code: "+intStatusCode);
                if (intStatusCode == 200) {
                    adicionarLog(Level.INFO, "La consulta 'Employees' se ha realizado exitosamente");
                    adicionarLog(Level.INFO, String.format("Respuesta del servicio:\n%s", obtenerInformacionEmployee.body().asString()));

                    adicionarLog(Level.INFO,String.format(" ------ Lista de Employees --------- "));

                    hmDatosEmployee = obtenerInformacionEmployee.body().path("data");
                    viewEmployee(hmDatosEmployee);

                }else {
                    adicionarLog(Level.INFO, String.format("No se pudo acceder al servicio employee, se obtuvo el siguiente codigo de respuesta %s", intStatusCode));
                    do{
                        adicionarLog(Level.INFO, Constant.MSG_CONSULTA_SERVICIO_REST);
                        adicionarLog(Level.INFO, String.format("Url del servicio: %s", strUrlListaEmployee));
                        obtenerInformacionEmployee = ConsumoServicios.servicioRestGet(strUrlListaEmployee);
                        intStatusCode = obtenerInformacionEmployee.statusCode();
                        adicionarLog(Level.INFO,"Status code: "+intStatusCode);

                        if (intStatusCode==200){
                            hmDatosEmployee = obtenerInformacionEmployee.body().path("data");
                            viewEmployee(hmDatosEmployee);
                        }


                    }while (intStatusCode!=200);


                }
            }else {
                adicionarLog(Level.INFO, "No se pudo acceder al servicio employee");

            }

        }catch (NullPointerException e) {
            adicionarLog(Level.SEVERE, String.format("No se pudo acceder al servicio employee, se obtuvo el siguiente error: %s", e));

        }
    }
}
