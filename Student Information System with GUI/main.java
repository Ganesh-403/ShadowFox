import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class main extends Application {
    private final List<Student> studentData = new ArrayList<>();
    private final ListView<String> studentListView = new ListView<>();
    private final TextField studentNameField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information System");

        Label label = new Label("Student Name:");
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        addButton.setOnAction(e -> addStudent());
        updateButton.setOnAction(e -> updateStudent());
        deleteButton.setOnAction(e -> deleteStudent());

        studentListView.setOnMouseClicked(e -> populateTextField());

        VBox layout = new VBox(10, label, studentNameField, addButton, updateButton, deleteButton, studentListView);
        primaryStage.setScene(new Scene(layout, 400, 400));
        primaryStage.show();
    }

    private void addStudent() {
        String name = studentNameField.getText().trim();
        if (!name.isEmpty()) {
            studentData.add(new Student(name));
            studentListView.getItems().add(name);
            studentNameField.clear();
        } else {
            showAlert("Please enter a name.");
        }
    }

    private void updateStudent() {
        int index = studentListView.getSelectionModel().getSelectedIndex();
        if (index >= 0 && !studentNameField.getText().trim().isEmpty()) {
            studentData.set(index, new Student(studentNameField.getText().trim()));
            studentListView.getItems().set(index, studentNameField.getText().trim());
            studentNameField.clear();
        } else {
            showAlert("Select a student and enter a new name.");
        }
    }

    private void deleteStudent() {
        int index = studentListView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            studentData.remove(index);
            studentListView.getItems().remove(index);
            studentNameField.clear();
        } else {
            showAlert("Select a student to delete.");
        }
    }

    private void populateTextField() {
        int index = studentListView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            studentNameField.setText(studentData.get(index).name());
        }
    }

    private void showAlert(String message) {
        new Alert(Alert.AlertType.WARNING, message, ButtonType.OK).showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Using Java Record for a cleaner Student class
record Student(String name) {}
