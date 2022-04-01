package com.zcdev.tpnote

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zcdev.tpnote.adapters.itemAdapter
import com.zcdev.tpnote.entities.Item
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Dialog
import android.content.DialogInterface
import android.util.Log
import android.view.MenuItem
import android.view.Menu

import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.dialog.*


class MainActivity : AppCompatActivity() {
    var listItem=ArrayList<Item>()
    var dialog: Dialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadPost()
        setUpRecyclerView()

    }



    private fun setUpRecyclerView() {

        /*StaggeredGridLayoutManager
        * It is basically an extension to Grid View but in this each
        *  Grid is of varying size(Height and width).
        * in this example twite text size its not the same thats why i use it
 * */


        recyclerView.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = itemAdapter(listItem)
        recyclerView.adapter!!.notifyDataSetChanged()
    }

    private fun loadPost() {

        // fake data to test
       /* var t0=Item(0,"zakaria","twit 1")
        var t1=Item(0,"zakaria","twit 2")
        var t2=Item(0,"zakaria","twit 3")
        var t3=Item(0,"zakaria","twit 4")
        listItem.add(t0)
        listItem.add(t1)
        listItem.add(t2)
        listItem.add(t3)*/
        dialog = Dialog(this)
        dialog!!.setContentView(R.layout.dialog)
        dialog!!.setTitle("Twitter")
        val btnValider: Button = dialog!!.findViewById(R.id.btn)
       var  txt1 = dialog!!.txt
        btnValider.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {

                listItem.add(Item(5,"zakaria", txt1.getText().toString(), R.drawable.logo))
                dialog!!.dismiss()
                if (listItem.size>0){
                    no_data_imageView.visibility=View.GONE
                    no_data_textView.visibility=View.GONE
                }

            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
          R.id.menu_add ->dialog!!.show()
        }
        return super.onOptionsItemSelected(item)
    }
}