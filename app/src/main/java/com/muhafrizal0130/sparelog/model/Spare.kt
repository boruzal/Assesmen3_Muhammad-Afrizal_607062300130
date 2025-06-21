package com.muhafrizal0130.sparelog.model

data class Spare(
    val id: String,
    val nama: String,
    val harga: String,
    val imageId: String,
    val userId:String,

) {
    companion object {
        val mine:Int = 0
    }
}
