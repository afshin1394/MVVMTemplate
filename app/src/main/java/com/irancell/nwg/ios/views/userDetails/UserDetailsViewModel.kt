package com.irancell.nwg.ios.views.userDetails

import androidx.databinding.ObservableParcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.irancell.nwg.ios.domain.UserDetails
import com.irancell.nwg.ios.repository.UserDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val userDetailsRepository: UserDetailsRepository
) : ViewModel() {

    val userDetails = ObservableParcelable(UserDetails())

    fun getUserDetails(user: String) = runBlocking {   userDetailsRepository.getUserDetails(user) }
    fun refreshUserDetails(user: String) = viewModelScope.launch {
        userDetailsRepository.refreshUserDetails(user)
    }

}