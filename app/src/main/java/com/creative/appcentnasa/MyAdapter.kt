package com.creative.appcentnasa

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.creative.appcentnasa.model.Camera
import com.creative.appcentnasa.model.Photo
import com.squareup.picasso.Picasso


class MyAdapter(private val cameraList: MutableList<Camera>) : RecyclerView.Adapter<MyHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = cameraList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val camera = cameraList[position]
        val cameraNameTextView = holder.itemView.findViewById<TextView>(R.id.camera_name)
        val fullName = "${camera.fullName}"
        val roverAvatarImageView = holder.itemView.findViewById<ImageView>(R.id.rover_avatar)
    }
}