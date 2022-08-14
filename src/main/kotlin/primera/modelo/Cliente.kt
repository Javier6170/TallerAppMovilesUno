package primera.modelo

open class Cliente(id: Int, nombreCompleto: String, documentoEntidad: String, correoElectronico: String, var direccion: String, var telefono: String) : Persona(id, nombreCompleto, documentoEntidad,
    correoElectronico
)