import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

@SuppressWarnings("unused")
public abstract class Vehiculo {
    protected String tipo; // "carro" o "moto"
    protected String marca;
    protected String modelo;
    protected int año;
    protected int kilometraje;
    protected String color;
    protected List<Documento> documentos;
    protected List<Mantenimiento> mantenimientos;
    private Object parentComponent;

    public Vehiculo(String tipo, String marca, String modelo, int año, String color) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.kilometraje = 0;
        this.color = color;
        this.documentos = new ArrayList<>();
        this.mantenimientos = new ArrayList<>();
    }

    public void actualizarKilometraje(int km) {
        this.kilometraje = km;
    }

    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }

    public void agregarMantenimiento(Mantenimiento mantenimiento) {
        mantenimientos.add(mantenimiento);
    }

    public void alertarEventos() {
        System.out.println("Revisión de los documentos y mantenimientos del vehículo " + marca + " " + modelo);

        if (documentos.isEmpty()) {
            JOptionPane.showMessageDialog((Component) parentComponent ,"No hay documentos");
        }
        else {

        for (Documento d : documentos) {
            // Revisión de los documentos
            JOptionPane.showMessageDialog((Component) parentComponent, "Tipo de documento: " + d.getTipo() + "\nFecha de emision: " + d.getFechaEmision() + "\nFecha de vencimiento: " + d.getFechaVencimiento());
            
        }
    }

        if (mantenimientos.isEmpty()) {
            JOptionPane.showMessageDialog((Component) parentComponent,  "No hay mantenimientos");
        } else {
        for (Mantenimiento m : mantenimientos) {
            // Revisión de los mantenimientos
            if (mantenimientos.isEmpty()) {
                JOptionPane.showMessageDialog((Component) parentComponent,  "No hay mantenimientos");
            }
            else {
                JOptionPane.showMessageDialog((Component) parentComponent, "Tipo de cambio: " + m.getTipoCambio() + "\nFecha de mantenimiento: " + m.getFechaMantenimiento());
            }
        }
    }
      
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public String getColor() {
        return color;
    }
}
