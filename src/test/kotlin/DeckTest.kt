import io.shaka.Deck
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun `A full deck should have 52 cards`() {
        val deck = Deck()
        assertEquals(52, deck.size())
    }


}