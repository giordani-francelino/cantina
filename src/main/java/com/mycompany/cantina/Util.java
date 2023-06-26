/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina;

import com.mycompany.cantina.repositorio.DbConnection;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Your Name &lt;francelino at ifnmg&gt;
 */
public class Util {
    
    
    
    public void relatorios(String relatorio, String titulo){
            try (InputStream in = getClass().getResourceAsStream(relatorio)) {

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    in, null, DbConnection.getConnection());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            JDialog jDialog = new JDialog();
            jDialog.setContentPane(jasperViewer.getContentPane());
            jDialog.setSize(jasperViewer.getSize());
            jDialog.setTitle(titulo);
            jDialog.setModal(true);
            jDialog.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
