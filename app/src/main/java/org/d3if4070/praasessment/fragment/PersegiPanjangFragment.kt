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
import org.d3if4070.praasessment.R
import org.d3if4070.praasessment.databinding.FragmentPersegiPanjangBinding
import org.d3if4070.praasessment.databinding.FragmentSegitigaBinding


class PersegiPanjangFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding : FragmentPersegiPanjangBinding
    private var luas = 0.0
    private var keliling = 0.0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_persegi_panjang,container,false)

        binding.btnHitungPersegi.setOnClickListener{ check() }
        binding.btnShare.setOnClickListener { share() }


        return binding.root
    }

    private fun check(){
        if (binding.edAngka01.text.isEmpty() && binding.edAngka02.text.isEmpty()){
            Toast.makeText(activity,"Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }
        else{
            persegiPanjang()
        }
    }

    private fun share(){
        if (binding.edAngka01.text.isEmpty() && binding.edAngka02.text.isEmpty()){
            Toast.makeText(activity,"Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent(Intent.ACTION_SENDTO)
            val subject = "Persegi Panjang"
            val message = """"
                - Panjang = ${binding.edAngka01.text}
                - Lebar   = ${binding.edAngka02.text}
                - Luas    = ${binding.tvLuas.text}
                - Keliling= ${binding.tvKeliling.text}
            """.trimIndent()
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(intent)
        }
    }

    private fun persegiPanjang(){
        luas = binding.edAngka01.text.toString().toDouble() * binding.edAngka02.text.toString().toDouble()
        binding.tvKeliling.visibility = View.VISIBLE
        binding.tvLuas.text = "$luas"
        keliling = 2 * (binding.edAngka01.text.toString().toDouble() + binding.edAngka02.text.toString().toDouble())
        binding.tvLuas.visibility = View.VISIBLE
        binding.tvKeliling.text = "$keliling"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("Luas", luas)
        outState.putDouble("Keliling", keliling)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            keliling = savedInstanceState.getDouble("Keliling")
            luas = savedInstanceState.getDouble("Luas")
            binding.tvKeliling.text = "$keliling"
            binding.tvLuas.text = "$luas"
            binding.tvKeliling.visibility = View.VISIBLE
            binding.tvLuas.visibility = View.VISIBLE
        }
        super.onViewStateRestored(savedInstanceState)
    }
    }


