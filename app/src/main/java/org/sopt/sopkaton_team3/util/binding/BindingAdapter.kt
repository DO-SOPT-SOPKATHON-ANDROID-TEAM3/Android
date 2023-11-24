package org.sopt.sopkaton_team3.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.sopkaton_team3.R

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    if (imageUrl == null) {
        load(R.color.white)
    } else {
        load(imageUrl) {
            placeholder(R.color.white)
            transformations(RoundedCornersTransformation(10F))
        }
    }
}