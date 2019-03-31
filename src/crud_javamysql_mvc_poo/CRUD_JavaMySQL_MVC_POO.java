
package crud_javamysql_mvc_poo;

import Controlador.ControladorProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.FormularioProducto;

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
