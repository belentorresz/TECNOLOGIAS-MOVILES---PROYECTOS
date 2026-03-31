package com.example.seguimiento2

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar

class DrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        drawerLayout.openDrawer(Gravity.LEFT)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    val intent = Intent(this, LoadingActivity::class.java)
                    intent.putExtra("destino", "inicio")
                    startActivity(intent)
                }

                R.id.nav_segunda -> {
                    val intent = Intent(this, LoadingActivity::class.java)
                    intent.putExtra("destino", "segunda")
                    startActivity(intent)
                }

                R.id.nav_conversion -> {
                    val intent = Intent(this, LoadingActivity::class.java)
                    intent.putExtra("destino", "conversion")
                    startActivity(intent)
                }
            }

            drawerLayout.closeDrawer(Gravity.LEFT)
            true
        }

    }
}