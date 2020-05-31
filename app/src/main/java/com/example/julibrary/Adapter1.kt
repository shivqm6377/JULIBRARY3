package com.example.julibrary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class Adapter1(val arrayList: ArrayList<Model1>,val context: Context): RecyclerView.Adapter<Adapter1.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model1: Model1) {
            itemView.titletv.text = model1.title
            itemView.descriptiontv.text = model1.des
            itemView.imageiv.setImageResource(model1.image)


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter1.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {

            if (position == 0) {



            }


            if (position == 1) {

            }
            if (position == 2) {

            }
            if (position == 3) {

            }
            if (position == 4) {


            }
            if (position == 5) {

            }
            if (position == 6) {

            }
            if (position == 7) {

            }
            if (position == 8) {

            }
            if (position == 9) {

            }
            if (position == 10) {

            }
            if (position == 11) {

            }
            if (position == 12) {

            }
            if (position == 13) {

            }
            if (position == 14) {

            }
            if (position == 15) {

            }
            if (position == 16) {

            }
            if (position == 17) {

            }
            if (position == 18) {

            }
            if (position == 19) {

            }
            if (position == 20) {

            }
            val model1 =arrayList.get(position)

            var gTitle:String=model1.title
            var gDescription:String=model1.des
            var gImage:Int=model1.image


            val intent=Intent (context,IssueActivity::class.java)
            intent.putExtra("iTitle",gTitle)
            intent.putExtra("iDescription",gDescription)
            intent.putExtra("iImage",gImage)
            context.startActivity(intent)



        }
    }
}