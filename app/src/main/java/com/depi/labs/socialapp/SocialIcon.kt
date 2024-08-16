package com.depi.labs.socialapp

import android.graphics.drawable.Drawable
import android.widget.TextView

data class SocialIcon(val iconTitle:String, val imageResourceId: Drawable?)
{
    private var _url: String = ""
    var url: String
        get() = _url
        set(value) {
            _url = value
        }
}
