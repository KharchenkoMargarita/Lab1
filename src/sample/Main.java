
package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {


    private final ObservableList<CityFlag> countriesData;

    private ListView<CityFlag> countries;
    private Label city;
    private ImageView flag;

    public Main() {
        countriesData = FXCollections.observableArrayList(
                new CityFlag("Australia", "Canberra", new Image("/images/Australia.png")),
                new CityFlag("Austria", "Vienna", new Image("/images/Austria.gif")),
                new CityFlag("Belgium", "Brussels", new Image("/images/Belgium.png")),
                new CityFlag("Chile", "Santiago", new Image("/images/Chile.jpg")),
                new CityFlag("Finland", "Helsinki", new Image("/images/Finland.png")),
                new CityFlag("India", "New Delhi", new Image("/images/India.jpg")),
                new CityFlag("Costa Rica", "San Jose", new Image("/images/Costa Rica.png")),
                new CityFlag("Taiwan", "Taipei", new Image("/images/Taiwan.jpg")),
                new CityFlag("USA", "Washington DC", new Image("/images/USA.jpg")),
                new CityFlag("UK", "London", new Image("/images/UK.png")),
                new CityFlag("Sweden", "Stockholm", new Image("/images/Sweden.jpg"))
        );
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Arrange Countries and Capitals");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 450);

        countries = new ListView<>(countriesData);
        countries.setCellFactory(param -> new ListCell<CityFlag>() {
            @Override
            protected void updateItem(CityFlag item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getNameCountry() == null) {
                    setText(null);
                } else {
                    setText(item.getNameCountry());
                }
            }
        });
        countries.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends CityFlag> ov, CityFlag _old, CityFlag _new) -> {
            city.setText(_new.getNameCapital());
            flag.setImage(_new.getFlag());
        });

        city = new Label();
        flag = new ImageView();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        column1.setHgrow(Priority.ALWAYS);
        column2.setHgrow(Priority.ALWAYS);
        column3.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        Label countriesLabel = new Label("Countries");
        GridPane.setHalignment(countriesLabel, HPos.CENTER);
        gridPane.add(countriesLabel, 0, 0);

        Label capitalsLabel = new Label("Capital");
        GridPane.setHalignment(capitalsLabel, HPos.CENTER);
        gridPane.add(capitalsLabel, 1, 0);

        Label flagsLabel = new Label("Flag");
        GridPane.setHalignment(flagsLabel, HPos.CENTER);
        gridPane.add(flagsLabel, 2, 0);

        gridPane.add(countries, 0, 1);
        gridPane.add(city, 1, 1);
        gridPane.add(flag, 2, 1);

        root.setCenter(gridPane);
        GridPane.setVgrow(root, Priority.ALWAYS);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}