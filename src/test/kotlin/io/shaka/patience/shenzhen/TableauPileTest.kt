package io.shaka.patience.shenzhen

import io.shaka.Card
import io.shaka.Rank
import io.shaka.Suit
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TableauPileTest {
    @Test
    fun `Can add any card as first card in the pile`() {
        val tableauPile = TableauPile()
        val card = Card(Suit.HEARTS, Rank.TWO)
        val newPile = tableauPile.addCard(card)
        assertEquals(listOf(card), newPile.cards)
    }

    @Test
    fun `Can add a card of the next rank down and different color to the the one on top of the pile`() {
        val tableauPile = TableauPile(listOf(Card(Suit.HEARTS, Rank.FIVE)))
        val card = Card(Suit.CLUBS, Rank.FOUR)
        val newPile = tableauPile.addCard(card)
        assertEquals(listOf(Card(Suit.HEARTS, Rank.FIVE), card), newPile.cards)
    }

    @Test
    fun `Adding a card of the same color to the one on the top of the pile throws`() {
        val tableauPile = TableauPile(listOf(Card(Suit.HEARTS, Rank.FIVE)))
        val card = Card(Suit.DIAMONDS, Rank.FOUR)
        assertThrows(IllegalArgumentException::class.java) {
            tableauPile.addCard(card)
        }
    }

    @Test
    fun `Adding a card of a different color but not the next rank down throws`() {
        val tableauPile = TableauPile(listOf(Card(Suit.HEARTS, Rank.FIVE)))
        val card = Card(Suit.CLUBS, Rank.THREE)
        assertThrows(IllegalArgumentException::class.java) {
            tableauPile.addCard(card)
        }
    }
}