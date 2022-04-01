package com.zcdev.tpnote.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zcdev.tpnote.R
import com.zcdev.tpnote.entities.Item
import android.content.DialogInterface
import android.app.Activity
import android.content.Intent
import com.zcdev.tpnote.DetailesActivity


class itemAdapter(var itemList:ArrayList<Item>):RecyclerView.Adapter<itemAdapter.ViewHolder>() {
    
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(p0?.context).inflate(R.layout.viewcell, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text=itemList[position].nom
        holder.desc.text=itemList[position].desc

        holder.itemView.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                alertRemove(p0!!,itemList,position)
                return true
            }

        })
        holder.itemView.setOnClickListener {
            var intent=Intent(holder.itemView.context,DetailesActivity::class.java)
            intent.putExtra("name",itemList[position].nom)
            intent.putExtra("desc",itemList[position].desc)
            intent.putExtra("image",R.drawable.logo)
            holder.itemView.context.startActivity(intent)

        }


    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name=itemView.findViewById<TextView>(R.id.txtName)
        var desc=itemView.findViewById<TextView>(R.id.txtDesc)
    }

    fun alertRemove(p0:View,items:ArrayList<Item>,position: Int){

        val confirm: AlertDialog.Builder = AlertDialog.Builder(p0.context)
        confirm.setTitle("Suppression")
        confirm.setIcon(android.R.drawable.ic_dialog_alert)
        confirm.setMessage("Vous confirmez la suppression?")
        confirm.setPositiveButton(android.R.string.yes,
            DialogInterface.OnClickListener { dialog, idBtn ->
                items.remove(items[position])
                notifyDataSetChanged()
            })
        confirm.setNegativeButton(android.R.string.no, null)
        confirm.show()
    }

}
