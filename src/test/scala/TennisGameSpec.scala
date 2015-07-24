class TennisGameSpec extends UnitTest {

  "A tennis game" should "start with the score love - love" in {
    val game = TennisGame()
    game.getScore() should be (Love(), Love())
  }

}
