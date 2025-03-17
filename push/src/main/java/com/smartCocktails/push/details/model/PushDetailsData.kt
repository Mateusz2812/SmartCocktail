package com.smartCocktails.push.details.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PushDetailsData(
    val id: String? = null,
    val title: String? = "",
    val subtitle: String? = "",
    val contextText: String? = null,
    val enableOrderListRedirect: Boolean? = false,
    val date: String? = null,
    val graphicId: String? = null
):Parcelable