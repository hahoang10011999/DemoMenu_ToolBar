package com.example.demomenu_toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_demo_drawer_layout.*
import kotlinx.android.synthetic.main.content_drawerlayout.*

class DemoDrawerLayout : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_drawer_layout)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.open,R.string.close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_main ->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_design ->{
                val intent = Intent(this,DesignToolBar::class.java)
                startActivity(intent)
            }
            R.id.nav_hiden ->{
                val intent = Intent(this,HidenActionBar::class.java)
                startActivity(intent)
            }
            R.id.item1 -> Toast.makeText(this,"This is item 1", Toast.LENGTH_LONG).show()
            R.id.item2 -> Toast.makeText(this,"This is item 2", Toast.LENGTH_LONG).show()
            R.id.item3 -> Toast.makeText(this,"This is item 3", Toast.LENGTH_LONG).show()
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}