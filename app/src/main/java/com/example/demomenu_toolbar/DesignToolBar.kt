package com.example.demomenu_toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_design_tool_bar.*

class DesignToolBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_tool_bar)
        setSupportActionBar(toolbar)
        var toolbar = supportActionBar
        if (toolbar != null) {
            toolbar.setTitle("This is my toolbar")
        }
    }
}