//package com.example.library_management_app.repository
//
//import com.example.library_management_app.models.Book
//
//import com.example.library_management_app.models.User
//
//class BookRepository {
//    private val books = mutableListOf<Book>()
//
//    fun addBook(book: Book) = books.add(book)
//
//    fun getAllBooks(): List<Book> = books
//
//    fun updateBook(updatedBook: Book) {
//        val index = books.indexOfFirst { it.id == updatedBook.id }
//        if (index != -1) {
//            books[index] = updatedBook
//        }
//    }
//
//    fun deleteBook(bookId: String) {
//        books.removeIf { it.id == bookId }
//    }
//}
//
//class UserRepository {
//    private val users = mutableListOf<User>()
//
//    fun addUser(user: User) = users.add(user)
//
//    fun getAllUsers(): List<User> = users
//
//    fun updateUser(updatedUser: User) {
//        val index = users.indexOfFirst { it.id == updatedUser.id }
//        if (index != -1) {
//            users[index] = updatedUser
//        }
//    }
//
//    fun deleteUser(userId: String) {
//        users.removeIf { it.id == userId }
//    }
//}
