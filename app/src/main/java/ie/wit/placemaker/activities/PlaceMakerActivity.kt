package ie.wit.placemaker.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ie.wit.placemaker.databinding.ActivityPlacemakerBinding
import ie.wit.placemaker.model.PlacemarkModel
import timber.log.Timber
import timber.log.Timber.i


class PlacemarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlacemakerBinding
    var placemark = PlacemarkModel()
    val placemarks = ArrayList<PlacemarkModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacemakerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        i("Placemark Activity started...")

        binding.btnAdd.setOnClickListener() {
            placemark.title = binding.placemarkTitle.text.toString()
            placemark.description = binding.description.text.toString()
            if (placemark.title.isNotEmpty()) {
                placemarks.add(placemark.copy())
                i("add Button Pressed: ${placemark}")
                for (i in placemarks.indices)
                { i("Placemark[$i]:${this.placemarks[i]}") }
            }
            else {
                Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}