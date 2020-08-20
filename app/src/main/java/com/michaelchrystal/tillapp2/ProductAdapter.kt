package com.michaelchrystal.tillapp2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

//class ProductAdapter : BaseAdapter() {}
class ProductAdapter(private val context: Context,
                     private val dataSource: ArrayList<Product>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_product, parent, false)

        // Get title element
        val quantityTextView = rowView.findViewById(R.id.list_entry_quantity) as TextView

// Get subtitle element
        val nameTextView = rowView.findViewById(R.id.list_entry_name) as TextView

// Get detail element
        val priceTextView = rowView.findViewById(R.id.list_entry_price) as TextView

// Get thumbnail element
//        val thumbnailImageView = rowView.findViewById(R.id.recipe_list_thumbnail) as ImageView

// 1
        val recipe = getItem(position) as Product

// 2
        quantityTextView.text = recipe.quantity.toString()
        nameTextView.text = recipe.productName
        priceTextView.text = recipe.price.toString()

// 3
        //Picasso.with(context).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)




        return rowView
    }

}









