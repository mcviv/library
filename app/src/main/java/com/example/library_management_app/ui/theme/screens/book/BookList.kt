package com.example.library_management_app.ui.theme.screens.book

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.library_management_app.data.BookViewModel
import com.example.library_management_app.data.borrowedBooks
import com.example.library_management_app.models.Book

@Composable
fun BookList( navController: NavController) {
    var showBorrowDialog by remember { mutableStateOf(false) }
    var selectedBook by remember { mutableStateOf<Book?>(null) }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(BookViewModel.books.filter { !it.isBorrowed }) { book ->
            Text(
                text = "${book.title} by ${book.author}",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        selectedBook = book
                        showBorrowDialog = true
                    }
                    .padding(8.dp),
//                style = MaterialTheme.typography.body1
            )
//            Divider()
        }
    }

    if (showBorrowDialog) {
        selectedBook?.let { book ->
            BorrowDialog(
                book = book,
                onBorrow = { borrower, returnDate ->
                    borrowedBooks(book, borrower, returnDate)
                    showBorrowDialog = false
                },
                onDismiss = { showBorrowDialog = false }
            )
        }
    }
}

@Composable
fun BorrowDialog(book: Book, onBorrow: (String, String) -> Unit, onDismiss: () -> Unit) {
    var borrower by remember { mutableStateOf("") }
    var returnDate by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Borrow ${book.title}") },
        text = {
            Column {
                OutlinedTextField(
                    value = borrower,
                    onValueChange = { borrower = it },
                    label = { Text("Borrower Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = returnDate,
                    onValueChange = { returnDate = it },
                    label = { Text("Return Date") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                if (borrower.isNotEmpty() && returnDate.isNotEmpty()) {
                    onBorrow(borrower, returnDate)
                }
            }) {
                Text("Confirm Borrow")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BookListPreview() {
    BookList(rememberNavController())
}
