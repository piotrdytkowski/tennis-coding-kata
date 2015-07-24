import org.scalatest.{Matchers, FlatSpec}

class TennisGameSpec extends FlatSpec with Matchers {

  "A tennis game" should "start with the score love - love" in {
    val game = TennisGame()
    game.getScore() should be (Love(), Love())
  }

}
