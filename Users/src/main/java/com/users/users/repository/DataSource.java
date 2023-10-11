package com.users.users.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    private static File file = new File("D:\\postInfo\\postgres.txt");

    static {
        String[] infoPostgres = readFiles();
        config.setJdbcUrl(infoPostgres[0]);
        config.setUsername(infoPostgres[1]);
        config.setPassword(infoPostgres[2]);
        ds = new HikariDataSource(config);
    }

    private static String[] readFiles(){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine().split("[ ]");
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private DataSource(){}
}