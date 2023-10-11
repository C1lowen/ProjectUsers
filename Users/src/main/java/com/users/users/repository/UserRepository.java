package com.users.users.repository;

import com.users.users.model.Role;
import com.users.users.model.User;
import com.users.users.model.UserRole;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@Repository
public class UserRepository
{
    private static final String INSERT_QUERY = "insert into users(name, role_id) values(?, ?);";
    private static final String SELECT_QUERY = "select * from users;";
    private static final String DELETE_QUERY = "delete from users where id = ?";
    private static final String UPDATE_QUERY = "update users set name = ?,role_id = ? WHERE id = ?;";
    private static final String SELECT_WHERE_QUERY = "select * from users where name = ?;";
    private static final String SELECT_JOIN_QUERY = "select users.id, users.name, users.role_id, roles.name from users left join roles on users.role_id = roles.id;";

    public boolean add(User user) {
        return executeQuery(INSERT_QUERY, statement -> {
            try {
                statement.setString(1, user.getName());
                statement.setInt(2, user.getRole_id());
                return statement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public boolean remove(int id) {
        return executeQuery(DELETE_QUERY , statement -> {
            try {
                statement.setInt(1, id);
                return statement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public boolean update(User user) {
        return executeQuery(UPDATE_QUERY, statement -> {
            try {
                statement.setString(1, user.getName());
                statement.setInt(2, user.getRole_id());
                statement.setInt(3, user.getId());
                statement.executeUpdate();
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<User> getByName(String name) {
        return executeQuery(SELECT_WHERE_QUERY, statement -> {
            try {
                statement.setString(1, name);
                try (var set = statement.executeQuery()) {
                    List<User> users = new ArrayList<>();
                    while (set.next()) {
                        User user = new User();
                        user.setId(set.getInt(1));
                        user.setName(set.getString(2));
                        user.setRole_id(set.getInt(3));
                        users.add(user);
                    }
                    return users;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<UserRole> getAllJoined() {
        return executeQuery(SELECT_JOIN_QUERY, statement -> {
            try {
                try (var set = statement.executeQuery()) {
                    List<UserRole> users = new ArrayList<>();
                    while (set.next()) {
                        User user = new User(set.getInt(1), set.getString(2), set.getInt(3));
                        Role role = new Role(set.getString(4));
                        UserRole userRole = new UserRole(user, role);
                        users.add(userRole);
                    }
                    return users;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<User> getAll() {
        return executeQuery(SELECT_QUERY, statement -> {
            try {
                try (var set = statement.executeQuery()) {
                    var users = new ArrayList<User>();
                    while (set.next()) {
                        var user = new User();
                        user.setId(set.getInt(1));
                        user.setName(set.getString(2));
                        user.setRole_id(set.getInt(3));
                        users.add(user);
                    }
                    return users;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private <T> T executeQuery(String query, Function<PreparedStatement, T> function){
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement(query)) {
             return function.apply(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
