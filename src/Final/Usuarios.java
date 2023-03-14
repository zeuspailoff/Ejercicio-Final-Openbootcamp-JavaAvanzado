package Sesion24.Codigo.Final;

import java.util.ArrayList;

public class Usuarios {
    UsuariosDB usuariosDB;

    public Usuarios(UsuariosDB usuariosDB) {
        this.usuariosDB = usuariosDB;
    }

    protected Usuarios() {}

    public ArrayList<Usuario> listarUsuarios() {
        return usuariosDB.obtener();
    }

    public Usuario obtenerUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        return usuariosDB.buscar(usuario);
    }

    public void crearUsuario(Usuario usuario) {
        if (usuariosDB.buscar(usuario) != null) {
            return;
        }

        usuariosDB.insertar(usuario);
    }

    public void borrarUsuario(String username) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = username;

        usuariosDB.borrar(usuario);
    }
}
