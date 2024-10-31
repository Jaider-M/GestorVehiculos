import java.util.Date;

public class Mantenimiento {
    private Date fechaMantenimiento;
    private String tipoCambio; // Tipo de cambio realizado
    private double costo;
    private Vehiculo vehiculo;

    public Mantenimiento(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    public list<Vehiculo> getVehiculos() {
        return list.of(vehiculo);
    }

    public Mantenimiento(Date fechaMantenimiento, String tipoCambio, double costo) {
        this.fechaMantenimiento = fechaMantenimiento;
        this.tipoCambio = tipoCambio;
        this.costo = costo;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public double getCosto() {
        return costo;
    }

    public void registrarMantenimiento() {
        System.out.println("Mantenimiento registrado: " + tipoCambio + " el " + fechaMantenimiento);
    }
}
