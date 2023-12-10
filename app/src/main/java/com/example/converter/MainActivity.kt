package com.example.kobinath.currency

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.converter.R

class MainActivity : AppCompatActivity() {
    var sp1: Spinner? = null
    var sp2: Spinner? = null
    var ed1: EditText? = null
    var b1: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp1 = findViewById<Spinner>(R.id.spfrom)
        sp2 = findViewById<Spinner>(R.id.spto)
        ed1 = findViewById<EditText>(R.id.txtamt)

        val from = arrayOf("USD")
        val ad: ArrayAdapter<*> =
            ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, from)
        sp1?.adapter = ad

        val to = arrayOf("Indian Rupees", "Sri Lankan Rupees")
        val ad1: ArrayAdapter<*> =
            ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, to)
        sp2?.adapter = ad1

        b1 = findViewById<Button>(R.id.btn1)
        b1?.setOnClickListener(View.OnClickListener {
            val tot: Double
            val amt = ed1?.text.toString().toDoubleOrNull()

            if (amt != null) {
                tot = when {
                    sp1?.selectedItem.toString() == "USD" && sp2?.selectedItem.toString() == "Indian Rupees" -> amt * 70.0
                    sp1?.selectedItem.toString() == "USD" && sp2?.selectedItem.toString() == "Sri Lankan Rupees" -> amt * 179.0
                    else -> 0.0
                }

                Toast.makeText(applicationContext, tot.toString(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Invalid amount", Toast.LENGTH_SHORT).show()
            }
        })
    }
}