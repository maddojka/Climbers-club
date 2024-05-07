package ru.soroko.climbers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AscensionDao {
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
                    String mountainName = "";
                    mountainNames.add(null);
                }
                return mountainNames;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
