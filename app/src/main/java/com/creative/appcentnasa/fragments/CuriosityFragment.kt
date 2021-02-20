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
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.creative.appcentnasa.MyAdapter
import com.creative.appcentnasa.R
import com.creative.appcentnasa.`interface`.networkAPI
import com.creative.appcentnasa.databinding.FragmentCuriosityBinding
import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.Reqrescuriosity
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CuriosityFragment : Fragment() {
    private val cameraList: MutableList<Camera> = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setup Adapter

        //Setup Recyclerview
        binding = FragmentCuriosityBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                OrientationHelper.VERTICAL
            )
        )

        val cilent = OkHttpClient.Builder().build()


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(cilent)
            .build()
            .create(networkAPI::class.java)

        val resp = retrofit.cameralistgetir()
        if (resp.isSuccessful) {
            Log.d("test",resp.body().toString())
        }



    }

    private lateinit var binding: FragmentCuriosityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return binding.root
    }
}


// Inflate the layout for this fragment
//return inflater.inflate(R.layout.fragment_curiosity, container, false)

// AndroidNetworking.initialize(requireContext())

//Setup Android Networking
/* AndroidNetworking.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY&page=1")
     .build()
     .getAsJSONArray(new)
     .getAsObject(Reqrescuriosity::class.java,
         object : ParsedRequestListener<Reqrescuriosity> {
             override fun onResponse(response: Reqrescuriosity) {
val cameras: MutableList<Camera> = mutableListOf()
 cameras.add(Camera("abc",1,"abcd",1))
 myAdapter = MyAdapter(cameras)
 binding.recyclerView.adapter = myAdapter
 //cameraList.addAll(response.photos)
 myAdapter.notifyDataSetChanged()


             }

             override fun onError(anError: ANError?) {
             Log.d("hata",anError.toString())
             }

         })*/