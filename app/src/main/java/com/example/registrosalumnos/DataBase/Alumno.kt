package com.example.registrosalumnos.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumnos")
data class Alumno(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val apellido: String,
    var curso: String
)
