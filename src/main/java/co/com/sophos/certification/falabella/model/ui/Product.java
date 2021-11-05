package co.com.sophos.certification.falabella.model.ui;

public class Product {
    private String nombreProducto,marca,precio,seguro,valorSeguro;

    public Product(String nombreProducto, String marca, String precio, String seguro, String valorSeguro) {
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.precio = precio;
        this.seguro = seguro;
        this.valorSeguro = valorSeguro;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(String valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
}
