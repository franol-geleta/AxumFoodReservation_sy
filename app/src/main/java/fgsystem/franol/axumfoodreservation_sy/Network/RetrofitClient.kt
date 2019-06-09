package fgsystem.franol.axumfoodreservation_sy.Network

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient  private constructor() {
    private val retrofit: Retrofit

    val api: ApiServices
        get() = retrofit.create(ApiServices::class.java!!)


    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .addHeader("Authorization", AUTH)
                    .method(original.method(), original.body())

                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {


        private val AUTH = "Basic " + Base64.encodeToString("franol:123456".toByteArray(), Base64.NO_WRAP)

        private val BASE_URL = "http://localhost/Axumfoodapp/public/"
        private var mInstance: RetrofitClient? = null

        val instance: RetrofitClient
            @Synchronized get() {
                if (mInstance == null) {
                    mInstance = RetrofitClient()
                }
                return mInstance as RetrofitClient
            }
    }
}
