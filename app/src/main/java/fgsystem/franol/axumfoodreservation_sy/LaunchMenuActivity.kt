package fgsystem.franol.axumfoodreservation_sy

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fgsystem.franol.axumfoodreservation_sy.FoodMenu

class LaunchMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }

        if(savedInstanceState == null) {
            val detailFragment = LaunchMenuDetail()
            detailFragment.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content,detailFragment) // android.R.id.content gives you the root view of your activity
                .commit()
        }
    }
}