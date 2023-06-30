package com.asss1.myapplication.chess

class ChessModel {
    val piecesBox = mutableSetOf<ChessPiece>()

    init {
        reset()
    }

    private fun reset(){
        piecesBox.removeAll(piecesBox)
        for (i in 0..1) {
            piecesBox.add(ChessPiece(0 + i * 7, 0 , ChessPlayer.WHITE , ChessRank.ROOK))
            piecesBox.add(ChessPiece(0 + i * 7, 7 , ChessPlayer.BLACK , ChessRank.ROOK))

            piecesBox.add(ChessPiece(1 + i * 5, 0 , ChessPlayer.WHITE , ChessRank.KNIGHT))
            piecesBox.add(ChessPiece(1 + i * 5, 7 , ChessPlayer.BLACK , ChessRank.KNIGHT))

            piecesBox.add(ChessPiece(2 + i * 3, 0 , ChessPlayer.WHITE , ChessRank.BISHOP))
            piecesBox.add(ChessPiece(2 + i * 3, 7 , ChessPlayer.BLACK , ChessRank.BISHOP))
        }

        for (i in 0..7){
            piecesBox.add(ChessPiece(i, 1 , ChessPlayer.WHITE , ChessRank.PAWN))
            piecesBox.add(ChessPiece(i, 6 , ChessPlayer.BLACK , ChessRank.PAWN))

        }

        piecesBox.add(ChessPiece(3, 0 , ChessPlayer.WHITE , ChessRank.QUEEN))
        piecesBox.add(ChessPiece(3, 7 , ChessPlayer.BLACK , ChessRank.QUEEN))


        piecesBox.add(ChessPiece(4, 0 , ChessPlayer.WHITE , ChessRank.KING))
        piecesBox.add(ChessPiece(4, 7 , ChessPlayer.BLACK , ChessRank.KING))


    }

    private fun pieceAt(col: Int , row: Int): ChessPiece? {
        for (piece in piecesBox) {
            if (col == piece.col && row == piece.row) {
                return piece
            }
        }
        return null
    }

    override fun toString(): String {
        var desc = "\n"
        for (row in 7 downTo 0) {
            desc += "$row"
            for (col in 0..7) {
                val piece = pieceAt(col , row)
                if (piece == null) {

                    desc += " ."
                } else {
                    val white = piece.player == ChessPlayer.WHITE
                    desc += " "
                    desc += when(piece.rank) {
                        ChessRank.KING -> {
                            if (white)"k" else "K"
                        }

                        ChessRank.QUEEN -> {
                            if (white)"q" else "Q"
                        }

                        ChessRank.BISHOP -> {
                            if (white)"b" else "B"
                        }

                        ChessRank.ROOK -> {
                            if (white)"r" else "R"
                        }

                        ChessRank.PAWN -> {
                            if (white)"p" else "P"
                        }

                        ChessRank.KNIGHT -> {
                            if (white)"n" else "N"
                        }

                    }
                }

            }
            desc += "\n"
        }
        desc += "  0 1 2 3 4 5 6 7"

        return desc
    }
}