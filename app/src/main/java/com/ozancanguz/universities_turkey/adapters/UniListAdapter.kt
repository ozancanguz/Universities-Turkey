package com.ozancanguz.universities_turkey.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.universities_turkey.R
import com.ozancanguz.universities_turkey.data.model.University
import com.ozancanguz.universities_turkey.data.model.UniversityItem
import com.ozancanguz.universities_turkey.ui.fragments.list.ListFragmentDirections
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.universitylist_rv.view.*
import okhttp3.internal.notify

class UniListAdapter:RecyclerView.Adapter<UniListAdapter.UniViewHolder>() {

    class UniViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    var uniList= emptyList<UniversityItem>()

    fun setData(newData:University){
        this.uniList= newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniViewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.universitylist_rv,parent,false)
        return UniViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniViewHolder, position: Int) {
        val currentUni=uniList[position]
        holder.itemView.uninameTv.text=currentUni.name
        holder.itemView.uniImage.setImageResource(R.drawable.uniimage)



        holder.itemView.setOnClickListener {

            val direction=ListFragmentDirections.actionListFragmentToDetailsFragment(currentUni)
            holder.itemView.findNavController().navigate(direction)

        }


    }

    override fun getItemCount(): Int {
        return uniList.size
    }


}