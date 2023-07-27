package com.asss1.myapplication.chess

interface ChessDelegate {
    fun pieceAt(col: Int , row: Int): ChessPiece?
}