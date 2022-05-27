package com.example.pokedex.Core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseConcactHolder<T>(itemview:View): RecyclerView.ViewHolder(itemview) {
    abstract fun bind(adapter:T)
}