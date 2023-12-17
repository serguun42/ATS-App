package ru.serguun42.android.ats

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.serguun42.android.ats.di.ServiceLocator
import ru.serguun42.android.ats.ui.navigation.BottomAppBarNavigation
import ru.serguun42.android.ats.ui.navigation.NavigationGraph
import ru.serguun42.android.ats.ui.theme.ATSTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainAppActivity : ComponentActivity() {

    @Inject
    lateinit var serviceAdapter: ServiceLocator

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val modifier = Modifier

        ServiceLocator.getInstance().init(application)

        setContent {
            ATSTheme {
                Surface(
                    modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    Scaffold(bottomBar = { BottomAppBarNavigation(navController) }, content = {
                        NavigationGraph(navController, modifier)
                    })
                }
            }
        }
    }
}