package co.com.sophos.certification.falabella.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListProductFalabellaPage {
    public static final Target MODAL_CONTENTS_INFO_TARJETA_CRM = Target.the("Modal de informacion de tarjeta CRM")
            .located(By.xpath("//div[@class='dy-lb-close']"));
    public static final Target LIST_ELEMENT_PRODUCTO = Target.the("Lista de productos del catalogo")
            .locatedBy("//b[contains(text(),'{0}')]");
    public static final Target BUTTON_AGREGAR_BOLSA_COMPRA = Target.the("Boton para agregar producto a la bolsa de compra")
            .located(By.id("buttonForCustomers"));
    public static final Target BUTTON_SEGURO = Target.the("Boton para dar click en un seguro")
            .locatedBy("(//button//span[contains(text(),'{0}')])[1]/..");
    public static final Target BUTTON_VER_BOLSA_COMPRA = Target.the("Boton para ver la bolsa de compra")
            .located(By.id("linkButton"));

}