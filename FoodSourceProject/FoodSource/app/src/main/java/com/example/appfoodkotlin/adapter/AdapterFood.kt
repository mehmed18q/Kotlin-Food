package com.example.foodkotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfoodkotlin.R
import com.example.appfoodkotlin.activity.DetailActivity
import com.example.appfoodkotlin.model.Food
import com.example.foodkotlin.App.*
import com.squareup.picasso.Picasso

class AdapterFood(val context: Context, var listFood: ArrayList<Food>) :
    RecyclerView.Adapter<AdapterFood.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFood.Holder {
        val layout = LayoutInflater.from(context).inflate(R.layout.food_layout, parent, false)
        return Holder(layout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val food = listFood.get(position)
        holder.txtNameFood.text = food.nameFood
        holder.txtDescription.text = food.description
        Picasso.get().load(food.image).into(holder.imageView)

        var category: String = ""

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
//luncher    dinner   cake
            if (food.category.equals("brunch")) {
                category = "صبحانه"
            } else if (food.category.equals("cake")) {
                category = "کیک و بستنی"
            } else if (food.category.equals("dinner")) {
                category = "شام"
            } else if (food.category.equals("luncher")) {
                category = "ناهار"
            }

            intent.putExtra(keyName, food.nameFood)
            intent.putExtra(keyCategory, category)
            intent.putExtra(key_description, food.description)
            intent.putExtra(key_raw_mat, food.rawMat)
            intent.putExtra(key_type_raw_mat, food.typeRawMat)
            intent.putExtra(key_image, food.image)
            intent.putExtra(key_id, food.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNameFood = itemView.findViewById<TextView>(R.id.txt_name_food)
        val txtDescription = itemView.findViewById<TextView>(R.id.txt_description_food)
        val imageView = itemView.findViewById<ImageView>(R.id.image_food)
    }


}