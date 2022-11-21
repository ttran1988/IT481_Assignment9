import java.sql.*;
import java.util.ArrayList;

public class SQLDataBase{
    private String URL;
    private Connection connection;


    public SQLDataBase() {
        this.URL = "jdbc:sqlserver://;servername=DESKTOP-4P5ION6\\sqlexpress;trustServerCertificate=true;integratedSecurity=true;databaseName=Northwind"; //Windows Authentication
    }

    public SQLDataBase(String connection) {

        this.URL = connection;
    }

    public void connectToDb() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnectFromDB() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isConnectionSuccessful() {
        try {
            if (connection.isValid(0)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String getCustomerCount() {
        String customerCount = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select count(*) from dbo.Customers;");

            while (result.next()) {
                customerCount = result.getString(1);
            }

        } catch (Exception e) {
            return "denied";
        }
        return customerCount;
    }

    public ArrayList<String> getCustomerID() {
        ArrayList<String> customerIDList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select distinct CustomerID from dbo.Orders;");

            while (result.next()) {
                customerIDList.add("\n" + result.getString(1));
            }

        } catch (Exception e) {
            customerIDList.add("denied");
            return customerIDList;
        }
        return customerIDList;
    }

    public String getOrderCount() {
        String orderCount = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select count(*) from dbo.Orders;");

            while (result.next()) {
                orderCount = result.getString(1);
            }

        } catch (Exception e) {
            return "denied";
        }
        return orderCount;
    }

    public ArrayList<String> getOrderID() {
        ArrayList<String> orderIDList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select distinct OrderID from dbo.Orders;");

            while (result.next()) {
                orderIDList.add("\n" + result.getString(1));
            }

        } catch (Exception e) {
            orderIDList.add("denied");
            return orderIDList;
        }
        return orderIDList;
    }

    public String getEmployeeCount() {
        String employeeCount = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select count(*) from dbo.Employees;");

            while (result.next()) {
                employeeCount = result.getString(1);
            }

        } catch (Exception e) {
            return "denied";
        }
        return employeeCount;
    }

    public ArrayList<String> getEmployeeLastName() {
        ArrayList<String> employeeLastNameList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select lastname from dbo.Employees;");

            while (result.next()) {
                employeeLastNameList.add("\n" + result.getString(1));
            }

        } catch (Exception e) {
            employeeLastNameList.add("denied");
            return employeeLastNameList;
        }
        return employeeLastNameList;
    }

    public ArrayList<String> getCompanyName() {
        ArrayList<String> companyName = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select companyname from dbo.Customers;");

            while (result.next()) {
                companyName.add("\n" + result.getString(1));
            }

        } catch (Exception e) {
            companyName.add("denied");
            return companyName;
        }
        return companyName;
    }

    public ArrayList<String> getShipName() {
        ArrayList<String> shipName = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select shipname from dbo.Orders;");

            while (result.next()) {
                shipName.add("\n" + result.getString(1));
            }

        } catch (Exception e) {
            shipName.add("denied");
            return shipName;
        }
        return shipName;
    }
}
