package com.example.applicationgastos.ui.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationgastos.R

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val images = intArrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_money,
        R.drawable.ic_menu_slideshow,
        R.drawable.ic_menu_camera
    )

    val titles = arrayOf(
        "tit ejemplo 1",
        "tit ejemplo 2",
        "tit ejemplo 3",
        "tit ejemplo 4")

    val details = arrayOf(
        "det ejemplo 1",
        "det ejemplo 2",
        "det ejemplo 3",
        "det ejemplo 4")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder,i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemTitle.text=titles[i]
        viewHolder.itemDetail.text= details[i]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    //Referencias para los elementos individuales
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }
}