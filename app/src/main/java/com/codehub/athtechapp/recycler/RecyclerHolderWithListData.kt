package com.codehub.athtechapp.recycler

import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codehub.athtechapp.R

class RecyclerHolderWithListData(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: ListData, listener: OnItemClickListener) {
        var textView = itemView.findViewById<TextView>(R.id.holder_text)
        textView.setText(data.value1 + System.lineSeparator() + data.value2)

        itemView.findViewById<LinearLayout>(R.id.holder_container)
            .setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Log.d("Holder", "User pressed the Row with data " + data)
                    listener.onClick(data)
                }
            })
    }
}