package com.wes.base.util

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import android.widget.ImageView
import com.wes.app.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.Target


object ImageUtil {

    fun loadAvatarImage(context: Context,
                  url: String,
                  placeHolder: Int = R.drawable.dummy_avatar,
                  imageView: ImageView,
                  height: Int = Target.SIZE_ORIGINAL,
                  width: Int = Target.SIZE_ORIGINAL) {
        Glide.with(context).load(url).centerCrop()
                .placeholder(placeHolder).override(height, width).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
    }

    fun loadImage(url: String,
                  placeHolder: Int = R.drawable.no_thumbnail,
                  imageView: ImageView,
                  height: Int = Target.SIZE_ORIGINAL,
                  width: Int = Target.SIZE_ORIGINAL) {
        Glide.with(imageView.context).load(url).centerCrop()
                .placeholder(placeHolder).override(height, width).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
    }

}