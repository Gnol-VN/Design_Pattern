package designPattern;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DatabaseFactory mySQLFactory = new MySQLFactory();
        //Client needs not to know how MysqlDB is instantiate
        Database mysqlLocal1 = mySQLFactory.getDatabase("localhost");
        mysqlLocal1.connect();
        Database mysqlLocal2 = mySQLFactory.getDatabase("localhost");
        mysqlLocal2.connect();

        //The following will be error, since mySQLFactory restrict to only 2 connection
        Database mysqlLocal3 = mySQLFactory.getDatabase("localhost");
    }
}

abstract class Database {
    String dbAddress;
    public Database(String dbAddress) {
        this.dbAddress = dbAddress;
    }
    abstract void connect();
}

class MySQL extends Database {
    public MySQL(String dbAddress) {
        super(dbAddress);
    }
    @Override
    public void connect() {
        System.out.println("Connected to " + dbAddress);
    }
}

class PostgreSQL extends Database {
    public PostgreSQL(String dbAddress) {
        super(dbAddress);
    }
    @Override
    public void connect() {
        System.out.println("Connected to " + dbAddress);
    }
}

class Oracle extends Database {
    public Oracle(String dbAddress) {
        super(dbAddress);
    }
    @Override
    public void connect() {
        System.out.println("Connected to " + dbAddress);
    }
}

interface DatabaseFactory {
    Database getDatabase(String dbAddress);
}

class MySQLFactory implements DatabaseFactory {
    private int numberOfConnection = 0;
    @Override
    public Database getDatabase(String dbAddress) {
        if (numberOfConnection < 2) {
            numberOfConnection++;
            return new MySQL(dbAddress);
        } else {
            System.out.println("Can't connect because of maximum of 2 connections");
            return null;
        }
    }
}

class PostgreSQLFactory implements DatabaseFactory {
    @Override
    public Database getDatabase(String dbAddress) {
        return new PostgreSQL(dbAddress);
    }
}

class OracleFactory implements DatabaseFactory {
    @Override
    public Database getDatabase(String dbAddress) {
        return new Oracle(dbAddress);
    }
}