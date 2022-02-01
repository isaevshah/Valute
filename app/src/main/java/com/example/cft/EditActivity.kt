package com.example.cft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.cft.databinding.ActivityEditBinding
import com.example.cft.model.Reqres
import org.json.JSONArray

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
        getAllResult()
    }
      private fun getAllResult(){

        val valutes = arrayOf("Все валюты","Австралийский доллар","Азербайджанский манат",
            "Фунт стерлингов Соединенного королевства","Армянских драмов","Белорусский рубль","Болгарский лев",
        "Бразильский реал","Венгерских форинтов","Гонконгских долларов","Датская крона","Доллар США","Евро",
        "Индийских рупий","Казахстанских тенге","Канадский доллар","Киргизских сомов","Китайский юань","Молдавских леев",
        "Норвежских крон","Польский злотый","Румынский лей","СДР (специальные права заимствования)","Сингапурский доллар",
        "Таджикских сомони","Турецких лир","Новый туркменский манат","Узбекских сумов","Украинских гривен","Чешских крон",
        "Шведских крон","Швейцарский франк","Южноафриканских рэндов","Вон Республики Корея","Японских иен")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,valutes)

        binding.simpleSpinner.adapter = arrayAdapter
        binding.simpleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                fun isEmpty(): Boolean {
                    binding.apply {
                        if(idText.text.isNullOrEmpty()) idText.error = "Please fill the row"
                        return idText.text.isNullOrEmpty()
                    }
                }
                if(!isEmpty()) {
                    when (valutes[position]) {
                        "Австралийский доллар" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.018151)}"
                            binding.idResult.text = "${result} AUD"
                        }
                        "Азербайджанский манат" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.021931)}"
                            binding.idResult.text = "${result} AZN"
                        }
                        "Фунт стерлингов Соединенного королевства" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.009602)}"
                            binding.idResult.text = "${result} GBP"
                        }
                        "Армянских драмов" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (6.23)}"
                            binding.idResult.text = "${result} AMD"
                        }
                        "Белорусский рубль" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.0336)}"
                            binding.idResult.text = "${result} BYN"
                        }
                        "Болгарский лев" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.022582)}"
                            binding.idResult.text = "${result} BGN"
                        }
                        "Бразильский реал" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.069287)}"
                            binding.idResult.text = "${result} BRL"
                        }
                        "Венгерских форинтов" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (4.13)}"
                            binding.idResult.text = "${result} HUF"
                        }
                        "Гонконгских долларов" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.10057)}"
                            binding.idResult.text = "${result} HKD"
                        }
                        "Датская крона" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.085921)}"
                            binding.idResult.text = "${result} DKK"
                        }
                        "Доллар США" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.012908)}"
                            binding.idResult.text = "${result} USD"
                        }
                        "Евро" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.01156)}"
                            binding.idResult.text = "${result} EUR"
                        }
                        "Индийских рупий" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.96431)}"
                            binding.idResult.text = "${result} INR"
                        }
                        "Казахстанских тенге" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (5.61)}"
                            binding.idResult.text = "${result} KZT"
                        }
                        "Канадский доллар" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.016273)}"
                            binding.idResult.text = "${result} CAD"
                        }
                        "Киргизских сомов" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (1.1)}"
                            binding.idResult.text = "${result} KGS"
                        }
                        "Китайский юань" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.082109)}"
                            binding.idResult.text = "${result} CNY"
                        }
                        "Молдавских леев" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.23235)}"
                            binding.idResult.text = "${result} MDL"
                        }
                        "Норвежских крон" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.1156)}"
                            binding.idResult.text = "${result} NOK"
                        }
                        "Польский злотый" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.052984)}"
                            binding.idResult.text = "${result} PLN"
                        }
                        "Румынский лей" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.057093)}"
                            binding.idResult.text = "${result} RON"
                        }
                        "СДР (специальные права заимствования)" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.0093)}"
                            binding.idResult.text = "${result} XDR"
                        }
                        "Сингапурский доллар" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.017478)}"
                            binding.idResult.text = "${result} SGD"
                        }
                        "Таджикских сомони" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.1458)}"
                            binding.idResult.text = "${result} TJS"
                        }
                        "Турецких лир" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.17204)}"
                            binding.idResult.text = "${result} TRY"
                        }
                        "Новый туркменский манат" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.045114)}"
                            binding.idResult.text = "${result} TMT"
                        }
                        "Узбекских сумов" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (139.6)}"
                            binding.idResult.text = "${result} UZS"
                        }
                        "Украинских гривен" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.36882)}"
                            binding.idResult.text = "${result} UAH"
                        }
                        "Чешских крон" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.28232)}"
                            binding.idResult.text = "${result} CZK"
                        }
                        "Шведских крон" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.12107)}"
                            binding.idResult.text = "${result} SEK"
                        }
                        "Швейцарский франк" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.012015)}"
                            binding.idResult.text = "${result} CHF"
                        }
                        "Южноафриканских рэндов" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (0.20075)}"
                            binding.idResult.text = "${result} ZAR"
                        }
                        "Вон Республики Корея" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (15.61)}"
                            binding.idResult.text = "${result} KRW"
                        }
                        "Японских иен" -> {
                            var a: Double
                            var result: String
                            a = binding.idText.text.toString().toDouble()
                            result = "${a * (1.49)}"
                            binding.idResult.text = "${result} JPY"
                        }
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(item.itemId == android.R.id.home ) {
           finish()
       }
        return super.onOptionsItemSelected(item)
    }
    private fun actionBarSettings(){
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }
}
