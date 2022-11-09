package com.example.apifinal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import android.R.id
import android.widget.Toast
import com.android.volley.*




class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        getJoke()

    }

    private fun getJoke() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val joke: String = "https://v2.jokeapi.dev/joke/Any?safe-mode/format=json&safe-mode&type=single"
        //val bookTitle: String = "https://openlibrary.org/isbn/9780140328721.json"
        //val url: String = "https://covers.openlibrary.org/b/isbn/9781405664387-L.jpg"

        // Request a string response from the provided URL.
        val stringReq = StringRequest(Request.Method.GET, joke,
            Response.Listener<String> { response ->

                //get the JSON object
                val obj = JSONObject(response)
                val parsedJoke = obj.getString("joke")

                //Ignore these they are from failed tries
                //get the object with the name - "joke"
                //val arr = obj.getJSONArray("joke")

                //get the JSON object from the array at index position 0
                //val obj2 = arr.getJSONObject(0)

                textView.text =
                    parsedJoke

            },
            //In case of any error
            Response.ErrorListener { textView!!.text = "API call didn't work or didn't parse!" })
        queue.add(stringReq)
    }
}