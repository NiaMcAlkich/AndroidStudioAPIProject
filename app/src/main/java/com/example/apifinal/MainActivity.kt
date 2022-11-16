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

        val sharedPref = getSharedPreferences("API Counter", Context.MODE_PRIVATE)
        val default = 0
        var apiCount = sharedPref.getInt("API Counter", default)


        with (sharedPref.edit()) {
            putInt("API Counter", apiCount)
            apply()
        }

        Toast.makeText(this, "The API was called " + apiCount + " times!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "This counts the calls");

        textView = findViewById(R.id.textView)

        //on clicking this button function to get the coordinates will be called
        val yesButton = findViewById<Button>(R.id.yesButton)
        val noButton = findViewById<Button>(R.id.noButton)

        yesButton.setOnClickListener {
            //function to find the coordinates of the last location
            textView = findViewById(R.id.jokeView)
            getJoke()
        }

        noButton.setOnClickListener {
            //function to find the coordinates of the last location
            textView = findViewById(R.id.papyrus)
        }

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

                //Here is where it will count the calls to the API
                apiCount += 1

                //This is the parsed esponse
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
