package com.example.randomizerp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HelloApplication extends Application {
    private Roll roll;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void start(Stage stage) throws IOException {

        final FileChooser fileChooser = new FileChooser();

        stage.setTitle("Hello");
        stage.setWidth(500);
        stage.setHeight(600);


        HBox hBox = new HBox();
        Label label = new Label("Hello word");
        label.setPrefWidth(10000);
        label.setAlignment(Pos.CENTER);
        Button button = new Button("Выбрать файл");
        button.setMaxWidth(120);
        button.setMinWidth(120);

        Button button2 = new Button("Сгенерировать");
        button2.setMaxWidth(120);
        button2.setMinWidth(120);
        hBox.getChildren().addAll(label, button, button2);
        hBox.setSpacing(30);
        hBox.setMaxHeight(40);
        hBox.setMinHeight(40);
        //hBox.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(hBox, 10.0);
        AnchorPane.setLeftAnchor(hBox, 20.0);
        AnchorPane.setRightAnchor(hBox, 20.0);

        //ObservableList<String> langs = FXCollections.observableArrayList("Java\nlkdfjsdfsd\nfklsdmlfksd\ndfms;dlfm", "JavaScript", "C#", "Python");
        //ListView<String> listView = new ListView<String>(langs);
        TextArea textArea = new TextArea();
        textArea.setMinHeight(500);
        //listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //listView.setMinHeight(500);

        System.out.println(hBox.getHeight());

        AnchorPane.setTopAnchor(textArea, 60.0);
        AnchorPane.setLeftAnchor(textArea, 20.0);
        AnchorPane.setRightAnchor(textArea, 20.0);

        button.setOnAction((event) -> {
            if(roll != null)
                roll = null;
            File file = fileChooser.showOpenDialog(stage);
            try {
                roll = objectMapper.readValue(file, Roll.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            label.setText(file.getName());
        });

        button2.setOnAction((event) -> {
            String str = roll.getAllRoll(3);
            setClipboard(str);
            textArea.setText(str);
            //String str = "";//= listView.getFocusModel().getFocusedItem();
            //setClipboard(str);
        });


        AnchorPane root = new AnchorPane(hBox, textArea);

        //label.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void setClipboard(String str) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(str);
        clipboard.setContent(content);
    }

    public static void main(String[] args) {
        launch();
    }
}