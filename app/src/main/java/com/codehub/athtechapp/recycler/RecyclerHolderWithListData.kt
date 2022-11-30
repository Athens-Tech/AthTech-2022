package com.codehub.athtechapp.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codehub.athtechapp.R

class RecyclerHolderWithListData(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: ListData) {
        var textView = itemView.findViewById<TextView>(R.id.holder_text)
        textView.setText(data.value1 + System.lineSeparator() + data.value2)
    }
}