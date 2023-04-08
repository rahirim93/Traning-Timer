package com.example.traningtimer

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.audiofx.Equalizer.Settings
import android.os.Build
import com.example.traningtimer.database.TrainingDatabase
import com.example.traningtimer.ui.edit.EditFragmentViewModel
import com.example.traningtimer.ui.list.ListFragmentViewModel
import com.example.traningtimer.ui.main.MainViewModelFrag
import com.example.traningtimer.ui.save.SaveFragmentViewModel
import com.example.traningtimer.ui.second.SecondFragmentViewModel
import com.example.traningtimer.ui.settings.SettingsFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val NOTIFICATION_CHANNEL_ID = "trainingApp"

class MyAppApplication: Application() {

    private val koinModule = module {
        single(named("appScope")) { CoroutineScope(SupervisorJob()) }
        single { TrainingDatabase.newInstance(androidContext()) }
        single {
            TrainingRepository(
                get<TrainingDatabase>().getTrainingDao(),
                get(named("appScope")),
                androidContext()
            )
        }
        viewModel { MainViewModel(get()) }
        viewModel { MainViewModelFrag(get()) }
        viewModel { SecondFragmentViewModel(get()) }
        viewModel { SettingsFragmentViewModel(get()) }
        viewModel { SaveFragmentViewModel(get()) }
        viewModel { ListFragmentViewModel(get()) }
        viewModel { EditFragmentViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "myChannelTrainingApp"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance)
            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        startKoin {
            androidLogger()
            androidContext(this@MyAppApplication)
            modules(koinModule)

        }
    }
}