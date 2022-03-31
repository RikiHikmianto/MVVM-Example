package co.id.rikihikmianto.mvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.id.rikihikmianto.mvvm.R

class UnicornAdapter(private val listUnicorn: List<String>) :
    RecyclerView.Adapter<UnicornAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem = view.findViewById<TextView>(R.id.tvList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnicornAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UnicornAdapter.ViewHolder, position: Int) {
        holder.tvItem.text = listUnicorn[position]
    }

    override fun getItemCount(): Int {
        return listUnicorn.size
    }
}
