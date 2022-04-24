package com.pdge.pramod.repository

import com.pdge.pramod.model.User

data class UserResponse(
    val error: Boolean,
    val users: List<User>
)

