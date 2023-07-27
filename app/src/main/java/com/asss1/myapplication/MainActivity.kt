package com.asss1.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.asss1.myapplication.chess.ChessDelegate
import com.asss1.myapplication.chess.ChessModel
import com.asss1.myapplication.chess.ChessPiece
import com.asss1.myapplication.chess.ChessView

private const val TAG = "TESTAAAAA"
/*
MVC : Model View Controller
 */

class MainActivity : AppCompatActivity(), ChessDelegate {
    var chessModel = ChessModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d(TAG , "$chessModel")
        val chessView = findViewById<ChessView>(R.id.chess_view)
        chessView.chessDelegate = this


    }

    override fun pieceAt(col: Int , row: Int): ChessPiece? {
        return chessModel.pieceAt(col,row)
    }
}