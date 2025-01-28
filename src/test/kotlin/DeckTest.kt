import io.shaka.Deck
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
    fun `Does slack failure`(){
        assertEquals(1, 2)
    }
}