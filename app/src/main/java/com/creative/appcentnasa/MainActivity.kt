package com.creative.appcentnasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.viewpager.widget.ViewPager
import com.creative.appcentnasa.databinding.ActivityMainBinding
import com.creative.appcentnasa.fragments.CuriosityFragment
import com.creative.appcentnasa.fragments.OpportunityFragment
import com.creative.appcentnasa.fragments.SpiritFragment
import com.creative.appcentnasa.fragments.adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CuriosityFragment(), "Curiosity")
        adapter.addFragment(SpiritFragment(), "Spirit")
        adapter.addFragment(OpportunityFragment(), "Opportunity")
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_curiosity_24)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_spirit_24)
        binding.tabs.getTabAt(2)!!.setIcon(R.drawable.ic_opportunity_24)
    }
}