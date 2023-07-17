package com.example.dinamik_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.dinamik_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            val firstFragment = FistFragment()
            val secondFragment = SecondFragment()

            val fragmentManager = supportFragmentManager

            btnAdd.setOnClickListener {

                fragmentManager.beginTransaction().add(R.id.first_conteiner,firstFragment)
                    .commit()
                Toast.makeText(this@MainActivity, "Yangi fragment yaratildi", Toast.LENGTH_SHORT).show()
            }

            btnDelete.setOnClickListener {
                fragmentManager.beginTransaction().remove(firstFragment)
                    .commit()
                Toast.makeText(this@MainActivity, "Fragment o'chirildi", Toast.LENGTH_SHORT).show()
            }

            btnReplace.setOnClickListener {
                fragmentManager.beginTransaction().replace(R.id.first_conteiner,secondFragment)
                    .commit()
                Toast.makeText(this@MainActivity, "Boshqa fragmentga o'zgartirildi", Toast.LENGTH_SHORT).show()
            }
            btnHide.setOnClickListener {
                fragmentManager.beginTransaction().hide(firstFragment).commit()
                fragmentManager.beginTransaction().hide(secondFragment).commit()
            }
            btnShow.setOnClickListener {
                fragmentManager.beginTransaction().show(firstFragment).commit()
                fragmentManager.beginTransaction().show(secondFragment).commit()

            }
        }
    }
}