import javafx.application.{Application, Platform}
import javafx.stage.Stage

object Main {
  var args: Array[String] = _

  def main(args: Array[String]): Unit = {
    this.args = args
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    val (scene, _) = Controller.createScene(Main.args, "second way")
    primaryStage.setScene(scene)
    primaryStage.show()
  }

  override def stop(): Unit = {
    super.stop()
    Platform.exit()
  }
}
