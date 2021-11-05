package co.com.sophos.certification.falabella.stepdefinitions;

import co.com.sophos.certification.falabella.model.ui.Product;
import co.com.sophos.certification.falabella.questions.ui.VerifySumary;
import co.com.sophos.certification.falabella.tasks.ui.*;
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

public class FrontendSearchFalabellaStepdefinition {

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) ingresa a la home de Falabella$")
    public void cristianIngresaALaHomeDeFalabella(String strNameActor) {
        theActorCalled(strNameActor).wasAbleTo(OpenThePage.homeTheFalabella());
    }

    @When("^filtra en la barra de busqueda el articulo de preferencia$")
    public void FiltraEnLaBarraDeBusquedaElArticuloDePreferencia(List<String> listArticulo) {
        theActorInTheSpotlight().attemptsTo(SearchInHomeFalabella.withKeyword(listArticulo.get(0)));
    }

    @When("^selecciona un elemento que se encuentre en la pagina superior a la segunda$")
    public void seleccionaUnElementoQueSeEncuentreEnLaPaginaSuperiorALaSegunda(List<String> listCategoria) {
        theActorInTheSpotlight().attemptsTo(SelectElement.fromTheFilterWith(listCategoria.get(0)));
    }

    @When("^agregar a la bolsa de compra$")
    public void agregarALaBolsaDeCompra(List<String> listNombreProducto) {
        theActorInTheSpotlight().attemptsTo(AddElement.inTheShoppingBag(listNombreProducto.get(0)));
    }

    @When("^selecciona un seguro para el producto$")
    public void seleccionaUnSeguroParaElProducto(List<String> listSeguro) {
        theActorInTheSpotlight().attemptsTo(AddSeguro.inTheShoppingElement(listSeguro.get(0)));
    }

    @Then("^verifica en el resumen de la bolsa de compra el articulo y el seguro$")
    public void verificaEnElResumenDeLaBolsaDeCompraElArticuloYElSeguro(List<Product> listProduct) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifySumary.ofOrder(listProduct.get(0))));
    }
}
