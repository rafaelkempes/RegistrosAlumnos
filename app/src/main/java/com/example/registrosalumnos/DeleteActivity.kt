package com.example.registrosalumnos

import android.os.Bundle
import com.example.registrosalumnos.DataBase.Alumno
import com.example.registrosalumnos.DataBase.Instanciar
import com.example.registrosalumnos.databinding.ActivityDeleteBinding

class DeleteActivity : ActivityWithMenus() {
    private lateinit var instanciar: Instanciar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Delete.setOnClickListener {
            val alumnoDao = instanciar.getDatabase().alumnoDao()

            val nombre = binding.TDeleteNombre.text.toString()
            val apellidos=""
            val curso = binding.TDeletecurso.text.toString()

            val borrarAlumno = Alumno(nombre = nombre, apellido = apellidos,curso = curso)
            alumnoDao.delete(borrarAlumno)
        }
    }
}