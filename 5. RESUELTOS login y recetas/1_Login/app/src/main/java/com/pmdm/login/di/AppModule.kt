package com.pmdm.login.di

import com.pmdm.login.data.UsuarioRepository
import com.pmdm.login.data.mocks.usuario.UsuarioDaoMock
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
    fun provideUsuarioDaoMock():UsuarioDaoMock= UsuarioDaoMock()

    @Provides
    @Singleton
    fun provideUsuarioRepository(
        usuarioDaoMock: UsuarioDaoMock
    ): UsuarioRepository =
        UsuarioRepository(usuarioDaoMock)

}