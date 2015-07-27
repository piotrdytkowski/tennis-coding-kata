package tennis.model

case class ScoreBoard(score1: Score, score2: Score, gameState: GameState = InPlay()) {

  def playerOneScored(): ScoreBoard = {
    playerScored(1)
  }

  def playerTwoScored(): ScoreBoard = {
    playerScored(2)
  }

  def getScoreForPlayer(index: Int): Score = {
    index match {
      case 1 => score1
      case 2 => score2
      case _ => throw new IllegalArgumentException()
    }
  }

  def playerScored(index: Int): ScoreBoard = {
    val thisPlayer = getScoreForPlayer(index)
    val otherPlayer = getScoreForPlayer(if (index == 1) 2 else 1)
    if (getState() == InPlay()) thisPlayer match {
      case Love() => if (index == 1) this.copy(score1 = Fifteen()) else this.copy(score2 = Fifteen())
      case Fifteen() => if (index == 1) this.copy(score1 = Thirty()) else this.copy(score2 = Thirty())
      case Thirty() if otherPlayer != Fourty() => if (index == 1) this.copy(score1 = Fourty()) else this.copy(score2 = Fourty())
      case Thirty() if otherPlayer == Fourty() => ScoreBoard(Deuce(), Deuce())
      case Fourty() => if (index == 1) this.copy(score1 = GameWon(), gameState = GameFinished()) else this.copy(score2 = GameWon(), gameState = GameFinished())
      case Deuce() if otherPlayer == Deuce() => if (index == 1) this.copy(score1 = Advantage()) else this.copy(score2 = Advantage())
      case Deuce() if otherPlayer == Advantage() => ScoreBoard(Deuce(), Deuce())
      case Advantage() => if (index == 1) this.copy(score1 = GameWon(), gameState = GameFinished()) else this.copy(score2 = GameWon(), gameState = GameFinished())
    } else {
      throw new IllegalStateException()
    }
  }

  def getScore(): (Score, Score) = {
    (score1, score2)
  }

  def getState(): GameState = {
    gameState
  }
}
