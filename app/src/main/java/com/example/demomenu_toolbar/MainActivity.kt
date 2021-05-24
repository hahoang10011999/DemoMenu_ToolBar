package com.example.demomenu_toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNoActionBar.setOnClickListener {
            val intent = Intent(this,HidenActionBar::class.java)
            startActivity(intent)
        }
        var actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        btnChangeTitle.setOnClickListener {
            if (actionBar != null) {
                actionBar.title = "This is main activity"
            }
        }
        btnSetIcon.setOnClickListener {
            if (actionBar != null) {
                actionBar.setDisplayShowHomeEnabled(true)
                actionBar.setLogo(R.drawable.logo)
                actionBar.setDisplayUseLogoEnabled(true)
            }
        }
        btnToolbar.setOnClickListener {
            val intent = Intent(this,DesignToolBar::class.java)
            startActivity(intent)
        }
        popupMenu.setOnClickListener {
            showPopup()
        }
        btnDemo.setOnClickListener {
            val intent = Intent(this,DemoDrawerLayout::class.java)
            startActivity(intent)
        }
        registerForContextMenu(btnContextMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this,"This is item 1",Toast.LENGTH_LONG).show()
            R.id.item2 -> Toast.makeText(this,"This is item 2",Toast.LENGTH_LONG).show()
            R.id.item3 -> Toast.makeText(this,"This is item 3",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)
        if (menu != null) {
            menu.setHeaderTitle("Choose item")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this,"This is item 1",Toast.LENGTH_LONG).show()
            R.id.item2 -> Toast.makeText(this,"This is item 2",Toast.LENGTH_LONG).show()
            R.id.item3 -> Toast.makeText(this,"This is item 3",Toast.LENGTH_LONG).show()
        }
        return super.onContextItemSelected(item)
    }
    fun showPopup(){
        var popup = PopupMenu(this,popupMenu)
        popup.menuInflater.inflate(R.menu.context_menu,popup.menu)
        popup.setOnMenuItemClickListener {
             when(it.itemId){
                 R.id.item1 -> Toast.makeText(this,"This is item 1",Toast.LENGTH_LONG).show()
                 R.id.item2 -> Toast.makeText(this,"This is item 2",Toast.LENGTH_LONG).show()
                 R.id.item3 -> Toast.makeText(this,"This is item 3",Toast.LENGTH_LONG).show()
             }
            true
        }
        popup.show()
    }
}