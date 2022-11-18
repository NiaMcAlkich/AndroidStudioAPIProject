package com.example.apifinal

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var jokeView: TextView
    private lateinit var papyrusView: TextView
    private lateinit var refreshButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("API Counter", MODE_PRIVATE)
        val default = 0
        val apiCount = sharedPref.getInt("API Counter", default)


        with (sharedPref.edit()) {
            putInt("API Counter", apiCount)
            apply()
        }

        Toast.makeText(this, "The API was called $apiCount times!", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "This counts the calls")

        textView = findViewById(R.id.textView)

        yesButton = findViewById(R.id.yesButton)
        noButton = findViewById(R.id.noButton)

        yesButton.setOnClickListener{

            jokeView = findViewById(R.id.jokeView)
            getJoke(apiCount)
        }

        noButton.setOnClickListener {

            papyrusView = findViewById(R.id.papyrus)
        }


    }

    private fun getJoke(apiCount: Int) {
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

                //Here is where it will count the calls to the API
                apiCount + 1

                //This is the parsed response
                val parsedJoke = obj.getString("joke")

                //Ignore these they are from failed tries
                //get the object with the name - "joke"
                //val arr = obj.getJSONArray("joke")

                //get the JSON object from the array at index position 0
                //val obj2 = arr.getJSONObject(0)

                jokeView.text =
                    parsedJoke

            },
            //In case of any error
            Response.ErrorListener { jokeView.text = "API call didn't work or didn't parse!" })
        queue.add(stringReq)

        refreshButton = findViewById(R.id.refreshButton)

        refreshButton.setOnClickListener {
            getJoke(apiCount)
        }
    }

}
