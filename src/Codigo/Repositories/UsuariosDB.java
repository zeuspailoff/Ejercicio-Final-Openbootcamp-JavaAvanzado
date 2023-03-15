package Codigo.Repositories;

import Codigo.entities.Usuario;

import java.util.ArrayList;

 public interface UsuariosDB {


     ArrayList<Usuario> obtener();
     Usuario buscar(Usuario usuario);
     void insertar(Usuario usuario);
     void borrar(Usuario usuario);
}
