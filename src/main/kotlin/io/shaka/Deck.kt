package io.shaka

data class Deck(val cards: List<Card> = createFullDeck()) {

    companion object {
        private fun createFullDeck(): List<Card> {
            return Suit.entries.flatMap { suit ->
                Rank.entries.map { rank -> Card(suit, rank) }
            }
        }
    }

    override fun toString(): String = cards.joinToString("\n")

    fun size(): Int = cards.size

    fun shuffle(): Deck {
        return Deck(cards.shuffled())
    }

    fun dealCard(): Pair<Card?, Deck> {
        return if (cards.isNotEmpty()) {
            val dealtCard = cards.first()
            val remainingDeck = Deck(cards.drop(1))
            dealtCard to remainingDeck
        } else {
            null to this
        }
    }
}

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