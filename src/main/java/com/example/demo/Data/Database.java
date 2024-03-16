package com.example.demo.Data;

import com.example.demo.Logic.Clock_C;
import com.example.demo.Logic.Clock_P;
import com.example.demo.Logic.InterfaceOfClock;
import com.example.demo.Logic.ShopOfClocks;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Database {

    private Connection connection;

    public Database() {

    }

    private void reconnect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                    "user=root&password=ktjybl030603");
        }
    }

    public ShopOfClocks load() throws SQLException {
        reconnect();

        ShopOfClocks shop = new ShopOfClocks();

        shop.ReturnList().addAll(loadFromClockP());
        shop.ReturnList().addAll(loadFromClockC());

        return shop;

    }

    public void save(ShopOfClocks shop) throws SQLException {
        reconnect();

        saveClockP(shop.ReturnList().stream().filter(clock -> (clock instanceof Clock_P && !(clock instanceof Clock_C))).map((clock -> (Clock_P)clock)).collect(Collectors.toList()));
        saveClockC(shop.ReturnList().stream().filter(clock -> (clock instanceof Clock_C)).map((clock -> (Clock_C)clock)).collect(Collectors.toList()));
    }

    private void saveClockC(List<Clock_C> clocks) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM `clock_c`")) {
            statement.execute();
        }

        for (Clock_C clock : clocks) {
            PreparedStatement statement;
            if (clock.getId() == -1) {
                statement = connection.prepareStatement("INSERT INTO clock_c (`name`, `cost`, `hours`, `minutes`, `seconds`) VALUES ("
                        + "'" + clock.getName() + "'," +
                        clock.getCost() + "," +
                        clock.getHours() + "," +
                        clock.getMinutes() + "," +
                        clock.getSeconds() +
                        ");");
            } else {
                 statement = connection.prepareStatement("INSERT INTO clock_c (`id`, `name`, `cost`, `hours`, `minutes`, `seconds`) VALUES ("
                        + clock.getId() + ","
                        + "'" + clock.getName() + "'," +
                         clock.getCost() + "," +
                         clock.getHours() + "," +
                         clock.getMinutes() + "," +
                         clock.getSeconds()  +
                        ") ON DUPLICATE KEY UPDATE `name` = '" + clock.getName() + "', `cost` = " + clock.getCost() + ", `hours` = " + clock.getHours() +
                        ", `minutes` = " + clock.getMinutes() + ", `seconds` = " + clock.getSeconds() + ";"
                        );
            }

            try (statement) {
                statement.execute();
            }

        }
    }

    private void saveClockP(List<Clock_P> clocks) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM `clock_p`")) {
            statement.execute();
        }

        for (Clock_P clock : clocks) {
            PreparedStatement statement;
            if (clock.getId() == -1) {
                statement = connection.prepareStatement("INSERT INTO clock_p (`name`, `cost`, `hours`, `minutes`) VALUES ("
                        + "'" + clock.getName() + "'," +
                        clock.getCost() + "," +
                        clock.getHours() + "," +
                        clock.getMinutes() +
                        ");");
            } else {
                statement = connection.prepareStatement("INSERT INTO clock_p (`name`, `cost`, `hours`, `minutes`, `id`) VALUES ("
                        + "'" + clock.getName() + "'," +
                        clock.getCost() + "," +
                        clock.getHours() + "," +
                        clock.getMinutes() + "," +
                        clock.getId() +
                        ") ON DUPLICATE KEY UPDATE `name` = '" + clock.getName() + "', `cost` = " + clock.getCost() + ", `hours` = " + clock.getHours() +
                        ", `minutes` = " + clock.getMinutes() + ";"
                );
            }

            try (statement) {
                statement.execute();
            }

        }
    }

    private List<InterfaceOfClock> loadFromClockC() throws SQLException {

        List<InterfaceOfClock> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clock_c");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int hours = resultSet.getInt("hours");
                int minutes = resultSet.getInt("minutes");
                int seconds = resultSet.getInt("seconds");
                list.add(new Clock_C(name, cost, hours, minutes, seconds, id));
            }
            return list;
        }
    }

    private List<InterfaceOfClock> loadFromClockP() throws SQLException {

        List<InterfaceOfClock> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clock_p");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int hours = resultSet.getInt("hours");
                int minutes = resultSet.getInt("minutes");
                list.add(new Clock_P(name, cost, hours, minutes, id));
            }
            return list;
        }
    }

}
