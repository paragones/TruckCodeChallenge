package com.aragones.paul.truck.component

import com.aragones.paul.truck.modules.*
import com.aragones.paul.truck.ui.dialog.DialogActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class,
        ExecutorsModule::class,
        InteractorModule::class,
        NetworkModule::class,
        RepositoryModule::class))
interface ActivitiesComponent {
    fun inject(activity: DialogActivity)
}