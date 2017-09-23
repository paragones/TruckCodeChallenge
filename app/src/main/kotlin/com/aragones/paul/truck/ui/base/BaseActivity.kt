package com.aragones.paul.truck.ui.base

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.aragones.paul.truck.R
import com.aragones.paul.truck.component.ActivitiesComponent
import com.aragones.paul.truck.component.DaggerActivitiesComponent
import com.aragones.paul.truck.modules.*

abstract class BaseActivity : AppCompatActivity() {

    protected fun component(): ActivitiesComponent {
        return DaggerActivitiesComponent.builder()
                .applicationModule(ApplicationModule(application))
                .executorsModule(ExecutorsModule())
                .interactorModule(InteractorModule())
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .build()
    }
}