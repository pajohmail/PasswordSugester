package com.example.passwordsugester

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.passwordsugester.ui.theme.PasswordSugesterTheme

/**
 * Main activity for the Password Suggester application.
 * This activity sets up the UI and binds the ViewModel.
 */
class MainActivity : ComponentActivity() {
    // ViewModel instance for managing password generation logic
    private val passwordViewModel: PasswordViewModel by viewModels()

    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     * this contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordSugesterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PasswordScreen(
                        passwordViewModel = passwordViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}