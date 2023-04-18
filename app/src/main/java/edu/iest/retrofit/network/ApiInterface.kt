package edu.iest.retrofit.network

import edu.iest.retrofit.models.ImageRandom
import edu.iest.retrofit.models.ListBreed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("breeds/image/random")
    fun imagenAleatoria(): Call<ImageRandom>

    @GET("breed/{raza}/images")
    fun listaImagenesDePerrosPorRaza(@Path("raza") raza: String): Call<ListBreed>
}