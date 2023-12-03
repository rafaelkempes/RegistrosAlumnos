package com.example.registrosalumnos.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlumnoDao {
    @Insert
    fun insert(alumno: Alumno)

    @Update
    fun update(alumno: Alumno)

    @Delete
    fun delete(alumno: Alumno)

    @Query("SELECT * FROM alumnos WHERE nombre = :nombre")
    fun getAlumnoPorNombre(nombre: String): Alumno?
}
