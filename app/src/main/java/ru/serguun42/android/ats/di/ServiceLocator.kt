package ru.serguun42.android.ats.di

import android.app.Application
import ru.serguun42.android.ats.di.util.isInternetAvailable
import ru.serguun42.android.ats.repository.RepositoryActions
import ru.serguun42.android.ats.repository.mock.MockRepository
import ru.serguun42.android.ats.repository.network.APIRepository
import ru.serguun42.android.ats.repository.room.RoomRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServiceLocator @Inject constructor() {
    private lateinit var context: Application

    private val api: RepositoryActions = APIRepository()
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
            // Enable API repository later
            if (isInternetAvailable(context) && 2 < 1) return api
            return room ?: mock
        }
}