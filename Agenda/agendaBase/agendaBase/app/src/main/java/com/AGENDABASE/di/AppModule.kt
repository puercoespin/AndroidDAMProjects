package com.AGENDABASE.di

import com.AGENDABASE.data.ContactoRepository
import com.AGENDABASE.data.mocks.contacto.ContactoDaoMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideContactoRepositoryDaoMock() : ContactoDaoMock = ContactoDaoMock()

    @Provides
    @Singleton
    fun provideContactoRepository(
        contactoDaoMock: ContactoDaoMock
    ):ContactoRepository = ContactoRepository()


}