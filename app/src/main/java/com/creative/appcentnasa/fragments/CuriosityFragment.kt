package com.creative.appcentnasa.fragments

import android.os.Bundle
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
import com.creative.appcentnasa.databinding.FragmentCuriosityBinding
import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.Reqrescuriosity


class CuriosityFragment : Fragment() {
    private val cameraList: MutableList<Camera> = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentCuriosityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_curiosity, container, false)

//setup Adapter
        myAdapter = MyAdapter(cameraList)
        //Setup Recyclerview
        binding = FragmentCuriosityBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity!!)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity!!,
                OrientationHelper.VERTICAL
            )
        )
        binding.recyclerView.adapter = myAdapter
        AndroidNetworking.initialize(activity!!)
        //Setup Android Networking
        AndroidNetworking.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY&page=1")
            .build()
            .getAsObject(Reqrescuriosity::class.java,
                object : ParsedRequestListener<Reqrescuriosity> {
                    override fun onResponse(response: Reqrescuriosity) {
                        //cameraList.addAll(response.photos)
                        myAdapter.notifyDataSetChanged()
                    }

                    override fun onError(anError: ANError?) {
                        TODO("Not yet implemented")
                    }

                })








        return binding.root
    }
}