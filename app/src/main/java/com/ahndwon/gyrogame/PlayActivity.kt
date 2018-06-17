package com.ahndwon.gyrogame

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ahndwon.gyrogame.models.Gyro
import processing.core.PApplet
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import android.view.WindowManager
import android.view.Window.FEATURE_NO_TITLE
import processing.android.PFragment
import processing.android.CompatUtils
import android.content.Intent







class PlayActivity : AppCompatActivity() {

    lateinit var fragment: PApplet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_play)
        val frame = FrameLayout(this)
        frame.id = CompatUtils.getUniqueViewId()
        setContentView(frame, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT))

        fragment = Processing(this)
        val fragment = PFragment(fragment)
        fragment.setView(frame, this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (fragment != null) {
            fragment.onRequestPermissionsResult(
                    requestCode, permissions, grantResults)
        }
    }

    public override fun onNewIntent(intent: Intent) {
        if (fragment != null) {
            fragment.onNewIntent(intent)
        }
    }
}
