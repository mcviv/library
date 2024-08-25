package com.example.library_management_app.models


class Book(val title: String, val author: String)
{
    data class BorrowedBook(
        val title: String,
        val author: String,
        val borrower: String,
        val returnDate: String
    )

}
