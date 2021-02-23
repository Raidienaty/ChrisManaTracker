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

public class LoadSaveDataController extends AnchorPane
{
    @FXML
    private Stage secondaryWindow;

    @FXML
    private AnchorPane loadPane;
    @FXML
    private TextField nameField;
    @FXML
    private Button nameSubmitButton;
    @FXML
    private Text nameErrorMessage;

    private List<SaveData> saveDataList;
    private SaveData loadData;

    public Group initializeLoadSaveData(Stage secondaryWindow, List<SaveData> saveDataList) throws IOException
    {
        Parent root = loadFXML();

        setSecondaryWindow(secondaryWindow);
        setSaveDataList(saveDataList);

        return new Group(root);
    }

    @FXML
    private void loadDataFromUsername()
    {
        String username = nameField.getText();

        if (username.isEmpty())
            return;
        else if (!checkForUsernameInData(username))
            return;

        int positionInData = getPositionInData(username);

        loadData = saveDataList.get(positionInData);
    }

    private int getPositionInData(String username)
    {
        for (int i = 0; i < saveDataList.size(); i++)
        {
            if (username.equals(saveDataList.get(i).getUsername()))
                return i;
        }

        return -1;
    }

    private boolean checkForUsernameInData(String username)
    {
        for (SaveData data: saveDataList)
        {
            if (username.equals(data.getUsername()))
                return true;
        }

        return false;
    }

    private void setSecondaryWindow(Stage secondaryWindow)
    {
        this.secondaryWindow = secondaryWindow;
    }

    private void setSaveDataList(List<SaveData> saveDataList)
    {
        this.saveDataList = saveDataList;
    }

    private Parent loadFXML() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/loadSaveData.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        return fxmlLoader.load();
    }
}
