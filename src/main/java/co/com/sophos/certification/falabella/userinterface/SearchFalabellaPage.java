package co.com.sophos.certification.falabella.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchFalabellaPage {
    public static final Target BUTTON_NO_GRACIAS = Target.the("Boton para no aceptar la suscríccion para enterarte sesus mejores Ofertas.")
            .located(By.id("acc-alert-deny"));
    public static final Target INPUT_CONSULTAR = Target.the("Caja de texto para ingresar el producto a consultar")
            .located(By.id("testId-SearchBar-Input"));
    public static final Target SELECT_CATEGORIA = Target.the("Lista del filtro de busqueda, con diferentes categorias relacionadas a la marac")
            .locatedBy("//a[contains(text(),'{0}')]");
}