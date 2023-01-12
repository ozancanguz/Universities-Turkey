package com.ozancanguz.universities_turkey.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.Objects

@Parcelize
data class UniversityItem(
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("web_pages")
    val webPages: List<String>
):Parcelable