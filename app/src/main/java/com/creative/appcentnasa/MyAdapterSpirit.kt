package com.creative.appcentnasa

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.creative.appcentnasa.modelspirit.Camera
import com.squareup.picasso.Picasso

class MyAdapterSpirit(private val spiritCameraList: MutableList<Camera>) :  RecyclerView.Adapter<MyHolder>() {
    private lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = spiritCameraList.size


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val camera = spiritCameraList[position]
        val cameraNameTextView = holder.itemView.findViewById<TextView>(R.id.camera_name)
        cameraNameTextView.text = camera.fullName
        val fullName = "${camera.fullName}"
        val roverAvatarImageView = holder.itemView.findViewById<ImageView>(R.id.rover_avatar)

    }

}