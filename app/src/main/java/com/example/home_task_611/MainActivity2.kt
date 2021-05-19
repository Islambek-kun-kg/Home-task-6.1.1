package com.example.home_task_611

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    private fun init() {
        txt_view2.text = intent.getStringExtra(KEY)
        btn2.setOnClickListener {
            if (edt_txt2.text.isEmpty())
                Toast.makeText(applicationContext, R.string.write_some, Toast.LENGTH_SHORT).show()
            else {
                setResult(Activity.RESULT_OK, Intent().putExtra(KEY, edt_txt2.text.toString()))
                finish()
            }
        }
    }

    companion object {
        const val KEY = "Key"
    }
}