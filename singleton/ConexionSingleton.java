package singleton;
 
import conexiondb.Conexion;
 
// Clase con patrón Singleton
public class ConexionSingleton {
 
    private static ConexionSingleton conexionSingleton;
    private Conexion conexion;
 
 // Constructor privado
    private ConexionSingleton(String url, String user, String passWord) {
         conexion = new Conexion(url, user, passWord);
    }
 
 // Método de clase, con retorno de la misma clase: ConexionSingleton
     public static ConexionSingleton getInstance(String url, String user, String passWord) {
        if (conexionSingleton == null) {
         conexionSingleton = new ConexionSingleton(url, user, passWord);
        }
        return conexionSingleton;
    }
 
    public Conexion getConexion() {
        return conexion;
    }
 
}