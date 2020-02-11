package com.wes.app.extensions

import com.wes.app.Config

fun String.toImageUrl(): String {
    return Config.IMAGE_URL + this
}