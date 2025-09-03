import random
from typing import List, Self

class Card:
    def __init__(self: Self, suit, value) -> None:
        self._suit: str = suit
        self._value: str = value

    def present(self: Self) -> str:
        return f'{self._value} of {self._suit}'

    def __str__(self: Self) -> str:
        return f'{self._value} of {self._suit}'



class Deck:
    _suits: List[str] = ['hearts', 'diamonds', 'clubs', 'spades']
    _values: List[str] = ['Ace', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Jack', 'Queen', 'King']

    def __init__(self: Self) -> None:
        self._cards: List[Card] = [Card(suit, value) for suit in Deck._suits for value in Deck._values]

    def cards(self: Self) -> List[Card]:
        return self._cards

    def shuffle(self: Self) -> None:
        random.shuffle(self._cards)

    def deal(self: Self) -> str | None:
        dealt_card = self._cards[-1]
        del self._cards[-1]
        return dealt_card if self._cards else None

    def count_remaining(self: Self) -> int:
        return len(self._cards)

    def get_remaining(self: Self) -> List[str]:
        return [card.present() for card in self._cards]


def main():
    deck = Deck()
    print(deck.get_remaining())
    deck.shuffle()
    print(deck.deal())
    print(deck.count_remaining())
    print(deck.get_remaining())


if __name__ == '__main__':
    main()
