package co.id.rikihikmianto.mvvm.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUnicorn {
    companion object {
        fun getInstance(): InterfaceUnicorn {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
            val retrofit = Retrofit.Builder().baseUrl("https://crudcrud.com/api/e1e008afa5e144129d762a192b9065e3/")
                .addConverterFactory(GsonConverterFactory.create()).client(client).build()
            return retrofit.create(InterfaceUnicorn::class.java)
        }
    }
}