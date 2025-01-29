package com.example.proyectoandroidcrafters.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.proyectoandroidcrafters.databinding.FragmentSecondBinding
import com.example.proyectoandroidcrafters.utils.FragmentCommunicator
import com.example.proyectoandroidcrafters.viewModel.SignUpViewModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: FragmentCommunicator
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        setupObservers()
        binding.RegisterButton.setOnClickListener {
            viewModel.createUser(binding.EmailEditText.text.toString(),
                binding.PasswordEditText.text.toString()
            )


        }


        return binding.root
    }

    private fun setupObservers() {

        viewModel.loaderState.observe(viewLifecycleOwner) { showLoader ->
            communicator.manageLoader(showLoader)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}