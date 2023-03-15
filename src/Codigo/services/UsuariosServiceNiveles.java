package Codigo.services;

import Codigo.entities.Usuario;

public class UsuariosServiceNiveles extends UsuariosService {
    private UsuariosServiceNiveles() {}

    public boolean esAdministrador(Usuario usuario) {
        return comprobarNivel(usuario, 10);
    }

    public boolean esEstudiante(Usuario usuario) {
        return comprobarNivel(usuario, 5);

    }

    public boolean esInvitado(Usuario usuario) {
        return comprobarNivel(usuario, 1);
    }

    private boolean comprobarNivel(Usuario usuario, int nivel) {
        if (usuariosDB.buscar(usuario) == null) {
            return false;
        }

        if (usuario.nivelAcceso != nivel) {
            return false;
        }

        return true;
    }
}
