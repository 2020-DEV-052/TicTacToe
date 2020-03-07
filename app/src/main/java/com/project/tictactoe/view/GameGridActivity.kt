package com.project.tictactoe.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.tictactoe.R
import com.project.tictactoe.databinding.ActivityGridBinding
import com.project.tictactoe.model.Player
import com.project.tictactoe.viewmodel.GameGridViewModel

class GameGridActivity : AppCompatActivity() {

    private lateinit var viewModel: GameGridViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startGame()
    }

    private fun startGame() {
        val activityGridBinding: ActivityGridBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_grid)

        viewModel = ViewModelProvider(this).get(GameGridViewModel::class.java)
        viewModel.initializeGame()
        activityGridBinding.viewModel = viewModel
        viewModel.getWinner().observe(this, Observer<Player> {  })

    }

}
