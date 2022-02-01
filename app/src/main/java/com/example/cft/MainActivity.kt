package com.example.cft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.cft.databinding.ActivityMainBinding
import com.example.cft.model.Reqres
import com.example.cft.model.Valute
import com.example.cft.model.ValuteInterface

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataList: MutableList<ValuteInterface> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu) // мы тут запихли меню на функцию onCreateOptionsMenu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){// android.R.id.home эта айди нашего кнопки он встроенный
            R.id.edit->{
                val intent  = Intent(this, EditActivity:: class.java)
                startActivity(intent)
                Toast.makeText(this, "Конвертировать", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setup adapter
        myAdapter = MyAdapter(dataList)
        // Setup recyclerView
        binding.idRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.idRecyclerView.addItemDecoration(
            DividerItemDecoration(this,
                OrientationHelper.VERTICAL)
        )
        //binding.idRecyclerView.layoutManager = GridLayoutManager(this@MainActivity , 1)
        binding.idRecyclerView.adapter = myAdapter
        // Setup Android networking
        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://www.cbr-xml-daily.ru/daily_json.js")
            .build()
            .getAsObject(Reqres :: class.java, object: ParsedRequestListener<Reqres> {
                override fun onResponse(response: Reqres) {
                    val items = listOf(
                        response.valute.aMD,
                        response.valute.aUD,
                        response.valute.aZN,
                        response.valute.bGN,
                        response.valute.bRL,
                        response.valute.bYN,
                        response.valute.cAD,
                        response.valute.cHF,
                        response.valute.cNY,
                        response.valute.cZK,
                        response.valute.dKK,
                        response.valute.eUR,
                        response.valute.gBP,
                        response.valute.hKD,
                        response.valute.hUF,
                        response.valute.iNR,
                        response.valute.jPY,
                        response.valute.kGS,
                        response.valute.kRW,
                        response.valute.kZT,
                        response.valute.mDL,
                        response.valute.nOK,
                        response.valute.pLN,
                        response.valute.rON,
                        response.valute.sEK,
                        response.valute.sGD,
                        response.valute.tJS,
                        response.valute.tMT,
                        response.valute.tRY,
                        response.valute.uAH,
                        response.valute.uSD,
                        response.valute.uZS,
                        response.valute.xDR,
                        response.valute.zAR
                    )
                    //if(items != null) {
                        dataList.addAll(items)
                    //}
                    myAdapter.notifyDataSetChanged()
                    Log.d("MyLog2","${dataList}")
                }
                override fun onError(anError: ANError?) {

                }
            })

    }
}
/*
            .getAsObject(Valute :: class.java, object: ParsedRequestListener<Valute> {
                override fun onResponse(response: Valute) {
                        val items = listOf(
                        response.aMD,
                        response.aUD,
                        response.aZN,
                        response.bGN,
                        response.bRL,
                        response.bYN,
                        response.cAD,
                        response.cHF,
                        response.cNY,
                        response.cZK,
                        response.dKK,
                        response.eUR,
                        response.gBP,
                        response.hKD,
                        response.hUF,
                        response.iNR,
                        response.jPY,
                        response.kGS,
                        response.kRW,
                        response.kZT,
                        response.mDL,
                        response.nOK,
                        response.pLN,
                        response.rON,
                        response.sEK,
                        response.sGD,
                        response.tJS,
                        response.tMT,
                        response.tRY,
                        response.uAH,
                        response.uSD,
                        response.uZS,
                        response.xDR,
                        response.zAR
                    )
*/