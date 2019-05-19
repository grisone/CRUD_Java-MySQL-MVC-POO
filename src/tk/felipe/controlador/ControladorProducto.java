package tk.felipe.controlador;

import tk.felipe.modelo.ConsultasProducto;
import tk.felipe.modelo.Producto;
import tk.felipe.vista.FormularioProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorProducto implements ActionListener{
    
    private Producto mod;
    private ConsultasProducto modC;
    private FormularioProducto frm;
    
    public ControladorProducto(Producto mod, ConsultasProducto modC, FormularioProducto frm){
        
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);       
    }
    
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtID.setVisible(false);      
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource() == frm.btnGuardar){
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Producto Guardado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiarCajas();
            }
        }
        
        if(e.getSource() == frm.btnEditar){
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Producto Ediatado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Editar");
                limpiarCajas();
            }
        }
        
        if(e.getSource() == frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                limpiarCajas();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiarCajas();
            }
        }
        
        if(e.getSource() == frm.btnBuscar){
            mod.setCodigo(frm.txtCodigo.getText());
            
            if(modC.buscar(mod)){
                frm.txtID.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                            
            }else{
                JOptionPane.showMessageDialog(null, "NO SE Encontro Producto");
                limpiarCajas();
            }
        }
        
        if(e.getSource() == frm.btnLimpiar){
            limpiarCajas();
        }
    }
    
    public void limpiarCajas(){
        frm.txtID.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
    } 
    
}
