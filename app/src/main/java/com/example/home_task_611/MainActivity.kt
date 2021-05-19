package com.example.home_task_611

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var txt: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent.getStringExtra(MainActivity2.KEY) != null) {
            txt = intent.getStringExtra(MainActivity2.KEY).toString()
            init(txt)
        } else init("")
    }

    private fun init(txt: String) {
        txt_view1.text = txt
        btn1.setOnClickListener {
            if (edt_txt1.text.isEmpty())
                Toast.makeText(applicationContext, "WRITE SOMETHING!!!", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra(MainActivity2.KEY, edt_txt1.text.toString())
                }
                startActivity(intent)
                finish()
            }
        }
    }
}