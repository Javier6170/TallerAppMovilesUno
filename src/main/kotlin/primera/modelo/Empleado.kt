package primera.modelo

class Empleado(id: Int, nombreCompleto: String, documentoEntidad: String, correoElectronico: String, var salario: Double, var listaSubordinados: MutableList<Persona>, var cargo: Cargo) : Persona(id, nombreCompleto,
    documentoEntidad,
    correoElectronico
) {
}