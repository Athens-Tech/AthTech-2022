package com.codehub.athtechapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codehub.athtechapp.json.JsonResponse
import com.google.gson.Gson

class ServerActivity : AppCompatActivity() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(this)
        val endpoint = "https://api.publicapis.org/entries"

        val stringRequest = StringRequest(endpoint,
            object : Response.Listener<String> {
                override fun onResponse(response: String?) {
                    val jsonResponse = Gson().fromJson(response, JsonResponse::class.java)
                    Log.d("API", response.toString())
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    Log.e("API", error?.message ?: "")
                }

            })

        queue.add(stringRequest)

    }
}