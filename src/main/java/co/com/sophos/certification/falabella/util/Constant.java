package co.com.sophos.certification.falabella.util;


import co.com.sophos.certification.falabella.model.apirest.Employee;
import org.codehaus.groovy.util.ListHashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Constant {
    public static int SIZE_RESULT_PRODUCTO_FILTER_BRAND;
    public static final Logger LOG_SOPHOS = Logger.getLogger("co.com.sophos");
    public static final String MSG_CONSULTA_SERVICIO_REST = "---------- CONSULTA DE SERVICIO REST ----------";
    public static List<Map<String, Object>> hmDatosEmployee;
    public static ListHashMap<Integer,String> hmFiltroDatosEmployees;
    public static ListHashMap<Integer, Employee> hmDetalleEmployee;
    public static Employee employee;
    public static final String URL_FALABELLA = "https://www.falabella.com.co/falabella-co";


    /**
     * WEBSERVICES REST
     */
    public static final String URL_PARA_OBTENER_INFORMACION_EMPLOYEE = "http://dummy.restapiexample.com/api/v1/employees";
    public static final String URL_PARA_OBTENER_DETALLE_EMPLOYEE ="http://dummy.restapiexample.com/api/v1/employee/%s";
}