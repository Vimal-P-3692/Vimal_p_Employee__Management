import java.sql.*;
class App
{
    String username,password;
    App(String username,String password)
    {
        this.username = username;
        this.password = password;
    }
    public boolean authenticateStudent() {
    String query = "SELECT password FROM Information WHERE username = ?";
    String url = "jdbc:mysql://localhost:3306/Employee";  
    String user = "root";  
    String password1 = "123456789";
    try (Connection connection = DriverManager.getConnection(url, user, password1);
        PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String Storedpassword = resultSet.getString("password");
            if (password.equals(Storedpassword)) {
                return true;  
            }
        }
    } catch (Exception e) {
        e.getMessage();
    }
    return false;
}
}

class Details {
    String username, password;
    Details(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String[] details() {
        String query = "SELECT * FROM Information WHERE username = ?";
        String url = "jdbc:mysql://localhost:3306/Employee";
        String user = "root";
        String password1 = "123456789";

        try (Connection connection = DriverManager.getConnection(url, user, password1);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString(3);
                String name = resultSet.getString(4);
                String department = resultSet.getString(5);
                String phno = resultSet.getString(6);
                String address = resultSet.getString(7);
                String[] arr = {id, name, department, phno, address};
                return arr;
            }

        } catch (SQLException e) {
            e.printStackTrace();  
        }

        return null;  
    }
}

class Registration
{
    String username,password,id,name,department,phno,address;
    Registration(String username,String password,String id,String name,String department,String phno,String address)
    {
        this.username = username;
        this.password = password;
        this.id = id;
        this.name = name;
        this.department = department;
        this.phno = phno;
        this.address = address;
    }
    public void register()
    {
        String query = "INSERT INTO Information(username, password, id, name, department, phno, address) VALUES (?,?,?,?,?,?,?)";
        String url = "jdbc:mysql://localhost:3306/Employee";
        String dbUser = "root";
        String dbPassword = "123456789";


        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password); // Store hashed password
            statement.setString(3, id);
            statement.setString(4, name);
            statement.setString(5, department);
            statement.setString(6, phno);
            statement.setString(7, address);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();  // Print the full stack trace for debugging
        }

    }
}
