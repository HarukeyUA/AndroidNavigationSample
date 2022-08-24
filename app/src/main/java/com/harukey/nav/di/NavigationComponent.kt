package com.harukey.nav.di

import com.harukey.nav.utils.NavigationDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainNavHostNavDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BottomNavHostDispatcher

@InstallIn(ActivityRetainedComponent::class)
@Module
object NavigationComponent {

    @MainNavHostNavDispatcher
    @Provides
    @ActivityRetainedScoped
    fun provideMainNavHostDispatcher(): NavigationDispatcher {
        return NavigationDispatcher()
    }

    @BottomNavHostDispatcher
    @Provides
    @ActivityRetainedScoped
    fun provideBottomNavHostDispatcher(): NavigationDispatcher {
        return NavigationDispatcher()
    }
}
