package com.example.authentication

import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.authentication.data.db
import kotlinx.android.synthetic.main.fragment_login.*

class Login : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_login.setOnClickListener {
            if((mpin.text.toString())== db.mpin)
            findNavController().navigate(R.id.action_login_to_dashboard);
            else
                Toast.makeText(context,"Invalid MPIN",Toast.LENGTH_SHORT).show()

        }

        }

    override fun onStart() {
        super.onStart()

    }
    }