package com.depi.labs.socialapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    val iconList = mutableListOf<SocialIcon>()
    lateinit var recyclerView:RecyclerView
    lateinit var iconListAdapter: IconListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    private fun insertIcons(mutableList: MutableList<SocialIcon>)
    {
        /*
        * facebook 0
        * instgram 1
        * google 2
        * twitter 3
        * tiktok 4
        * youtube 5
        * */
        fun initUrls() {
            mutableList[0].url = getString(R.string.facebook_url)
            mutableList[1].url = getString(R.string.instgram_url)
            mutableList[2].url = getString(R.string.google_url)
            mutableList[3].url = getString(R.string.twitter_url)
            mutableList[4].url = getString(R.string.tiktok_url)
            mutableList[5].url = getString(R.string.youtube_url)
        }
        mutableList.add(SocialIcon(getString(R.string.facebook),AppCompatResources.getDrawable(this@MainActivity,R.mipmap.facebook)))
        mutableList.add(SocialIcon(getString(R.string.instgram),AppCompatResources.getDrawable(this@MainActivity,R.mipmap.instegram)))
        mutableList.add(SocialIcon(getString(R.string.google),AppCompatResources.getDrawable(this@MainActivity,R.mipmap.google)))
        mutableList.add(SocialIcon(getString(R.string.twitter),AppCompatResources.getDrawable(this@MainActivity,R.mipmap.twitter)))
        mutableList.add(SocialIcon(getString(R.string.tiktok),AppCompatResources.getDrawable(this@MainActivity,R.mipmap.tiktok)))
        mutableList.add(SocialIcon(getString(R.string.youtube),AppCompatResources.getDrawable(this@MainActivity,R.mipmap.youtube)))
        initUrls()
    }

    private fun initRecycler()
    {
        recyclerView = findViewById(R.id.recyclerview)
        insertIcons(iconList)
        iconListAdapter = IconListAdapter(iconList,object:OnIconClicklistener{

            override fun onClick(position: Int) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(iconList[position].url))
                startActivity(intent)
            }
        })
        val manager : RecyclerView.LayoutManager = StaggeredGridLayoutManager(8,StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.adapter = iconListAdapter
        recyclerView.layoutManager = manager
    }
}