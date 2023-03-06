package com.example.practiceone

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val itemList = arrayListOf(
        Color("Blue", "#000000", "#526760"),
        Color("Blue", "#000000", "#526760"),
        Color("Blue", "#000000", "#526760"),
    )
    fun getItemList(): ArrayList<Color>{
        return itemList
    }
    fun addColor(nameColor: String, backgroundColor: String) {
        itemList.add(Color(nameColor, "000000", backgroundColor))
    }

    fun removeColor(color: Color) {
        itemList.remove(color)
    }

    fun changeTextsColors(textColor: String) {
        for (item in itemList) {
            item.textColor = textColor
        }
    }

    fun resetTextsColors() {
        for (item in itemList) {
            item.textColor = "000000"
        }
    }
}