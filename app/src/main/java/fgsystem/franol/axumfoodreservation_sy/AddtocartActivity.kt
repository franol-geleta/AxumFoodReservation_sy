package fgsystem.franol.axumfoodreservation_sy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import fgsystem.franol.axumfoodreservation_sy.data.Addtocart
import kotlinx.android.synthetic.main.activity_addtocart.*

class AddtocartActivity : AppCompatActivity() {

    private lateinit var addtocartButton: Button
    private lateinit var nameoffood: EditText
    private lateinit var priceoffood: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtocart)


        addtocartButton = addtocart_button
        nameoffood = name_detial_activity
        priceoffood = price_detail_activity


        addtocartButton.setOnClickListener {

            val food = readFields()
            val replayFoodIntent = Intent()
            replayFoodIntent.putExtra("FOOD", food)
            setResult(Activity.RESULT_OK, replayFoodIntent)
            finish()

        }


    }
    private fun readFields() = Addtocart(
        nameoffood.text.toString(),
        priceoffood.text.toString()
    )
}
