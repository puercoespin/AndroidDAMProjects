package arquitectura_usuario.data.mocks


class RecipeDaoMock {
    //solo tengo una receta
    private var recipe =
        RecipeMock(
            name = "Magdalenas de la abuela",
            description = "Fabulosas magdalenas con pepitas de chocolate y un suave sabor a naranja.",
            chef = "Carlos Arguiñano",
            photo = null,
            likes = 8,
            isLiked = false
        )

    fun get(): RecipeMock =recipe
    fun updateRecipe(recipeRemote:RecipeMock){
        recipe=recipeRemote
    }

}
