package org.sopt.sopkaton_team3.util.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

inline fun <reified T : Activity> AppCompatActivity.startActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}