package com.example.julibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val actionbar=supportActionBar
        actionbar!!.title="Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        var intent=intent
        val name=intent.getStringExtra("Name")
        val userID=intent.getStringExtra("UserID")
        val email=intent.getStringExtra("Email")
        val category=intent.getStringExtra("Category")
        val gender=intent.getStringExtra("Gender")
        val mobile=intent.getStringExtra("Mobile")

        val textView11=findViewById<TextView>(R.id.text11)
        textView11.text="Name:"+name+"\n UserID:"+userID+"\nEmail:"+email+"\nCategory:"+category+"\nGender:"+gender+"\nMobile:"+mobile
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}


