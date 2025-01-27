package io.shaka

enum class Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
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

data class Card(val suit: Suit, val rank: Rank) {
    override fun toString(): String = "$rank of $suit"
}

class Deck {
    private val cards = mutableListOf<Card>()

    init {
        for (suit in Suit.entries) {
            for (rank in Rank.entries) {
                cards.add(Card(suit, rank))
            }
        }
    }


    fun size() = cards.size

    override fun toString(): String = cards.joinToString("\n")
}

fun main() {
    val deck = Deck()
    println(deck.size())
}