package co.com.sophos.certification.falabella.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class SummaryOfOrderPage {
    public static final Target LABEL_NOMBRE_PRODUCTO = Target.the("Etiqueda del nombre del producto")
            .locatedBy("//*[@class='fb-product__title']");
    public static final Target LABEL_PRECIO_PRODUCTO = Target.the("Etiqueta del precio del producto")
            .locatedBy("//div[@class='fb-pod__prices' and contains(.,'(Precio final)')]");
    public static final Target LABEL_SEGURO_PRODUCTO = Target.the("")
            .locatedBy("//*[@class='fb-inline-dropdown__link__title js-inline-dropdown__link__title']");

}