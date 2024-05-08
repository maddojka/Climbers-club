package ru.soroko.climbers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AscensionDao {
    public boolean createClimber() {
        String createSql = "CREATE TABLE IF NOT EXISTS tb_climbers(" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(30) NOT NULL, " +
                "surname VARCHAR(50) NOT NULL, " +
                "phone_number INTEGER UNIQUE, " +
                "email VARCHAR(30) UNIQUE)";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createSql);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createMountain() {
        String createSql = "CREATE TABLE IF NOT EXISTS tb_mountains(" +
                "id SERIAL PRIMARY KEY, " +
                "title VARCHAR(30) NOT NULL, " +
                "country VARCHAR(30) NOT NULL, " +
                "height INTEGER CHECK (height > 100))";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createSql);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createGroup() {
        String createSql = "CREATE TABLE IF NOT EXISTS tb_groups(" +
                "id SERIAL PRIMARY KEY, " +
                "superior VARCHAR(100) NOT NULL, " +
                "next_ascension DATE DEFAULT CURRENT_DATE NOT NULL, " +
                "max_climbers INTEGER DEFAULT 50 NOT NULL, " +
                "cost INTEGER NOT NULL, " +
                "mountain_id INTEGER NOT NULL, " +
                "CONSTRAINT fk_mountain_groups " +
                "FOREIGN KEY (mountain_id) " +
                "REFERENCES tb_mountains (id))";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createSql);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createAscension() {
        String createSql = "CREATE TABLE IF NOT EXISTS tb_ascensions(" +
                "id SERIAL PRIMARY KEY, " +
                "start_date TIMESTAMPTZ, " +
                "end_date TIMESTAMPTZ, " +
                "succeed_climbers INTEGER NOT NULL, " +
                "group_id INTEGER NOT NULL, " +
                "CONSTRAINT fk_group_ascensions " +
                "FOREIGN KEY (group_id) " +
                "REFERENCES tb_groups (id))";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createSql);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAscensionSurnamesAndEmails(Climber climber) {
        String selectSql = "SELECT surname, email, " +
                "FROM tb_climbers " +
                "WHERE " +
                "ORDER BY surname";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> getIdByValue() {
        String selectSql = "SELECT id" +
                "FROM tb_groups " +
                "WHERE superior = ";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
                ResultSet resultSet = ps.executeQuery();
                List<Integer> groupsId = new ArrayList<>();
                while (resultSet.next()) {
                    groupsId.add(null);
                }
                return groupsId;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Group> getOpenGroups() {
        String selectSql = "SELECT *" +
                "FROM tb_groups " +
                "WHERE CURRENT_DATE < next_ascension";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
                ResultSet resultSet = ps.executeQuery();
                List<Group> groups = new ArrayList<>();
                while (resultSet.next()) {
                    Group group = new Group();
                    groups.add(null);
                }
                return groups;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ascension> getAscensionsByPeriod() {
        String selectSql = "SELECT *" +
                "FROM tb_ascensions " +
                "WHERE end_date BETWEEN";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
                ResultSet resultSet = ps.executeQuery();
                List<Ascension> ascensions = new ArrayList<>();
                while (resultSet.next()) {
                    Ascension ascension = new Ascension();
                    ascensions.add(null);
                }
                return ascensions;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getMountainNames() {
        String selectSql = "SELECT *" +
                "FROM tb_ascensions " +
                "WHERE end_date BETWEEN";
        try (Connection connection = C3P0Pool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
                ResultSet resultSet = ps.executeQuery();
                List<String> mountainNames = new ArrayList<>();
                while (resultSet.next()) {
                    mountainNames.add(null);
                }
                return mountainNames;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
