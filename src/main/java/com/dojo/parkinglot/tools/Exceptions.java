package com.dojo.parkinglot.tools;

import java.sql.SQLException;

public class Exceptions {
    public static void handle (Exception ex) {
        handle(ex, "");
    }
    public static void handle (Exception ex, String acceptedSQLState) {
        if (ex instanceof SQLException) {
            SQLException  sqlEx = (SQLException) ex;
            System.out.println(
                    String.format("errorCode %s sqlstate %s message %s ",
                            sqlEx.getErrorCode(), sqlEx.getSQLState(), sqlEx.getMessage()));
            if (acceptedSQLState.equals(((SQLException) ex).getSQLState())) {
                System.out.println("Accepted error. continuing...");
            } else {
                throw new RuntimeException(ex.getCause());
            }

        } else {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }

    }

}
