package com.example.practiceone

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val itemList = arrayListOf(
        MyColor("Blue", "#000000", "#0000FF"),
        MyColor("Red", "#000000", "#ff0000"),
        MyColor("Green", "#000000", "#28721D"),
        MyColor("Aqua", "#000000", "#00FFFF"),
        MyColor("Teal", "#000000", "#008080"),
        MyColor("Navy", "#000000", "#000080"),
        MyColor("Fuchsia", "#000000", "#FF00FF"),
        MyColor("Purple", "#000000", "#800080"),
        MyColor("Maroon", "#000000", "#800000"),
        MyColor("Lime", "#000000", "#00FF00"),
    )
    fun getItemList(): ArrayList<MyColor>{
        return itemList
    }
    fun addColor(nameColor: String, backgroundColor: String) {
        itemList.add(MyColor(nameColor, "000000", backgroundColor))
    }

    fun removeColor(myColor: MyColor) {
        itemList.remove(myColor)
    }

    fun changeTextsColors(textColor: String) {
        for (item in itemList) {
            item.textColor = textColor
        }
    }

    fun resetTextsColors() {
        for (item in itemList) {
            item.textColor = "#000000"
        }
    }
}