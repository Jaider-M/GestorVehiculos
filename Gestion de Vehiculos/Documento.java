import java.util.Date;

public class Documento {
    private String tipo; // "Tecnomecanica" o "Seguro"
    private Date fechaEmision;
    private Date fechaVencimiento;

    public Documento(String tipo, Date fechaEmision, Date fechaVencimiento) {
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
}