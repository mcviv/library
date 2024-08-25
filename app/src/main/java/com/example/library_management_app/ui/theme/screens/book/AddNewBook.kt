package com.example.library_management_app.ui.theme.screens.book

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.library_management_app.data.BookViewModel

@Composable
fun AddBook(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Add a Book", style = MaterialTheme.typography.bodyMedium)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { androidx.compose.material3.Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { androidx.compose.material3.Text("Author") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            BookViewModel.addBook(title, author)
            title = ""
            author = ""
        }) {
            androidx.compose.material3.Text("Add Book")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Book List", style = MaterialTheme.typography.bodyMedium)
        LazyColumn {
            items(BookViewModel.books) { book ->
                Text("${book.title} by ${book.author}")
                Divider()
            }
    }
}


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddBookPreview() {
    AddBook(rememberNavController())
}
