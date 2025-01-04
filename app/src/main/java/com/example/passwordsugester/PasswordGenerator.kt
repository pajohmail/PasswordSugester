package com.example.passwordsugester

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A class responsible for generating passwords by making network requests to an external API.
 */
class PasswordGenerator {

    private val client = OkHttpClient()

    /**
     * Suspends the current coroutine, makes a network request to generate a password, and returns the result.
     *
     * @param length The desired length of the generated password.
     * @return A string containing the generated password or an error message if the request fails.
     */
    suspend fun getSuggestedPassword(length: Int): String {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://api.api-ninjas.com/v1/passwordgenerator?length=$length")
                .addHeader("X-Api-Key", "Ej1nILWaPIak5S6fp5IMCg==YSUuVB9ZaxF1vlb3")
                .build()

            try {
                val response: Response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    response.body?.string() ?: "Error: Empty response body"
                } else {
                    "Error: Request failed with code ${response.code}"
                }
            } catch (e: Exception) {
                e.printStackTrace()
                "Error: Exception during request - ${e.message}"
            }
        }
    }
}