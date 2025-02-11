package io.shaka.patience.shenzhen

import io.shaka.Deck
import io.shaka.deal
import io.shaka.shuffle
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayerTest{
  @Test
  fun `A player can draw a card from their stock`(){
   val (hands, _) = Deck()
    .shuffle()
    .deal(cards = 26, players = 1)
   val (startingStock) = hands
   val player = Player(stock = startingStock)

    val currentPlayer = player.drawCard()
    assertEquals(currentPlayer.stock.size, 25)
    assertEquals(currentPlayer.inHand, startingStock.first())
  }
 }