package com.aragones.paul.truck.models

import com.google.gson.annotations.SerializedName

data class TruckResponse(@SerializedName("wkda") val truckMap: Map<String, String>)


