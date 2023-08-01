package com.esj.navapp


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.esj.navapp.databinding.FragmentEmailBinding

/**
 * A simple [Fragment] subclass.
 */
class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        val name = arguments?.getString("input_text")
        binding.submitButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.emailEditText.text.toString())){
                val bundle: Bundle = bundleOf("email_input" to binding.emailEditText.text.toString(),
                    "input_name" to name)
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)

            }else{
                Toast.makeText(activity, "Email cannot be empty", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}
