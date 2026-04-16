package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp.databinding.ItemListKabkotaBinding

class ListKabKotaAdapter(private val listKabKota: ArrayList<KabKota>) :
    RecyclerView.Adapter<ListKabKotaAdapter.ListViewHolder>() {

    // =========================
    // CALLBACK CLICK
    // =========================
    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(data: KabKota)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // =========================
    // VIEW HOLDER
    // =========================
    class ListViewHolder(val binding: ItemListKabkotaBinding) :
        RecyclerView.ViewHolder(binding.root)

    // =========================
    // CREATE VIEW
    // =========================
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListKabkotaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    // =========================
    // BIND DATA
    // =========================
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listKabKota[position]

        Glide.with(holder.binding.imgItemPhoto.context)
            .load(data.gambar)
            .apply(RequestOptions().override(55, 55))
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = data.kabupaten_kota
        holder.binding.tvItemDetail.text =
            "Pusat Pemerintahan: ${data.pusat_pemerintahan}"

        // EVENT KLIK
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(data)
        }
    }

    // =========================
    // ITEM COUNT
    // =========================
    override fun getItemCount(): Int = listKabKota.size
}