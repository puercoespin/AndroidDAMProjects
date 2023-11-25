package com.vehiculos.data.mocks

class CocheDaoMock {

    private val coches = mutableListOf<CocheMock>(
        CocheMock(
            fabricante = "Volkswagen",
            modelo = "Passat",
            año = 2016,
            precio = 43210f,
            porcentajeDescuento = 0,
            stock = 2,
            descripcion = "Volkswagen Passat 2.0 TDI 150CV BMT Advance DSG 4p"
        ),
        CocheMock(
            fabricante = "Ford",
            modelo = "Mustang",
            año = 2017,
            precio = 55000f,
            porcentajeDescuento = 10,
            stock = 3,
            descripcion = "Ford Mustang 5.0 Ti-VCT V8 GT 2p"
        ),
        CocheMock(
            fabricante = "Audi",
            modelo = "A4",
            año = 2018,
            precio = 46000f,
            porcentajeDescuento = 0,
            stock = 1,
            descripcion = "Audi A4 2.0 TDI 110kW (150CV) S line edition 4p"
        ),
        CocheMock(
            fabricante = "BMW",
            modelo = "X5",
            año = 2019,
            precio = 86800f,
            porcentajeDescuento = 20,
            stock = 1,
            descripcion = "BMW X5 xDrive30d 5p"
        ),
        CocheMock(
            fabricante = "Mercedes",
            modelo = "Clase C",
            año = 2020,
            precio = 50000f,
            porcentajeDescuento = 0,
            stock = 2,
            descripcion = "Mercedes-Benz Clase C C 220d Estate 9G-Tronic 5p"
        ),
        CocheMock(
            fabricante = "Volkswagen",
            modelo = "Golf",
            año = 2021,
            precio = 29000f,
            porcentajeDescuento = 0,
            stock = 6,
            descripcion = "Volkswagen Golf 1.5 TSI 96kW (130CV) Sport 5p"
        ),
        CocheMock(
            fabricante = "Ford",
            modelo = "Focus",
            año = 2022,
            precio = 30000f,
            porcentajeDescuento = 5,
            stock = 5,
            descripcion = "Ford Focus 1.0 Ecoboost 92kW (125CV) ST-Line 5p"
        ),
        CocheMock(
            fabricante = "Audi",
            modelo = "A3",
            año = 2023,
            precio = 32000f,
            porcentajeDescuento = 0,
            stock = 2,
            descripcion = "Audi A3 Sportback 30 TFSI 81kW (110CV) S tronic 5p"
        ),
        CocheMock(
            fabricante = "BMW",
            modelo = "Serie 3",
            año = 2020,
            precio = 45200f,
            porcentajeDescuento = 0,
            stock = 1,
            descripcion = "BMW Serie 3 320d 140kW (190CV) Touring 5p"
        ),
        CocheMock(
            fabricante = "Mercedes",
            modelo = "Clase A",
            año = 2021,
            precio = 38200f,
            porcentajeDescuento = 0,
            stock = 1,
            descripcion = "Mercedes-Benz Clase A A 200d 7G-DCT 5p"
        ),
        CocheMock(
            fabricante = "Audi",
            modelo = "e-tron",
            año = 2022,
            precio = 87310f,
            porcentajeDescuento = 10,
            stock = 1,
            descripcion = "Audi e-tron 55 quattro 265kW (360CV) Advanced edition 5p"
        ),
        CocheMock(
            fabricante = "BMW",
            modelo = "Serie 5",
            año = 2023,
            precio = 60000f,
            porcentajeDescuento = 20,
            stock = 1,
            descripcion = "BMW Serie 5 520d 140kW (190CV) Touring 5p"
        ),
        CocheMock(
            fabricante = "Mercedes",
            modelo = "Clase G",
            año = 2020,
            precio = 148225f,
            porcentajeDescuento = 0,
            stock = 1,
            descripcion = "Mercedes-Benz Clase G G 350d 4Matic 180kW (245CV) 5p"
        ),
        CocheMock(
            fabricante = "Volkswagen",
            modelo = "Tiguan",
            año = 2021,
            precio = 39000f,
            porcentajeDescuento = 0,
            stock = 5,
            descripcion = "Volkswagen Tiguan 2.0 TDI 110kW (150CV) 4Motion DSG 5p"
        ),
        CocheMock(
            fabricante = "Ford",
            modelo = "Kuga",
            año = 2022,
            precio = 38250f,
            porcentajeDescuento = 0,
            stock = 3,
            descripcion = "Ford Kuga 1.5 EcoBoost 110kW (150CV) ST-Line 5p"
        ),
        CocheMock(
            fabricante = "Audi",
            modelo = "Q3",
            año = 2023,
            precio = 43270f,
            porcentajeDescuento = 0,
            stock = 2,
            descripcion = "Audi Q3 35 TFSI 110kW (150CV) S tronic 5p"
        ),
        CocheMock(
            fabricante = "Ford",
            modelo = "Mondeo",
            año = 2021,
            precio = 32000f,
            porcentajeDescuento = 10,
            stock = 4,
            descripcion = "Ford Mondeo 2.0 TDCi 110kW (150CV) Titanium 5p."
        )
    )

    fun get(): MutableList<CocheMock> {
        return coches
    }

    fun get(modelo: String): CocheMock? {
        return coches.find { it.modelo == modelo }
    }


}