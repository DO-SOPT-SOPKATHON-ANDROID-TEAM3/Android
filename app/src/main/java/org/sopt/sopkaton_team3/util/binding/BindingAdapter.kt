package org.sopt.sopkaton_team3.util.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.sopkaton_team3.R

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    if (imageUrl == null) {
        return
    } else {
        load(imageUrl) {
            transformations(RoundedCornersTransformation(10F))
        }
    }
}