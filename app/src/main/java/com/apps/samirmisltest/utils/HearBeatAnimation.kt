package com.apps.samirmisltest.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.Interpolator
import androidx.core.animation.doOnEnd


object HearBeatAnimation {
    var ANTICIPATE: Interpolator = AnticipateInterpolator(2.8f)

    fun animateHeartBeat(view: View?) {
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.1f)
        scaleX.interpolator = ANTICIPATE
        scaleX.repeatCount = 1
        scaleX.repeatMode = ValueAnimator.REVERSE
        scaleX.duration = 400.toLong()
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.1f)
        scaleY.interpolator = ANTICIPATE
        scaleY.repeatCount = 1
        scaleY.repeatMode = ValueAnimator.REVERSE
        scaleY.duration = 400.toLong()
        val set1 = AnimatorSet()
        set1.playTogether(scaleX, scaleY)
        val set2 = AnimatorSet()
        set2.playTogether(scaleX, scaleY)
        val animSet = AnimatorSet()
        animSet.playSequentially(set1, set2)
        animSet.doOnEnd { animSet.start() }
        animSet.start()
    }
}
