package com.codehub.athtechapp.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codehub.athtechapp.R

class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: String) {
        var textView = itemView.findViewById<TextView>(R.id.holder_text)
        textView.setText(data)
    }
}