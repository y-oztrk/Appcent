package com.creative.appcentnasa.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.creative.appcentnasa.MyAdapter
import com.creative.appcentnasa.`interface`.networkAPI
import com.creative.appcentnasa.databinding.FragmentCuriosityBinding
import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.NasaResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.*
import retrofit2.converter.gson.GsonConverterFactory



class CuriosityFragment : Fragment() {


    private lateinit var myAdapter: MyAdapter
    private lateinit var binding: FragmentCuriosityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCuriosityBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                OrientationHelper.VERTICAL
            )
        )

    }

    //glide
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val cilent = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
            .addCallAdapterFactory(create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(cilent)
            .build()
            .create(networkAPI::class.java)

        retrofit.cameralistgetir(100, "DEMO_KEY", 1).enqueue(object : Callback<NasaResponse> {
            override fun onFailure(call: Call<NasaResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<NasaResponse>, response: Response<NasaResponse>) {
                Log.d("FAIL", response.body()!!.photos[0].imgSrc.toString())
                val cameras: MutableList<Camera> = mutableListOf()
                response.body()!!.photos.forEach {
                    cameras.add(
                        Camera(
                            it.camera.id,
                            it.camera.name,
                            it.camera.fullName,
                            it.camera.roverİd
                        )
                    )
                }
                Log.d("SUCCESS", cameras.size.toString())
                myAdapter = MyAdapter(cameras)
                binding.recyclerView.adapter = myAdapter
                //cameraList.addAll(response.photos)
                myAdapter.notifyDataSetChanged()

            }
        })

        return binding.root
    }
}


