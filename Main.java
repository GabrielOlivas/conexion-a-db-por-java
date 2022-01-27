import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.Query;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
import java.sql.ResultSet;
import conexiondb.Conexion;
import singleton.ConexionSingleton;

public class Main {

    public static void main(String[] args) {
        
        // creacion del objeto singleton 
        try {

            // TABLA UNOOOOO AQUI VA TODO LO DE LA PRIMERA TABLAAAA

        ConexionSingleton conexionSingleton = ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ine",
            "ine_user",
            "ine.1234");

           // imprimimos los datos que ya estan registrados en la base de datos
           ResultSet resultSet = conexionSingleton.getConexion().query("select * from ciudadano");

            System.out.println("DATOS DE LA PRIMERA TABLA, CIUDADANO");
           System.out.println("nombres que estan default:");
           while (resultSet.next()) {
            System.out.printf("%-30s", resultSet.getString("nombre"));
        }
        System.out.println("");

        //insertamos un nuevo nombre en la base de datos y volvemos a imprimir para corroborar
        conexionSingleton.getConexion().ejecutar("insert into ciudadano values ('juancho')");
        ResultSet insert1 = conexionSingleton.getConexion().query("select * from ciudadano");
        System.out.println("NOMBRES CON EL INSERT");
        while (insert1.next()) {
            System.out.printf("%-30s", insert1.getString("nombre"));
        }
        System.out.println("");

        //ahora haremos el update al nombre que introdujimos y lo cambiaremos a otro
        conexionSingleton.getConexion().ejecutar("update ciudadano set nombre = 'hermenejildo' where nombre = 'juancho'");
        ResultSet update1 = conexionSingleton.getConexion().query("select * from ciudadano");
        System.out.println("NOMBRES CON EL UPDATE");
        while (update1.next()) {
            System.out.printf("%-30s", update1.getString("nombre"));
        }
        System.out.println("");

        // ahora borraremos el nombre que acabamos de introducir y actualizar y volvemos a imprimir para verificar que ya se borro
        conexionSingleton.getConexion().ejecutar("delete from ciudadano where nombre = 'hermenejildo'");
        ResultSet delete1 = conexionSingleton.getConexion().query("select * from ciudadano");
        System.out.println("NOMBRES CON EL DELETE");
        while (delete1.next()) {
            System.out.printf("%-30s", delete1.getString("nombre"));
        }
        System.out.println("");

        //////////////////////////////////////////////
        // AQUI EMPEZARA LO DE LA TABLA 2 QUE SERA PARECIDO A LO DE LA TABLA UNO PERO DIFERENTEEEE 

        System.out.println("");
        System.out.println("");
      
        ConexionSingleton conexionSingleton2 = ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ine",
            "ine_user",
            "ine.1234");

           // imprimimos los datos que ya estan registrados en la tabla
           ResultSet resultSet2 = conexionSingleton2.getConexion().query("select * from paises");

            System.out.println("DATOS DE LA SEGUNDA TABLA, PAISES");
           System.out.println("nombres de paises que estan default:");
           while (resultSet2.next()) {
            System.out.printf("%-30s", resultSet2.getString("nombre_pais"));
        }
        System.out.println("");

        //insertamos un nuevo nombre en la tabla y volvemos a imprimir para corroborar
        conexionSingleton2.getConexion().ejecutar("insert into paises values ('estados unidos')");
        ResultSet insert2 = conexionSingleton2.getConexion().query("select * from paises");
        System.out.println("PAISES CON EL INSERT");
        while (insert2.next()) {
            System.out.printf("%-30s", insert2.getString("nombre_pais"));
        }
        System.out.println("");

        //ahora haremos el update al pais que introdujimos y lo cambiaremos a otro
        conexionSingleton2.getConexion().ejecutar("update paises set nombre_pais = 'gringolandia' where nombre_pais = 'estados unidos'");
        ResultSet update2 = conexionSingleton2.getConexion().query("select * from paises");
        System.out.println("PAISES CON EL UPDATE");
        while (update2.next()) {
            System.out.printf("%-30s", update2.getString("nombre_pais"));
        }
        System.out.println("");

        // ahora borraremos el nombre que acabamos de introducir y actualizar y volvemos a imprimir para verificar que ya se borro
        conexionSingleton2.getConexion().ejecutar("delete from paises where nombre_pais = 'gringolandia'");
        ResultSet delete2 = conexionSingleton2.getConexion().query("select * from paises");
        System.out.println("PAISES CON EL DELETE");
        while (delete2.next()) {
            System.out.printf("%-30s", delete2.getString("nombre_pais"));
        }
        System.out.println("");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}