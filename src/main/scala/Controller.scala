import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

object Controller {
  val fxmlSrc = "fxml/window.fxml"

  /** inititates the scene in a separate window. after the window is closed - returns scene's controller. */
  def showAndWait(args: Array[String] = Array.empty[String], header: String = ""): Controller = {
    val (scene, controller) = createScene(args, header)
    val stage = new Stage()
    stage.setScene(scene)
    stage.showAndWait()

    controller
  }

  /**
   * returns a scene and a controller of that scene.
   * use if needed to initiate inside of an existing scene or whatever
   */
  def createScene(args: Array[String] = Array.empty[String], header: String = ""): (Scene, Controller) = {
    val controller = new Controller()
    controller.setHeader(header)
    controller.setArgs(args)

    val loader = new FXMLLoader(getClass().getResource(fxmlSrc))
    loader.setController(controller)

    val parentNode: Parent = loader.load()
    val scene = new Scene(parentNode)

    (scene, controller)
  }
}

/** houses actual logic of a scene. */
class Controller extends ControllerBase {

  // could be done by adding them to the class itself as arguments,
  // but that would make them immutable. you might want them to stay immutable
  // if your window is a window with immutable information or these arguments are available at scene creation
  // but that's unlikely so i'm using vars
  var header: String = _
  var args: Array[String] = _

  def setHeader(header: String): Unit = this.header = header
  def setArgs(args: Array[String]): Unit = this.args = args

  def processArgs(args: Array[String]): String =
    if (args == null || args.length == 0) ""
    else "args: \n " + args.map("    " + _ + "\n").mkString("")

  override def initialize(): Unit = {
    tfMain.setText(header)
    taMain.setText(processArgs(args))
  }
}
