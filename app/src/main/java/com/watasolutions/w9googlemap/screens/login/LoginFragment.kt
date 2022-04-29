package com.watasolutions.w9googlemap.screens.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.facebook.CallbackManager
import com.watasolutions.w9googlemap.databinding.FragmentLoginBinding
import java.util.*
import com.facebook.FacebookException

import com.facebook.login.LoginResult

import com.facebook.FacebookCallback





/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var model: LoginViewModel

    private val EMAIL = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val callbackManager = CallbackManager.Factory.create()
        val loginButton = binding.loginButton
        loginButton.setPermissions(Arrays.asList(EMAIL))
        loginButton.setFragment(this)
        // Callback registration
        // Callback registration
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) {
                // App code
                Log.e("success", loginResult.toString())
            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }


        })
    }

}