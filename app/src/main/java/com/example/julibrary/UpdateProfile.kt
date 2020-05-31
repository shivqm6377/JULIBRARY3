package com.example.julibrary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_update_profile.*

class UpdateProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
        val actionbar=supportActionBar
        actionbar!!.title="Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val text2=findViewById<EditText>(R.id.text2)
        val text3=findViewById<EditText>(R.id.text3)
        val text4=findViewById<EditText>(R.id.text4)
        val text5=findViewById<EditText>(R.id.text5)
        val text6=findViewById<EditText>(R.id.text6)
        val text7=findViewById<EditText>(R.id.text7)
        val btn=findViewById<Button>(R.id.btn)

        val sharedPreferences= getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        btn.setOnClickListener {
            val name=text2.text.toString().trim()
            val Userid=text3.text.toString().trim()
            val email=text4.text.toString().trim()
            val category=text5.text.toString().trim()
            val gender=text6.text.toString().trim()
            val mobile=text7.text.toString().trim()

            val editor=sharedPreferences.edit()
            editor.putString("Name",name)
            editor.putString("UserID",Userid)
            editor.putString("Email",email)
            editor.putString("Category",category)
            editor.putString("Gender",gender)
            editor.putString("Mobile",mobile)

            editor.apply()



        }
        showInfoBtn.setOnClickListener{
            val name=sharedPreferences.getString("Name","")
            val Userid=sharedPreferences.getString("UserID","")
            val email=sharedPreferences.getString("Email","")
            val category=sharedPreferences.getString("Category","")
            val gender=sharedPreferences.getString("Gender","")
            val mobile=sharedPreferences.getString("Mobile","")

            val intent= Intent(this@UpdateProfile,Profile::class.java)
            intent.putExtra("Name",name)
            intent.putExtra("UserID",Userid)
            intent.putExtra("Email",email)
            intent.putExtra("Category",category)
            intent.putExtra("Gender",gender)
            intent.putExtra("Mobile",mobile)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}


