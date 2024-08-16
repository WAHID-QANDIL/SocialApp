package com.depi.labs.socialapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnIconClicklistener{
    fun onClick(position: Int)
}

class IconListAdapter(mutableList: MutableList<SocialIcon>, onIconClicklistener:OnIconClicklistener) :
    RecyclerView.Adapter<IconListAdapter.ViewHolder>() {


    private val iconClickHandler = onIconClicklistener
    private var socialIconList = mutableList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.social_icon_layout,parent,false)
        return ViewHolder(view,iconClickHandler)

    }

    override fun getItemCount() = socialIconList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*
        * facebook 0
        * instgram 1
        * google 2
        * twitter 3
        * tiktok 4
        * youtube 5
        * */


        val socialIcon = socialIconList[position]
        holder.bind(socialIcon)

        /*
        //        val context = holder.itemView.context
        //        when(position)
        //        {
        //            0 -> holder.socialIcon = SocialIcon(
        //                    iconTitle = context.getString(R.string.facebook),
        //                    imageResourceId = ContextCompat.getDrawable(holder.itemView.context,R.mipmap.facebook)
        //                )
        //            1 -> holder.socialIcon = SocialIcon(
        //                iconTitle = context.getString(R.string.instgram),
        //                imageResourceId = ContextCompat.getDrawable(holder.itemView.context,R.mipmap.instegram)
        //            )
        //            2 -> holder.socialIcon = SocialIcon(
        //                iconTitle = context.getString(R.string.google),
        //                imageResourceId = ContextCompat.getDrawable(holder.itemView.context,R.mipmap.google)
        //            )
        //            3 -> holder.socialIcon = SocialIcon(
        //                iconTitle = context.getString(R.string.twitter),
        //                imageResourceId = ContextCompat.getDrawable(holder.itemView.context,R.mipmap.twitter)
        //            )
        //            4 -> holder.socialIcon = SocialIcon(
        //                iconTitle = context.getString(R.string.tiktok),
        //                imageResourceId = ContextCompat.getDrawable(holder.itemView.context,R.mipmap.tiktok)
        //            )
        //            5 -> holder.socialIcon = SocialIcon(
        //                iconTitle = context.getString(R.string.youtube),
        //                imageResourceId = AppCompatResources.getDrawable(holder.itemView.context,R.mipmap.youtube)
        //            )
        //        }
        */

    }


    class ViewHolder(itemView: View, private val listener: OnIconClicklistener) : RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        val iconTitleTextView: TextView = itemView.findViewById(R.id.icon_title)
        val iconImageView: ImageView = itemView.findViewById(R.id.imageview)

        fun bind(socialIcon: SocialIcon) {
            iconTitleTextView.text = socialIcon.iconTitle
            iconImageView.setImageDrawable(socialIcon.imageResourceId)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClick(adapterPosition)
        }

    }
}