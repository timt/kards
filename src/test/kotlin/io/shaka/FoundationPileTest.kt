package io.shaka

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FoundationPileTest {
    @Test
    fun `Adding a card of a different suit to pile throws`() {
        val foundationPile = FoundationPile(Suit.HEARTS)
        val card = Card(Suit.CLUBS, Rank.ACE)
        assertThrows(IllegalArgumentException::class.java) {
            foundationPile.addCard(card)
        }
    }

    @Test
    fun `Can add an Ace of the same suit to an empty pile`() {
        val foundationPile = FoundationPile(Suit.HEARTS)
        val card = Card(Suit.HEARTS, Rank.ACE)
        val newPile = foundationPile.addCard(card)
        assertEquals(listOf(card), newPile.cards)
    }

    @Test
    fun `Can add a card of the same suit and next rank to a pile`() {
        val foundationPile = FoundationPile(Suit.HEARTS, listOf(Card(Suit.HEARTS, Rank.ACE)))
        val card = Card(Suit.HEARTS, Rank.TWO)
        val newPile = foundationPile.addCard(card)
        assertEquals(listOf(Card(Suit.HEARTS, Rank.ACE), card), newPile.cards)
    }

    @Test
    fun `Adding a card fo the same suit but not the next rank throws`() {
        val foundationPile = FoundationPile(Suit.HEARTS, listOf(Card(Suit.HEARTS, Rank.ACE)))
        val card = Card(Suit.HEARTS, Rank.THREE)
        assertThrows(IllegalArgumentException::class.java) {
            foundationPile.addCard(card)
        }
    }
}