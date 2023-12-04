package ui.features

class RecetaUiState(
    val id: Int,
    var prioridad : Int,
    val cookingTime: Int,
    val recipeName: String,
    var recipePicture: String?,
    val chefName: String,
    val chefMail: String,
    var chefPicture: String?
) {

    override fun toString(): String {
        return "RecetaUiState(id=$id, prioridad=$prioridad, cookingTime=$cookingTime," +
                " recipeName='$recipeName', recipePicture=$recipePicture," +
                " chefName='$chefName', chefMail='$chefMail', chefPicture=$chefPicture)"
    }
}