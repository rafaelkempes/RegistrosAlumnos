package com.example.registrosalumnos

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus :AppCompatActivity(){
    companion object {
        var actividadactual=0
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.menu,menu)

        if (menu != null) {
            for (i in 0 until menu.size()){
                if (i== actividadactual)menu.getItem(i).isEnabled =false
                else menu.getItem(i).isEnabled=true
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.añadir ->{
                val intent =Intent(this,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                actividadactual=0
                startActivities(arrayOf(intent))
                true
            }
            R.id.Actualizar ->{
                val intent =Intent(this,UpdateActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                actividadactual=1
                startActivities(arrayOf(intent))
                true
            }
            R.id.Eliminar ->{
                val intent =Intent(this,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                actividadactual=0
                startActivities(arrayOf(intent))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}