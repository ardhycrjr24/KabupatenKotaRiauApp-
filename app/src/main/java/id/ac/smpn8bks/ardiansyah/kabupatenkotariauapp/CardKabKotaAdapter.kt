package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp.databinding.ItemCardKabkotaBinding

class CardKabKotaAdapter(private val listKabKota: ArrayList<KabKota>) :
    RecyclerView.Adapter<CardKabKotaAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardKabkotaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val data = listKabKota[position]

        Glide.with(holder.itemView.context)
            .load(data.gambar)
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = data.kabupaten_kota
        holder.binding.tvItemDetail.text =
            "Pusat Pemerintahan: ${data.pusat_pemerintahan}"

        holder.binding.btnSetShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share Data ${data.kabupaten_kota}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listKabKota.size

    class CardViewHolder(val binding: ItemCardKabkotaBinding) :
        RecyclerView.ViewHolder(binding.root)
}