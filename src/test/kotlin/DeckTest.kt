import io.shaka.Deck
import io.shaka.deal
import io.shaka.dealCard
import io.shaka.shuffle
import io.shaka.size
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun `A full deck should have 52 cards`() {
        val deck = Deck()
        assertEquals(52, deck.size())
    }

    @Test
    fun `can shuffle a deck`() {
        val originalDeck = Deck()
        val secondDeck = originalDeck.copy()

        assertEquals(originalDeck, secondDeck)

        assertNotEquals(originalDeck, originalDeck.shuffle())
    }

    @Test
    fun `Can deal a card`(){
        val deck = Deck()
        val (dealtCard, remainingDeck) = deck.dealCard()
        assertNotNull(dealtCard)
        assertEquals(51, remainingDeck.size())
    }

    @Test
    fun `Deal x cards to y players`(){
        val (hands, remainingDeck) = Deck()
            .shuffle()
            .deal(cards = 5, players = 2)

        val (hand1, hand2) = hands

        assertEquals(5, hand1.size)
        assertEquals(5, hand2.size)
        assertEquals(42, remainingDeck.size())
    }

}