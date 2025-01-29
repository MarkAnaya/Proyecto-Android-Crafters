package com.example.proyectoandroidcrafters.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.proyectoandroidcrafters.databinding.ActivityLoginOrRegisterBinding
import com.example.proyectoandroidcrafters.utils.FragmentCommunicator

class LoginOrRegister : AppCompatActivity(), FragmentCommunicator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLoginOrRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginOrRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun manageLoader(isVisible: Boolean) {
        if (isVisible) {
            binding.loaderView.visibility = View.VISIBLE
        } else {
            binding.loaderView.visibility = View.GONE
        }
        // binding.loaderView.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

}