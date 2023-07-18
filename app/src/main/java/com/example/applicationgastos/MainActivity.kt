package com.example.applicationgastos

import android.content.Context
import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.applicationgastos.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val PREFS_NAME = "MyPrefs"
    private val KEY_FIRST_RUN = "firstRun"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isFirstRun = prefs.getBoolean(KEY_FIRST_RUN, true)
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

        //Base de Datos
        val db = Room.databaseBuilder(
            this,
            DB::class.java, "BD"
        ).allowMainThreadQueries().build()

        lifecycleScope.launch {
            if (isFirstRun) {
                db.categoryDAO().insertAll(Category("Alimentos"))
                db.categoryDAO().insertAll(Category("Comida"))
                db.categoryDAO().insertAll(Category("Entretenimiento"))
                db.categoryDAO().insertAll(Category("Pagos & Cuentas"))
                db.categoryDAO().insertAll(Category("Ropa & Calzado"))
                db.categoryDAO().insertAll(Category("Salud"))
                db.categoryDAO().insertAll(Category("Transporte"))
                db.categoryDAO().insertAll(Category("Otros"))

                val editor = prefs.edit()
                editor.putBoolean(KEY_FIRST_RUN, false)
                editor.apply()
            }

            db.daoUser().insertAll(
                User(
                    "solisdonoso19", "Carlos Solis", "1234", 100.00
                )
            )
            val users = db.daoUser().getAll()
            for (i in users) {
                println("${i.userID},${i.name}, ${i.user}, ${i.password}, ${i.salary}")
            }

            val categories = db.categoryDAO().getAll()
            for (c in categories) {
                println("${c.categoryID}, ${c.category}")
            }

            db.gastosDAO().insertAll(Gastos(1, 100.00, "19/8/2023", "SuperMercado"))
            val gastos = db.gastosDAO().getGastos()
            for (g in gastos) {
                println("${g.gastos.monto}, ${g.gastos.fecha}, ${g.gastos.descripcion}, ${g.category}")
            }
        }
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

