package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp.databinding.ActivityViewPetaBinding

class ViewPetaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPetaBinding

    companion object {
        const val EXTRA_URL_PETA = "extra_url_peta"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewPetaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val urlPeta = intent.getStringExtra(EXTRA_URL_PETA)

        Glide.with(this)
            .load(urlPeta)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .fitCenter()
            )
            .into(binding.imgItemPhoto)
    }
}