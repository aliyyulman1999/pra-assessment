package org.d3if4070.praasessment.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if4070.praasessment.R
import org.d3if4070.praasessment.databinding.FragmentSegitigaBinding


class SegitigaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding : FragmentSegitigaBinding
    private var luas = 0.0
    private var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_segitiga,container,false)

        binding.btnHitungSegitiga.setOnClickListener{ check() }
        binding.btnShare.setOnClickListener { share() }

        return binding.root
    }
    private fun check(){
        if (binding.edAlas.text.isEmpty() && binding.edTinggi.text.isEmpty()){
            Toast.makeText(activity,"Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }
        else{
            SegitigaFragment()
        }
    }

    private fun share(){
        if (binding.edAlas.text.isEmpty() && binding.edTinggi.text.isEmpty()){
            Toast.makeText(activity,"Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent(Intent.ACTION_SENDTO)
            val subject = "Segitiga"
            val message = """"
                - Alas = ${binding.edAlas.text}
                - Tinggi   = ${binding.edTinggi.text}
                - Luas    = ${binding.tvLuas.text}
                - Keliling= ${binding.tvKeliling.text}
            """.trimIndent()
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(intent)
        }
    }

}
