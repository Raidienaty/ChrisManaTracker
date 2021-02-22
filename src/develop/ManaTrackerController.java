package develop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManaTrackerController extends AnchorPane
{
    @FXML
    private Stage primaryStage;

    public Group initializeManaTracker(Stage primaryStage) throws IOException
    {
        Parent root = loadManaTrackerFXML();

        this.primaryStage = primaryStage;

        return new Group(root);
    }

    private Parent loadManaTrackerFXML() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/manaTracker.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        return fxmlLoader.load();
    }
}
