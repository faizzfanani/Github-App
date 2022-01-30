package com.faizzfanani.githubapp.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.faizzfanani.githubapp.databinding.ActivityListBinding
import com.faizzfanani.githubapp.di.MyApplication
import com.faizzfanani.githubapp.ui.detail.DetailActivity
import com.faizzfanani.githubapp.ui.viewmodel.ViewModelFactory
import com.faizzfanani.githubapp.utils.Constant
import com.faizzfanani.githubapp.vo.Resource
import javax.inject.Inject

class ListActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityListBinding
    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        MyApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra(Constant.username, query)
                intent.putExtra(Constant.search, true)
                startActivity(intent)
                return false
            }

        })
    }
    private fun loadData(){
        val adapter = UserAdapter()
        binding.rvUser.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvUser.adapter = adapter
        viewModel.getUserList().observe(this){ resource ->
            when(resource){
                is Resource.Success -> {
                    resource.data?.let {
                        adapter.setList(it)
                    }
                    binding.shimmer.shimmerList.stopShimmer()
                    binding.shimmer.shimmerList.visibility = View.GONE
                }
                is Resource.Loading -> {
                    resource.data?.let {
                        adapter.setList(it)
                    }
                    if (resource.data.isNullOrEmpty()){
                        binding.shimmer.shimmerList.startShimmer()
                    }
                }
                is Resource.Error -> {
                    binding.shimmer.shimmerList.stopShimmer()
                    binding.shimmer.shimmerList.visibility = View.GONE
                    resource.data?.let {
                        adapter.setList(it)
                    }
                    Toast.makeText(applicationContext, resource.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}