package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainGame : Fragment() {
    var user: User? = null
    var listener: UserInterface? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p1 = view.findViewById<TextView>(R.id.player_1)
        val p2 = view.findViewById<TextView>(R.id.player_2)
        val sc1 = view.findViewById<TextView>(R.id.score_1)
        val sc2 = view.findViewById<TextView>(R.id.score_2)

        val b1 = view.findViewById<Button>(R.id.b1)
        val b2 = view.findViewById<Button>(R.id.b2)
        val b3 = view.findViewById<Button>(R.id.b3)
        val b4 = view.findViewById<Button>(R.id.b4)
        val b5 = view.findViewById<Button>(R.id.b5)
        val b6 = view.findViewById<Button>(R.id.b6)
        val b7 = view.findViewById<Button>(R.id.b7)
        val b8 = view.findViewById<Button>(R.id.b8)
        val b9 = view.findViewById<Button>(R.id.b9)

        sc1.text = user?.n1.toString()
        sc2.text = user?.n2.toString()
        user?.let {
            p1.text = it.player1
            p2.text = it.player2
        }

        var click = 0

        val listX = mutableListOf<Int>()
        val listO = mutableListOf<Int>()
        val winLists = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(3, 6, 9),
            listOf(3, 5, 7),
            listOf(1, 5, 9)
        )

        fun xWinCheck(): Boolean {
            return listX.containsAll(winLists[0]) || listX.containsAll(winLists[1]) || listX.containsAll(
                winLists[2]
            ) || listX.containsAll(winLists[3]) ||
                    listX.containsAll(winLists[4]) || listX.containsAll(winLists[5]) || listX.containsAll(
                winLists[6]
            ) || listX.containsAll(winLists[7])
        }

        fun oWinCheck(): Boolean {
            return listO.containsAll(winLists[0]) || listO.containsAll(winLists[1]) || listO.containsAll(
                winLists[2]
            ) || listO.containsAll(winLists[3]) ||
                    listO.containsAll(winLists[4]) || listO.containsAll(winLists[5]) || listO.containsAll(
                winLists[6]
            ) || listO.containsAll(winLists[7])
        }

        fun buttonClicked(clk: Int, slot: Int, button: Button) {
            if (clk % 2 == 1) {
                listX.add(slot)
                button.setTextColor(R.color.red)
                button.text = "X"
            } else {
                listO.add(slot)
                button.text = "O"
                button.setTextColor(R.color.blue)
            }
            if (xWinCheck()) {
                sc1.text = "${sc1.text.toString().toInt() + 1}"
                user?.n1 = sc1.text.toString().toInt()
                user?.let { it1 -> listener?.end(it1) }


            }
            if (oWinCheck()) {
                sc2.text = "${sc2.text.toString().toInt() + 1}"
                user?.n2 = sc2.text.toString().toInt()
                user?.let { it1 -> listener?.end(it1) }

            }
            if (clk == 9) {
                user?.let { it1 -> listener?.end(it1) }
            }
            button.isClickable = false
        }

        b1.setOnClickListener {
            ++click
            buttonClicked(click, 1, b1)
        }
        b2.setOnClickListener {
            ++click
            buttonClicked(click, 2, b2)
        }
        b3.setOnClickListener {
            ++click
            buttonClicked(click, 3, b3)
        }
        b4.setOnClickListener {
            ++click
            buttonClicked(click, 4, b4)
        }
        b5.setOnClickListener {
            ++click
            buttonClicked(click, 5, b5)
        }
        b6.setOnClickListener {
            ++click
            buttonClicked(click, 6, b6)
        }
        b7.setOnClickListener {
            ++click
            buttonClicked(click, 7, b7)
        }
        b8.setOnClickListener {
            ++click
            buttonClicked(click, 8, b8)
        }
        b9.setOnClickListener {
            ++click
            buttonClicked(click, 9, b9)
        }
    }
}