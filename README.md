# 🃏 Blackjack Java

A fully functional Blackjack game built with pure Java, featuring all standard casino rules.

## 🎮 How to Play

Run `Play.java` and follow the instructions in the terminal.

### Actions
| Action | Description |
|--------|-------------|
| `HIT` | Draw another card |
| `STAND` | Keep your current hand |
| `DOUBLE` | Double down — draw 1 card and stand |
| `SPLIT` | Split two equal-value cards into separate hands |

## 📋 Game Rules

- **Blackjack** — Ace + 10-value card from the first 2 cards = instant win (+2 points)
- **Bust** — Score exceeds 21 = instant loss
- **Dealer** — Automatically hits on 16 or below, stands on 17 or above
- **Split** — Available when first 2 cards have equal value, can split multiple times
- **Double** — Available on first 2 cards only, win = +2, lose = -2

## 🏆 Scoring
| Result | Player | Dealer |
|--------|--------|--------|
| Win | +1 | -1 |
| Blackjack | +2 | -2 |
| Win Double | +2 | -2 |
| Lose | -1 | +1 |
| Lose Double | -2 | +2 |
| Draw | 0 | 0 |

## 🏗️ Project Structure
```
src/LetPlayBlackJack/
├── Enum/
│   ├── Rank.java        # Card ranks (2-A)
│   └── Suit.java        # Card suits (♥♦♣♠)
├── Card.java            # Single playing card
├── Deck.java            # 52-card deck with shuffle
├── Hand.java            # Player/dealer hand logic
├── Player.java          # Player with score tracking
├── Dealer.java          # Dealer with hidden card
├── BlackJackGame.java   # Main game logic
└── Play.java            # Entry point
```

## 🛠️ Tech Stack
- **Language**: Java
- **IDE**: IntelliJ IDEA
- **Build**: Maven

## 👨‍💻 NIKOLOVE
Made with ❤️ while learning Java fundamentals and OOP.
