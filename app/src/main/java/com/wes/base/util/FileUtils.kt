package com.wes.base.util

import com.wes.app.extensions.AppContext

/**
 * @author by hunghoang on 2019-05-16.
 */
object FileUtils {
    fun readFileFromAssets(filePath: String): String {
        return AppContext.assets.open(filePath).bufferedReader().use {
            it.readText()
        }
    }
}