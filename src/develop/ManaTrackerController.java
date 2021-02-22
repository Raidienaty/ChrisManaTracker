package develop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private int maxMana;
    private int currentManaAmount;

    public Group initializeManaTracker(Stage primaryStage) throws IOException
    {
        Parent root = loadManaTrackerFXML();

        syncModifyManaValuePane(root);
        syncResetManaPane(root);
        syncManaPane(root);
        syncNameLoadPane(root);

        setPrimaryStage(primaryStage);

        return new Group(root);
    }

    private void syncModifyManaValuePane(Parent root)
    {
        modifyManaValuePane = (AnchorPane) root.getChildrenUnmodifiable().get(0);

        changeMaxManaField = (TextField) modifyManaValuePane.getChildren().get(0);
        changeMaxManaButton = (Button) modifyManaValuePane.getChildren().get(1);

        addManaField = (TextField) modifyManaValuePane.getChildren().get(2);
        addManaButton = (Button) modifyManaValuePane.getChildren().get(3);

        removeManaField = (TextField) modifyManaValuePane.getChildren().get(4);
        removeManaButton = (Button) modifyManaValuePane.getChildren().get(5);
    }

    private void syncResetManaPane(Parent root)
    {
        resetManaPane = (AnchorPane) root.getChildrenUnmodifiable().get(1);
    }

    private void syncManaPane(Parent root)
    {
        currentManaPane = (AnchorPane) root.getChildrenUnmodifiable().get(2);

        currentMana = (Text) currentManaPane.getChildren().get(0);
    }

    private void syncNameLoadPane(Parent root)
    {
        nameLoadPane = (AnchorPane) root.getChildrenUnmodifiable().get(3);

        name = (Text) nameLoadPane.getChildren().get(0);
        loadButton = (Button) nameLoadPane.getChildren().get(1);
        newButton = (Button) nameLoadPane.getChildren().get(2);
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

    private Boolean checkIfInteger(String currentString)
    {
        try
        {
            Integer.parseInt(currentString);
        }
        catch (NumberFormatException e)
        {
            return false;
        }

        return true;
    }

    @FXML
    private void resetMana()
    {
        currentMana.setText(Integer.toString(0));
        currentManaAmount = 0;
    }

    @FXML
    private void removeMana()
    {
        String removeManaText = removeManaField.getText();

        if (removeManaText.isEmpty())
            return;
        else if (!checkIfInteger(removeManaText))
            return;

        currentManaAmount -= Integer.parseInt(removeManaText);

        currentMana.setText(Integer.toString(currentManaAmount));

        removeManaField.clear();
    }

    @FXML
    private void addMana()
    {
        String addManaText = addManaField.getText();

        if (addManaText.isEmpty())
            return;
        else if (!checkIfInteger(addManaText))
            return;

        int mana = Integer.parseInt(addManaText);

        if (mana + currentManaAmount > maxMana)
            return;
        else
            currentManaAmount += mana;

        currentMana.setText(Integer.toString(currentManaAmount));

        addManaField.clear();
    }

    @FXML
    private void changeMaxMana()
    {
        String changeMaxManaText = changeMaxManaField.getText();

        if (changeMaxManaText.isEmpty())
            return;
        else if (!checkIfInteger(changeMaxManaText))
            return;

        maxMana = Integer.parseInt(changeMaxManaText);

        changeMaxManaField.clear();
    }
}
