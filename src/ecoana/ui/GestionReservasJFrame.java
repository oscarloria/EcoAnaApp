
package ecoana.ui;

import ecoana.db.DatabaseManager;
import javax.swing.table.DefaultTableModel; // Para manejar la tabla
import java.util.List; // Para la lista de datos
import java.time.LocalDate; // Para manejar fechas modernas
import java.time.temporal.ChronoUnit; // Para calcular diferencia entre fechas
import java.util.Date; // La tabla devuelve Date (probablemente java.sql.Date)
import javax.swing.JOptionPane; // Para mensajes
import javax.swing.JScrollPane; // Para mostrar texto largo
import javax.swing.JTextArea; // Para mostrar texto largo
import java.text.NumberFormat; // Para formato de moneda (opcional pero bueno)
import java.util.Locale; // Para formato de moneda
import java.awt.print.PrinterException;





public class GestionReservasJFrame extends javax.swing.JFrame {

    private DatabaseManager dbManager;
    /**
     * Creates new form GestionReservasJFrame
     */
    public GestionReservasJFrame() {
        initComponents();
        
        dbManager = new DatabaseManager(); // Inicializar el manejador de BD
        cargarDatosTabla(); // ¡Llamar al método para llenar la tabla!

        // Opcional: Configuración extra de la ventana (recomendado)
        this.setTitle("Gestión de Reservas - Cabaña Eco-Ana");
        this.setLocationRelativeTo(null); // Centrar ventana
    }
    
    
    
    

    private void cargarDatosTabla() {
        // 1. Definir los nombres de las columnas para la tabla
        String[] columnas = {"ID", "Nombre", "Apellidos", "Cédula", "Ingreso", "Salida", "Personas", "Estado"};

        // 2. Crear un modelo de tabla por defecto, sin filas iniciales
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0) {
             @Override
             public boolean isCellEditable(int row, int column) {
                // Hacer que las celdas no sean editables
                return false;
             }
        };

        // 3. Obtener los datos de la base de datos
        // Asegúrate que dbManager no sea null aquí (debería haberse inicializado en el constructor)
        if (dbManager == null) {
             System.err.println("dbManager no inicializado en cargarDatosTabla!");
             return; // Salir si dbManager es null
        }
        List<Object[]> solicitudes = dbManager.getTodasLasSolicitudes();

        // 4. Añadir cada fila de datos al modelo de la tabla
        for (Object[] fila : solicitudes) {
            tableModel.addRow(fila);
        }

        // 5. Establecer el modelo cargado en nuestra JTable (tblReservas)
        tblReservas.setModel(tableModel);

        // 6. (Opcional) Ajustar anchos de columna
        tblReservas.getColumnModel().getColumn(0).setPreferredWidth(40); // ID
        tblReservas.getColumnModel().getColumn(1).setPreferredWidth(100); // Nombre
        tblReservas.getColumnModel().getColumn(2).setPreferredWidth(120); // Apellidos
        tblReservas.getColumnModel().getColumn(3).setPreferredWidth(80);  // Cédula
        tblReservas.getColumnModel().getColumn(7).setPreferredWidth(80);  // Estado
    }
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaImprimir = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblReservas);

        btnAceptar.setText("Aceptar Solicitud");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRechazar.setText("Rechazar Solicitud");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir Factura");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        areaImprimir.setColumns(20);
        areaImprimir.setRows(5);
        jScrollPane2.setViewportView(areaImprimir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRechazar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
     // 1. Obtener la fila seleccionada en la tabla
    int filaSeleccionada = tblReservas.getSelectedRow();

    // 2. Validar si se seleccionó una fila
    if (filaSeleccionada == -1) {
        // Si no hay fila seleccionada, muestra un mensaje y termina
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una solicitud de la tabla.", "Ninguna Solicitud Seleccionada", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 3. Obtener el ID de la solicitud de la fila seleccionada (asumiendo que ID está en la columna 0)
        int idSolicitud = (int) tblReservas.getValueAt(filaSeleccionada, 0); // Columna 0 = ID
        String estadoActual = (String) tblReservas.getValueAt(filaSeleccionada, 7); // Columna 7 = Estado

        // Opcional: Evitar aceptar una ya aceptada/rechazada
        if ("Aceptada".equals(estadoActual) || "Rechazada".equals(estadoActual)) {
             javax.swing.JOptionPane.showMessageDialog(this, "Esta solicitud ya ha sido procesada.", "Solicitud Procesada", javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }


        // 4. Llamar al método del DatabaseManager para actualizar el estado
        boolean actualizado = dbManager.actualizarEstadoSolicitud(idSolicitud, "Aceptada");

        // 5. Mostrar mensaje de confirmación o error
        if (actualizado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Solicitud ID " + idSolicitud + " marcada como ACEPTADA.", "Actualización Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            // 6. ¡Importante! Recargar la tabla para ver el cambio
            cargarDatosTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la solicitud.", "Error de Base de Datos", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
         // Capturar cualquier otro error (ej. ClassCastException si el ID no es int)
         System.err.println("Error al procesar aceptación: " + e.getMessage());
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado al procesar la solicitud.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        // 1. Obtener la fila seleccionada
    int filaSeleccionada = tblReservas.getSelectedRow();

    // 2. Validar selección
    if (filaSeleccionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una solicitud de la tabla.", "Ninguna Solicitud Seleccionada", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 3. Obtener el ID de la solicitud (columna 0)
        int idSolicitud = (int) tblReservas.getValueAt(filaSeleccionada, 0);
         String estadoActual = (String) tblReservas.getValueAt(filaSeleccionada, 7); // Columna 7 = Estado

        // Opcional: Evitar rechazar una ya aceptada/rechazada
        if ("Aceptada".equals(estadoActual) || "Rechazada".equals(estadoActual)) {
             javax.swing.JOptionPane.showMessageDialog(this, "Esta solicitud ya ha sido procesada.", "Solicitud Procesada", javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }

        // 4. Llamar al DatabaseManager para actualizar a "Rechazada"
        boolean actualizado = dbManager.actualizarEstadoSolicitud(idSolicitud, "Rechazada");

        // 5. Mostrar feedback
        if (actualizado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Solicitud ID " + idSolicitud + " marcada como RECHAZADA.", "Actualización Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            // 6. Recargar tabla
            cargarDatosTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el estado de la solicitud.", "Error de Base de Datos", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
         System.err.println("Error al procesar rechazo: " + e.getMessage());
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado al procesar la solicitud.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    } // TODO add your handling code here:
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
     // 1. Obtener la fila seleccionada en la tabla
    int filaSeleccionada = tblReservas.getSelectedRow();

    // 2. Validar si se seleccionó una fila
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una solicitud para imprimir la factura.", "Ninguna Solicitud Seleccionada", javax.swing.JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si no hay selección
    }

    try {
        // 3. Obtener datos de la fila seleccionada (con casting adecuado)
        int idSolicitud = (int) tblReservas.getValueAt(filaSeleccionada, 0);
        String nombreCliente = (String) tblReservas.getValueAt(filaSeleccionada, 1);
        String apellidosCliente = (String) tblReservas.getValueAt(filaSeleccionada, 2);
        String cedulaCliente = (String) tblReservas.getValueAt(filaSeleccionada, 3);
        // Las fechas vienen como Object, castear a java.util.Date (o java.sql.Date si estás seguro)
        java.util.Date fechaIngresoUtil = (java.util.Date) tblReservas.getValueAt(filaSeleccionada, 4);
        java.util.Date fechaSalidaUtil = (java.util.Date) tblReservas.getValueAt(filaSeleccionada, 5);
        int cantPersonas = (int) tblReservas.getValueAt(filaSeleccionada, 6);
        String estadoActual = (String) tblReservas.getValueAt(filaSeleccionada, 7);

        // 4. Validar que el estado sea "Aceptada"
        if (!"Aceptada".equals(estadoActual)) {
            JOptionPane.showMessageDialog(this, "Solo puede imprimir facturas de reservas ACEPTADAS.", "Estado No Válido", javax.swing.JOptionPane.WARNING_MESSAGE);
            return; // Salir si no está aceptada
        }

        // 5. Calcular número de noches (Usando java.time)
        // Convertir fechas a LocalDate (más robusto)
        LocalDate fechaInLocalDate = new java.sql.Date(fechaIngresoUtil.getTime()).toLocalDate();
        LocalDate fechaOutLocalDate = new java.sql.Date(fechaSalidaUtil.getTime()).toLocalDate();

        long noches = ChronoUnit.DAYS.between(fechaInLocalDate, fechaOutLocalDate);

        // Validar número de noches positivo
        if (noches <= 0) {
            JOptionPane.showMessageDialog(this, "Las fechas de ingreso y salida no permiten calcular un número válido de noches.", "Error de Fechas", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 6. Calcular Costos
        double precioPorNochePorPersona = 30.0;
        double tasaIVA = 0.13; // 13%

        double subTotal = noches * cantPersonas * precioPorNochePorPersona;
        double montoIVA = subTotal * tasaIVA;
        double totalPagar = subTotal + montoIVA;

        // Formateador de moneda (ejemplo con $ USD, puedes ajustar Locale si necesitas Colones ₡)
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        // Para Colones (puede requerir configuración regional):
        // Locale localeCR = new Locale("es", "CR");
        // NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeCR);

        // 7. Construir el texto de la factura
        StringBuilder facturaTexto = new StringBuilder();
        facturaTexto.append("----------------------------------------\n");
        facturaTexto.append("        FACTURA - CABAÑA ECO-ANA\n");
        facturaTexto.append("----------------------------------------\n\n");
        facturaTexto.append("Reserva ID: ").append(idSolicitud).append("\n\n");

        facturaTexto.append("Cliente:\n");
        facturaTexto.append("  Nombre: ").append(nombreCliente).append(" ").append(apellidosCliente).append("\n");
        facturaTexto.append("  Cédula: ").append(cedulaCliente).append("\n\n");

        facturaTexto.append("Estadía:\n");
        facturaTexto.append("  Fecha Ingreso: ").append(fechaInLocalDate).append("\n"); // Mostrar LocalDate
        facturaTexto.append("  Fecha Salida:  ").append(fechaOutLocalDate).append("\n"); // Mostrar LocalDate
        facturaTexto.append("  Noches: ").append(noches).append("\n");
        facturaTexto.append("  Personas: ").append(cantPersonas).append("\n\n");

        facturaTexto.append("Detalle Costos:\n");
        facturaTexto.append(String.format("  Subtotal ( %d noches x %d personas x %s /noche): %s\n",
                                           noches, cantPersonas, currencyFormatter.format(precioPorNochePorPersona), currencyFormatter.format(subTotal)));
        facturaTexto.append(String.format("  IVA (13%%): %s\n", currencyFormatter.format(montoIVA)));
        facturaTexto.append("----------------------------------------\n");
        facturaTexto.append(String.format("  TOTAL A PAGAR: %s\n", currencyFormatter.format(totalPagar)));
        facturaTexto.append("----------------------------------------\n\n");
        facturaTexto.append("Emitido: ").append(LocalDate.now()).append("\n"); // Fecha de emisión de factura
        facturaTexto.append("¡Gracias por su visita!\n");

        // 8. Crear JTextArea y llamar a su método print()
        JTextArea areaImprimir = new JTextArea(facturaTexto.toString());
        areaImprimir.setEditable(false);
        // Opcional: Mejorar apariencia para impresión
        areaImprimir.setLineWrap(true);
        areaImprimir.setWrapStyleWord(true);
        // areaImprimir.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12)); // Fuente monoespaciada

        try {
            // Mostrar el diálogo de impresión del sistema
            boolean impresionCompleta = areaImprimir.print();

            // (Opcional) Mostrar mensaje post-impresión
            if (impresionCompleta) {
                System.out.println("INFO: Trabajo de impresión enviado.");
                // JOptionPane.showMessageDialog(this, "La factura ha sido enviada a la cola de impresión.", "Impresión Iniciada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 System.out.println("INFO: Impresión cancelada por el usuario.");
                // JOptionPane.showMessageDialog(this, "La impresión de la factura fue cancelada.", "Impresión Cancelada", JOptionPane.WARNING_MESSAGE);
            }

        } catch (PrinterException ex) {
            // Capturar errores específicos de la impresora
            System.err.println("Error al intentar imprimir: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo iniciar el proceso de impresión.\nVerifique la configuración de su impresora.", "Error de Impresión", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception e) {
         // Capturar cualquier otro error inesperado durante el proceso
         System.err.println("Error al generar/imprimir factura: " + e.getMessage());
         e.printStackTrace();
         JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado al generar la factura.", "Error General", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(GestionReservasJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // Cambia esta línea para crear la nueva ventana
            new GestionReservasJFrame().setVisible(true);
        }
    });
    }
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaImprimir;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblReservas;
    // End of variables declaration//GEN-END:variables
}
