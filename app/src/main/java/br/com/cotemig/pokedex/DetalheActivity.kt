package br.com.cotemig.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalheActivity : AppCompatActivity() {
    var pokemon: PokemonModel = PokemonModel()
    lateinit var tvNome: TextView
    lateinit var tvAltura: TextView
    lateinit var tvPeso: TextView
    lateinit var ivPokemon: ImageView
    lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        var name = intent.getStringExtra("name")


        if (name != null) {
            get(name)
        }
        tvNome = findViewById<TextView>(R.id.tvNome)
        tvNome.text = name.toString().toUpperCase()
        tvInfo = findViewById<TextView>(R.id.tvInfo1)
        ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
        tvAltura = findViewById<TextView>(R.id.tvAltura)
        tvPeso = findViewById<TextView>(R.id.tvPeso)
        //Implementar o metodo get para buscar os dados do pokemon e preencher os dados na tela

    }
    fun get(name: String) {
        var instace = RetrofitUtill.getInstance("https://api-brkshm5xha-uc.a.run.app/")
        var endpoint = instace.create(PokemonEndpoint::class.java)

        var contexto = this

        endpoint.getById(name).enqueue(object : Callback<PokemonModel> {
            override fun onResponse(
                call: Call<PokemonModel>,
                response: Response<PokemonModel>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        pokemon = response?.body()!!


                        tvNome.setText(pokemon.name)
                        tvPeso.setText(pokemon.weight)
                        tvAltura.setText(pokemon.height)
                       //tvInfo.setText(pokemon.abilities)
                        Glide
                            .with(contexto)
                            .load(pokemon.url)
                            .into(ivPokemon)
                    }
                }
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                Toast.makeText(contexto, "Erro na chamada", Toast.LENGTH_SHORT).show()
            }

        })
    }
}