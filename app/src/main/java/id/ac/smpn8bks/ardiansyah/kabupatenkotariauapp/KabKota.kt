package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KabKota(
    var gambar: Int = 0,
    var kabupaten_kota: String = "",
    var pusat_pemerintahan: String = "",
    var bupati_walikota: String = "",
    var luas_wilayah: Double = 0.0,
    var jumlah_penduduk: Int = 0,
    var jumlah_kecamatan: Int = 0,
    var jumlah_kelurahan: Int = 0,
    var jumlah_desa: Int = 0,
    var url_peta_wilayah: String = ""
) : Parcelable