package ru.serguun42.android.ats.di

import android.app.Application
import ru.serguun42.android.ats.repository.RepositoryActions
import ru.serguun42.android.ats.repository.mock.MockRepository
import ru.serguun42.android.ats.repository.room.RoomRepository

class ServiceLocator {
    private lateinit var context: Application

    // val api: RepositoryActions = APIRepository()
    private val mock: RepositoryActions = MockRepository()
    private var room: RepositoryActions? = null

    companion object {
        @Volatile
        private var instance: ServiceLocator? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: ServiceLocator().also { instance = it }
        }
    }

    fun init(app: Application) {
        context = app
        room = RoomRepository(app)
    }

    val repository: RepositoryActions
        get() {
//            if (isInternetAvailable(context)) Toast.makeText(
//                context, "Internet is available", Toast.LENGTH_SHORT
//            ).show() else Toast.makeText(
//                context, "NO Internet ☹", Toast.LENGTH_SHORT
//            ).show()

            // if (isNetworkAvailable) return api
            return room ?: mock
        }
}