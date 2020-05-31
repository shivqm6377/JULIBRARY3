package com.example.julibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_issue.*
import kotlinx.android.synthetic.main.nav_header.*

class IssueActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue)
        val actionbar=supportActionBar
        actionbar!!.title="JU LIBRARY"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        var intent =intent
        val aTitle=intent.getStringExtra("iTitle")
        val aDescrption=intent.getStringExtra("iDescrption")
        val aImage=intent.getIntExtra("iImage",0)

        actionbar.setTitle(aTitle)
        atitle.text=aTitle
        adescription.text=aDescrption
        aimageview.setImageResource(aImage)


        issue.setOnClickListener {

            val builder= AlertDialog.Builder(this)
            builder.setTitle("Done")
            builder.setIcon(R.drawable.ic_action_check)
            builder.setMessage("Your Book Is Issue...")
            builder.setPositiveButton("ok",null)
            val dialog:AlertDialog=builder.create()
            dialog.show()


        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.backtomenu)
        {
            startActivity(Intent(this,Category::class.java))
        }
        if(item.itemId==R.id.cancelissue)
        {
            val builder= AlertDialog.Builder(this)
            builder.setTitle("Cancel")
            builder.setIcon(R.drawable.ic_cancel)
            builder.setMessage("Your Book Is Cancelled...")
            builder.setPositiveButton("ok",null)
            val dialog:AlertDialog=builder.create()
            dialog.show()


        }
        return super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}
