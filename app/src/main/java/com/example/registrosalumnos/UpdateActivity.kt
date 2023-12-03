package com.example.registrosalumnos

import android.os.Bundle
import com.example.registrosalumnos.DataBase.Instanciar
import com.example.registrosalumnos.databinding.ActivityUpdateBinding

class UpdateActivity : ActivityWithMenus() {
    private lateinit var instanciar: Instanciar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.curso.setOnClickListener {

            val alumnoDao = instanciar.getDatabase().alumnoDao()

            // Asumiendo que tienes un EditText para el nuevo curso y un nombre de alumno
            val nuevoCurso = binding.Tnombreupdate.text.toString()
            val nombreAlumno = binding.tcursoupdate.text.toString()

            val alumno = alumnoDao.getAlumnoPorNombre(nombreAlumno)
            if (alumno != null) {
                alumno.curso = nuevoCurso
                alumnoDao.update(alumno)
            }
        }
    }
}