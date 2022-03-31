package co.id.rikihikmianto.mvvm.api

import co.id.rikihikmianto.mvvm.data.ResponseUnicorns
import retrofit2.Call
import retrofit2.http.*

interface InterfaceUnicorn {
    @GET("unicorns")
    fun getUnicorn(): Call<List<ResponseUnicorns>>

    @POST("unicorns")
    fun postUnicorn(@Body responseUnicorns: ResponseUnicorns): Call<List<ResponseUnicorns>>
}