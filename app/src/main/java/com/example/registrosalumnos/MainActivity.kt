package com.example.registrosalumnos

import android.os.Bundle
import com.example.registrosalumnos.DataBase.Alumno
import com.example.registrosalumnos.DataBase.Instanciar

import com.example.registrosalumnos.databinding.ActivityMainBinding

class MainActivity : ActivityWithMenus() {
    private lateinit var instanciar: Instanciar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Agregar.setOnClickListener {

            instanciar = Instanciar.getInstance(applicationContext)

            val alumnoDao = instanciar.getDatabase().alumnoDao()


            val nombre = binding.Tnombre.text.toString()
            val apellido = binding.Tapellido.text.toString()
            val curso = binding.Tcurso.text.toString()

            val nuevoAlumno = Alumno(nombre = nombre, curso = curso)
            alumnoDao.insert(nuevoAlumno)
        }
    }
}

