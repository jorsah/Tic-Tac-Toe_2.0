package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class MenuFragment:Fragment() {

    var starter:UserInterface? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p1et = view.findViewById<EditText>(R.id.p1et)
        val p2et = view.findViewById<EditText>(R.id.p2et)

        val score1 = view.findViewById<TextView>(R.id.score1)
        val score2 = view.findViewById<TextView>(R.id.score2)
        val player1 = view.findViewById<TextView>(R.id.player1)
        val player2 = view.findViewById<TextView>(R.id.player2)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val user = User(player1 = p1et.text.toString(),player2 = p2et.text.toString())
            p1et.setText("")
            p2et.setText("")
            starter?.start(user)
        }
    }
}

