package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() , UserInterface {
    private val menuFragment = MenuFragment()
    private val mainGame = MainGame()
    private val menuFragment2 = MenuFragment2()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuFragment2.newUser = this
        menuFragment2.listener = this
        mainGame.listener = this
        menuFragment.starter = this
        supportFragmentManager.beginTransaction().add(R.id.container,menuFragment).commit()
    }

    override fun start(user: User) {
        mainGame.user = user
        supportFragmentManager.beginTransaction().replace(R.id.container,mainGame).commit()
    }

    override fun end(user: User) {
        menuFragment2.user = user
        supportFragmentManager.beginTransaction().replace(R.id.container,menuFragment2).commit()
    }

    override fun newUser() {
        supportFragmentManager.beginTransaction().replace(R.id.container,menuFragment).commit()
    }
}