package com.aragones.paul.truck.models

import com.google.gson.annotations.SerializedName

data class CarResponse(@SerializedName("wkda") val carMap: Map<String, String>)


