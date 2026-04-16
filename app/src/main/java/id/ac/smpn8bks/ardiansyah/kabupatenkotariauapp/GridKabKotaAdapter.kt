package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp.databinding.ItemGridKabkotaBinding

class GridKabKotaAdapter(private val listKabKota: ArrayList<KabKota>) :
    RecyclerView.Adapter<GridKabKotaAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridKabkotaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listKabKota[position].gambar)
            .into(holder.binding.imgItemPhoto)
    }

    override fun getItemCount(): Int = listKabKota.size

    class GridViewHolder(val binding: ItemGridKabkotaBinding) :
        RecyclerView.ViewHolder(binding.root)
}