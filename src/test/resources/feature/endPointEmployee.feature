Feature: Consulta de empleados
  Como Usuario
  Quiero ingresar al API Rest
  A consulta informacion de todos los empleados

  @ConsultaExitosaEmpleados
  Scenario Outline: Consulta de empleados
    Given Cristian obtiene una lista de empleados del servicio de empleados
    When de la lista de resultados toma aquellos que contengan el salario menor a
      |<salaryTope>|
    And por cada elemento de la lista anterior pedir el detalle en API y tomar solo aquel que contenga el salario
      |<salary>|
    Then Sobre el empleado resultante, assert lo siguiente
      |<id>|<name>|<salary>|<age>|
    Examples:
      |id|name|salary|age|salaryTope|
      |24|Doris Wilder|85600|23|300000|