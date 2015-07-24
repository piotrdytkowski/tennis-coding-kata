package tennis.model

case class TennisGame(player1: Player, player2: Player, scoreBoard: ScoreBoard = ScoreBoard(Love(), Love())) {

  def achievePoint(p: Player): TennisGame = {
    val newScore = if (p == player1) scoreBoard.playerOneScored() else scoreBoard.playerTwoScored()
    this.copy(scoreBoard = newScore)
  }

  def getScore(): (Score, Score) = {
    scoreBoard.getScore()
  }
  
  def getState(): GameState = {
    scoreBoard.getState()
  }
}
