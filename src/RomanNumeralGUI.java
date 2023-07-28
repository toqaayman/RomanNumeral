import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class RomanNumeralGUI extends JFrame {
    // Create an unsorted and sorted list to store the Roman Numerals read from file
    private UnsortedRomanNumeralList unsortedList;
    private SortedRomanNumeralList sortedList;
    
    // Constructor to initialize the GUI and read the Roman Numerals from file
    public RomanNumeralGUI(String filename) {
        // Initialize the unsorted and sorted lists
        this.unsortedList = new UnsortedRomanNumeralList();
        this.sortedList = new SortedRomanNumeralList();

        try {
            // Read the Roman Numerals from file and add them to the lists
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                RomanNumeral numeral = new RomanNumeral(line);
                unsortedList.append(numeral);
                sortedList.add(numeral);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Set the layout of the GUI to a 3-column grid
        this.setLayout(new GridLayout(0, 3));
        
        // Add labels to the GUI to indicate the contents of each column
        JLabel label1 = new JLabel("Original Roman Numerals        ");
        JLabel label2 = new JLabel("Unsorted Arabic Values         ");
        JLabel label3 = new JLabel("Sorted Arabic Values");

        this.add(label1);
        this.add(label2);
        this.add(label3);

        // Add the Roman Numerals and their corresponding Arabic values to the GUI
        int size = unsortedList.size();
        for (int i = 0; i < size; i++) {
            JLabel labelRN = new JLabel(unsortedList.get(i).getRomanNumeral());
            JLabel labelUA = new JLabel(Integer.toString(unsortedList.get(i).getArabicValue()));
            JLabel labelSA = new JLabel(Integer.toString(sortedList.get(i).getArabicValue()));
            this.add(labelRN);
            this.add(labelUA);
            this.add(labelSA);
        }
        
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // Create the File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem quitItem = new JMenuItem("Quit");
        
        // Add action listeners to the menu items
        openItem.addActionListener(new OpenHandler());
        quitItem.addActionListener(new QuitHandler());
        
        // Add the menu items to the File menu
        fileMenu.add(openItem);
        fileMenu.add(quitItem);
        
        // Create the Convert menu
        JMenu convertMenu = new JMenu("Convert");
        JMenuItem romanToArabicItem = new JMenuItem("Roman to Arabic");
        
        // Add an action listener to the menu item
        romanToArabicItem.addActionListener(new RomanToArabicHandler());
        
        // Add the menu item to the Convert menu
        convertMenu.add(romanToArabicItem);
        
        // Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(convertMenu);
        
        // Set the menu bar for the JFrame
        this.setJMenuBar(menuBar);
        
        // Pack the GUI and make it visible
        this.pack();
        this.setVisible(true);
    }
    
    // Handler for the Open menu item
    private class OpenHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(RomanNumeralGUI.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getAbsolutePath();
                new RomanNumeralGUI(filename);
            }
        }
    }
    
    // Handler for the Quit menu item
    private class QuitHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    // Handler for the Roman to Arabic menu item
    private class RomanToArabicHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String romanNumeral = JOptionPane.showInputDialog("Enter a Roman numeral:");
            try {
                RomanNumeral numeral = new RomanNumeral(romanNumeral);
                int arabicValue = numeral.getArabicValue();
                JOptionPane.showMessageDialog(null, arabicValue);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Roman numeral.");
            }
        }
    }

    // Main method to create a new RomanNumeralGUI object
    public static void main(String[] args) {
        new RomanNumeralGUI("input.txt");
    }
}