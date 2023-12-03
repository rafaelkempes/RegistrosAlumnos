package com.example.registrosalumnos.DataBase

import android.content.Context
import androidx.room.Room


class Instanciar private constructor(context: Context) {

    private val database: DBAlumno = Room.databaseBuilder(
        context.applicationContext,
        DBAlumno::class.java, "mi-base-de-datos"
    ).build()

    fun getDatabase(): DBAlumno {
        return database
    }

    companion object {
        @Volatile
        private var INSTANCE: Instanciar? = null

        fun getInstance(context: Context): Instanciar {
            return INSTANCE ?: synchronized(this) {
                val instance = Instanciar(context)
                INSTANCE = instance
                instance
            }
        }
    }
}
