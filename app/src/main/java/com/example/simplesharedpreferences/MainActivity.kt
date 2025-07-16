package com.example.simplesharedpreferences

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplesharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mySharedPref: MySharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPref = MySharedPref(this)

        val savedName = mySharedPref.getString("user_name","No name found")
        binding.textViewResult.text = "Stored Name: $savedName"

        binding.buttonSave.setOnClickListener {
            val userName = binding.editTextName.text.toString()
            mySharedPref.saveString("user_name",userName)

            binding.textViewResult.text = "Stored Name: $userName"
            Toast.makeText(this,"Name Save Successfully!",Toast.LENGTH_SHORT).show()
        }

    }
}