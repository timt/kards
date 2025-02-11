package io.shaka

import io.shaka.SuitColor.BLACK
import io.shaka.SuitColor.RED

enum class SuitColor {
    RED, BLACK
}
enum class Suit(val color: SuitColor) {
    HEARTS(RED), DIAMONDS(RED), CLUBS(BLACK), SPADES(BLACK)
}

enum class Rank(val defaultOrder: Int) {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13)
}

data class Deck(val cards: List<Card> = createFullDeck()) {

    companion object {
        private fun createFullDeck(): List<Card> = Suit.entries.flatMap { suit ->
            Rank.entries.map { rank -> Card(suit, rank) }
        }
    }

}

fun Deck.deal(cards: Int, players: Int): Pair<List<List<Card>>, Deck> {
    val hands = List(players) { mutableListOf<Card>() }
    var remainingDeck = this
    repeat(cards) {
        hands.forEach { hand ->
            val (dealtCard, newDeck) = remainingDeck.dealCard()
            dealtCard?.let { hand.add(it) }
            remainingDeck = newDeck
        }
    }
    return hands to remainingDeck
}

fun Deck.dealCard(): Pair<Card?, Deck> = if (cards.isNotEmpty()) {
    val dealtCard = cards.first()
    val remainingDeck = Deck(cards.drop(1))
    dealtCard to remainingDeck
} else {
    null to this
}

fun Deck.size(): Int = cards.size

fun Deck.shuffle(): Deck = Deck(cards.shuffled())



data class Card(val suit: Suit, val rank: Rank) {
    override fun toString(): String = "$rank of $suit"
}