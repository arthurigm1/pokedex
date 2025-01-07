package br.com.cotemig.pokedex

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PokemonEndpoint {
    @GET("pokemon")
    fun get(): Call<ArrayList<PokemonModel>>


    @GET("pokemon/{nome}")
    fun getById(@Path("nome")nome: String): Call<PokemonModel>
}