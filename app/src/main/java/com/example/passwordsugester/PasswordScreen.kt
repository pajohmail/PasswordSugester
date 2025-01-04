package com.example.passwordsugester

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordsugester.ui.theme.PasswordSugesterTheme
import com.example.passwordsugester.PasswordViewModel

/**
 * Composable function that displays the password generation screen.
 *
 * @param passwordViewModel The ViewModel that manages the password generation logic.
 * @param modifier Modifier to be applied to the Scaffold.
 */
@Composable
fun PasswordScreen(passwordViewModel: PasswordViewModel, modifier: Modifier = Modifier) {
    val password by passwordViewModel.password.observeAsState("")

    Scaffold(modifier = modifier) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            TextField(
                value = password,
                onValueChange = { /* No-op */ },
                label = { Text("Generated Password") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { passwordViewModel.generatePassword() }) {
                Text("Generate Password")
            }
        }
    }
}

/**
 * Preview function for the PasswordScreen composable.
 */
@Preview(showBackground = true)
@Composable
fun PasswordScreenPreview() {
    val passwordViewModel = PasswordViewModel()
    PasswordSugesterTheme {
        PasswordScreen(passwordViewModel)
    }
}