package com.login_v3_4.di

import com.login_v3_4.data.UsuarioRepository
import com.login_v3_4.data.mocks.usuario.UsuarioDaoMock
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
    fun provideUsuarioDaoMock() : UsuarioDaoMock = UsuarioDaoMock()


    @Provides
    @Singleton
    fun provideUsuarioRepository(
        UsuarioDaoMock : UsuarioDaoMock
    ) : UsuarioRepository = UsuarioRepository(UsuarioDaoMock)

}