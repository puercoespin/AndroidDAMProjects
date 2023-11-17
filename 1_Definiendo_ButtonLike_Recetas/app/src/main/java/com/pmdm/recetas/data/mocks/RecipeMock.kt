package arquitectura_usuario.data.mocks

data class RecipeMock(
    val name: String,

    val description: String,
    val chef : String,
    val photo:String?,
    val likes:Int,
    val isLiked : Boolean
)
