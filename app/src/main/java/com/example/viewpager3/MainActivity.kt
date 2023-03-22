package com.example.viewpager3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.viewpager3.adapters.ViewPagerAdapter
import com.example.viewpager3.databinding.ActivityMainBinding
import com.example.viewpager3.databinding.ItemTabBinding
import com.example.viewpager3.models.MyData
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyData.addData()
        var index = 0
        viewPagerAdapter = ViewPagerAdapter(MyData.itemList)
        binding.myViewPager.adapter = viewPagerAdapter

        binding.myTab.setupWithViewPager(binding.myViewPager)
        addTab()

        binding.myViewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                index = position
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        binding.btnNext.setOnClickListener {
            when (index) {
                0 -> {
                    binding.myViewPager.currentItem = index + 1
                }
                1 -> {
                    binding.myViewPager.currentItem = index + 1
                }
                2 -> {
                    binding.myViewPager.currentItem = index + 1
                }
                3 -> {
                    binding.myViewPager.currentItem = index - 3
                }
            }
        }

    }

    private fun addTab() {
        val tabCount = binding.myTab.tabCount

        for (i in 0 until tabCount) {
            val tabItem = ItemTabBinding.inflate(layoutInflater)
            val tab = binding.myTab.getTabAt(i)
            tab?.customView = tabItem.root

            if (i == 0) {
                tabItem.tabImage.setImageResource(R.drawable.selected_indicator)
            } else {
                tabItem.tabImage.setImageResource(R.drawable.default_indicator)
            }
        }

        binding.myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.tab_image)
                    ?.setImageResource(R.drawable.selected_indicator)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.tab_image)?.setImageResource(R.drawable.default_indicator)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        MyData.addData()
        MyData.itemList.removeAll(MyData.itemList.toSet())
    }
}