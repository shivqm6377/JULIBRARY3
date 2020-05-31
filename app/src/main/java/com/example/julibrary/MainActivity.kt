package com.example.julibrary

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = findViewById(R.id.drawerlayout)
        navView = findViewById(R.id.navview)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {

        }









    }





        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.nav_updateprofile -> {
                    startActivity(Intent(this, UpdateProfile::class.java))
                }
                R.id.nav_messages -> {
                    startActivity(Intent(this, Message::class.java))
                }
                R.id.nav_books -> {
                    startActivity(Intent(this, Category::class.java))
                }
                R.id.nav_contact -> {
                    startActivity(Intent(this, Contact::class.java))
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, Settings::class.java))
                }
                R.id.logout_btn->{
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this,LoginActivity::class.java))
                }



            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return true
        }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mys_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.love)
        {
            val builder= AlertDialog.Builder(this)
            builder.setTitle("Rating")
            builder.setIcon(R.drawable.ic_favorite)
            builder.setMessage("Liked...")
            builder.setPositiveButton("ok",null)
            val dialog: AlertDialog =builder.create()
            dialog.show()
        }
        if(item.itemId==R.id.share)
        {
            val builder= AlertDialog.Builder(this)
            builder.setTitle("Share")
            builder.setIcon(R.drawable.ic_share)
            builder.setMessage("Share To Friends...")
            builder.setPositiveButton("ok",null)
            val dialog: AlertDialog =builder.create()
            dialog.show()
        }
        return super.onOptionsItemSelected(item)
    }

}


