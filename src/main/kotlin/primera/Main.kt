import primera.controlador.ControladorCrudUser
import primera.modelo.*

fun main(args: Array<String>) {
    var controladorCrud: ControladorCrudUser = ControladorCrudUser()
    val listaSubordinado: MutableList<Persona> = mutableListOf()
    var salirTotal: Boolean = false
    println(
        "Hola Bienvenido a App movil \n" + "para entrar al menu de opciones digita (1)\n" +
                  "Para Salir de este menu digita (2): "
    )
    var opcionPrincipal: Int = readLine()!!.toInt()
    while (!salirTotal) {
        try {
            when(opcionPrincipal){
                1 -> {
                    println(
                        "\n-----------------Menu---------------- \n" + "Para Agregar un empleado digita (1)\n" + "Para Agregar un cliente digita (2)\n"+ "elminar usuario (3)\n" +  "buscar usuario (4)\n" + "Para Salir de este menu digita (5): "
                    )
                    var opcion: Int = readLine()!!.toInt()
                    var salir: Boolean = false
                    while (!salir) {
                        try {
                            when (opcion) {
                                1 -> {
                                    print("id: ")
                                    var idEmpleado = readLine()!!.toInt()
                                    print("nombre completo: ")
                                    var nombreCompleto = readLine()!!.toString()
                                    print("documento identidad: ")
                                    var documentoIdentidad = readLine()!!.toString()
                                    print("correo electronico: ")
                                    var correoElectronico = readLine()!!.toString()
                                    print("salario: ")
                                    var salario = readLine()!!.toDouble()
                                    print("nombre cargo: ")
                                    var nombreCargo = readLine()!!.toString()
                                    print("nivel jerarquico: ")
                                    var nivelJerarquico = readLine()!!.toInt()
                                    println(
                                        "Esoge: \n" + "(1) si deseas tener subordinados\n" + "(2) si no deseas tener subordinados"
                                    )
                                    var opcionSubordinados: Int = readLine()!!.toInt()
                                    if (opcionSubordinados == 1) {
                                        print("digita numero subordinados: ")
                                        var numeroSubordinados: Int = readLine()!!.toInt()

                                        for (i in 1..numeroSubordinados) {
                                            print("id: ")
                                            var idSubordinado = readLine()!!.toInt()
                                            print("nombre completo: ")
                                            var nombreCompletoSubordinado = readLine()!!.toString()
                                            print("documento identidad: ")
                                            var documentoIdentidadSubordinado = readLine()!!.toString()
                                            print("correo electronico: ")
                                            var correoElectronicoSubordinado = readLine()!!.toString()
                                            print("id jefe: ")
                                            var idJefe = readLine()!!.toInt()
                                            var subordinado = Subordinado(
                                                idSubordinado,
                                                nombreCompletoSubordinado,
                                                documentoIdentidadSubordinado,
                                                correoElectronicoSubordinado,
                                                idJefe
                                            )
                                            listaSubordinado.add(subordinado)
                                            println("Subordinado guardado con exito")
                                        }
                                    }
                                    var cargo = Cargo(nombreCargo, nivelJerarquico)
                                    var empleado = Empleado(
                                        idEmpleado,
                                        nombreCompleto,
                                        documentoIdentidad,
                                        correoElectronico,
                                        salario,
                                        listaSubordinado,
                                        cargo
                                    )
                                    controladorCrud.agregarUser(empleado)
                                    println("Empleado guardado con exito!")
                                    controladorCrud.listaPersona()
                                    salir = true
                                }
                                2 -> {
                                    print("id: ")
                                    var id = readLine()!!.toInt()
                                    print("nombre completo: ")
                                    var nombreCompleato = readLine().toString()
                                    print("documento identidad: ")
                                    var documentoIdentidad = readLine().toString()
                                    print("correo electronico: ")
                                    var correoElectronico = readLine().toString()
                                    print("direccion: ")
                                    var direccion = readLine().toString()
                                    print("telefono: ")
                                    var telefono = readLine().toString()

                                    var cliente =
                                        Cliente(id, nombreCompleato, documentoIdentidad, correoElectronico, direccion, telefono)
                                    controladorCrud.agregarUser(cliente)
                                    println("lista personas:  ${controladorCrud.listaPersona()}")
                                    salir = true
                                }
                                3 -> {
                                    print("documento identidad: ")
                                    var documentoIdentidad = readLine()!!.toString()
                                    controladorCrud.eliminarUser(documentoIdentidad)
                                    println("Se ha eliminado con exito la persona!")
                                    salir = true
                                }
                                4 ->{
                                    print("documento identidad: ")
                                    var documentoIdentidad = readLine()!!.toString()
                                    controladorCrud.buscarUserByDocumento(documentoIdentidad)
                                    if (controladorCrud.buscarUserByDocumento(documentoIdentidad) != null){
                                        if (controladorCrud.buscarUserByDocumento(documentoIdentidad) is Cliente){
                                            println ("\n-------------Cliente----------\ncompleto: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad) as Cliente).nombreCompleto}\n" +
                                                    "Correo Electronico ${(controladorCrud.buscarUserByDocumento(documentoIdentidad) as Cliente).correoElectronico}\n"+
                                                    "Direccion ${(controladorCrud.buscarUserByDocumento(documentoIdentidad) as Cliente).direccion}\n"+
                                                    "Telefono ${(controladorCrud.buscarUserByDocumento(documentoIdentidad) as Cliente).telefono}\n")
                                        }
                                        if (controladorCrud.buscarUserByDocumento(documentoIdentidad) is Empleado){
                                            println ("\n------------Jefe---------------\nNombre completo: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).nombreCompleto}\n" +
                                                    "Documento identidad: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).documentoEntidad}\n"+
                                                    "Correo Electronico: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).correoElectronico}\n"+
                                                    "Salario: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).salario}\n"+
                                                    "Nombre cargo: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).cargo.nombreCargo} - nivel jerarquico ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).cargo.nivelJerarquico}\n" +
                                                    "Lista de Subordinados: ${(controladorCrud.buscarUserByDocumento(documentoIdentidad)as Empleado).listaSubordinados.forEach {
                                                        println("\n-------------Subordinados-----------\nid: ${it.id}\n" +
                                                                "Nombre completo: ${it.nombreCompleto}\n" +
                                                                "documento Identidad: ${it.documentoEntidad}\n" +
                                                                "Correo electronico: ${it.correoElectronico}")
                                                    }}")
                                        }
                                    }else{
                                        println("Esta persona no existe!")
                                    }
                                    salir = true
                                }
                                5 ->{
                                    salir = true
                                    break
                                }
                            }

                        } catch (ex: Exception) {
                            println("No debes digitar un numero diferente del menu!")
                        }
                    }
                }
                2->{
                    salirTotal = true
                    break
                }
            }
        }catch (ex: Exception){
            println("No debes digitar un numero diferente del menu!")
        }
    }
}



