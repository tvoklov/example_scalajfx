import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public abstract class ControllerBase {

    @FXML protected TextField tfMain;

    @FXML protected TextArea taMain;

    @FXML protected BorderPane bpMain;

    @FXML public void initialize();
}
