package data.models

class Receta(val id:Int,
             val cookingTime: Int,
             val recipeName: String,
             var recipePicture: String?,
             val chefName: String,
             val chefMail: String,
             var chefPicture: String?) {


}