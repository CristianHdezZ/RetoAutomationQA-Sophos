package co.com.sophos.certification.falabella.stepdefinitions;

import co.com.sophos.certification.falabella.questions.apirest.VerifyResultEmployee;
import co.com.sophos.certification.falabella.tasks.apirest.EmployeeDetail;
import co.com.sophos.certification.falabella.tasks.apirest.FilterList;
import co.com.sophos.certification.falabella.tasks.apirest.SearchList;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EndPointEmployeeStepdefinition {
    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^(.*) obtiene una lista de empleados del servicio de empleados$")
    public void ObtieneUnaListaDeEmpleadosDelServicioDeEmpleados(String nameActor) {
        theActorCalled(nameActor).wasAbleTo(SearchList.ofEmpleyee());
    }

    @When("^de la lista de resultados toma aquellos que contengan el salario menor a$")
    public void deLaListaDeResultadosTomaAquellosQueContenganElSalarioMenorA(List<String> listValueSalary) {
        theActorInTheSpotlight().attemptsTo(FilterList.withKeySalary(listValueSalary.get(0)));
    }

    @When("^por cada elemento de la lista anterior pedir el detalle en API y tomar solo aquel que contenga el salario$")
    public void porCadaElementoDeLaListaAnteriorPedirElDetalleEnAPIYTomarSoloAquelQueContengaElSalario(List<String> listSalary) {
        theActorInTheSpotlight().attemptsTo(EmployeeDetail.withTheSalary(listSalary.get(0)));
    }

    @Then("^Sobre el empleado resultante, assert lo siguiente$")
    public void sobreElEmpleadoResultanteAssertLoSiguiente(List<String> listEmployee) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyResultEmployee.with(listEmployee.get(0),listEmployee.get(1),listEmployee.get(2),listEmployee.get(3))));
    }


}
