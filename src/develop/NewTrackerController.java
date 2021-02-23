package develop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class NewTrackerController
{
    @FXML
    private Stage primaryStage;

    private List<SaveData> saveDataList;

    public Group initializeNewTracker(Stage primaryStage, List<SaveData> saveDataList) throws IOException
    {
        Parent root = loadFXML();

        setPrimaryStage(primaryStage);
        setSaveDataList(saveDataList);

        return new Group(root);
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
