package io.shaka

data class FoundationPile(val suit: Suit, val cards: List<Card> = emptyList())

fun FoundationPile.addCard(card: Card): FoundationPile {
    if (card.suit != suit) throw IllegalArgumentException("Card $card is not the correct suit for this foundation pile: $suit")
    if (card.rank != Rank.ACE && cards.isNotEmpty() && card.rank.defaultOrder != (cards.last().rank.defaultOrder + 1)) {
        throw IllegalArgumentException("Card $card is not the next rank for this foundation pile: $cards")
    }
    return this.copy(cards = cards + card)
}