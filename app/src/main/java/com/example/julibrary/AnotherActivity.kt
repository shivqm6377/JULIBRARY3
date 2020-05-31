package com.example.julibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category.*
import java.util.*
import kotlin.collections.ArrayList

class AnotherActivity : AppCompatActivity() {
    val arrayList=ArrayList<Model1>()
    val displayList=ArrayList<Model1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        val actionbar=supportActionBar
        actionbar!!.title="JU LIBRARY"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        arrayList.add(Model1("Computer Networks", "ANNA University (IV-CSE, V-IT- 2013 course)",R.drawable.cs11))
        arrayList.add(Model1("object Oriented Analysis and Design", "B.Tech (III Year II Semester CSE & IT) & M.Tech Kakinada II Sem – CSE)",R.drawable.cs2))
        arrayList.add(Model1("Civil Engineering", "Conventional and Objective Type",R.drawable.cs3))
        arrayList.add(Model1("Mechanical Technology", "A Textbook of Thermal Engineering",R.drawable.cs4))
        arrayList.add(Model1("Programming in C & C++", "C & C++",R.drawable.cs5))
        arrayList.add(Model1("Fundamentals of Computer Algorithms", "Book by Ellis Horowitz and Sartaj Sahni",R.drawable.lo1))
        arrayList.add(Model1("Computer Networks: A Systems Approach", "Book by Bruce S. Davie and Larry L. Peterson",R.drawable.lo2))
        arrayList.add(Model1("The finite element method in engineering", "Book by S. S. Rao",R.drawable.lo3))
        arrayList.add(Model1("Advanced Structural Analysis", "Textbook by Devdas Menon",R.drawable.lo4))
        arrayList.add(Model1("Technical writing and professional communication", "Book by Thomas N Huckin",R.drawable.llo5))
        arrayList.add(Model1("Letters to a Law Student: A Guide to Studying Law at University", "Book by McBride Nicholas",R.drawable.lo6))
        arrayList.add(Model1("Learning the Law", "Book by Glanville Williams",R.drawable.lo7))
        arrayList.add(Model1("The Concept of Law", "Book by H. L. A. Hart",R.drawable.lo8))
        arrayList.add(Model1("The Common Law", "Book by Oliver Wendell Holmes Jr",R.drawable.lo))
        arrayList.add(Model1("Atiyah's Accidents, Compensation and the Law", "Book by Peter Cane",R.drawable.lo9))
        arrayList.add(Model1("Introduction to Agricultural Engineering Technology: A Problem Solving Approach", "Book by Harry L. Field and John Solie",R.drawable.cs13))
        arrayList.add(Model1("Agricultural Salinity Assessment", "Book",R.drawable.cs14))
        arrayList.add(Model1("Computer Vision-Based Agriculture Engineering", "Book by Han Zhongzhi",R.drawable.cs14))
        arrayList.add(Model1("Soil and water conservation engineering", "Book by Richard K. Frevert",R.drawable.cs15))
        arrayList.add(Model1("Agricultural Engineering and Feeding the ...", "Book by Anne Rooney",R.drawable.cs18))

        displayList.addAll(arrayList)

        val Adapter1=Adapter1(displayList,this)
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.adapter=Adapter1

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
