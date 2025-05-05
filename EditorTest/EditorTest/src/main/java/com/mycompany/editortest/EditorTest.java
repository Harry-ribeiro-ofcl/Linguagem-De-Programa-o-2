/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.editortest;

/**
 *
 * @author Aluno
 */
import javax.swing.JFrame;

public class EditorTest {
    public static void main(String[] args) {
        WordLikeEditor editor = new WordLikeEditor();
        editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setSize(600, 400);
        editor.setVisible(true);
    }
}
