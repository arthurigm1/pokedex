package br.com.cotemig.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.graphics.component2
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
        getpokemon()
    }

    fun getpokemon() {
        var instace = RetrofitUtill.getInstance("https://api-brkshm5xha-uc.a.run.app/")
        var endpoint = instace.create(PokemonEndpoint::class.java)

        var contexto = this
        endpoint.get().enqueue(object : Callback<ArrayList<PokemonModel>> {
            override fun onResponse(
                call: Call<ArrayList<PokemonModel>>,
                response: Response<ArrayList<PokemonModel>>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        var retorno: ArrayList<PokemonModel> = response?.body()!!
                        var recyclerviw = findViewById<RecyclerView>(R.id.rvPokemon)
                        recyclerviw.adapter = PokemonAdapter(contexto, retorno)
                        recyclerviw.itemAnimator = DefaultItemAnimator()
                        recyclerviw.layoutManager = GridLayoutManager(contexto, 2)


                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<PokemonModel>>, t: Throwable) {
                Toast.makeText(contexto, "Erro na chamada", Toast.LENGTH_SHORT).show()
            }

        })

    }
}