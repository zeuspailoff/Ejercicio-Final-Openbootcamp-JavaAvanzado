import Codigo.Database.DatabaseSQlite;
import Codigo.Database.DatabaseStore;
import Codigo.Repositories.*;
import Codigo.entities.Usuario;
import Codigo.services.UsuariosService;

public class Main {
    public static void main(String []args) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = "openbootcamp";
        usuario.nombre = "Open";
        usuario.apellidos = "Bootcamp";
        usuario.email = "ejemplos@open-bootcamp.com";
        usuario.nivelAcceso = 1;

        Usuario usuario2 = new Usuario();
        usuario2.nombreUsuario = "openbootcamp2";
        usuario2.nombre = "Open2";
        usuario2.apellidos = "Bootcamp2";
        usuario2.email = "ejemplos2@open-bootcamp.com";
        usuario2.nivelAcceso = 2;

        Usuario usuario3 = new Usuario();
        usuario3.nombreUsuario = "openbootcamp3";
        usuario3.nombre = "Open3";
        usuario3.apellidos = "Bootcamp3";
        usuario3.email = "ejemplos3@open-bootcamp.com";
        usuario3.nivelAcceso = 3;

        UsuariosDB usuariosDB;

        String tipo = "memoria";
        if (tipo.equalsIgnoreCase("fichero")) {
            usuariosDB = new UsuariosDBFichero();
        } else {
            usuariosDB = new UsuariosDBMemoria();
        }

        UsuariosService usuariosService = new UsuariosService(usuariosDB);

        usuariosService.crearUsuario(usuario);
        usuariosService.crearUsuario(usuario2);
        usuariosService.crearUsuario(usuario3);

        DatabaseStore db = new DatabaseSQlite();
        GuardarEnBaseDeDatos(db , usuario);

        Usuario openbootcamp = usuariosService.obtenerUsuario("openbootcamp");
        System.out.println("Email del usuario obtenido: " + openbootcamp.email);

        usuariosService.borrarUsuario("openbootcamp");
        //usuarios.borrarUsuario("openbootcamp3");
        for (Usuario a : usuariosService.listarUsuarios()) {
            System.out.println("Usuario actual: " + a.nombreUsuario);
            System.out.println("----------------" + "-".repeat(a.nombreUsuario.length()));
            System.out.println(a);
            System.out.println();
        }

        imprimirEstadisticas(usuariosDB);



    }
    public static void imprimirEstadisticas(UsuariosDB usuariosDB){
        if(usuariosDB instanceof UsuariosDBMemoria){
            System.out.println("inserciones: " + ((UsuariosDBMemoria) usuariosDB).getTotalInserciones());
            System.out.println("Eliminaciones: " + ((UsuariosDBMemoria) usuariosDB).getTotalEliminaciones());
        }
    }
    public static void GuardarEnBaseDeDatos(DatabaseStore db, Usuario usuario){
        db.Guardar(usuario);
    }
}
