package com.example.cft.model


import com.google.gson.annotations.SerializedName

data class MDL(
    @SerializedName("CharCode")
    override val charCode: String,
    @SerializedName("ID")
    override val iD: String,
    @SerializedName("Name")
    override val name: String,
    @SerializedName("Nominal")
    override val nominal: Int,
    @SerializedName("NumCode")
    override val numCode: String,
    @SerializedName("Previous")
    override val previous: Double,
    @SerializedName("Value")
    override val value: Double
): ValuteInterface