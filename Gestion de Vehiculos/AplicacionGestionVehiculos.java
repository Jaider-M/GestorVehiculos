import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

@SuppressWarnings("unused")
public class AplicacionGestionVehiculos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        @SuppressWarnings("unused")
        JFrame jframe = new JFrame();

        try {
        System.out.println("Aplicación de Gestion de Vehículos");
        GestorVehiculos gestor = new GestorVehiculos();

        while (true) {
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Mostrar Vehículos");
            System.out.println("3. Mostrar Documentos");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                try {
                    
                System.out.println("Ingrese tipo de vehículo (carro/moto): ");
                String tipo = scanner.nextLine();
                System.out.println("Ingrese marca: ");
                String marca = scanner.nextLine();
                System.out.println("Ingrese modelo: ");
                String modelo = scanner.nextLine();
                System.out.println("Ingrese año: ");
                int año = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Ingrese color: ");
                String color = scanner.nextLine();

                Vehiculo vehiculo;
                if (tipo.equalsIgnoreCase("carro")) {
                    vehiculo = new Carro(marca, modelo, año, color);
                } else if (tipo.equalsIgnoreCase("moto")) {
                    vehiculo = new Moto(marca, modelo, año, color);
                } else {
                    System.out.println("Tipo de vehículo no válido.");
                    continue;
                }

                // Ingresar kilometraje
                System.out.println("Ingrese kilometraje: ");
                int km = scanner.nextInt();
                vehiculo.actualizarKilometraje(km);
                scanner.nextLine();

                // Ingresar documentos
                System.out.println("¿Desea agregar un documento? (si/no): ");
                if (scanner.nextLine().equalsIgnoreCase("si")) {
                    System.out.println("Ingrese tipo de documento (tecnomecanica/seguro): ");
                    String tipoDocumento = scanner.nextLine();
                    System.out.println("Ingrese fecha de emisión (formato: dd/MM/yyyy): ");
                    String fechaEmisionStr = scanner.nextLine();
                    System.out.println("Ingrese fecha de vencimiento (formato: dd/MM/yyyy): ");
                    String fechaVencimientoStr = scanner.nextLine();

                    Date fechaEmision = convertirFecha(fechaEmisionStr);
                    Date fechaVencimiento = convertirFecha(fechaVencimientoStr);
                    Documento documento = new Documento(tipoDocumento, fechaEmision, fechaVencimiento);
                    vehiculo.agregarDocumento(documento);
                    
                }

                // Ingresar mantenimientos
                System.out.println("¿Desea agregar un mantenimiento? (si/no): ");
                if (scanner.nextLine().equalsIgnoreCase("si")) {
                    System.out.println("Ingrese tipo de cambio: ");
                    String tipoCambio = scanner.nextLine();
                    System.out.println("Ingrese costo: ");
                    double costo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese fecha de mantenimiento (formato: dd/MM/yyyy): ");
                    String fechaMantenimientoStr = scanner.nextLine();
                    Date fechaMantenimiento = convertirFecha(fechaMantenimientoStr);

                    Mantenimiento mantenimiento = new Mantenimiento(fechaMantenimiento, tipoCambio, costo);
                    vehiculo.agregarMantenimiento(mantenimiento);
                }

                gestor.agregarVehiculo(vehiculo);
            }
            // Manejo de excepciones
            catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,"Error: Entrada no válida. " + e.getMessage());
            }
            catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,"Error: Formato de entrada no válido. " + e.getMessage());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
            finally {
                scanner.nextLine(); // Limpiar el buffer
            }
        }
                
             else if (opcion == 2) {
                if (gestor.getVehiculos().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"No hay vehículos registrados.");
                    continue;
                }
                else {
                gestor.mostrarVehiculos(); 
            }
            } else if (opcion == 3) {
                gestor.alertarEventos();
            } else if (opcion == 4) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        
        }
    }
        // Manejo de excepciones
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,"Error: Formato de entrada no válido. " + e.getMessage());
        }
        catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null,"Error: Ups! Entrada no válida. " + e.getMessage());
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
        finally {
        scanner.close();
        }

    }

    private static Date convertirFecha(String fechaStr) {
        try {
            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Formato de fecha no válido.");
            return null;
        }
        finally {
        }
    }
}
