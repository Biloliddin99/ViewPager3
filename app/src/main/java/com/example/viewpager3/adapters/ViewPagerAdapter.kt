package com.example.viewpager3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpager3.databinding.ItemPagerBinding
import com.example.viewpager3.models.User

class ViewPagerAdapter(private val list: ArrayList<User>) : PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemPagerBinding =
            ItemPagerBinding.inflate(LayoutInflater.from(container.context), container, false)
        itemPagerBinding.itemImage.setImageResource(list[position].imageView)
        itemPagerBinding.title.text = list[position].title
        itemPagerBinding.text.text = list[position].textView
        container.addView(itemPagerBinding.root)
        return itemPagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}