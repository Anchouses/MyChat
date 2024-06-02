package com.silaeva.mychat.ui.sign_in

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.silaeva.mychat.AUTH
import com.silaeva.mychat.CHILD_ID
import com.silaeva.mychat.CHILD_PHONE
import com.silaeva.mychat.CHILD_USERNAME
import com.silaeva.mychat.MainActivity
import com.silaeva.mychat.NODE_USERS
import com.silaeva.mychat.R
import com.silaeva.mychat.REF_DATABASE_ROOT
import com.silaeva.mychat.initFirebase

class SignInActivity : ComponentActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        initFirebase()
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    firebaseAuthWithGoogle(account.idToken!!)
                }
            } catch (e: ApiException) {
                Log.d("MyLog", "Api exception")
            }
        }
//        checkAuthState()
        setContent {
            Button(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                onClick = { signInWithGoogle() }) {
                Text(text = "Google SignIn")
            }
        }
    }

    private fun getClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(this, gso)
    }

    private fun signInWithGoogle() {
        val singInClient = getClient()
        launcher.launch(singInClient.signInIntent)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("MyLog", "Google singIn done")
//                checkAuthState()
                val uid = AUTH.currentUser?.uid.toString()
                val dataMap: MutableMap<String, Any> = mutableMapOf<String, Any>()
                dataMap[CHILD_ID] = uid
                dataMap[CHILD_PHONE] = "phoneNumber"
                dataMap[CHILD_USERNAME] = uid

                REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dataMap).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                    } else {
                        Log.d("MyLog", "something wrong")
                    }
                }
            } else {
                Log.d("MyLog", "Google singIn error")
            }
        }
    }

//    private fun checkAuthState() {
//        if (auth.currentUser != null) {
//            val i = Intent(this, MainActivity::class.java)
//            startActivity(i)
//        }
//    }
}

@Composable
fun SignIn() {
    Button(
        onClick = { }) {
        Text(text = "Google SignIn")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignIn()
}