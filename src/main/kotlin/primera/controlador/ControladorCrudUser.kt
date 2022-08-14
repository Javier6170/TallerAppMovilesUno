package primera.controlador

import primera.modelo.Cliente
import primera.modelo.Empleado
import primera.modelo.Persona

class ControladorCrudUser {
    val listaPersonas: MutableList<Persona> = mutableListOf()

    fun agregarUser(persona: Persona) {
        var aux: Persona? = buscarUserByDocumento(persona.documentoEntidad)
        if (aux == null) {
            listaPersonas.add(persona)
        }else
             println("Esta persona ya esta registrada!")
    }

    fun buscarUserByDocumento(documentoIdentidad: String): Persona? {
        for (persona in listaPersonas) {
            if (persona.documentoEntidad == documentoIdentidad) {
                return persona
            }
        }
        return null
    }

    fun eliminarUser(documentoIdentidad: String){
        var aux: Persona? = null
        for (persona in listaPersonas) {
            if (persona.documentoEntidad == documentoIdentidad) {
                aux = persona
            }
        }
        if (aux != null) {
            listaPersonas.remove(aux)
        }else{
            return print("Esta persona no existe!")
        }

    }

    fun listaPersona(){
        for (i in listaPersonas){
            if (i is Cliente){
                println ("\n-------------Cliente----------\ncompleto: ${i.nombreCompleto}\n" +
                        "Documento identidad ${i.documentoEntidad}\n"+
                        "Correo Electronico ${i.correoElectronico}\n"+
                        "Direccion ${i.direccion}\n"+
                        "Telefono ${i.telefono}\n")
            }
            if (i is Empleado){
                println ("\n------------Jefe---------------\nNombre completo: ${i.nombreCompleto}\n" +
                        "Documento identidad: ${i.documentoEntidad}\n"+
                        "Correo Electronico: ${i.correoElectronico}\n"+
                        "Salario: ${i.salario}\n"+
                        "Nombre cargo: ${i.cargo.nombreCargo} - nivel jerarquico ${i.cargo.nivelJerarquico}\n" +
                        "Lista de Subordinados: ${i.listaSubordinados.forEach { 
                                    println("\n-------------Subordinados-----------\nid: ${it.id}\n" +
                                    "Nombre completo: ${it.nombreCompleto}\n" +
                                    "documento Identidad: ${it.documentoEntidad}\n" +
                                    "Correo electronico: ${it.correoElectronico}")
                        }}")
            }

        }
    }
}