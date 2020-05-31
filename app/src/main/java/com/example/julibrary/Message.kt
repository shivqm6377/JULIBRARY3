package com.example.julibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Message : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        val actionbar=supportActionBar
        actionbar!!.title="Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}

