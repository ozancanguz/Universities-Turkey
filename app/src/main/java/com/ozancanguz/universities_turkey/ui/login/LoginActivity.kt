package com.ozancanguz.universities_turkey.ui.login


import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ozancanguz.universities_turkey.MainActivity
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = Firebase.auth


        // user sign up
        register()

        // user login
        login()


        // current user
        val currentUser=auth.currentUser
        if(currentUser!=null){
            binding.pbar.visibility=View.VISIBLE
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            binding.pbar.visibility=View.INVISIBLE
        }





    }

    private fun login() {
        binding.signInBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()
            binding.pbar.visibility= View.VISIBLE
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,"E-mail or password empty",Toast.LENGTH_LONG).show()
                binding.pbar.visibility= View.INVISIBLE
            } else {

                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

                    val intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    binding.pbar.visibility= View.INVISIBLE

                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }


            }
        }
    }

    private fun register() {
        binding.registerBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()
            binding.pbar.visibility= View.VISIBLE

            if (email.isEmpty() || password.isEmpty()) {
             Toast.makeText(this,"E-mail or password empty",Toast.LENGTH_LONG).show()
                binding.pbar.visibility= View.INVISIBLE
            } else {

                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                    val intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    binding.pbar.visibility= View.INVISIBLE

                }.addOnFailureListener {
                    binding.pbar.visibility= View.INVISIBLE
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}