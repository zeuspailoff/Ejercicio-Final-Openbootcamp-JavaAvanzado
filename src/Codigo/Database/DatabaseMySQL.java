package Codigo.Database;

import Codigo.entities.Usuario;

public class DatabaseMySQL implements DatabaseStore{
    public void Guardar(Usuario usuario){
        System.out.println("estoy guardando el usuario en database");
    }
}
