package co.id.rikihikmianto.mvvm.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.id.rikihikmianto.mvvm.api.ApiUnicorn
import co.id.rikihikmianto.mvvm.data.ResponseUnicorns
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _listUnicorn = MutableLiveData<List<ResponseUnicorns>>()
    val listUnicorn: LiveData<List<ResponseUnicorns>> = _listUnicorn

    companion object {
        private const val TAG = "ViewModelError"
    }

        init {
            getListUnicorn()
        }

    private fun getListUnicorn() {
        val client = ApiUnicorn.getInstance().getUnicorn()
        client.enqueue(object : Callback<List<ResponseUnicorns>>{
            override fun onResponse(
                call: Call<List<ResponseUnicorns>>,
                response: Response<List<ResponseUnicorns>>
            ) {
                _listUnicorn.value = response.body()
                Log.d(TAG, "onResponse: success")
            }

            override fun onFailure(call: Call<List<ResponseUnicorns>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message.toString()}", )
            }

        })
    }

    fun postUnicorns(name: String, age: Int, color: String){
        val modelData = ResponseUnicorns(color, name, null, age)
        val client = ApiUnicorn.getInstance().postUnicorn(modelData)
        client.enqueue(object : Callback<List<ResponseUnicorns>>{
            override fun onResponse(
                call: Call<List<ResponseUnicorns>>,
                response: Response<List<ResponseUnicorns>>
            ) {
                _listUnicorn.value = response.body()
                Log.e(TAG, "onResponse: success")
            }

            override fun onFailure(call: Call<List<ResponseUnicorns>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}", )
            }

        })
    }
}