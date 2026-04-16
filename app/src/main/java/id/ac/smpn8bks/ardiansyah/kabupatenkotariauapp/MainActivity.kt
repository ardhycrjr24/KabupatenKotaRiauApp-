package id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var title: String = "Mode List View"
    private var listData: ArrayList<KabKota> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(title)

        listData.addAll(KabKotaData.listDataKabKota)

        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List View"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid View"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode Card View"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    // =====================
    // LIST VIEW + KLIK
    // =====================
    private fun showRecyclerList() {
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val adapter = ListKabKotaAdapter(listData)
        binding.rvKabKota.adapter = adapter

        adapter.setOnItemClickCallback(object : ListKabKotaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KabKota) {
                showSelectedKabKota(data)
            }
        })
    }

    // =====================
    // GRID VIEW
    // =====================
    private fun showRecyclerGrid() {
        binding.rvKabKota.layoutManager = GridLayoutManager(this, 2)
        val gridAdapter = GridKabKotaAdapter(listData)
        binding.rvKabKota.adapter = gridAdapter
    }

    // =====================
    // CARD VIEW
    // =====================
    private fun showRecyclerCardView() {
        binding.rvKabKota.layoutManager = LinearLayoutManager(this)
        val cardAdapter = CardKabKotaAdapter(listData)
        binding.rvKabKota.adapter = cardAdapter
    }

    // =====================
    // PINDAH KE DETAIL
    // =====================
    private fun showSelectedKabKota(data: KabKota) {
        val intent = Intent(this, DetailKabKotaActivity::class.java)
        intent.putExtra("DATA", data)
        startActivity(intent)
    }
}