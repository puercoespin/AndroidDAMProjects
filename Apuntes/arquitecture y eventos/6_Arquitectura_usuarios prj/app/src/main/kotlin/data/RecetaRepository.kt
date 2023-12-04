package data

import data.mock.RecetaDaoMock
import data.mock.RecetaMock
import data.mock.UsuarioDaoMock
import data.models.Receta

class RecetaRepository {
    private val recetaDaoMock: RecetaDaoMock = RecetaDaoMock()

    fun get(): MutableList<Receta> {
        return recetaDaoMock.get().map { it.toReceta() }.toMutableList()
    }

    fun get(id: Int): Receta? {
        return get().find { it.id == id }
    }

    fun insert(recetaRemoto: Receta) {
        recetaDaoMock.insert(recetaRemoto.toRecetaMock())
    }

    fun delete(id: Int) {
        get().removeIf{it.id == id}
    }


}