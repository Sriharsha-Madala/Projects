package edu.ucsc.cse118.assignment3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import edu.ucsc.cse118.assignment3.model.SharedViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
//  private val sharedViewModel: SharedViewModel by viewModels()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

//    sharedViewModel.loadFrom(resources.openRawResource(R.raw.workspaces))

    val navHostFragment = supportFragmentManager
      .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController

    setupActionBarWithNavController(navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    val navController = NavHostFragment.findNavController(supportFragmentManager
      .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    )
    return navController.navigateUp() || super.onSupportNavigateUp()
  }
}