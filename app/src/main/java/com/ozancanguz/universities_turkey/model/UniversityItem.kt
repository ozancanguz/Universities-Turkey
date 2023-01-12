package com.ozancanguz.universities_turkey.model


import com.google.gson.annotations.SerializedName

data class UniversityItem(
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("state-province")
    val stateProvince: Any,
    @SerializedName("web_pages")
    val webPages: List<String>
)