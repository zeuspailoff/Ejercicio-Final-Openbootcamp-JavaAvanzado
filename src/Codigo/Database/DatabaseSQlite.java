package Codigo.Database;

import Codigo.entities.Usuario;

public class DatabaseSQlite implements DatabaseStore {
    @Override
    public void Guardar(Usuario usuario) {
        System.out.println("estoy guardando el usuario en sqlite");
    }
}
