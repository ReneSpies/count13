package co.aresid.count13.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.aresid.count13.R
import timber.log.Timber

class MainActivity: AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {

		Timber.d("onCreate: called")

		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)

	}

}