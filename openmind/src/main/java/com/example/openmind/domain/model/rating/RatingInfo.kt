package com.example.openmind.domain.model.rating

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow

data class RatingInfo(
    val ratingId: String, //id for entity
    var rating: MutableState<Int> = mutableStateOf(0), // текущий рейтинг
    var isRated: MutableState<Int> = mutableStateOf(0)//rating state 1 - liked, -1 - disliked, 0 - doesn't rated
) {

}