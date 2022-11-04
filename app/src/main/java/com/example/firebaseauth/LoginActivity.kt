package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var entermail: EditText
    private lateinit var enterpassword: EditText
    private lateinit var butlog: Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        entermail = findViewById(R.id.tremail)
        enterpassword = findViewById(R.id.trepass)
        butlog = findViewById(R.id.btnbtnreg)

        //initialize the firebase
        auth = FirebaseAuth.getInstance()

        butlog.setOnClickListener {
            val email = entermail.text.toString().trim()
            val password = enterpassword.text.toString().trim()

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()

                    var i = Intent(this, Dashboard::class.java)
                    startActivity(i)
                    finish()

                } else {
                    Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
                }
            }

//            butlog.setOnClickListener {
//                var i = Intent(this, Dashboard::class.java)
//                startActivity(i)
//            }
        }
    }
}
