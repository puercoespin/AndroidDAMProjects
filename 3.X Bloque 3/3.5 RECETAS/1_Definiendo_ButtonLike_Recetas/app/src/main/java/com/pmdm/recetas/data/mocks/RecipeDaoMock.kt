package arquitectura_usuario.data.mocks


class RecipeDaoMock {
    private var recipe =
        RecipeMock(
            name = "",
            description = "",
            chef = "",
            photo = null,
            likes = 8,
            isLiked = false
        )

    fun get():RecipeMock=recipe
    fun updateRecipe(recipeRemoto:RecipeMock){
        recipe=recipeRemoto
    }

}
