package com.pioost;

import com.pioost.dependency.CalculationRule;
import com.pioost.dependency.Dependency;
import com.pioost.dependency.TextFiledBindable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        setDependency(root);

        primaryStage.show();
    }

    private void setDependency(GridPane root) {

        Optional<Node> field1 =
            root.getChildrenUnmodifiable().stream().filter(f -> f.getId().equals("field1"))
                .findFirst();

        TextFiledBindable textFiledBindable1 = new TextFiledBindable(
            (javafx.scene.control.TextField) field1.get());


        Optional<Node> field2 =
            root.getChildrenUnmodifiable().stream().filter(f -> f.getId().equals("field2"))
                .findFirst();

        TextFiledBindable textFiledBindable2 = new TextFiledBindable(
            (javafx.scene.control.TextField) field2.get());



        Dependency dependency =
            new DependencyBuilder().from(textFiledBindable1).rule(new CalculationRule())
                .to(textFiledBindable2).build();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
