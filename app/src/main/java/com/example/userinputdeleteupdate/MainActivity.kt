package com.example.userinputdeleteupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userinputdeleteupdate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.RVUsers.adapter = UsersAdapter(
            mutableListOf<User>()
        ).apply {

            binding.BTNAddbutton.setOnClickListener {

                usersList.add(
                    User(
                        binding.ETEnterEmail.text.toString(),
                        binding.ETEnterLastname.text.toString(),
                        binding.ETEnterFirstname.text.toString()
                    )
                )
                notifyDataSetChanged()

                setOnDeleteClickListener { user: User, i: Int ->
                    usersList.remove(user)
                    notifyDataSetChanged()


                    Toast.makeText(
                        this@MainActivity,
                        "${binding.ETEnterFirstname.text.toString()} deleted",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }
}

