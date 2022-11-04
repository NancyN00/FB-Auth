package com.example.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var etmail: EditText
    private lateinit var etpass: EditText
    private lateinit var btncreate: Button

    private lateinit var cresign: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etmail = findViewById(R.id.edtemail)
        etpass = findViewById(R.id.edtpassword)
        btncreate = findViewById(R.id.btncre)
        cresign = findViewById(R.id.btnsign)

        auth = Firebase.auth

        cresign.setOnClickListener {

            var  i = Intent(this, LoginActivity::class.java)
            startActivity(i)

        }

        btncreate.setOnClickListener {

            var useremail = etmail.text.toString().trim()
            var userpassword = etpass.text.toString().trim()

            auth.createUserWithEmailAndPassword(useremail, userpassword).addOnCompleteListener {
                if (it.isSuccessful) {

                    Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                    Log.d("Succ--->", it.toString())

                } else {

                    Toast.makeText(this, "Failed, try again!", Toast.LENGTH_LONG).show()
                    Log.d("Failed--->", it.toString())


                }
            }

        }

    }
}