package com.github.kubrabal;

import org.jdbi.v3.core.Jdbi;

public class RemoteDatabaseExample {
    private static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11678198";
    private static final String USER = "sql11678198";
    private static final String PASSWORD = "wVJ6TIBGWB";

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create(DB_URL, USER, PASSWORD);

        jdbi.useHandle(handle -> {
            handle.execute("CREATE TABLE IF NOT EXISTS ad_soyad (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))");
        });

        jdbi.useHandle(handle -> {
            handle.execute("INSERT INTO ad_soyad (name) VALUES (?)", "Elif");
            handle.execute("INSERT INTO ad_soyad (name) VALUES (?)", "Ayşe");
            handle.execute("INSERT INTO ad_soyad (name) VALUES (?)", "Fatma");
        });

        jdbi.useHandle(handle -> {
            handle.execute("DELETE FROM ad_soyad WHERE id = ?", 1);
        });
    }
}
