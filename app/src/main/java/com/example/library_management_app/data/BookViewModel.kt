package com.example.library_management_app.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

import com.example.library_management_app.models.Book

class BookViewModel : ViewModel() {

    private val _books = mutableStateListOf<Book>()
    val books: List<Book> get() = _books

    fun addBook(title: String, author: String) {
        _books.add(Book(title))
    }
}


class borrowedBooks : ViewModel() {
    private val _borrowedBooks = mutableStateListOf<Book.BorrowedBook>()
    val borrowedBooks: List<Book.BorrowedBook> get() = _borrowedBooks

    fun addBorrowedBook(title: String, author: String, borrower: String, returnDate: String) {
        _borrowedBooks.add(Book.BorrowedBook(title, author, borrower, returnDate))
    }
}





