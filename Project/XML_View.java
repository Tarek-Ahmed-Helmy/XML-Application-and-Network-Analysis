import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author moham
 */
public class XML_View extends JFrame {

    /**
     * Creates new form XML_View
     */
        String xml2string;
        String json;
	File file;
        File file_C;
	Reader fr;
	String correctedxml="";
    public int currentFileNo=1;
        String search_word;
        JTextArea textArea = new JTextArea();
	public JTextArea getTextArea() {
		return textArea;
	}
        public String getXML() {
		return xml2string;
	}
    public XML_View() {
        setTitle("XML Editor");
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        openFilebtn = new javax.swing.JButton();
        convertJSONbtn = new javax.swing.JButton();
        consistencybtn = new javax.swing.JButton();
        showErrorbtn = new javax.swing.JButton();
        solveErrorbtn = new javax.swing.JButton();
        searchGraphbtn = new javax.swing.JButton();
        formatbtn = new javax.swing.JButton();
        minifybtn = new javax.swing.JButton();
        compressbtn = new javax.swing.JButton();
        decompressbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        mostInflbtn = new javax.swing.JButton();
        mutualFlwrbtn = new javax.swing.JButton();
        mostActivebtn = new javax.swing.JButton();
        suggestFlwrbtn = new javax.swing.JButton();
        visualizebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openFilebtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        openFilebtn.setText("Open File");
        openFilebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFilebtnActionPerformed(evt);
            }
        });

        convertJSONbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        convertJSONbtn.setText("Convert to Json");
        convertJSONbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    convertJSONbtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        consistencybtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        consistencybtn.setText("Check Consistency");
        consistencybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consistencybtnActionPerformed(evt);
            }
        });

        showErrorbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        showErrorbtn.setText("Show Errors");
        showErrorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showErrorbtnActionPerformed(evt);
            }
        });

        solveErrorbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        solveErrorbtn.setText("Correct Errors");
        solveErrorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveErrorbtnActionPerformed(evt);
            }
        });

        searchGraphbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchGraphbtn.setText("Search Graph");
        searchGraphbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    searchGraphbtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        formatbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        formatbtn.setText("Format");
        formatbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    formatbtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        minifybtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        minifybtn.setText("Minify");
        minifybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    minifybtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        compressbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        compressbtn.setText("Compress");
        compressbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressbtnActionPerformed(evt);
            }
        });

        decompressbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        decompressbtn.setText("Decompress");
        decompressbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decompressbtnActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Output  is Here !!!!!!!!");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        jLabel1.setOpaque(true);

        mostInflbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        mostInflbtn.setText("Most Influencer");
        mostInflbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    mostInflbtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mutualFlwrbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        mutualFlwrbtn.setText("Mutual Followers");
        mutualFlwrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    mutualFlwrbtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mostActivebtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        mostActivebtn.setText("Most Active");
        mostActivebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    mostActivebtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        suggestFlwrbtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        suggestFlwrbtn.setText("Suggestion Followers");
        suggestFlwrbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    suggestFlwrbtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        visualizebtn.setFont(new java.awt.Font("Segoe UI", 1, 12));
        visualizebtn.setText("Visualize Graph");
        visualizebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    visualizebtnActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consistencybtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(solveErrorbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showErrorbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(convertJSONbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openFilebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchGraphbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formatbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minifybtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compressbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(decompressbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mostInflbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mostActivebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mutualFlwrbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suggestFlwrbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(visualizebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openFilebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(convertJSONbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consistencybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showErrorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(solveErrorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(formatbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(minifybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(compressbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(decompressbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchGraphbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mostInflbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mutualFlwrbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mostActivebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suggestFlwrbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pack();
    }

    private void searchGraphbtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before Search Graph");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }else {
            SearchWindow window = new SearchWindow();
            window.sendXML(xml2string);
            window.setVisible(true);
        }
    }

    private void minifybtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String minified=Formatting.minify(xml2string);
        jTextArea1.setText(minified);
        jLabel1.setText("XML Minified");
        FileWriter fw=new FileWriter("MinifiedXML.xml");
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(minified);
        bw.close();
    }

    private void openFilebtnActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(chooser);
        chooser.setVisible(true);
        file = new File(chooser.getSelectedFile().toString());
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line !=null){
                sb.append(line).append("\n");
                line = br.readLine();
            }
            xml2string = sb.toString();
            jTextArea1.setText(xml2string);
            br.close();
        } catch (IOException e1) {
                    e1.printStackTrace();
                }
    }

    private void convertJSONbtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before converting to JSON");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }
        else {
            jTextArea1.setText(null);
            Tree xmltree = new Tree();
            xmltree.fillTree(xml2string);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);
            JsonConversion.printJSON(xmltree.getRoot());
            System.out.flush();
            System.setOut(old);
            json = baos.toString();
            jTextArea1.insert(json, 0);
            jLabel1.setText("XML converted to JSON");
            FileWriter fw=new FileWriter("json.JSON");
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(json);
            bw.close();
        }
    }

    private void formatbtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        String formatted=Formatting.formatXML(xml2string);
        jTextArea1.setText(formatted);
        jLabel1.setText("XML formatted");
        FileWriter fw=new FileWriter("FormattedXML.xml");
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(formatted);
        bw.close();
    }

    private void consistencybtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);
            if(ErrorHandling.consistency(xml2string)){
                System.out.println("The XML File Is Consistent");
            }else {
                System.out.println("The XML File Is Not Consistent");}
                System.out.flush();
                System.setOut(old);
                String consistency = baos.toString();
                jLabel1.setText(consistency);
                br.close();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    private void compressbtnActionPerformed(java.awt.event.ActionEvent evt) {
        FileWriter fw3;
        Reader fr;
        String file2stringcompressionArea="";
        try {
            // we need a file chooser
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(chooser);
            chooser.setVisible(true);
            File fileCompressionArea = new File(chooser.getSelectedFile().toString());
            try {
                fr = new FileReader(fileCompressionArea);
                BufferedReader br = new BufferedReader(fr);
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while(line !=null){
                    sb.append(line).append("\n");
                    line = br.readLine();
                }
                file2stringcompressionArea = sb.toString();
                jTextArea1.setText(file2stringcompressionArea);
                br.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            fw3 = new FileWriter("compressed"+currentFileNo+".txt");
            currentFileNo++;
            //file_C = new File("compressed.xml");
            BufferedWriter bw3=new BufferedWriter(fw3);
            jTextArea1.setText(Formatting.formatXML(Compression.compress(file2stringcompressionArea,bw3)));
            jLabel1.setText("The file is compressed");
        } catch (IOException ex) {
            Logger.getLogger(XML_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void decompressbtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Reader fr_c;
        try {
            File fileCompressionArea = new File("compressed"+(currentFileNo-1)+".txt");
            fr_c = new FileReader(fileCompressionArea);
            BufferedReader br = new BufferedReader(fr_c);
            String decompressed=Compression.decompress(br);
            jTextArea1.setText(decompressed);
            jLabel1.setText("XML/JSON file is decompressed");
        } catch (Exception ex) {
            jLabel1.setText("There is no compressed file to be decompressed");
            Logger.getLogger(XML_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showErrorbtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);
            ErrorHandling.showError(xml2string);
            br.close();
            System.out.flush();
            System.setOut(old);
            String error = baos.toString();
            JFrame showError = new JFrame();
            JPanel panel = new JPanel();
            showError.setBounds(200, 150, 300, 300);
            if(!ErrorHandling.consistency(xml2string)) {
                String[] errors_lines = error.split("\n");
                for (int i = 0; i < errors_lines.length; i++) {
                    JLabel errors_name = new JLabel();
                    errors_name.setBounds(30, 30, 180, 160);
                    errors_name.setText(errors_lines[i]);
                    panel.add(errors_name);
                }
            }else {
                JLabel label2 = new JLabel();
                label2.setText("There are no Errors");
                label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
                panel.add(label2);
            }
            panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
            panel.setLayout(new GridLayout(0,1));
            showError.add(panel, BorderLayout.CENTER);
            showError.setTitle("XML Errors");
            showError.setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void solveErrorbtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            fr = new FileReader(file);
            FileWriter fw=new FileWriter("sample-input-corrected.xml");
	    BufferedWriter bw=new BufferedWriter(fw);
            BufferedReader br = new BufferedReader(fr);
            ErrorHandling.solveError(xml2string,bw);
            br.close();
            bw.close();
            FileReader fr2 = new FileReader("sample-input-corrected.xml");
            BufferedReader br2 = new BufferedReader(fr2);
            StringBuilder sb2 = new StringBuilder();
            String line2 = br2.readLine();
            while(line2 !=null){
                sb2.append(line2).append("\n");
                line2 = br2.readLine();
            }
            correctedxml = sb2.toString();
            xml2string = sb2.toString();
            jTextArea1.setText(correctedxml);
            jLabel1.setText("The errors are corrected");
            br2.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void mostInflbtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before Network Analysis");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }else {
            Tree xmlTree = new Tree();
            xmlTree.fillTree(xml2string);
            List<GraphNode> users = GraphConstruction.treeToUsersArray(xmlTree.getRoot());
            Graph constructedGraph = GraphConstruction.construct(users);
            GraphNode mostInfluencer = NetworkAnalysis.mostInfluencer(constructedGraph, users);
            jLabel1.setText("Most Influencer is " + mostInfluencer.name + ", id: " + mostInfluencer.id);
        }
    }

    private void mutualFlwrbtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before Network Analysis");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }else {
            MutualFollowers mf = new MutualFollowers();
            mf.sendXML(xml2string);
            mf.setVisible(true);
        }
    }

    private void mostActivebtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_mostActivebtnActionPerformed
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before Network Analysis");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }else {
            Tree xmlTree = new Tree();
            xmlTree.fillTree(xml2string);
            List<GraphNode> users = GraphConstruction.treeToUsersArray(xmlTree.getRoot());
            Graph constructedGraph = GraphConstruction.construct(users);
            GraphNode mostActive = NetworkAnalysis.mostActive(constructedGraph, users);
            jLabel1.setText("Most Active is " + mostActive.name + ", id: " + mostActive.id);
        }
    }

    private void suggestFlwrbtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_suggestFlwrbtnActionPerformed
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before Network Analysis");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }else {
            SuggestionFollowers sf = new SuggestionFollowers();
	        sf.sendXML(xml2string);
	        sf.setVisible(true);
        }
    }

    private void visualizebtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_visualizebtnActionPerformed
        if(!ErrorHandling.consistency(xml2string)){
            JFrame Note = new JFrame();
            JPanel pane2 = new JPanel();
            Note.setBounds(200, 150, 500, 150);
            pane2.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));
            pane2.setLayout(new GridLayout(0,1));
            JLabel label2 = new JLabel();
            label2.setText("Please solve the errors before Graph visualization");
            label2.setFont(new java.awt.Font("Segoe UI", 2, 16));
            pane2.add(label2);
            Note.add(pane2, BorderLayout.CENTER);
            Note.setTitle("Note");
            Note.setVisible(true);
        }else {
            Tree xmlTree = new Tree();
            xmlTree.fillTree(xml2string);
            List<GraphNode> users=GraphConstruction.treeToUsersArray(xmlTree.getRoot());
            try {
                GraphVisualization.dotGen(users);
                Runtime.getRuntime().exec("dot -Tpng graph.dot -o graph.png");
                GraphImage image = new GraphImage();
                image.sendXML(xml2string);
                image.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XML_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XML_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XML_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XML_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new XML_View().setVisible(true));
    }


    private javax.swing.JButton compressbtn;
    private javax.swing.JButton consistencybtn;
    private javax.swing.JButton convertJSONbtn;
    private javax.swing.JButton decompressbtn;
    private javax.swing.JButton formatbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton minifybtn;
    private javax.swing.JButton mostActivebtn;
    private javax.swing.JButton mostInflbtn;
    private javax.swing.JButton mutualFlwrbtn;
    private javax.swing.JButton openFilebtn;
    private javax.swing.JButton searchGraphbtn;
    private javax.swing.JButton showErrorbtn;
    private javax.swing.JButton solveErrorbtn;
    private javax.swing.JButton suggestFlwrbtn;
    private javax.swing.JButton visualizebtn;
}