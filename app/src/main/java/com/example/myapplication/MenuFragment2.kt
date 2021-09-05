package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MenuFragment2 : Fragment() {
    var user: User? = null
    var listener: UserInterface? = null
    var newUser: UserInterface? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val score1 = view.findViewById<TextView>(R.id.score1)
        val score2 = view.findViewById<TextView>(R.id.score2)
        val player1 = view.findViewById<TextView>(R.id.player1)
        val player2 = view.findViewById<TextView>(R.id.player2)

        val button = view.findViewById<Button>(R.id.button)
        val userBtn = view.findViewById<Button>(R.id.new_user)

        score1.text = user?.n1.toString()
        score2.text = user?.n2.toString()
        user?.let {
            player1.text = it.player1
            player2.text = it.player2
        }
        button.setOnClickListener {
            user?.let { it1 -> listener?.start(it1) }
        }
        userBtn.setOnClickListener {
            newUser?.newUser()
        }
    }
}