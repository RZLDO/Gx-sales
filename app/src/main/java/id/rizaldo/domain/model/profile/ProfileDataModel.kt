package id.rizaldo.domain.model.profile

data class ProfileDataModel(
    val id : Int,
    val name : String,
    val email : String
){
    companion object{
        fun fakes() : ProfileDataModel{
            return ProfileDataModel(1,"","")
        }
    }
}