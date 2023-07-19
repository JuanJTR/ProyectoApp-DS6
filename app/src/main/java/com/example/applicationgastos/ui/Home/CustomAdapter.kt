package com.example.applicationgastos.ui.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.applicationgastos.DB
import com.example.applicationgastos.R

class CustomAdapter (private val context: Context, private val database: DB): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val images = intArrayOf(
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank,
        R.drawable.ic_money_rank
    )

    val titles = database.gastosDAO().getCategoriaConMayorSuma()

    val details = database.categoryDAO().getAll()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder,i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemTitle.text=titles[i].nombre + ' ' + (i+1)
        viewHolder.itemDetail.text= titles[i].total.toString()
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