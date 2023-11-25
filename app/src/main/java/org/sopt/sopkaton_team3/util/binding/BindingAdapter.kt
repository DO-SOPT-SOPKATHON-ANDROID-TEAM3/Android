package org.sopt.sopkaton_team3.util.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import coil.load
import coil.transform.RoundedCornersTransformation
import com.mikhaellopez.circularprogressbar.CircularProgressBar

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

@BindingAdapter("left", "max")
fun TextView.setLeftPeople(left: Long, max: Float) {
    text = String.format("%d / %.0f", left, max)
}

@BindingAdapter("app:cpb_progress_max")
fun setCircularProgressBarMax(circularProgressBar: CircularProgressBar, max: LiveData<Float>) {
    circularProgressBar.progressMax = max.value?.toFloat() ?: 0f
}
