package tk.felipe.crud.mvc;
// crud_javamysql_mvc_poo

import tk.felipe.controlador.ControladorProducto;
import tk.felipe.modelo.ConsultasProducto;
import tk.felipe.modelo.Producto;
import tk.felipe.vista.FormularioProducto;

public class CRUD_JavaMySQL_MVC_POO {

  
    public static void main(String[] args) {
        
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        FormularioProducto frm = new FormularioProducto();
        
        ControladorProducto ctrl = new ControladorProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
