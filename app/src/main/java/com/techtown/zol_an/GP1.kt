package com.techtown.zol_an

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.widget.Toast
import androidx.core.graphics.toColor
import kotlinx.android.synthetic.main.gp1.*

import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Gp1: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gp1)

        if (App.prefs.setColor)
            textView.setTextColor(Color.parseColor(App.prefs.backColor))

        button3.setOnClickListener{
            val nextIntent= Intent(this, Gp3::class.java)
            startActivityForResult(nextIntent,1)
        }
        button2.setOnClickListener{
            val nextIntent= Intent(this, Gp2::class.java)
            startActivityForResult(nextIntent,2)
        }
        button4.setOnClickListener{
            val nextIntent= Intent(this, Gp4::class.java)
            startActivityForResult(nextIntent,4)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && App.prefs.setText) {
                textView.setText(data?.getStringExtra("Text"))
            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK && App.prefs.setColor) {
                App.prefs.backColor = data?.getStringExtra("color")!!
                textView.setTextColor(Color.parseColor(App.prefs.backColor))
            }
        } else if (requestCode == 4) {
            if(resultCode == Activity.RESULT_OK) {
                if(App.prefs.setColor) {
                    textView.setTextColor(Color.parseColor(App.prefs.backColor))
                }
                else {
                    textView.setTextColor(Color.parseColor("#000000"))
                }
            }
        }
    }
}