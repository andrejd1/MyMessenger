package com.andrejd1.mymessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_editText_login.text.toString()
            val password = password_editText_login.text.toString()

            Log.d("LoginActivity", "Email/Password is: $email/$password")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (!it.isSuccessful) {
                    return@addOnCompleteListener
                }

                Log.d("Login", "Logged successfully!")
            }
                .addOnFailureListener {
                    Log.d("Main", "Failed to login user: ${it.message}")
                }
        }

        back_to_register_textView.setOnClickListener {
            finish()
        }
    }
}