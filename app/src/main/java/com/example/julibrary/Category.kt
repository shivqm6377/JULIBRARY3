package com.example.julibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category.*
import java.util.*
import kotlin.collections.ArrayList

class Category : AppCompatActivity() {
    val arrayList=ArrayList<Model>()
    val displayList=ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val actionbar=supportActionBar
        actionbar!!.title="JULIBRARY"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        arrayList.add(Model("B.TECH", "Bachelor Of Technology",R.drawable.btech))
        arrayList.add(Model("M.TECH", "Master Of Technology",R.drawable.mtech))
        arrayList.add(Model("LAW", "Bachelor Of Law Degree",R.drawable.law))
        arrayList.add(Model("Agriculture", "Bachelor Of Agriculture",R.drawable.agriculture))

        displayList.addAll(arrayList)

        val myAdapter=MyAdapter(displayList,this)
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.adapter=myAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val menuItem =menu!!.findItem(R.id.search)
        if(menuItem!=null){
            val searchView=menuItem.actionView as androidx.appcompat.widget.SearchView
            val editText=searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint="Search..."
            searchView.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        arrayList.forEach {
                            if (it.title.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        recyclerview.adapter!!.notifyDataSetChanged()
                    } else {
                             displayList.clear()
                        displayList.addAll(arrayList)
                        recyclerview.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }



}
