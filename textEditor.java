import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;




public class textEditor {


    private File readFile, saveFile;
    private String filepath;
    private boolean justified = true;
    private boolean fulljustified = false;
    private boolean space = true;
    private JLabel spaceLabel1;
    private JLabel blankLabel;
    private JLabel numofWordsLabel;
    private JLabel agWordLabel;
    private JLabel maxCharLabel;
    private JLabel numLinesLabel;


   
    /* Launch the application.
     * */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                textEditor window = new textEditor();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /* Create the application.
     */
    
    private textEditor() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private JFrame frame;
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Text Modifier");
        frame.setBounds(500, 500, 500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JDesktopPane pane = new JDesktopPane();
       pane.setBackground(Color.WHITE);
        frame.getContentPane().add(pane,BorderLayout.CENTER);
        


        JLabel charLength = new JLabel("Characters per Line:");
        charLength.setBounds(299, 39, 103, 16);
       pane.add(charLength);




        Integer[] maxLength = new Integer[100];
        int inc=20;
        for(int i=0;i<100;i++)
        {
            maxLength[i] = inc;
            inc++;
        }
        JComboBox maxSelect = new JComboBox(maxLength);
        maxSelect.setBounds(360, 34, 80, 26);
        maxSelect.setSelectedIndex(60);
        textAnalysis.maxChar = 80;
       pane.add(maxSelect);
        maxSelect.addActionListener(arg0 -> {
            textAnalysis.maxChar = (int) maxSelect.getSelectedItem();

        });


        JRadioButton leftButton = new JRadioButton("Left Justification");
        leftButton.setBounds(6, 62, 141, 23);
       pane.add(leftButton);

        JRadioButton fullButton = new JRadioButton("Full Justification");
        fullButton.setBounds(156, 62, 141, 23);
       pane.add(fullButton);

        JRadioButton rightButton = new JRadioButton("Right Justification");
        rightButton.setBounds(299, 62, 141, 23);
       pane.add(rightButton);

        ButtonGroup justifyButtons = new ButtonGroup();
        justifyButtons.add(leftButton);
        justifyButtons.add(rightButton);
        justifyButtons.add(fullButton);
        leftButton.setSelected(true);
        justified = true;

        leftButton.addActionListener(arg0 -> {
            justified = true;
            fulljustified = false;
        });

        rightButton.addActionListener(arg0 -> {
            justified = false;
            fulljustified = false;
        });

        fullButton.addActionListener(arg0 -> {
            justified = false;
            fulljustified = true;
        });

        JRadioButton singleSpace = new JRadioButton("Single Spaced");
        singleSpace.setBounds(6, 36, 141, 23);
       pane.add(singleSpace);

        JRadioButton doubleSpace = new JRadioButton("Double Spaced");
        doubleSpace.setBounds(156, 36, 141, 23);
       pane.add(doubleSpace);

        ButtonGroup spacegroup = new ButtonGroup();
        spacegroup.add(singleSpace);
        spacegroup.add(doubleSpace);
        singleSpace.setSelected(true);
        space = true;

        singleSpace.addActionListener(arg0 -> {
            space = true;
        });

        doubleSpace.addActionListener(arg0 -> {
            space = false;
        });
        JLabel label1=new JLabel();
		JLabel spaceLabel=new JLabel();
        JButton input = new JButton("Select Input File\r\n");
        input.setBounds(0,0, 450, 20);
        input.setBackground(Color.WHITE);
		input.setForeground(Color.BLACK);
		input.setFont(UIManager.getFont("FileChooser.listFont"));
       pane.add(input);
        input.addActionListener((ActionEvent arg0) -> {
            FileNameExtensionFilter filter1 = new FileNameExtensionFilter("TXT Document", "txt");
            JFileChooser inputChooser = new JFileChooser();
            
            inputChooser.setDialogTitle("Select a Text File");
			inputChooser.setAcceptAllFileFilterUsed(false);
			inputChooser.setFileFilter(filter1);
            int returnVal = inputChooser.showOpenDialog(null);
        	if (returnVal==JFileChooser.APPROVE_OPTION) {
				File file=inputChooser.getSelectedFile();
				String name=file.getName();
				label1.setText("Selected File: "+name);
			}
        });

        JButton formatter = new JButton("Format/Edit selected text file");
        formatter.setBounds(0, 95, 460, 30);
       pane.add(formatter);
        formatter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    fileRead();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            private void fileRead() {
                if (readFile != null) {
                    String path = readFile.getPath();
                    textAnalysis analyze = new textAnalysis(path);

                    String spaces = Integer.toString(textAnalysis.numSpace);
                    blankLabel.setText(spaces);

                    String linesR = Integer.toString(textAnalysis.numLR);
                    spaceLabel1.setText(linesR);

                    String words = Integer.toString(textAnalysis.numofWords);
                    numofWordsLabel.setText(words);

                    String wordPline = Integer.toString(textAnalysis.wPL);
                    agWordLabel.setText(wordPline);

                    if(fullButton.isSelected()){
                        String avgLength = Integer.toString(textAnalysis.maxChar);
                        maxCharLabel.setText(avgLength);
                    }
                    else {
                        String avgLength = Integer.toString(textAnalysis.lPL);
                        maxCharLabel.setText(avgLength);
                    }

                    String NumberofLines = Integer.toString(textAnalysis.numLines);
                    numLinesLabel.setText(NumberofLines);
                }
            }
        });

        spaceLabel = new JLabel("0");
        spaceLabel.setBounds(405, 199, 61, 16);
       pane.add(spaceLabel);

        blankLabel = new JLabel("0");
        blankLabel.setBounds(94, 199, 61, 16);
       pane.add(blankLabel);

        numofWordsLabel = new JLabel("0");
        numofWordsLabel.setBounds(94, 172, 61, 16);
       pane.add(numofWordsLabel);


        agWordLabel = new JLabel("0");
        agWordLabel.setBounds(256, 172, 61, 16);
       pane.add(agWordLabel);


        maxCharLabel = new JLabel("0");
        maxCharLabel.setBounds(256, 199, 61, 16);
       pane.add(maxCharLabel);

        numLinesLabel = new JLabel("0");
        numLinesLabel.setBounds(405, 172, 61, 16);
       pane.add(numLinesLabel);



        JButton output = new JButton("Select Output File\r\n");
        output.setBackground(Color.WHITE);
		output.setForeground(Color.BLACK);
		output.setFont(UIManager.getFont("FileChooser.listFont"));
		output.setBounds(0,130,460,30);
       pane.add(output);
        output.addActionListener(arg0 -> {
            //FileNameExtensionFilter filter2 = new FileNameExtensionFilter("TXT Document", "txt");
            JFileChooser outputChooser = new JFileChooser();
            outputChooser.setDialogTitle("Select a Text File");
			outputChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter txtFilter = new FileNameExtensionFilter ("Text Files","txt");
			outputChooser.addChoosableFileFilter(txtFilter);
			int returnVal= outputChooser.showOpenDialog(null);
			if (returnVal==JFileChooser.APPROVE_OPTION) {
				File file=outputChooser.getSelectedFile();
				String name =file.getName();
				spaceLabel1.setText("Selected File: "+name);
			
                try {
                    FileWriter fileWrite = new FileWriter(outputChooser.getSelectedFile()+ ".txt");

                    ArrayList <String> write = textAnalysis.fileString;
                    ArrayList <String> writefull = textAnalysis.filledFileString;
                    String full = "%0$"+Integer.toString(textAnalysis.maxChar)+"s";

                    if(fulljustified == true){

                        for (int i =0; i < writefull.size();i++){
                            if(space == true)
                                fileWrite.write(String.format(writefull.get(i) + "\n"));
                            else if(space == false)
                                fileWrite.write(String.format(writefull.get(i) + "\n\n"));
                        }
                    }
                    else {
                        for (int x = 0; x < write.size(); x++) {

                            if (justified == true && space == true)
                                fileWrite.write(write.get(x) + "\n");
                            
                            
                            else if (justified == true && space == false)
                                fileWrite.write(write.get(x) + "\n\n");
                            
                            
                            else if (justified == false && space == true)
                                fileWrite.write(String.format(full, write.get(x) + "\n"));
                            
                            
                            else if (justified == false && space == false)
                                fileWrite.write(String.format(full, write.get(x) + "\n\n"));
                        }
                    }

                    fileWrite.close();

                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

                saveFile = outputChooser.getSelectedFile();
                filepath = saveFile.getAbsolutePath();
                

            }
        });


        

        JLabel wordLabel = new JLabel("Words :");
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        wordLabel.setBounds(6, 172, 42, 16);
       pane.add(wordLabel);

        JLabel lineLabel = new JLabel("Lines :");
        lineLabel.setBounds(317, 172, 97, 16);
       pane.add(lineLabel);

        JLabel blankLabel = new JLabel("Blank Lines Removed:");
        blankLabel.setBounds(317, 199, 237, 16);
       pane.add(blankLabel);

        JLabel spaceLabel1 = new JLabel("Spaces Added: ");
        spaceLabel1.setBounds(6, 199, 95, 16);
       pane.add(spaceLabel1);

        JLabel perLineLabel = new JLabel("Avg Words per Line:");
        perLineLabel.setBounds(156, 172, 194, 16);
       pane.add(perLineLabel);

        JLabel lineLengthLabel = new JLabel("Avg Line Length (characters):");
        lineLengthLabel.setBounds(156, 199, 184, 16);
       pane.add(lineLengthLabel);
        //commit
       
      /* frame.getContentPane().add(input);
       frame.getContentPane().add(label1);
       
       frame.getContentPane().add(formatter);
       frame.getContentPane().add(output);
       frame.getContentPane().add(spaceLabel1);
       frame.getContentPane().add(pane);*/
       
    }

}