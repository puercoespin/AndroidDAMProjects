package com.vehiculos.data

import com.vehiculos.data.mocks.CocheDaoMock
import com.vehiculos.model.Coche
import com.vehiculos.ui.features.cochesFicha.FichaCocheUiState

class CocheRepository {
    private val cocheDaoMock : CocheDaoMock = CocheDaoMock()

    fun get(): MutableList<Coche> {

        return cocheDaoMock.get().map { it.toCoche() }.toMutableList()
    }

    fun get(modelo: String): Coche? {
        return get().find { it.modelo == modelo }
    }




}