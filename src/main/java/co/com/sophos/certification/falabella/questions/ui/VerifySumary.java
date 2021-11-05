package co.com.sophos.certification.falabella.questions.ui;

import co.com.sophos.certification.falabella.model.ui.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.sophos.certification.falabella.userinterface.SummaryOfOrderPage.*;

public class VerifySumary implements Question<Boolean> {
    private Product product;

    public VerifySumary(Product product) {
        this.product = product;
    }

    public static VerifySumary ofOrder(Product product) {
        return new VerifySumary(product);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String strLabelNombreProducto = Text.of(LABEL_NOMBRE_PRODUCTO).viewedBy(actor).asString();
        String strLabelPrecioProducto = Text.of(LABEL_PRECIO_PRODUCTO).viewedBy(actor).asString();
        String strLabelSeguroProducto = Text.of(LABEL_SEGURO_PRODUCTO).viewedBy(actor).asString();

        System.out.println(strLabelNombreProducto+" "+strLabelPrecioProducto+" "+strLabelSeguroProducto);

        return product.getNombreProducto().equalsIgnoreCase(strLabelNombreProducto)&&product.getPrecio().equalsIgnoreCase(strLabelPrecioProducto)&&String.valueOf(product.getSeguro()+" "+product.getValorSeguro()).equalsIgnoreCase(strLabelSeguroProducto);
    }
}
