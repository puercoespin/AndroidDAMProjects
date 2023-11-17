package com.pmdm.recetas.di

import com.pmdm.recetas.data.RecipeRepository
import com.pmdm.recetas.data.mocks.RecipeDaoMock
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
    fun provideRecipeDaoMock() : RecipeDaoMock = RecipeDaoMock()

    @Provides
    @Singleton
    fun provideRecipeRepository(
        modeloDaoMock : RecipeDaoMock // Es inyectado por provideModeloDaoMock()
    ) : RecipeRepository = RecipeRepository(modeloDaoMock)
}