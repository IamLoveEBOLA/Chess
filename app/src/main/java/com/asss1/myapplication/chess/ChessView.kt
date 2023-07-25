package com.asss1.myapplication.chess

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.asss1.myapplication.R

class ChessView(context: Context? , attrs: AttributeSet?) : View(context , attrs) {
    private val originX: Float = 20f
    private val originY: Float = 200f
    private val cellSide: Float = 130f
    private val lightColor = Color.argb(1f , .7f , .7f , .7f)
    private val darkColor = Color.argb(1f , .3f , .3f , .3f)
    private val imgResIDs = setOf(
        R.drawable.bishop_black ,
        R.drawable.king_black ,
        R.drawable.knight_black ,
        R.drawable.queen_black ,
        R.drawable.rook_black ,
        R.drawable.pawn_black ,
        R.drawable.queen_white ,
        R.drawable.bishop_white ,
        R.drawable.king_white ,
        R.drawable.knight_white ,
        R.drawable.pawn_white ,
        R.drawable.rook_white
    )
    private val bitmaps = mutableMapOf<Int , Bitmap>()
    private val paint = Paint()

    init {
        loadBitmaps()
    }


    override fun onDraw(canvas: Canvas?) {
        drawChessboard(canvas)
        drawPieces(canvas)


    }

    private fun loadBitmaps() {
        imgResIDs.forEach {
            bitmaps[it] = BitmapFactory.decodeResource(resources , it)
        }
    }

    private fun drawPieces(canvas: Canvas?) {
        val chessModel = ChessModel()
        chessModel.reset()

        for (row in 0..7) {
            for (col in 0..7) {


                chessModel.pieceAt(col , row)?.let { drawPieceAt(canvas , col , row , it.resID) }
            }
        }

    }

    private fun drawPieceAt(canvas: Canvas? , col: Int , row: Int , resID: Int) {
        val bitmap = bitmaps[resID]!!
        canvas?.drawBitmap(
            bitmap ,
            null ,
            RectF(
                originX + col * cellSide ,
                originY + (7 - row) * cellSide ,
                originX + (col + 1) * cellSide ,
                originY + ((7 - row) + 1) * cellSide
            ) ,
            paint
        )

    }

    private fun drawChessboard(canvas: Canvas?) {
        for (i in 0..7) {
            for (j in 0..7) {
                paint.color = if ((i + j) % 2 == 1) darkColor else lightColor
                canvas?.drawRect(
                    originX + i * cellSide ,
                    originY + j * cellSide ,
                    originX + (i + 1) * cellSide ,
                    originY + (j + 1) * cellSide ,
                    paint
                )


            }

        }

    }

}

