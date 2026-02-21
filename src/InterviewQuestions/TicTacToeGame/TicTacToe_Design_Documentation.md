# TicTacToe Game - Design Documentation

## Overview
This document provides a comprehensive overview of the TicTacToe game design, architecture, and implementation patterns used in this project.

## Table of Contents
1. [System Architecture](#system-architecture)
2. [Design Patterns Used](#design-patterns-used)
3. [Class Diagram](#class-diagram)
4. [Package Structure](#package-structure)
5. [Core Components](#core-components)
6. [Game Flow](#game-flow)
7. [Design Principles](#design-principles)
8. [Extension Points](#extension-points)
9. [Code Quality](#code-quality)

---

## System Architecture

The TicTacToe game follows a **layered architecture** with clear separation of concerns:

```
┌─────────────────────────────────────────┐
│           Presentation Layer            │
│        (PlayGame - Main Class)         │
├─────────────────────────────────────────┤
│            Business Logic               │
│         (TicTacToeGame Class)          │
├─────────────────────────────────────────┤
│              Model Layer                │
│  (Board, Player, PlayingPiece, Enums)  │
└─────────────────────────────────────────┘
```

---

## Design Patterns Used

### 1. **Factory Pattern**
- **Location**: `PlayingPiece` hierarchy
- **Purpose**: Creates different types of playing pieces (X and O)
- **Implementation**: 
  - Abstract base class: `PlayingPiece`
  - Concrete implementations: `PlayingPieceX`, `PlayingPieceO`

### 2. **Strategy Pattern** (Implicit)
- **Location**: Game logic can be extended for different game rules
- **Purpose**: Allows different winning strategies or board sizes
- **Implementation**: Winner checking logic is centralized and can be extended

### 3. **Composite Pattern** (Simplified)
- **Location**: Board contains a 2D array of PlayingPiece objects
- **Purpose**: Manages the game state as a collection of pieces

### 4. **State Pattern** (Enum-based)
- **Location**: `GameStatus` enum
- **Purpose**: Represents different game states (WIN, DRAW, ONGOING)

---

## Class Diagram

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   TicTacToeGame │────│     Player      │────│  PlayingPiece   │
│                 │    │                 │    │   (abstract)    │
│ - players: Deque│    │ - name: String  │    │ + pieceType     │
│ - gameBoard     │    │ - piece         │    └─────────────────┘
│ + startGame()   │    └─────────────────┘           △
│ + checkWinner() │                                  │
└─────────────────┘                         ┌────────┴────────┐
         │                                  │                 │
         │                           ┌─────────────┐   ┌─────────────┐
         ▼                           │PlayingPieceX│   │PlayingPieceO│
┌─────────────────┐                  │             │   │             │
│      Board      │                  │ + pieceType │   │ + pieceType │
│                 │                  │   = X       │   │   = O       │
│ - size: int     │                  └─────────────┘   └─────────────┘
│ - board[][]     │
│ + addPiece()    │
│ + getFreeCells()│
│ + printBoard()  │
└─────────────────┘

┌─────────────────┐    ┌─────────────────┐
│   GameStatus    │    │   PieceType     │
│    (enum)       │    │    (enum)       │
│                 │    │                 │
│ + WIN          │    │ + X             │
│ + DRAW         │    │ + O             │
└─────────────────┘    └─────────────────┘
```

---

## Package Structure

```
InterviewQuestions.TicTacToeGame/
│
├── TicTacToeGame.java          # Main game logic controller
├── PlayGame.java               # Entry point and game launcher
├── GameStatus.java             # Game state enumeration
│
├── Board/
│   ├── Board.java              # Game board implementation
│   └── Pair.java               # Utility class for coordinates
│
├── Player/
│   └── Player.java             # Player representation
│
└── PlayingPiece/
    ├── PlayingPiece.java       # Abstract base class for pieces
    ├── PlayingPieceX.java      # X piece implementation
    ├── PlayingPieceO.java      # O piece implementation
    └── PieceType.java          # Piece type enumeration
```

---

## Core Components

### 1. **TicTacToeGame** (Controller)
- **Responsibility**: Orchestrates the game flow
- **Key Methods**:
  - `initialiseGame()`: Sets up players and board
  - `startGame()`: Main game loop
  - `checkForWinner()`: Validates winning conditions

### 2. **Board** (Model)
- **Responsibility**: Manages game state and board operations
- **Key Features**:
  - Dynamic size support (currently 3x3)
  - Piece placement validation
  - Free cell tracking
  - Board visualization

### 3. **Player** (Model)
- **Responsibility**: Represents a game participant
- **Attributes**:
  - Player name
  - Associated playing piece (X or O)

### 4. **PlayingPiece Hierarchy** (Model)
- **Responsibility**: Represents game pieces
- **Design**: Abstract base class with concrete implementations
- **Extensibility**: Easy to add new piece types

---

## Game Flow

```
1. Game Initialization
   ├── Create Players (Player 1: X, Player 2: O)
   ├── Initialize Board (3x3 grid)
   └── Add Players to Queue

2. Game Loop
   ├── Get Current Player
   ├── Check for Available Moves
   ├── Get Player Input (row, column)
   ├── Validate Move
   ├── Place Piece on Board
   ├── Display Updated Board
   ├── Check for Winner
   └── Switch to Next Player

3. Game End
   ├── Announce Winner/Draw
   ├── Display Final Board
   └── Exit Game
```

---

## Design Principles

### 1. **Single Responsibility Principle (SRP)**
- Each class has a single, well-defined responsibility
- `Board` manages board state, `Player` represents players, etc.

### 2. **Open/Closed Principle (OCP)**
- Easy to extend with new piece types without modifying existing code
- Board size can be configured without changing core logic

### 3. **Liskov Substitution Principle (LSP)**
- All `PlayingPiece` implementations can be used interchangeably
- Polymorphic behavior with piece types

### 4. **Interface Segregation Principle (ISP)**
- Classes only depend on methods they actually use
- Clean, focused interfaces

### 5. **Dependency Inversion Principle (DIP)**
- High-level modules don't depend on low-level modules
- Abstractions are used for piece types

---

## Extension Points

### 1. **Board Size Customization**
```java
// Current: Board(3) for 3x3
// Possible: Board(4) for 4x4, Board(5) for 5x5
```

### 2. **New Piece Types**
```java
// Add new piece types by extending PlayingPiece
public class PlayingPieceY extends PlayingPiece {
    public PlayingPieceY() {
        this.pieceType = PieceType.Y;
    }
}
```

### 3. **Different Win Conditions**
```java
// Modify checkForWinner() for:
// - Different winning patterns
// - N-in-a-row games
// - Custom victory conditions
```

### 4. **Multiple Players**
```java
// Current: 2 players
// Extend: Support for 3+ players with different pieces
```

### 5. **AI Players**
```java
// Create AIPlayer extends Player
// Implement different difficulty levels
```

---

## Code Quality

### Strengths ✅
- **Clear separation of concerns**
- **Proper encapsulation**
- **Consistent naming conventions**
- **Extensible design**
- **Error handling for invalid moves**
- **Real-time board state display**

### Areas for Improvement 🔄
- **Input validation** (handle non-numeric input)
- **Exception handling** (array bounds, null checks)
- **Unit testing** (add comprehensive test coverage)
- **Configuration** (externalize board size, player count)
- **Logging** (add logging for game events)

### Recent Bug Fixes 🐛➡️✅
- **Fixed NullPointerException** in diagonal winner checking
- **Removed duplicate board printing**
- **Fixed missing break statements** in switch cases
- **Updated Java version compatibility** (Java 21)

---

## Usage Example

```java
// Basic game flow
TicTacToeGame game = new TicTacToeGame();
game.initialiseGame();
GameStatus result = game.startGame();

// Expected output format:
// -----STARTING THE GAME-----
// Player: Player 1 - Please enter [row, column]: 1,1
// 
// ----CURRENT BOARD STATE----
// ----PRINTING THE BOARD----
//    | X  |    |
//    |    |    |
//    |    |    |
```

---

## Testing Strategy

### Unit Tests Needed
1. **Board Tests**
   - Piece placement validation
   - Free cell calculation
   - Board printing format

2. **Game Logic Tests**
   - Winner detection (rows, columns, diagonals)
   - Draw condition detection
   - Player turn management

3. **Integration Tests**
   - Complete game flow
   - Input/output validation
   - Edge cases (full board, invalid moves)

---

## Performance Considerations

- **Time Complexity**: O(n) for winner checking (where n = board size)
- **Space Complexity**: O(n²) for board storage
- **Scalability**: Current design supports larger boards efficiently

---

*Last Updated: February 16, 2026*  
*Version: 1.0*  
*Author: System Design Team*
