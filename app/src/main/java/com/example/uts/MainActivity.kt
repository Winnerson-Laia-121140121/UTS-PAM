package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

//      Inisialisasi UI components
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()


           if (isValidCredentials(email, password)) {

            } else {
                Peringatan("Invalid username or password")
            }
        }

        buttonRegister.setOnClickListener {
            val go = Intent(this@MainActivity, Register::class.java)
            startActivity(go)
        }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        return email == "admin" && password == "PAM2024"
    }

    private fun keRegister() {
        val intent = Intent(this@MainActivity, Register::class.java)
        startActivity(intent)
    }

    private fun Peringatan(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}