package com.example.androidmonth6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.androidmonth6.R
import com.example.androidmonth6.databinding.FragmentFirstBinding
import com.example.androidmonth6.ui.CharactersViewModel
import com.example.androidmonth6.utils.Resource
import androidx.navigation.fragment.findNavController
import androidx.core.os.bundleOf

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[CharactersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnConfirm.setOnClickListener {
            val name = binding.etGetName.text.toString().trim()
            if (name.isNotEmpty()) {
                viewModel.getCharacterByName(name).observe(viewLifecycleOwner) { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Error -> {
                            Toast.makeText(requireContext(), resource.message, Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Success -> {
                            val character = resource.data.firstOrNull()
                            character?.let {
                                val bundle = bundleOf("characterSC" to it)
                                findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Please enter a name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
