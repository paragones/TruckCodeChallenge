package com.aragones.paul.truck.models

/**
 * Auto1CodeChallenge
 *
 * Created by Paul Aragones on 9/23/2017.
 */
class Car() {
    var manufacturerKey: String = ""
    var manufacturerValue: String = ""
    var modelKey: String = ""
    var modelValue: String = ""
    var yearKey: String = ""
    var yearValue: String = ""

    fun cleanValues() {
        manufacturerKey = ""
        manufacturerValue = ""
        modelKey = ""
        modelValue = ""
        yearKey = ""
        yearValue = ""
    }
}