package com.belen.basededatos.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articulos")
data class Articulo(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val descripcion: String,
    val precio: Double
)