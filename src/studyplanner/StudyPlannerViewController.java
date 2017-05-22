package studyplanner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class StudyPlannerViewController implements Initializable {
    
    private StudyProfile profile; //profile data to be used by the controller
    
    @FXML private ListView<StudyProfile> profileListView;
    @FXML private AnchorPane content;
    
    
    @FXML private void loadProfileButtonAction(){
        System.out.println(profile);
    }
    @FXML private void newProfileButtonAction() throws Exception{
        showCreateStudyProfile();
    }

    public void profileAdded(final StudyProfile sp) {
        Platform.runLater(() -> {
            profileListView.getItems().add(sp);
        });
    }
    
    public void showCreateStudyProfile() throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "CreateStudyProfileView.fxml"
                )
        );
        
        Stage stage = new Stage();
        //hides stage if main window is closed
        content.getScene().getWindow().setOnHidden(e -> stage.hide());
        stage.setTitle("Create New Profile");
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        
        CreateStudyProfileViewController controller = 
                loader.<CreateStudyProfileViewController>getController();
        controller.initData(this);
        stage.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChangeListener listener = (ChangeListener<StudyProfile>) 
                (ObservableValue<? extends StudyProfile> observable, StudyProfile oldValue, StudyProfile newValue) -> {
            profile = newValue;
            System.out.println("ListView selection changed from oldValue = "
                    + oldValue + " to newValue = " + newValue);
        };
        profileListView.getSelectionModel().selectedItemProperty().addListener(listener);
    }
}