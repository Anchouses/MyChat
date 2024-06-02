package com.silaeva.mychat.ui.model

data class UserModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullName: String = "",
    var status: String = "",
    var phone: String = "",
    var photoUrl: String = ""
)