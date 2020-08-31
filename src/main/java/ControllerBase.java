import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * doesn't do anything on it's own, only houses fxml links to elements of a scene.
 */
public class ControllerBase {

    @FXML
    protected TextField tfMain;

    @FXML
    protected TextArea taMain;

    @FXML // even if you won't need it i recommend adding it here just in case
    protected BorderPane bpMain;

    @FXML
    public void initialize() {
        System.out.println("this works");
    }
}
