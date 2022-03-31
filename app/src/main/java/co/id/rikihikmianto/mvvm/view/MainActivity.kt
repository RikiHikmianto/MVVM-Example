package co.id.rikihikmianto.mvvm.view

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.rikihikmianto.mvvm.data.ResponseUnicorns
import co.id.rikihikmianto.mvvm.databinding.ActivityMainBinding
import co.id.rikihikmianto.mvvm.model.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this)
        binding.rvMain.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvMain.addItemDecoration(itemDecoration)

        mainViewModel.listUnicorn.observe(this) {
            setUnicornData(it)
        }

        binding.btnSave.setOnClickListener { v ->
            if (binding.edtName.text.toString().isEmpty() && binding.edtAge.text.toString()
                    .isEmpty() && binding.edtColor.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Please enter both the values",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            mainViewModel.postUnicorns(
                binding.edtName.text.toString(),
                binding.edtAge.text!!.length,
                binding.edtColor.text.toString()
            )
            val input = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            input.hideSoftInputFromWindow(v?.windowToken, 0)

        }
    }

    private fun setUnicornData(listUnicornResponse: List<ResponseUnicorns>) {
        val list = listUnicornResponse.map {
            "-${it.name}\n- ${it.age}\n - ${it.colour} "
        }
        val adapter = UnicornAdapter(list)
        binding.rvMain.adapter = adapter
        binding.edtAge.setText("")
        binding.edtName.setText("")
        binding.edtColor.setText("")
    }
}
