package org.sopt.sopkaton_team3.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.sopkaton_team3.BuildConfig
import org.sopt.sopkaton_team3.data.service.EnterService
import org.sopt.sopkaton_team3.data.service.SlotService
import org.sopt.sopkaton_team3.data.service.MakeRoomService
import org.sopt.sopkaton_team3.data.service.ResultService
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL = BuildConfig.BASE_URL
  
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        ).build()
    }
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    // val dummyService = ApiFactory.create<DummyService>()
    val exampleService = ExampleSource()
    val resultService = ApiFactory.create<ResultService>()
    val madeRoomService = MadeRoomUserListSource()
    val slotService = ApiFactory.create<SlotService>()
    val makeRoomService = ApiFactory.create<MakeRoomService>()
    val enterRoomService = ApiFactory.create<EnterService>()
}