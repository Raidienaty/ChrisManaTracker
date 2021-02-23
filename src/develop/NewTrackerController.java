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
import java.util.List;

public class NewTrackerController
{
    @FXML
    private Stage primaryStage;

    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private TextField nameField;
    @FXML
    private Button submitButton;
    @FXML
    private Text errorMessage;
    @FXML
    private Button backButton;

    private List<SaveData> saveDataList;

    public Group initializeNewTracker(Stage primaryStage, List<SaveData> saveDataList) throws IOException
    {
        Parent root = loadFXML();

        syncMainAnchor(root);

        setPrimaryStage(primaryStage);
        setSaveDataList(saveDataList);

        return new Group(root);
    }
    
    private void syncMainAnchor(Parent root)
    {
        this.mainAnchorPane = (AnchorPane) root.getChildrenUnmodifiable().get(0);

        this.nameField = (TextField) mainAnchorPane.getChildren().get(2);
        this.submitButton = (Button) mainAnchorPane.getChildren().get(3);
        this.errorMessage = (Text) mainAnchorPane.getChildren().get(4);
        this.backButton = (Button) mainAnchorPane.getChildren().get(1);
    }

    private Parent loadFXML() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/loadSaveData.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        return fxmlLoader.load();
    }

    public void setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void setSaveDataList(List<SaveData> saveDataList)
    {
        this.saveDataList = saveDataList;
    }
}
