package org.sopt.sopkaton_team3.util.activity

import android.app.Activity
import android.view.View
import org.sopt.sopkaton_team3.util.context.hideKeyboard

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}