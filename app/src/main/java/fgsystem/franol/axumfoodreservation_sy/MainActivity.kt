package fgsystem.franol.axumfoodreservation_sy

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import fgsystem.franol.axumfoodreservation_sy.data.Launch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,LaunchMenu.OnFoodSelected {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        displayScreen(-1)
    }

    override  fun OnFoodSelected(launch: Launch){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            val launchMenuActivity = Intent(this, LaunchMenuActivity::class.java)
            launchMenuActivity.putExtra("launch",launch)
            startActivity(launchMenuActivity)

        }
    }

      fun OnAddtoChartSelected(launch: Launch){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            val launchMenuActivity = Intent(this, LaunchMenuActivity::class.java)
            launchMenuActivity.putExtra("launch",launch)
            startActivity(launchMenuActivity)

        }
    }




    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        val id = item.itemId


        if (id == R.id.action_settings) {


            val h = Intent(this, Addtocartmain::class.java)
            startActivity(h)
        }

        return  super.onOptionsItemSelected(item)
    }

    fun displayScreen(id: Int){
        val fragment = when(id){
            R.id.nav_home -> {
                FoodMenu()
            }

            else -> {
                Main_Page()
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.relativelayout, fragment)
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
