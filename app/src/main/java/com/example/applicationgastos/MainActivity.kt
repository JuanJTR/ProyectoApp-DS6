package com.example.applicationgastos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationgastos.databinding.ActivityMainBinding
import com.example.applicationgastos.ui.CloseFragment
import com.example.applicationgastos.ui.Home.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        /*binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

                **ESTO VA EN EL APP_BAR_MAIN.XML, EN LA LINEA 25
                    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_marginEnd="@dimen/fab_margin"
        android:layout_marginBottom="16dp"
        app:backgroundTint="#673AB7"
        app:srcCompat="@drawable/ic_add" />

        }*/

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        //opciones de barra de menu lateral
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery,R.id.nav_comida ,R.id.nav_slideshow,R.id.nav_alimentos,R.id.nav_pagos,R.id.nav_salud,R.id.nav_transporte,R.id.nav_otros
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true//indica que cosumiremos el recurso
    }

    //conecta el option menubar , con el CloseFargment
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.settings -> {
                goToSettings()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToSettings(){
        val intent = Intent(this,CloseFragment::class.java)
        startActivity(intent)//accion
    }*/

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    <TableLayout
//    android:id="@+id/tableLayout"
//    android:layout_marginTop="5dp"
//    android:layout_gravity="center"
//    android:gravity="center"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"/>
//
//    private fun setupTable(){
//        val tableRow0 = TableRow(requireContext())
//        tableRow0.setBackgroundResource(R.color.gray)
//        //Crear Headers para la tabla
//        val textView0 = TextView(requireContext())
//        textView0.text=" Mes "
//        textView0.setTextColor(Color.BLACK)
//        //agregar textView a la fila de la tabla:
//        tableRow0.addView(textView0)
//        val textView1 = TextView(requireContext())
//        textView1.text=" Cantidad de Ventas "
//        textView1.setTextColor(Color.BLACK)
//        //agregar textView a la fila de la tabla:
//        tableRow0.addView(textView1)
//        //Agregar fila al tableLayout
//        binding.tableLayout.addView(tableRow0)
//
//        for (i in 1..5){
//            val tblRow = TableRow(requireContext())
//            val tv0 = TextView(requireContext())
//            tv0.text="Mes $i "
//            tv0.gravity=Gravity.CENTER
//            tblRow.addView(tv0)
//
//            val tv1 = TextView(requireContext())
//            tv1.text=" ${i*10} "
//            tv1.gravity=Gravity.CENTER
//            tblRow.addView(tv1)
//            binding.tableLayout.addView(tblRow)
//        }
//
//    }

}

