package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ImportarCsv {
    
    
    private String separador;
    
    public ImportarCsv(String separador){
        this.separador = separador;    
    }   
    
    public JTable importarArquivo() {
        
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("/backup/PAPIRO/PAP/SmallBI/Arquivos/"));
        jfc.setDialogTitle("Procurar Arquivo CSV");
        jfc.setFileFilter(new FileNameExtensionFilter(null, "csv"));
        jfc.showOpenDialog(jfc);

        if (jfc.getSelectedFile() != null) { 
            String caminho;
            caminho = jfc.getSelectedFile().getPath();
            File file = new File(caminho);
            try {
                JTable jtable = new JTable();
                jtable.setModel(importarCSV(file));
                return jtable;
            } catch (IOException ex) {
                Logger.getLogger(ImportarCsv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //modelo.setColumnCount(0);
        }
        return null;
    }

    private DefaultTableModel importarCSV(File file) throws FileNotFoundException, IOException {

        DefaultTableModel modelo = new DefaultTableModel();
        
        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            boolean primeiraLinha = true;
            String linha;
            
            while ((linha = br.readLine()) != null) {
                Object[] obj = linha.split(separador);
                if (primeiraLinha) {
                    for (Object objColuna : obj) {
                        modelo.addColumn(objColuna);
                    }
                    primeiraLinha = false;
                } else {
                    modelo.addRow(obj);
                }
            }
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao importar arquivo: " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo: " + ex.getMessage());
        }
        return modelo;
    } 
}