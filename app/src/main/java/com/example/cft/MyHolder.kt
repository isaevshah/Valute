package com.example.cft

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cft.databinding.ActivityEditBinding
import com.example.cft.databinding.EditViewBinding
import com.example.cft.model.ValuteInterface

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = EditViewBinding.bind(itemView)
    fun  bind(data: ValuteInterface) = with(binding){
        idId.text ="${data.iD}"
        idNumCode.text = "${data.numCode}"
        idCharCode.text = "${data.charCode}"
        idNominal.text = "${data.nominal}"
        idName.text = "${data.name}"
        idValue.text = "${data.value}"
        idPrevious.text = "${data.previous}"
    }
}