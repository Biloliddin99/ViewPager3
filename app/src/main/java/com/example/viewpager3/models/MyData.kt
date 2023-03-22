package com.example.viewpager3.models

import com.example.viewpager3.R

object MyData {
     val itemList = ArrayList<User>()

    fun addData(){
        itemList.add(User(R.drawable.fon_1,"Geoaxborot","Geoaxborot moduli orqali siz o'zigizga yaqin bo'lgan migrantlar va boshqa muassasalar haqida ma'lumot olishingiz mumkin",))
        itemList.add(User(R.drawable.fon_2,"Huquqiy axborot","Huquqiy axborot moduli orqali siz migratsiya sohasia oid yangiliklardan, qonunlardan xabardor bo'lishigiz mumkin"))
        itemList.add(User(R.drawable.fon_3,"To'lovlar xizmati","To'lov xizmati moduli orqali siz masofadan turib turli xil xizmatlarga to'lovlar haqida ma'lumot olishingiz va to'lovlarni amalga oshirishingiz mumkin"))
        itemList.add(User(R.drawable.fon_4,"Qo'shimcha imkoniyat","Qo'shimcha imkoniyatlar moduli orqali siz interaktiv so'zlashgichlar va lug'atlar yordamida til bilish savodxonligingizni oshirishingiz mumkin"))

    }
}