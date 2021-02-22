package develop;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ManaTrackerController manaTrackerController = new ManaTrackerController();

        Group root = manaTrackerController.initializeManaTracker(primaryStage);

        Scene scene = new Scene(root);

        primaryStage.close();

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
