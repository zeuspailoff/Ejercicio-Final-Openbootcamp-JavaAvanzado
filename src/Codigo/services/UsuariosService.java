package Codigo.services;


import Codigo.Repositories.UsuariosDB;
import Codigo.entities.Usuario;

import java.util.ArrayList;

public class UsuariosService {
    UsuariosDB usuariosDB;

    public UsuariosService(UsuariosDB usuariosDB) {
        this.usuariosDB = usuariosDB;
    }

    protected UsuariosService() {}

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
