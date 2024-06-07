package com.example.androidmonth6.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.androidmonth6.data.model.Character
import com.example.androidmonth6.databinding.FragmentSecondBinding
import com.example.androidmonth6.ui.CharactersViewModel
import com.example.androidmonth6.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private var g = 0
    private val viewModel: CharactersViewModel by viewModel()
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = args.characterSC
        bindCharacterData(character)
        expand()
    }

    private fun bindCharacterData(character: Character) {
        binding.apply {
            tvName.text = character.name
            tvStatus.text = character.status
            tvRace.text = character.species
            tvGender.text = character.gender
        }
    }

    private fun expand() {
        binding.expandable.setOnClickListener {
            if (g == 0) {
                g = 1
                binding.expandable.expand()
            } else {
                g = 0
                binding.expandable.collapse()
            }
        }
        binding.expandable2.setOnClickListener {
            if (g == 0) {
                g = 1
                binding.expandable2.expand()
            } else {
                g = 0
                binding.expandable2.collapse()
            }
        }
        binding.expandable3.setOnClickListener {
            if (g == 0) {
                g = 1
                binding.expandable3.expand()
            } else {
                g = 0
                binding.expandable3.collapse()
            }
        }
    }
}
