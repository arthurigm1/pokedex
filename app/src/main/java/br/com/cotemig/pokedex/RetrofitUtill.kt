package br.com.cotemig.pokedex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtill {
companion object {
    fun getInstance(path: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
}