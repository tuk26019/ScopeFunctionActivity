package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

        Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray() : List<Int> = MutableList(10) { Random.nextInt() }.sorted()
}

    // Return true if average value in list is greater than median value, false otherwise
    private fun averageGreaterThanMedian(listOfNumbers: List<Double>): Boolean = listOfNumbers.sorted().let {
        it.average()< if (it.size % 2 == 0) (it[it.size/2] + it[(it.size-1)/2])/2 else it[it.size/2]
    }


    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View =
        (recycledView as? TextView) ?: run {
            TextView(context).apply {
                setPadding(5, 10, 10, 0)
                textSize = 22f
            }
        }.also {
            it.text = collection[position].toString()
        }
