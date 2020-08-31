import javafx.application.{Application, Platform}
import javafx.stage.Stage

object Main {
  // you might want to dedicate a separate class to hold these
  var args: Array[String] = _

  def main(args: Array[String]): Unit = {
    this.args = args
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    // there are two ways of initiating windows at this point
    // you can either create a new stage, which is ill-advisable for a first scene
    // or use the old one
    // the only reason why you might want to not use a primary stage is to delay it
    // for example - to show the login window before showing the main application in the primary stage
    // just for fun i'll show you both ways

    // first way - as a separate window
    Controller.showAndWait(Main.args, "first way")

    // second way - using the primaryStage
    // notice how it doesn't show up right after the previous line
    // that's the "wait" in "showAndWait" doing it's job
    val (scene, _) = Controller.createScene(Main.args, "second way")
    primaryStage.setScene(scene)
    primaryStage.show()

    // yes, the actual logic for these is inside of the Controller class
    // anyways, after you close the primaryStage - stop() runs.
  }

  // i recommend leaving this just to make sure the application actually closes
  // it will stop the main thread and if there aren't any other threads of this
  // app running then it'll stop the jvm
  override def stop(): Unit = {
    super.stop()
    Platform.exit()
  }
}
