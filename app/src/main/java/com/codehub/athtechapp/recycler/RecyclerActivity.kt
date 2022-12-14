package com.codehub.athtechapp.recycler

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codehub.athtechapp.R
import com.codehub.athtechapp.json.JsonResponse
import com.codehub.athtechapp.storage.AsyncTaskClass
import com.google.gson.Gson

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        findViewById<Button>(R.id.recyclerView_btn).setOnClickListener {
            recyclerView.adapter = RecyclerAdapter(
                this, getArrayData()
            )
        }
    }

    private fun getArrayData(): List<String> {
        var array = mutableListOf<String>()
        (1..500).forEach {
            array.add(it.toString())
        }

        return array
    }

    override fun onPostResume() {
        super.onPostResume()

        val queue = Volley.newRequestQueue(this)
        val endpoint = "https://api.publicapis.org/entries"

        val stringRequest = StringRequest(endpoint,
            object : Response.Listener<String> {
                override fun onResponse(response: String?) {
                    val jsonResponse = Gson().fromJson(response, JsonResponse::class.java)

                    var dataList = mutableListOf<ListData>()
                    jsonResponse.entries.forEach {
                        var row = ListData(it.Description, it.HTTPS)
                        dataList.add(row)
                    }

                    var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerView.adapter = RecyclerAdapterWithListData(
                        this@RecyclerActivity,
                        dataList,
                        object : OnItemClickListener {
                            override fun onClick(data: ListData) {
                                Log.d("Activity-Holder", "We receive data from a holder " + data)
                            }

                        })
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    Log.e("API", error?.message ?: "")
                }

            })

        queue.add(stringRequest)
    }
}