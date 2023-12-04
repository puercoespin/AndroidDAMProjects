package data.mock

class RecetaDaoMock {
    private var recetas = mutableListOf<RecetaMock>(
        RecetaMock(
            id=1,
            cookingTime = 40,
            recipeName = "Magdalenas de la abuela",
            recipePicture = "imagen1.png",
            chefName = "Carlos Arguiñano",
            chefMail = "carlos.arguiñano@gmail.com",
            chefPicture = null
        ),
        RecetaMock(
            id=2,
            cookingTime = 120,
            recipeName = "Pan casero con tomates secos",
            recipePicture = "imagen2.png",
            chefName = "Carlos Arguiñano",
            chefMail = "carlos.arguiñano@gmail.com",
            chefPicture = null
        ),
        RecetaMock(
            id=3,
            cookingTime = 10,
            recipeName = "Ensalada multicolor con cacahuete",
            recipePicture = "imagen3.png",
            chefName = "Sonia de la Oz",
            chefMail = "soniaoz@gmail.com",
            chefPicture = null
        ),
        RecetaMock(
            id=4,
            cookingTime = 35,
            recipeName = "Caldo de almendras pasas y calabaza",
            recipePicture = "imagen4.png",
            chefName = "Mohamed Aldalay",
            chefMail = "mohaaldala@gmail.com",
            chefPicture = null
        ),
    )

    fun get() : MutableList<RecetaMock>
    {
        return recetas
    }

    fun get(id:Int):RecetaMock?{
        return recetas.find { it.id == id }
    }

    fun insert(recetaRemoto:RecetaMock)
    {
        recetas.add(recetaRemoto)
    }

    fun delete(id:Int)
    {
        recetas.removeIf{it.id == id}
    }


}