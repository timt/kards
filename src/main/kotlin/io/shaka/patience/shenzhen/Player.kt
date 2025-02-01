package io.shaka.patience.shenzhen

import io.shaka.Card

data class Player(val stock: List<Card>, val discardPile: List<Card> = emptyList(), val inHand: Card? = null)

fun Player.drawCard(): Player = if (stock.isNotEmpty()) {
    copy(stock = stock.drop(1), inHand = stock.first())
} else {
    copy(stock = discardPile.reversed(), discardPile = emptyList()).drawCard()
}