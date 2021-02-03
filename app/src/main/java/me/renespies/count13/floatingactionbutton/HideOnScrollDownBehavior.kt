package me.renespies.count13.floatingactionbutton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import timber.log.Timber


/**
 *    Created on: 2 Feb 2021
 *    For Project: count13
 *    Author: René Jörg Spies
 *    Copyright: © 2021 René Jörg Spies
 */


class HideOnScrollDownBehavior : FloatingActionButton.Behavior {

    constructor() : super()
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {

        Timber.d("onStartNestedScroll: called")

        return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(
            coordinatorLayout,
            child,
            directTargetChild,
            target,
            axes,
            type
        )

    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {

        Timber.d("onNestedScroll: called")

        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )

        if (dyConsumed > 0 && child.visibility == View.VISIBLE) {

            child.hide(object : FloatingActionButton.OnVisibilityChangedListener() {

                override fun onHidden(fab: FloatingActionButton?) {

                    Timber.d("onHidden: called")

                    super.onHidden(fab)

                    fab?.visibility = View.INVISIBLE

                }

            })

        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {

            child.show()

        }

    }

}