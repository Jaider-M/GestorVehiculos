import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GestorVehiculos {
    private List<Vehiculo> vehiculos;
    private Object parentComponent;

    public GestorVehiculos() {
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void mostrarVehiculos() {
        for (Vehiculo v : vehiculos) {
            JOptionPane.showMessageDialog((Component) parentComponent, v.getTipo() + " - " + v.getMarca() + " " + v.getModelo() + "\n Año de modelo: " + v.getAño() + "\n Color: " + v.getColor() + "\n Kilometros: " +  v.getKilometraje() );
        }
    }

    public void alertarEventos() {
        for (Vehiculo v : vehiculos) {
            v.alertarEventos();
        }
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}

