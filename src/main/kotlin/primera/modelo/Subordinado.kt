package primera.modelo

open class Subordinado(id: Int, nombreCompleto: String, documentoEntidad: String, correoElectronico: String, var idJefe: Int) : Persona(id, nombreCompleto,
    documentoEntidad,
    correoElectronico
)