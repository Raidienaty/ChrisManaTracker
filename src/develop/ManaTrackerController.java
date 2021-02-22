package develop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ManaTrackerController extends AnchorPane
{
    @FXML
    private Stage primaryStage;

    @FXML
    private AnchorPane currentManaPane;
    @FXML
    private Text currentMana;

    @FXML
    private AnchorPane resetManaPane;
    @FXML
    private Button resetManaButton;

    @FXML
    private AnchorPane modifyManaValuePane;
    @FXML
    private TextField changeMaxManaField;
    @FXML
    private Button changeMaxManaButton;
    @FXML
    private TextField addManaField;
    @FXML
    private Button addManaButton;
    @FXML
    private TextField removeManaField;
    @FXML
    private Button removeManaButton;

    @FXML
    private AnchorPane nameLoadPane;
    @FXML
    private Text name;
    @FXML
    private Button newButton;
    @FXML
    private Button loadButton;

    public Group initializeManaTracker(Stage primaryStage) throws IOException
    {
        Parent root = loadManaTrackerFXML();

        setPrimaryStage(primaryStage);

        return new Group(root);
    }

    private Parent loadManaTrackerFXML() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/manaTracker.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        return fxmlLoader.load();
    }

    private void setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }
}
