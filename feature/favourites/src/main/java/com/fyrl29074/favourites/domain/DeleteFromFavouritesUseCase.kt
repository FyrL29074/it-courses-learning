package com.fyrl29074.favourites.domain

class DeleteFromFavouritesUseCase(
    private val coursesRepository: FavouritesRepository,
) {

    suspend fun execute(id: Int) {
        coursesRepository.deleteFromFavourites(id)
    }
}