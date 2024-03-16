package com.example.demo;

import com.example.demo.Data.*;
import com.example.demo.Logic.Clock_C;
import com.example.demo.Logic.Clock_P;
import com.example.demo.Logic.ShopOfClocks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {

    private ShopOfClocks shop;
    private Database database = new Database(); // База Данных
    private static HelloApplication instance;

    public static HelloApplication getInstance() {
        return instance;
    }

    public ShopOfClocks getShop() {
        return shop;
    }

    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, SQLException {

        initShop();
        instance = this;

        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader1.load(), 700, 700);
        stage.setTitle("Clock's Shop");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    private void initShop() throws IOException, ClassNotFoundException, SQLException {
        //shop = createCustom();     // Создание кастомного объекта
        //shop = loadFromFile();     // Загрузка из файла
        shop = loadFromJson();     // Запись из Json
        //shop = loadFromDatabase(); // Загрузка из Базы Данных
    }

    // Создание кастомного объекта
    private ShopOfClocks createCustom() {
        ShopOfClocks shop = new ShopOfClocks();
        shop.AddOfWatch(new Clock_C("Rolex", 10000,0,0, 1));
        shop.AddOfWatch(new Clock_P("Rolex", 8000,0,0));
        return shop;
    }

    // 1) Загрузка из файла
    private ShopOfClocks loadFromFile() throws IOException, ClassNotFoundException {
        return new FileDeserializer<ShopOfClocks>("test.bin", SerializeStrategy.AS_BYTES).deserialize();
    }

    // 2) Запись из Json
    private ShopOfClocks loadFromJson() throws IOException, ClassNotFoundException {
        return
                new JsonDeserializer(
                    new FileDeserializer<String>("test.txt", SerializeStrategy.AS_STRING).deserialize()
                ).deserialize();
    }

    // 3) Загрузка из Базы Данных
    private ShopOfClocks loadFromDatabase() throws SQLException {
        return database.load();
    }


    @Override
    public void stop() throws IOException, SQLException {
        //saveToFile();     // Сохранение в файл
        saveToJson();     // Запись в Json
        //saveToDatabase(); // Сохранение в Базу Данных
    }

    // 1) Сохранение в файл
    private void saveToFile() throws IOException {
        new FileSerializer<>(shop, "test.bin", SerializeStrategy.AS_BYTES).serialize();
    }

    // 2) Запись в Json
    private void saveToJson() throws IOException {
        new FileSerializer<>(new JsonSerializer(shop).serialize(), "test.txt", SerializeStrategy.AS_STRING).serialize();
    }

    // 3) Сохранение в Базу Данных
    private void saveToDatabase() throws SQLException {
        database.save(shop);
    }

    public static void main(String[] args) {
        launch();
    }
}