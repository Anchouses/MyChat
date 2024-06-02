package com.silaeva.mychat.ui.chat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.silaeva.mychat.ui.model.UserModel
import kotlinx.coroutines.flow.MutableStateFlow

class ChatViewModel() : ViewModel() {

    private val database =
        Firebase.database("https://mychat-fde6b-default-rtdb.europe-west1.firebasedatabase.app")
    private val myRef = database.getReference("messages")
    val text = MutableStateFlow("")

    val msgList: MutableState<List<UserModel>> = mutableStateOf(listOf())

    private val auth = Firebase.auth

    fun setOwnerMsg(msg: String) {
        myRef.child(myRef.push().key ?: "").setValue(UserModel(1, auth.currentUser?.displayName, msg))
        getMsg(myRef)
    }

    private fun getMsg(dbRef: DatabaseReference) {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (item in snapshot.children) {
                    val userModel = item.getValue(UserModel::class.java)
                    if (userModel != null) {
//                        msgList.add(user)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun getName(): String? {
        return auth.currentUser?.displayName
    }

    fun signOut() {
        auth.signOut()
    }
}

