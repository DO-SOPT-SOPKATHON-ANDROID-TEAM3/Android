package org.sopt.sopkaton_team3.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

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