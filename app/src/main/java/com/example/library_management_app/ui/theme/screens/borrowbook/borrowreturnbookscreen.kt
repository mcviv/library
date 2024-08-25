package com.example.library_management_app.ui.theme.screens.borrowbook

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.library_management_app.data.borrowedBooks

@Composable
fun BorrowedBook( navController: NavController) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(borrowedBooks) { borrowedBook ->
            Text(
                text = "${borrowedBook.book.title} by ${borrowedBook.book.author}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text("Borrower: ${borrowedBook.borrower}", style = MaterialTheme.typography.bodyMedium)
            Text("Return Date: ${borrowedBook.returnDate}", style = MaterialTheme.typography.bodyMedium)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}
