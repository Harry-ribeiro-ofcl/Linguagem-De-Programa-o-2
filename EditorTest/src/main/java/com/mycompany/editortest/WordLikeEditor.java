/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.editortest;

/**
 *
 * @author Aluno
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class WordLikeEditor extends JFrame {

    private JTextPane textPane;
    private StyledDocument doc;
    private SimpleAttributeSet attributes;

    public WordLikeEditor() {
        super("Mini Word Editor");

        setLayout(new BorderLayout());

        textPane = new JTextPane();
        doc = textPane.getStyledDocument();
        attributes = new SimpleAttributeSet();
        textPane.setCharacterAttributes(attributes, true);

        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout());

        // Botões de Estilo
        JCheckBox boldBox = new JCheckBox("Bold");
        JCheckBox italicBox = new JCheckBox("Italic");
        JCheckBox underlineBox = new JCheckBox("Underline");

        // Alinhamento
        JButton alignLeft = new JButton("Left");
        JButton alignCenter = new JButton("Center");
        JButton alignRight = new JButton("Right");

        // Cor da fonte
        String[] colors = {"Black", "Red", "Blue", "Green"};
        JComboBox<String> colorBox = new JComboBox<>(colors);

        // Listeners de estilo
        boldBox.addItemListener(e -> {
            StyleConstants.setBold(attributes, boldBox.isSelected());
            updateTextStyle();
        });

        italicBox.addItemListener(e -> {
            StyleConstants.setItalic(attributes, italicBox.isSelected());
            updateTextStyle();
        });

        underlineBox.addItemListener(e -> {
            StyleConstants.setUnderline(attributes, underlineBox.isSelected());
            updateTextStyle();
        });

        // Listeners de alinhamento
        alignLeft.addActionListener(e -> setAlignment(StyleConstants.ALIGN_LEFT));
        alignCenter.addActionListener(e -> setAlignment(StyleConstants.ALIGN_CENTER));
        alignRight.addActionListener(e -> setAlignment(StyleConstants.ALIGN_RIGHT));

        // Listener de cor
        colorBox.addActionListener(e -> {
            String selected = (String) colorBox.getSelectedItem();
            Color color = switch (selected) {
                case "Red" -> Color.RED;
                case "Blue" -> Color.BLUE;
                case "Green" -> Color.GREEN;
                default -> Color.BLACK;
            };
            StyleConstants.setForeground(attributes, color);
            updateTextStyle();
        });

        // Adicionando componentes ao painel
        controlPanel.add(boldBox);
        controlPanel.add(italicBox);
        controlPanel.add(underlineBox);
        controlPanel.add(alignLeft);
        controlPanel.add(alignCenter);
        controlPanel.add(alignRight);
        controlPanel.add(new JLabel("Color:"));
        controlPanel.add(colorBox);

        add(controlPanel, BorderLayout.NORTH);
    }

    // Atualiza os estilos no texto selecionado
    private void updateTextStyle() {
        textPane.setCharacterAttributes(attributes, true);
    }

    // Aplica alinhamento no parágrafo atual
    private void setAlignment(int alignment) {
        SimpleAttributeSet alignmentAttr = new SimpleAttributeSet();
        StyleConstants.setAlignment(alignmentAttr, alignment);
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        doc.setParagraphAttributes(start, end - start, alignmentAttr, false);
    }
}
