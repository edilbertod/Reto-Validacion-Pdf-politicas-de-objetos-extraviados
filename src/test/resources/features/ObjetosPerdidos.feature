#Autor: Edi
  #language: es
Característica: Validacion pdf de objetos perdidos
  Como usuario
  Quiero realizar la validaccion del pdf de objetos perdidos
  Para ver si es el pdf correcto

  @caso1
  Escenario: Validacion correcta

    Dado que entro a la seccion de objetos perdidos

    Cuando consulto el pdf

    Entonces verifico que sea el correcto
    |titulo|
    |Políticas de Objetos Extraviados|