
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
import java.util.List;
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
   // private HashMap<String,String> parametros = new HashMap<>();//nombre parametro - tipo parametro
    private HashMap<String,Production> funciones = new HashMap<>();
    HashMap<String,Production> llamadas = new HashMap<>();
    private HashMap<String, String> identSV = new HashMap<>();
    private boolean codeHasBeenCompiled = false;
    private ArrayList<FuncionData> funDat = new ArrayList<>();
    private HashMap<String,FuncionData> functionData = new HashMap<>();
    private HashMap<String,FuncData> pvFuncion = new HashMap<>();
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
       //semanticAnalysis();
       semanticAnalysis2();
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
              // g.group("EXP_ARITMETICA","PARENTESISAPERTURA (EXP_ARITMETICA | VALOR | IDENTIFICADOR) PARENTESISCIERRE");
                g.group("EXP_ARITMETICA", "(EXP_ARITMETICA) (OPERADORARITMETICO (VALOR | IDENTIFICADOR))*");
       }); 
        
        g.group("EXP_ARITMETICA","IDENTIFICADOR (INCREMENTO | DECREMENTO)",true);
        //Expresiones Logicas
  
       
       g.loopForFunExecUntilChangeNotDetected(()->{
            g.group("EXP_LOGICA","(VALOR | IDENTIFICADOR | EXP_ARITMETICA) (OPERADORELACIONAL (VALOR | IDENTIFICADOR | EXP_ARITMETICA))+",true,identProd);
           g.group("EXP_LOGICA", "(EXP_LOGICA) (OPERADORLOGICO (EXP_LOGICA))+");
           //g.group("EXP_LOGICA","PARENTESISAPERTURA (EXP_LOGICA | VALOR | IDENTIFICADOR) PARENTESISCIERRE",true);
       });
        
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR OPASIG (VALOR | IDENTIFICADOR | EXP_ARITMETICA) PUNTOCOMA",true,identProd);
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR PUNTOCOMA",true,identProd);
        //Errores
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR OPASIG (VALOR | IDENTIFICADOR | EXP_ARITMETICA)",true,2,
                "Error Sintactico {}: falta ; [#,%]");
        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR OPASIG",true,2,
                "Error Sintactico {}: no se esta asignando nada [#,%]");
//        g.group("VARIABLE","TIPODATO (STATIC)? IDENTIFICADOR",true,2,
//                "Error Sintactico {}: falta ; [#,%]");
         //Asignación de operaciones 
        //llamada a Funcion
        g.group("CALLF", " GATO IDENTIFICADOR PARENTESISAPERTURA ((IDENTIFICADOR | VALOR) (COMA (IDENTIFICADOR | VALOR))*)? PARENTESISCIERRE PUNTOCOMA",true,identProd);
        //Errores
         g.group("CALLF", " GATO IDENTIFICADOR PARENTESISAPERTURA ((IDENTIFICADOR | VALOR) (COMA (IDENTIFICADOR | VALOR))*)? PARENTESISCIERRE",true,21,
                 "Error sintactico {}: falta ; [#,%]");
         g.group("CALLF", "GATO IDENTIFICADOR PARENTESISAPERTURA ((IDENTIFICADOR | VALOR) (COMA (IDENTIFICADOR | VALOR))*)?",true,21,
                 "Error sintactico {}: falta ) [#,%]");
 
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG (EXP_ARITMETICA | IDENTIFICADOR | VALOR) PUNTOCOMA",true,identProd);
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG CALLF",true,identProd);
        //Errores
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG (EXP_ARITMETICA | IDENTIFICADOR | VALOR)",true,16,
                "error sintáctico {}: falta el delimitador ; [#,%]");
        g.group("ASIG_VALOR","IDENTIFICADOR OPASIG",true,16,
                "error sintáctico {}: falta el valor a asignar [#,%]");
        g.group("ASIG_VALOR","OPASIG (EXP_ARITMETICA | IDENTIFICADOR | VALOR)",true,16,
                "error sintáctico {}: falta el identificador [#,%]");
        g.group("ASIG_VALOR","OPASIG CALLF",true,16,
                "error sintáctico {}: falta el identificador [#,%]");
        //return
        g.group("RETURNV","RETURN (VALOR | IDENTIFICADOR | EXP_ARITMETICA) PUNTOCOMA",true,identProd);
        //Errores
        g.group("RETURNV","RETURN (VALOR | IDENTIFICADOR | EXP_ARITMETICA)",true,17,"error sintáctico {}: falta el delimitador ; [#,%]");
        g.group("RETURNV","RETURN PUNTOCOMA",true,17,"error sintáctico {}: falta valor de retorno [#,%]");
        g.group("RETURNV","RETURN",true,17,"error sintáctico {}: falta valor de retorno [#,%]");
        
        
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
       
        g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE | CALLF)+)? (RETURNV)? LLAVECIERRE"
                + "(ELSE LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE | CALLF)+)? (RETURNV)? LLAVECIERRE)?",identProd);
        
        //Erroes
         g.group("EST_IF_C","EST_IF",true,13,"Error Sintactico {}: falta { en el if [#,%]");
         g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE | CALLF)+)? (RETURNV)?"
                + "(ELSE LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE | CALLF)+)? LLAVECIERRE)?",true,13,"Error Sintactico {}: falta { en el if [#,%]");
         g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE)+)? LLAVECIERRE"
                + "(ELSE)?",true,13,"Error Sintactico {}: falta { en el else [#,%]");
         g.group("EST_IF_C","EST_IF LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE | CALLF)+)? (RETURNV)? LLAVECIERRE"
                + "(ELSE LLAVEAPERTURA ((ASIG_VALOR | IMPRESION | VARIABLE | CALLF)+)? (RETURNV)?)?",true,13,"Error Sintactico {}: falta } en el else [#,%]");
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
                 + " | VARIABLE | ASIG_VALOR | IMPRESION | CALLF)* (RETURNV)? LLAVECIERRE",identProd);
       //Errores
            g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE LLAVEAPERTURA (EST_IF_C"
                 + " | VARIABLE | ASIG_VALOR | IMPRESION | CALLF)* (RETURNV)?",true,11,""
                         + "Error sintactico{}: falta } en la funcion [#,%]");
            g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE (EST_IF_C"
                 + " | VARIABLE | ASIG_VALOR | IMPRESION | CALLF)* (RETURNV)? LLAVECIERRE",true,11,""
                         + "Error sintactico{}: falta { en la funcion [#,%]");
            g.group("FUNCION","MODACCESO (STATIC | INTERFACE | ABSTRACT)? TIPODATO IDENTIFICADOR"
                 + " PARENTESISAPERTURA (TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR (COMA TIPODATO (CORCHETEAPERTURA CORCHETECIERRE)? IDENTIFICADOR)*)? PARENTESISCIERRE"
                       ,true,11,""
                         + "Error sintactico{}: falta { en la funcion [#,%]");
        //Clases
         g.group("CLASE","MODACCESO (INTERFACE | ABSTRACT)? CLASS IDENTIFICADOR LLAVEAPERTURA (FUNCION | ATRIBUTO)* LLAVECIERRE",true,identProd);
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
   
    private void semanticAnalysis(){
//        System.out.println("Parte del Analisis Semantico");
//        
//        HashMap<String,String>identDataType = new HashMap<>();
//        
//        
//        identDataType.put("int", "NUMERO");
//        identDataType.put("double", "NUMERODECIMAL");
//        identDataType.put("float","NUMERODECIMAL");
//        identDataType.put("String", "TEXTO");
//        identDataType.put("char","CARACTER");
//        identDataType.put("boolean", "TRUE");
//        HashMap<String,String>identDataType2 = new HashMap<>();
//        identDataType2.put("boolean", "FALSE");
//        //Recorrido para llamadas
//        for(Production id: identProd){
//            if(id.getName().equals("CALLF")){
//         llamadas.put(id.lexemeRank(1), id);
//        
//        }
//        
//        }
//        //Primer Recorrido para buscar funciones
//        for(Production id: identProd){
//            if(id.getName().equals("FUNCION")){
//                if(id.lexicalCompRank(1).equals("STATIC")){
//                    if(!functionData.containsKey(id.lexemeRank(3))){
//                        FuncionData fd = new FuncionData(id.getLine(),id.getFinalLine(),
//                    id.lexemeRank(3),true,id.lexemeRank(2));
//                    functionData.put(id.lexemeRank(3), fd);
//                    funDat.add(fd);
//                    funciones.put(id.lexemeRank(3), id);
//                    System.out.println(obtenerParametrosFuncion(id));
//                    }else{
////                         errors.add(new ErrorLSSL(5,"Error semántico {}: Identificador de Funcion Repetido [#,%]",id,true));
//                    }
//                }else{
//                    if(!functionData.containsKey(id.lexemeRank(2))){
//                        FuncionData fd2 = new FuncionData(id.getLine(),id.getFinalLine(),id.lexemeRank(2),false,id.lexemeRank(1));
//                   functionData.put(id.lexemeRank(2), fd2);
//                   funDat.add(fd2);
//                   funciones.put(id.lexemeRank(2), id); 
//                    System.out.println(obtenerParametrosFuncion(id));
//                    }else{
////                        errors.add(new ErrorLSSL(5,"Error semántico {}: Identificador de Funcion Repetido [#,%]",id,true));
//                    } 
//                }
//            }
//        }
//        System.out.println(functionData);
//        for(Production id : identProd){
//            System.out.println(id.getSizeTokens());
//            System.out.println(id.getLine());
//            System.out.println(id.getFinalLine());
//            System.out.println(id.getName());
//             System.out.println(id.lexemeRank(0,-1));
//             System.out.println(id.lexicalCompRank(0,-1));
//            if(id.getName().equals("VARIABLE")&&id.getSizeTokens()>3){
//                   
//                        if(id.lexicalCompRank(0).equals("BOOLEAN")){
//                              if(!(id.lexicalCompRank(-2).equals("TRUE")||id.lexicalCompRank(-2).equals("FALSE"))){
//                                   errors.add(new ErrorLSSL(1,"Error semántico {}: Valor no compatible con el tipo de dato [#,%]",id,true));
//                              }else{
//                                 if( !identificadores.containsKey(id.lexemeRank(1))&&!id.lexemeRank(1).equals("static")){
//                                 identificadores.put(id.lexemeRank(1), id.lexemeRank(0));
//                                 }else if(!identificadores.containsKey(id.lexemeRank(2))&&id.lexemeRank(1).equals("static")){
//                                 identificadores.put(id.lexemeRank(2), id.lexemeRank(0));
//                                 }else{
//                                 errors.add(new ErrorLSSL(2,"Error semántico {}: Identificador repetido [#,%]",id,true));
//                                 }
//                                  
//                              }
//                        }else{
//                            if(!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-2))){
//                                    errors.add(new ErrorLSSL(1,"Error semántico {}: Valor no compatible con el tipo de dato [#,%]",id,true));
//                                }else{
//                                if( !identificadores.containsKey(id.lexemeRank(1))&&!id.lexemeRank(1).equals("static")){
//                                 identificadores.put(id.lexemeRank(1), id.lexemeRank(0));
//                                 }else if(!identificadores.containsKey(id.lexemeRank(2))&&id.lexemeRank(1).equals("static")){
//                                 identificadores.put(id.lexemeRank(2), id.lexemeRank(0));
//                                 }
//                                else{
//                                errors.add(new ErrorLSSL(2,"Error semántico {}: Identificador repetido [#,%]",id,true));
//                                 }
//                            }
//                        }
//            }else if(id.getName().equals("VARIABLE")&&id.getSizeTokens()==3){
//                     if( !identSV.containsKey(id.lexemeRank(1))&& !identificadores.containsKey(id.lexemeRank(1))&&!id.lexemeRank(1).equals("static")){
//                                 identSV.put(id.lexemeRank(1), id.lexemeRank(0));
//                                 }else if(!identSV.containsKey(id.lexemeRank(2))&& !identificadores.containsKey(id.lexemeRank(1))&&id.lexemeRank(1).equals("static")){
//                                 identSV.put(id.lexemeRank(2), id.lexemeRank(0));
//                                 }
//                                else{
//                                 errors.add(new ErrorLSSL(2,"Error semántico {}: Identificador repetido [#,%]",id,true));
//                                 }
//            
//            }else if(id.getName().equals("ASIG_VALOR")){
//                if(identSV.containsKey(id.lexemeRank(0))&&checkID(id,1)){
//                    identificadores.put(id.lexemeRank(0),identSV.get(id.lexemeRank(0)));
//                    identSV.remove(id.lexemeRank(0),identSV.get(id.lexemeRank(0)));
//                }
//                if(!checkID(id,0)&&!identSV.containsKey(id.lexemeRank(0))){
//                    errors.add(new ErrorLSSL(3,"Error semántico {}: Identificador no declarado [#,%]",id,true));
//                }
//                
//            }else if(id.getName().equals("RETURNV")){
//                for(FuncionData f: funDat){
//                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
//                       if(f.isIsStatic()){
//                           errors.add(new ErrorLSSL(6,"Error semántico {}: Void no retorna [#,%]",id,true));
//                       }else{
//                           if(!f.getTipoDato().equals("boolean")){
//                           if( !identDataType.get(f.getTipoDato()).equals(id.lexicalCompRank(1))){
//                            errors.add(new ErrorLSSL(6,"Error semántico {}: El return regresa datos incorrectos [#,%]",id,true));
//                           }
//                           }else{
//                             if( !id.lexicalCompRank(1).equals("TRUE")&&!id.lexicalCompRank(1).equals("FALSE")){
//                            errors.add(new ErrorLSSL(6,"Error semántico {}: El return regresa datos incorrectos [#,%]",id,true));
//                           }  
//                           }
//                       }
//                }
//            }
//            
//        }else if(id.getName().equals("EST_IF_C")){
//            for(int i=0;i<id.getSizeTokens();i++){
//                if(id.lexicalCompRank(i).equals("IDENTIFICADOR")){
//                    if(!llamadas.containsKey(id.lexemeRank(i))){
//                    if(!identificadores.containsKey(id.lexemeRank(i))){
//                       errors.add(new ErrorLSSL(7,"Error semántico {}: Identificador no definido [#,%]",id,true)); 
//                    }}
//                }
//            }
//        }else if(id.getName().equals("CALLF")){
//            if(!functionData.containsKey(id.lexemeRank(1))){
//                errors.add(new ErrorLSSL(8,"Error semántico {}: Funcion No Definida [#,%]",id,true)); 
//            }else{
//                for(FuncionData f: funDat){
//                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
//                        if(f.isIsStatic()!=functionData.get(id.lexemeRank(1)).isIsStatic()){
//                            errors.add(new ErrorLSSL(9,"Error semántico {}: No puedes llamar a una funcion estatica en una no estatica y viceversa [#,%]",id,true));
//                        }
//                    }
//                }
//                validarLlamadaFuncion(funciones.get(id.lexemeRank(1)),id,identDataType);
////                
//            }
//        }
//        System.out.println(identificadores);
//        System.out.println(identSV);
//        
//    }
        
        
    }
    
            public boolean checkID(Production id, int b){
                for(int i=b ; i<id.getSizeTokens();i++){
                    if(id.lexicalCompRank(i).equals("IDENTIFICADOR")){
                        if(!identificadores.containsKey(id.lexemeRank(i))){
                            return false;
                        }
                    }
                }
                return true;
            }
    public void validarLlamadaFuncion(String funcion,String fun2, Production llamada){
            
            
            List<String> parametrosFuncion = pvFuncion.get(funcion).getTiposP();
            HashMap<String,String> p = pvFuncion.get(fun2).getParametros();
            HashMap<String,String> v = pvFuncion.get(fun2).getVaribles();
            List<String> parametrosLlamada = obtenerParametrosLlamada(llamada,p,v);
            System.out.println("????????");
            System.out.println(parametrosFuncion);
            System.out.println(parametrosLlamada);
            
            if (parametrosFuncion.size() != parametrosLlamada.size()) {
            errors.add(new ErrorLSSL(10,"Error semántico {}: Número incorrecto de parámetros en la llamada a la función en línea [#,%]",llamada,true));
            }else{
                for (int i = 0; i < parametrosFuncion.size(); i++) {
                    if(parametrosFuncion.get(i).equals("double")){
                            if(!parametrosLlamada.get(i).equals("float")){
                              errors.add(new ErrorLSSL(11,"Error semántico {}: Tipo de dato incorrecto para el parámetro [#,%]",llamada,true));  
                            }
                    }else{
                        if(!parametrosFuncion.get(i).equals(parametrosLlamada.get(i))){
                             errors.add(new ErrorLSSL(11,"Error semántico {}: Tipo de dato incorrecto para el parámetro [#,%]",llamada,true)); 
                        }
                        
                    }
                
                }
            }
    }
                
    public List<String> obtenerParametrosFuncion(Production funcion) {
    List<String> parametros = new ArrayList<>();
    
    
    for (int i = 0; i < funcion.getSizeTokens(); i++) {
        if (funcion.lexicalCompRank(i).equals("PARENTESISAPERTURA")) {
            i++;
            while (!funcion.lexicalCompRank(i).equals("PARENTESISCIERRE")) {
                if (funcion.lexicalCompRank(i).matches("IDENTIFICADOR")) {
                    parametros.add(funcion.lexemeRank(i - 1)); // Agregar tipo anterior
                }
                i++;
            }
            break;
        }
    }

    return parametros;
}
    
    
    public List<String> obtenerParametrosLlamada(Production llamada,HashMap<String,String> p,HashMap<String,String> v) {
    List<String> parametros = new ArrayList<>();
   
    for (int i = 0; i < llamada.getSizeTokens(); i++) {
        if (llamada.lexicalCompRank(i).equals("PARENTESISAPERTURA")) {
            i++;
            while (!llamada.lexicalCompRank(i).equals("PARENTESISCIERRE")) {
//               
                if(llamada.lexicalCompRank(i).equals("IDENTIFICADOR")){
                   if(p.containsKey(llamada.lexemeRank(i))){
                       parametros.add(p.get(llamada.lexemeRank(i)));
                   }else if(v.containsKey(llamada.lexemeRank(i))){
                       parametros.add(v.get(llamada.lexemeRank(i)));
                   }else{
                      errors.add(new ErrorLSSL(6,"Error semántico {}: Identificador no definido [#,%]",llamada,true));
  
                   } 
                    
                   
                }else if(llamada.lexicalCompRank(i).equals("NUMERO")){
                   parametros.add("int");
                }else if(llamada.lexicalCompRank(i).equals("NUMERODECIMAL")){
                    parametros.add("float");
                }else if(llamada.lexicalCompRank(i).equals("TEXTO")){
                    parametros.add("String");
                }else if(llamada.lexicalCompRank(i).equals("CARACTER")){
                    parametros.add("char");
                }else if(llamada.lexicalCompRank(i).equals("TRUE")||llamada.lexicalCompRank(i).equals("FALSE")){
                    parametros.add("boolean");
                }
                i++;
            }
            break;
        }
    }
    

    return parametros;
}
    public List<String> obtenerTokensLlamada(Production llamada){
        List<String> tokens = new ArrayList<>();
   
    for (int i = 0; i < llamada.getSizeTokens(); i++) {
        if (llamada.lexicalCompRank(i).equals("PARENTESISAPERTURA")) {
            i++;
            while (!llamada.lexicalCompRank(i).equals("PARENTESISCIERRE")) {
                if (llamada.lexicalCompRank(i).equals("IDENTIFICADOR") || llamada.lexicalCompRank(i).equals("NUMERO")||
                        llamada.lexicalCompRank(i).equals("NUMERODECIMAL")||llamada.lexicalCompRank(i).equals("TEXTO")||
                        llamada.lexicalCompRank(i).equals("CARACTER")||llamada.lexicalCompRank(i).equals("TRUE")||
                        llamada.lexicalCompRank(i).equals("FALSE")) {
                    tokens.add(llamada.lexicalCompRank(i)); // Agregar el lexema
                }
                i++;
            }
            break;
        }
    }
    

    return tokens; 
    }
    private void semanticAnalysis2(){
        functionData.clear();
        funDat.clear();
        pvFuncion.clear();
      for(Production id: identProd){
            if(id.getName().equals("FUNCION")){
                if(id.lexicalCompRank(1).equals("STATIC")){
                    if(!functionData.containsKey(id.lexemeRank(3))){
                        FuncionData fd = new FuncionData(id.getLine(),id.getFinalLine(),
                    id.lexemeRank(3),true,id.lexemeRank(2));
                    functionData.put(id.lexemeRank(3), fd);
                    funDat.add(fd);
                    funciones.put(id.lexemeRank(3), id);
                    FuncData funcD = new FuncData();
                    funcD.setNombresP(obtenerNPFuncion(id));
                    funcD.setTiposP(obtenerParametrosFuncion(id));
                    System.out.println(funcD.getNombresP());
                    System.out.println(funcD.getTiposP());
                    funcD.setNombresV(obtenerNVFuncion(id));
                    funcD.setTiposV(obtenerTVFuncion(id));
                    System.out.println(obtenerNVFuncion(id));
                    System.out.println(obtenerTVFuncion(id));
                    LlenarPMap(funcD.getNombresP(),funcD.getTiposP(),funcD,id);
                    LlenarVMap(funcD.getNombresV(),funcD.getTiposV(),funcD,id);
                    checkRepN(funcD.getNombresP(),funcD,id);
                    System.out.println(funcD.getParametros());
                    System.out.println(funcD.getVaribles());
                    pvFuncion.put(id.lexemeRank(3), funcD);
                    }else{
                       errors.add(new ErrorLSSL(5,"Error semántico {}: Identificador de Funcion Repetido [#,%]",id,true));
                    }
                }else{
                    if(!functionData.containsKey(id.lexemeRank(2))){
                        FuncionData fd2 = new FuncionData(id.getLine(),id.getFinalLine(),id.lexemeRank(2),false,id.lexemeRank(1));
                   functionData.put(id.lexemeRank(2), fd2);
                   funDat.add(fd2);
                   funciones.put(id.lexemeRank(2), id); 
                    FuncData funcD = new FuncData();
                    funcD.setNombresP(obtenerNPFuncion(id));
                    funcD.setTiposP(obtenerParametrosFuncion(id));
                    System.out.println(funcD.getNombresP());
                    System.out.println(funcD.getTiposP());
                    funcD.setNombresV(obtenerNVFuncion(id));
                    funcD.setTiposV(obtenerTVFuncion(id));
                    System.out.println(obtenerNVFuncion(id));
                    System.out.println(obtenerTVFuncion(id));
                    LlenarPMap(funcD.getNombresP(),funcD.getTiposP(),funcD,id);
                    LlenarVMap(funcD.getNombresV(),funcD.getTiposV(),funcD,id);
                    checkRepN(funcD.getNombresP(),funcD,id);
                    System.out.println(funcD.getParametros());
                    System.out.println(funcD.getVaribles());
                    pvFuncion.put(id.lexemeRank(2), funcD);
                    }else{
                        errors.add(new ErrorLSSL(5,"Error semántico {}: Identificador de Funcion Repetido [#,%]",id,true));
                    } 
                }
            }
        }   
      System.out.println(functionData);
      
      /*Ciclo para buscar errores en la asignacion de parametros*/
      for(Production id : identProd){
            
             if(id.getName().equals("VARIABLE")&&id.getSizeTokens()>3){
                 for(FuncionData f: funDat){
                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
                      /*HashMaps Auxiliares*/
                      HashMap<String,String> parametros = pvFuncion.get(f.getNombre()).getParametros();
                      HashMap<String,String> variables = pvFuncion.get(f.getNombre()).getVaribles();
                      System.out.println("*****");
                      System.out.println(parametros);
                      System.out.println(variables);
                      for (int i = 0; i < id.getSizeTokens(); i++) {
                     if (id.lexicalCompRank(i).equals("ASIGNACIONSIMPLE")) {
                          i++;
                    while (!id.lexicalCompRank(i).equals("PUNTOCOMA")) {
                      if (parametros.containsKey(id.lexemeRank(i))) {
                          if(!parametros.get(id.lexemeRank(i)).equals(variables.get(id.lexemeRank(1))) ){
                              errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                          }
                        }
                      if(variables.containsKey(id.lexemeRank(i))){
                            if(
                                 !variables.get(id.lexemeRank(i)).equals(variables.get(id.lexemeRank(1))) ){
                              errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                          }
                      }
                      
                       if(id.lexicalCompRank(i).equals("NUMERO")){
                   if(!variables.get(id.lexemeRank(1)).equals("int")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("NUMERODECIMAL")){
                    
                    if(variables.get(id.lexemeRank(1)).equals("float")||variables.get(id.lexemeRank(1)).equals("double")){
                       
                   }else{
                      errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                    }
                }else if(id.lexicalCompRank(i).equals("TEXTO")){
                    
                    if(!variables.get(id.lexemeRank(1)).equals("String")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("CARACTER")){
                    
                    if(!variables.get(id.lexemeRank(1)).equals("char")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("TRUE")||id.lexicalCompRank(i).equals("FALSE")){
                   
                    if(!variables.get(id.lexemeRank(1)).equals("boolean")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }
                      
                i++;
            }
            break;
        }
    
                    }
               }
             
             }
    }
    
    
    }
      /*Ciclo para buscar errores en las asignaciones*/
      
      for(Production id : identProd){
          if(id.getName().equals("ASIG_VALOR")){
              if(!id.lexicalCompRank(2).equals("GATO")){
              for(FuncionData f: funDat){
                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
                      /*HashMaps Auxiliares*/
                      HashMap<String,String> parametros = pvFuncion.get(f.getNombre()).getParametros();
                      HashMap<String,String> variables = pvFuncion.get(f.getNombre()).getVaribles();
                      System.out.println("*****");
                      System.out.println(parametros);
                      System.out.println(variables);
                      for (int i = 0; i < id.getSizeTokens(); i++) {
                     if (id.lexicalCompRank(i).equals("ASIGNACIONSIMPLE")) {
                          i++;
                    while (!id.lexicalCompRank(i).equals("PUNTOCOMA")) {
                      if (parametros.containsKey(id.lexemeRank(i))) {
                          if(!parametros.get(id.lexemeRank(i)).equals(variables.get(id.lexemeRank(1))) ){
                              errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                          }
                        }
                      if(variables.containsKey(id.lexemeRank(i))){
                            if(
                                 !variables.get(id.lexemeRank(i)).equals(variables.get(id.lexemeRank(1))) ){
                              errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                          }
                      }
                      
                       if(id.lexicalCompRank(i).equals("NUMERO")){
                   if(!variables.get(id.lexemeRank(1)).equals("int")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("NUMERODECIMAL")){
                    
                    if(variables.get(id.lexemeRank(1)).equals("float")||variables.get(id.lexemeRank(1)).equals("double")){
                       
                   }else{
                      errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                    }
                }else if(id.lexicalCompRank(i).equals("TEXTO")){
                    
                    if(!variables.get(id.lexemeRank(1)).equals("String")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("CARACTER")){
                    
                    if(!variables.get(id.lexemeRank(1)).equals("char")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("TRUE")||id.lexicalCompRank(i).equals("FALSE")){
                   
                    if(!variables.get(id.lexemeRank(1)).equals("boolean")){
                       errors.add(new ErrorLSSL(3,"Error semántico {}: Tipos de datos no compatibles [#,%]",id,true));
                   }
                }
                      
                i++;
            }
            break;
        }
    
                    }
               }
             
             }
            }else{
                  String nombreFuncion = "";
                  for(FuncionData f: funDat){
                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
                        nombreFuncion = f.getNombre();
                    
                    }}
                  System.out.println("------");
                  System.out.println(functionData.get(id.lexemeRank(3)).getTipoDato());
                  System.out.println(pvFuncion.get(nombreFuncion).getTVariable(id.lexemeRank(0)));
                  if(functionData.containsKey(id.lexemeRank(3))){
                      if(functionData.get(id.lexemeRank(3)).getTipoDato().equals("void")){
                      errors.add(new ErrorLSSL(3,"Error semántico {}: La funcion no retorna porque es void [#,%]",id,true));
                      }else{
                        if(!functionData.get(id.lexemeRank(3)).getTipoDato().equals(
                           pvFuncion.get(nombreFuncion).getTVariable(id.lexemeRank(0))
                        
                        )){
                          errors.add(new ErrorLSSL(4,"Error semántico {}: La funcion retorna diferente tipo a la variable [#,%]",id,true));   
                        }  
                      }
                  }
              }
          }
      }
      /*Ciclo para validar los returns*/
      for(Production id: identProd){
          if(id.getName().equals("RETURNV")){
            for(FuncionData f: funDat){
                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
                    HashMap<String,String> parametros = pvFuncion.get(f.getNombre()).getParametros();
                      HashMap<String,String> variables = pvFuncion.get(f.getNombre()).getVaribles();
                      System.out.println("**|**");
                      System.out.println(parametros);
                      System.out.println(variables);
                    
                          int i=0;
                          i++;
                    while (!id.lexicalCompRank(i).equals("PUNTOCOMA")) {
                      if (parametros.containsKey(id.lexemeRank(i))) {
                          if(!parametros.get(id.lexemeRank(i)).equals(f.getTipoDato()) ){
                              errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                          }
                        }
                      if(variables.containsKey(id.lexemeRank(i))){
                            if(
                                 !variables.get(id.lexemeRank(i)).equals(f.getTipoDato()) ){
                              errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                          }
                      }
                      
                       if(id.lexicalCompRank(i).equals("NUMERO")){
                   if(!f.getTipoDato().equals("int")){
                       errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("NUMERODECIMAL")){
                    
                    if(f.getTipoDato().equals("float")||f.getTipoDato().equals("double")){
                       
                   }else{
                      errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                    }
                }else if(id.lexicalCompRank(i).equals("TEXTO")){
                    
                    if(!f.getTipoDato().equals("String")){
                        errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("CARACTER")){
                    
                    if(!f.getTipoDato().equals("char")){
                       errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                   }
                }else if(id.lexicalCompRank(i).equals("TRUE")||id.lexicalCompRank(i).equals("FALSE")){
                   
                    if(!f.getTipoDato().equals("boolean")){
                       errors.add(new ErrorLSSL(4,"Error semántico {}: Retorno con tipos de datos incopatibles [#,%]",id,true));
                   }
                }
                      
                i++;
            }
            
                      
                    }}  
          }
      }
      /*Ciclo para validar LLamadas a Funciones*/
       for(Production id : identProd){
           if(id.getName().equals("CALLF")){
               if(!pvFuncion.containsKey(id.lexemeRank(1))){
               errors.add(new ErrorLSSL(8,"Error semántico {}: Funcion No Definida [#,%]",id,true)); 
          }else{
                   for(FuncionData f: funDat){
                    if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
                        HashMap<String,String> parametros = pvFuncion.get(f.getNombre()).getParametros();
                      HashMap<String,String> variables = pvFuncion.get(f.getNombre()).getVaribles();
                      System.out.println("**|**");
                      System.out.println(parametros);
                      System.out.println(variables);
                        if(f.isIsStatic()!=functionData.get(id.lexemeRank(1)).isIsStatic()){
                            errors.add(new ErrorLSSL(9,"Error semántico {}: No puedes llamar a una funcion estatica en una no estatica y viceversa [#,%]",id,true));
                        }
                        validarLlamadaFuncion(id.lexemeRank(1),f.getNombre(),id);
                        
                    }
                }
               }
           
           }
       
       }
       /* Ciclo para intentar validad comparaciones */
       for(Production id : identProd){
           if(id.getName().equals("EXP_LOGICA")){
              String fun = "";
               for(FuncionData f: funDat){
                                if(id.getLine()>f.getFilaInicio()&&id.getLine()<f.getFilaFinal()){
                                    fun= f.getNombre();
                                
                                
                                }
                            }
               System.out.println("++++++++");
               validarComp(fun,id);
           }
       
       }
       
       
      for(Production id : identProd){
            System.out.println(id.getSizeTokens());
            System.out.println(id.getLine());
            System.out.println(id.getFinalLine());
            System.out.println(id.getName());
             System.out.println(id.lexemeRank(0,-1));
             System.out.println(id.lexicalCompRank(0,-1));
             
    }
    }
       public List<String> obtenerTiposComp(Production llamada,HashMap<String,String> p,HashMap<String,String> v) {
    List<String> parametros = new ArrayList<>();
   
    for (int i = 0; i < llamada.getSizeTokens(); i++) {
        
            
//               
                if(llamada.lexicalCompRank(i).equals("IDENTIFICADOR")){
                   if(p.containsKey(llamada.lexemeRank(i))){
                       parametros.add(p.get(llamada.lexemeRank(i)));
                   }else if(v.containsKey(llamada.lexemeRank(i))){
                       parametros.add(v.get(llamada.lexemeRank(i)));
                   }else{
                      errors.add(new ErrorLSSL(6,"Error semántico {}: Identificador no definido [#,%]",llamada,true));
  
                   } 
                    
                   
                }else if(llamada.lexicalCompRank(i).equals("NUMERO")){
                   parametros.add("int");
                }else if(llamada.lexicalCompRank(i).equals("NUMERODECIMAL")){
                    parametros.add("float");
                }else if(llamada.lexicalCompRank(i).equals("TEXTO")){
                    parametros.add("String");
                }else if(llamada.lexicalCompRank(i).equals("CARACTER")){
                    parametros.add("char");
                }else if(llamada.lexicalCompRank(i).equals("TRUE")||llamada.lexicalCompRank(i).equals("FALSE")){
                    parametros.add("boolean");
                }else if(llamada.lexicalCompRank(i).equals("IGUAL")){
                   parametros.add(llamada.lexemeRank(i));
                }
                
            
           
    }
    

    return parametros;
}
   public void validarComp(String funcion,Production llamada){
       
            HashMap<String,String> p = pvFuncion.get(funcion).getParametros();
            HashMap<String,String> v = pvFuncion.get(funcion).getVaribles();
            List<String> tiposComp = obtenerTiposComp(llamada,p,v);
            System.out.println("????????");
            
            System.out.println(tiposComp);
            
            
                for (int i = 0; i < tiposComp.size(); i++) {
                    if(tiposComp.get(i).equals("==")){
                        if(tiposComp.get(i-1).equals("int")||tiposComp.get(i-1).equals("double")||tiposComp.get(i-1).equals("float")){
                          if(!tiposComp.get(i+1).equals("int")&&!tiposComp.get(i+1).equals("double")&&!tiposComp.get(i+1).equals("float")){
                          errors.add(new ErrorLSSL(13,"Error semántico {}: Comparacion de tipos distintos [#,%]",llamada,true));  

                            }  
                        }else{
                            if(!tiposComp.get(i-1).equals(tiposComp.get(i+1))){
                       errors.add(new ErrorLSSL(13,"Error semántico {}: Comparacion de tipos distintos [#,%]",llamada,true));  

                            }
                        }
                    }
                
                }
   }
    
   public List<String> obtenerNPFuncion(Production funcion) {
    List<String> parametros = new ArrayList<>();
    
    
    for (int i = 0; i < funcion.getSizeTokens(); i++) {
        if (funcion.lexicalCompRank(i).equals("PARENTESISAPERTURA")) {
            i++;
            while (!funcion.lexicalCompRank(i).equals("PARENTESISCIERRE")) {
                if (funcion.lexicalCompRank(i).matches("IDENTIFICADOR")) {
                    parametros.add(funcion.lexemeRank(i)); // Agregar tipo anterior
                }
                i++;
            }
            break;
        }
    }

    return parametros;
}
   public List<String> obtenerNVFuncion(Production funcion) {//Obtiene los nombres de las variables de una funcion
    List<String> parametros = new ArrayList<>();
    
    
    for (int i = 0; i < funcion.getSizeTokens(); i++) {
        if (funcion.lexicalCompRank(i).equals("LLAVEAPERTURA")) {
            i++;
            while (!funcion.lexicalCompRank(i).equals("LLAVECIERRE")) {
                if (funcion.lexicalCompRank(i).matches("INT")||
                        funcion.lexicalCompRank(i).matches("BOOLEAN")||
                        funcion.lexicalCompRank(i).matches("DOUBLE")||
                        funcion.lexicalCompRank(i).matches("SHORT")||
                        funcion.lexicalCompRank(i).matches("CHAR")||
                        funcion.lexicalCompRank(i).matches("LONG")||
                        funcion.lexicalCompRank(i).matches("FLOAT")||
                        funcion.lexicalCompRank(i).matches("STRING")) {
                    parametros.add(funcion.lexemeRank(i + 1)); // Agregar tipo anterior
                }
                i++;
            }
            break;
        }
    }

    return parametros;
}
   public List<String> obtenerTVFuncion(Production funcion) {//Obtiene los nombres de las variables de una funcion
    List<String> parametros = new ArrayList<>();
    
    
    for (int i = 0; i < funcion.getSizeTokens(); i++) {
        if (funcion.lexicalCompRank(i).equals("LLAVEAPERTURA")) {
            i++;
            while (!funcion.lexicalCompRank(i).equals("LLAVECIERRE")) {
                if (funcion.lexicalCompRank(i).matches("INT")||
                        funcion.lexicalCompRank(i).matches("BOOLEAN")||
                        funcion.lexicalCompRank(i).matches("DOUBLE")||
                        funcion.lexicalCompRank(i).matches("SHORT")||
                        funcion.lexicalCompRank(i).matches("CHAR")||
                        funcion.lexicalCompRank(i).matches("LONG")||
                        funcion.lexicalCompRank(i).matches("FLOAT")||
                        funcion.lexicalCompRank(i).matches("STRING")) {
                    parametros.add(funcion.lexemeRank(i)); // Agregar tipo anterior
                }
                i++;
            }
            break;
        }
    }

    return parametros;
}
   public void LlenarPMap(List<String> nombres, List<String> tipos, FuncData fc,Production id){
        if(nombres.size()==tipos.size()){
            for(int i=0;i<nombres.size();i++){
                if(!fc.setParametro(nombres.get(i), tipos.get(i))){
                    errors.add(new ErrorLSSL(2,"Error semántico {}: Identificador de Parametro Repetido"
                            + "en la funcion [#,%]",id,true));
                }
            }
        }
   
   }
   public void LlenarVMap(List<String> nombres, List<String> tipos, FuncData fc,Production id){
        if(nombres.size()==tipos.size()){
            for(int i=0;i<nombres.size();i++){
                if(!fc.setVariable(nombres.get(i), tipos.get(i))){
                    errors.add(new ErrorLSSL(2,"Error semántico {}: Identificador de Variable Repetido"
                            + "en la funcion [#,%]",id,true));
                }
            }
        }
   
   }
   public void checkRepN(List<String> nombres,FuncData fc,Production id){
       for(int i=0;i<nombres.size();i++){
                if(fc.contKVaribale(nombres.get(i))){
                    errors.add(new ErrorLSSL(2,"Error semántico {}: Identificador definido en los parametros"
                            + "en la funcion [#,%]",id,true));
                }
            }
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
