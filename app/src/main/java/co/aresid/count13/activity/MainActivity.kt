package co.aresid.count13.activity

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import co.aresid.count13.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity: AppCompatActivity() {

    // Binding for the layout
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.d("onCreate: called")

        // TODO: 12/12/2020 onCreate: Create and add a SplashScreen

        super.onCreate(savedInstanceState)

        // Define the binding and inflate the layout
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        // Set the inflated layout
        setContentView(binding.root)

    }

}