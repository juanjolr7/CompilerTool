
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Compilador de Java";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".java");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
//        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
//            timerKeyReleased.stop();
//            //colorAnalysis();
//        });
//        Functions.insertAsteriskInName(this, jtpCode, () -> {
//            timerKeyReleased.restart();
//        });
        Functions.insertAsteriskInName(this, jtpCode);
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        btnCompilar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jtpCode.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtpCode);

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(70, 73, 75));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setForeground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblTokens);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(btnCompilar)
                        .addGap(136, 136, 136)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompilar))
                .addGap(15, 15, 15)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed



    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
       // semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }
    private void syntacticAnalysis() {
        Grammar g= new Grammar(tokens,errors);
        g.disableMessages();
        g.disableValidations();
        g.delete(new String[]{"ERROR"},1);
        
        g.group("OPERADORARITMETICO","(SUMA | RESTA | MULTIPLICACION | DIVISION | MODULO)");
        g.group("OPERADORELACIONAL", "(IGUAL | NOTIGUAL | DIFERENTE | MENOR | MENORIGUAL | MAYOR | MAYORIGUAL)");
        g.group("INCDEC", "(INCREMENTO | DECREMENTO)");
        g.group("TIPODATO","(BOOLEAN | DOUBLE | INT | SHORT | CHAR | LONG | FLOAT | STRING | VOID)");
        g.group("OPERADORLOGICO", "(AND | OR)");
        g.group("MODACCESO", "(PUBLIC | PROTECTED | PRIVATE)");
        //g.group("TCLASS","(INTERFACE)");
        // g.group("TMETHOD","(STATIC | ABSTRACT)");
        g.group("OPASIG", "(ASIGNACIONSIMPLE | ASIGNACIONSUMA | ASIGNACIONRESTA | ASIGNACONMULTIPLICACION | ASIGNACIONDIVISION | ASIGNACIONMODULO)");
        
        //valores
        g.group("VALOR", "(NUMERO | NUMERODECIMAL | TEXTO | CARACTER | TRUE | FALSE)");
        
        //Expresiones Ariteticas
       
        
        g.loopForFunExecUntilChangeNotDetected(()->{
                g.group("EXP_ARITMETICA", "(VALOR | IDENTIFICADOR) (OPERADORARITMETICO (VALOR | IDENTIFICADOR))+");
                g.group("EXP_ARITMETICA", "(EXP_ARITMETICA) (OPERADORARITMETICO (EXP_ARITMETICA))+");
               // g.group("EXP_ARITMETICA","PARENTESISAPERTURA (EXP_ARITMETICA | VALOR | IDENTIFICADOR) PARENTESISCIERRE",true);
       }); 
        
        g.group("EXP_ARITMETICA","IDENTIFICADOR (INCREMENTO | DECREMENTO)",true);
        //Expresiones Logicas
  
       
       g.loopForFunExecUntilChangeNotDetected(()->{
            g.group("EXP_LOGICA","(VALOR | IDENTIFICADOR | EXP_ARITMETICA) (OPERADORELACIONAL (VALOR | IDENTIFICADOR | EXP_ARITMETICA))+");
           g.group("EXP_LOGICA", "(EXP_LOGICA) (OPERADORLOGICO (EXP_LOGICA))+");
           //g.group("EXP_LOGICA","PARENTESISAPERTURA (EXP_LOGICA | VALOR | IDENTIFICADOR) PARENTESISCIERRE",true);
       });
        
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR OPASIG (VALOR | IDENTIFICADOR | EXP_ARITMETICA) PUNTOCOMA",true);
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR PUNTOCOMA",true);
        //Errores
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR OPASIG (VALOR | IDENTIFICADOR | EXP_ARITMETICA)",true,2,
                "Error Sintactico {}: falta ; [#,%]");
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR OPASIG",true,2,
                "Error Sintactico {}: no se esta asignando nada [#,%]");
//        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR",true,2,
//                "Error Sintactico {}: falta ; [#,%]");
         //Asignación de operaciones 
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG (EXP_ARITMETICA | IDENTIFICADOR) PUNTOCOMA",true);
        //Errores
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG (EXP_ARITMETICA | IDENTIFICADOR)",true,16,
                "error sintáctico {}: falta el delimitador ; [#,%]");
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG",true,16,
                "error sintáctico {}: falta el valor a asignar [#,%]");
        g.group("ASIG_VALOR","OPASIG (EXP_ARITMETICA | IDENTIFICADOR)",true,16,
                "error sintáctico {}: falta el identificador [#,%]");
        
        //Impresion
        //Impresion
        g.group("IMPRESION","SYSTEM PUNTO OUT PUNTO (PRINT | PRINTLN) PARENTESISAPERTURA (VALOR | IDENTIFICADOR)? PARENTESISCIERRE PUNTOCOMA",true);
        g.group("IMPRESION","SYSTEM OUT PUNTO (PRINT | PRINTLN) PARENTESISAPERTURA (VALOR | IDENTIFICADOR)? PARENTESISCIERRE PUNTOCOMA",true,20
        ,"error sintactico {}: falta .");
        g.group("IMPRESION","SYSTEM PUNTO OUT (PRINT | PRINTLN) PARENTESISAPERTURA (VALOR | IDENTIFICADOR)? PARENTESISCIERRE PUNTOCOMA",true,20
        ,"error sintactico {}: falta .");
        g.group("IMPRESION","SYSTEM PUNTO OUT PUNTO (PRINT | PRINTLN) PARENTESISAPERTURA (VALOR | IDENTIFICADOR)? PARENTESISCIERRE",true,20
        ,"error sintactico {}: falta el delimitador ;");
        g.group("IMPRESION","SYSTEM PUNTO OUT PUNTO (PRINT | PRINTLN) (VALOR | IDENTIFICADOR)? PARENTESISCIERRE PUNTOCOMA",true,20
        ,"error sintactico {}: falta parentesis de apertura");
        g.group("IMPRESION","SYSTEM PUNTO OUT PUNTO (PRINT | PRINTLN) PARENTESISAPERTURA (VALOR | IDENTIFICADOR)? PUNTOCOMA",true,20
        ,"error sintactico {}: falta parentesis de cierre");
        //Estructura if else
        g.group("EST_IF","IF PARENTESISAPERTURA (VALOR | EXP_LOGICA | IDENTIFICADOR)? PARENTESISCIERRE",true);
        g.group("EST_IF","IF (VALOR | EXP_LOGICA | IDENTIFICADOR)? PARENTESISCIERRE",true,7,""
                + "Error sintactico {}: falta parentesis apertura [#,%]");
        g.group("EST_IF","IF PARENTESISAPERTURA (VALOR | EXP_LOGICA | IDENTIFICADOR)?",true,7,""
                + "Error sintactico {}: falta parentesis cierre [#,%]");
       
        g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)? LLAVECIERRE"
                + "(ELSE LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)? LLAVECIERRE)?");
        
        //Erroes
         g.group("EST_IF_C","EST_IF",true,13,"Error Sintactico {}: falta { en el if [#,%]");
         g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)?"
                + "(ELSE LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)? LLAVECIERRE)?",true,13,"Error Sintactico {}: falta { en el if [#,%]");
         g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)? LLAVECIERRE"
                + "(ELSE)?",true,13,"Error Sintactico {}: falta { en el else [#,%]");
         g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)? LLAVECIERRE"
                + "(ELSE LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)?)?",true,13,"Error Sintactico {}: falta } en el else [#,%]");
       // g.group("PARAMETROS", "TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR");
      //   g.group("PARAMETROS", "TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*");
//        g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
//                 + "PARENTESISAPERTURA ("
//                + "TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*"
//                + ")? PARENTESISCIERRE LLAVEAPERTURA (EST_IF_C"
//                + " | VARIABLES | ASIG_VALOR | IMPRESION)* LLAVECIERRE");
          g.group("ATRIBUTO","MODACCESO VARIABLE");
         g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE LLAVEAPERTURA (EST_IF_C"
                 + " | VARIABLE | ASIG_VALOR | IMPRESION)* LLAVECIERRE");
       //Errores
            g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE LLAVEAPERTURA (EST_IF_C"
                 + " | VARIABLE | ASIG_VALOR | IMPRESION)*",true,11,""
                         + "Error sintactico{}: falta } en la funcion [#,%]");
            g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE (EST_IF_C"
                 + " | VARIABLE | ASIG_VALOR | IMPRESION)* LLAVECIERRE",true,11,""
                         + "Error sintactico{}: falta { en la funcion [#,%]");
            g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE"
                       ,true,11,""
                         + "Error sintactico{}: falta { en la funcion [#,%]");
        //Clases
         g.group("CLASE","MODACCESO (INTERFACE | ABSTRACT)? CLASS IDENTIFICADOR LLAVEAPERTURA (FUNCION | ATRIBUTO)* LLAVECIERRE",true);
        //Errores
         g.group("CLASE","MODACCESO (INTERFACE | ABSTRACT)? CLASS IDENTIFICADOR (FUNCION | ATRIBUTO)* LLAVECIERRE",true,11,
                 "Error sintactico {}: Falta { en la declaracion de clase");
         g.group("CLASE","MODACCESO (INTERFACE | ABSTRACT)? CLASS IDENTIFICADOR LLAVEAPERTURA (FUNCION | ATRIBUTO)*",true,11,
                 "Error sintactico {}: Falta } en la declaracion de clase");
       g.delete("IF",10,"Error sintactico {}: Error al declarar if [#,%]");
        g.delete("EST_IF",10,"Error sintactico {}: Error al declarar if [#,%]");
        g.delete("PUNTOCOMA",4,"Error Sintactico{}: ; no esta al final de una sentencia [#,%]");
        g.delete("OPASIG",5,"Error Sintactico{}: operador de asignacion no esta en una sentencia [#,%]");
        g.show();
    }
   

 


    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            
            if(!token.getLexeme().equals("OPERADORARITMETICO")&&!token.getLexeme().equals("OPERADORRELACIONAL")&&
                   !token.getLexeme().equals("OPERADORLOGICO") && !token.getLexeme().equals("OPERADORASIGNACION")&&
                    !token.getLexeme().equals("DELIMITADOR")){
            Functions.addRowDataInTable(tblTokens, data);
            }
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
