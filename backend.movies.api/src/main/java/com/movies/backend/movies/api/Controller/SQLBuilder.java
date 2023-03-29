package com.movies.backend.movies.api.Controller;

public class SQLBuilder {
    public String getSQL(String table, String from, String where){
        return "SELECT " + table + " FROM " + from + " WHERE " + where + ";";
    }

    public String getSQLTable(String table){
        return "SELECT " + "*" + " FROM " + table + ";";
    }
}
