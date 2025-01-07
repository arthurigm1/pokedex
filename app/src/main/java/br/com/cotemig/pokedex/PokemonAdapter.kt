package br.com.cotemig.pokedex

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonAdapter(val contexto: Context, val lista: ArrayList<PokemonModel>) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.tvNome)
        val img = view.findViewById<ImageView>(R.id.ivPokemon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(contexto).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nome.text = lista[position].name
        Glide
            .with(contexto)
            .load(lista[position].url)
            .into(holder.img)

        holder.itemView.setOnClickListener {
            var newIntent = Intent(contexto, DetalheActivity::class.java)
            newIntent.putExtra("name", lista[position].name)
            contexto.startActivity(newIntent)
        }
    }
}