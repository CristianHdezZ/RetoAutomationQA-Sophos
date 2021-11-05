Feature: Agregar producto en bolsa de compras en Falabella
  Como Usuario
  Quiero ingresar a la home de Falabella.com.co
  A consulta informacion de productos
  Y agregarlos en la bolsa de compras
  Con un seguro de producto

  @AgregarProductoBolsaComprasExitosa
  Scenario Outline: Agregar producto en bolsa de compras
    Given Cristian ingresa a la home de Falabella
    When filtra en la barra de busqueda el articulo de preferencia
      |<marca>|
    And selecciona un elemento que se encuentre en la pagina superior a la segunda
      |<categoria>|
    And agregar a la bolsa de compra
      |<nombreProducto>|
    And selecciona un seguro para el producto
      |<seguro>|
    Then verifica en el resumen de la bolsa de compra el articulo y el seguro
      |nombreProducto|marca|precio|seguro|valorSeguro|
      |<nombreProducto>|<marca>|<precio>|<seguro>|<valorSeguro>|
    Examples:
      |nombreProducto|marca|categoria|precio|seguro|valorSeguro|
      |Celular Samsung Galaxy A21S 128GB|Samsung|celulares|$ 729.900 (Precio final)|Asegura tu Pantalla|$ 99.900|