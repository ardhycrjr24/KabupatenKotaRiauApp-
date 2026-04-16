package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp.databinding.ActivityDetailKabKotaBinding

class DetailKabKotaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKabKotaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailKabKotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KabKota>("DATA")

        if (data != null) {

            // =====================
            // TAMPILKAN GAMBAR
            // =====================
            Glide.with(this)
                .load(data.gambar)
                .into(binding.imgItemPhoto)

            // =====================
            // TAMPILKAN DATA
            // =====================
            binding.tvNama.text = data.kabupaten_kota
            binding.tvPusatPemerintahan.text = data.pusat_pemerintahan
            binding.tvBupatiWalikota.text = data.bupati_walikota
            binding.tvLuasWilayah.text = data.luas_wilayah.toString()
            binding.tvJumlahPenduduk.text = data.jumlah_penduduk.toString()
            binding.tvJumlahKecamatan.text = data.jumlah_kecamatan.toString()
            binding.tvJumlahKelurahan.text = data.jumlah_kelurahan.toString()
            binding.tvJumlahDesa.text = data.jumlah_desa.toString()

            // =====================
            // BUTTON LIHAT PETA
            // =====================
            binding.btnViewPeta.setOnClickListener {
                val intent = Intent(this, ViewPetaActivity::class.java)

                // 🔥 GUNAKAN URL DARI DATA (SUDAH BENAR)
                intent.putExtra(
                    ViewPetaActivity.EXTRA_URL_PETA,
                    data.url_peta_wilayah
                )

                startActivity(intent)
            }
        }
    }
}