/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.andrei.quiz.view;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ro.andrei.quiz.model.Answer;
import ro.andrei.quiz.model.Question;
import ro.andrei.quiz.model.Section;

/**
 *
 * @author epopean
 */
public class QuizFrame extends javax.swing.JFrame {

    private Section section;
    private Question currentQuestion;
    private List<Answer> currentAnswers;
    private int questionNumber;

    private Double score;
    private Double tScore;
    
    private int[] answeredQuestions;
    
    public QuizFrame(Section section) {
        initComponents();
                
        this.section = section;
        this.questionNumber = 1; 
        this.score = 0.0;
        this.tScore = 0.0;
        
        this.currentQNumber.setText(this.questionNumber + "");
        this.totalQNumber.setText(section.getQuestionList().size() + "");
        this.currentScore.setText("0.0");
        this.totalScore.setText("0.0");
        
        answeredQuestions = new int[this.section.getQuestionList().size()];
        infoTextArea.setEnabled(false);
        infoTextArea.setDisabledTextColor(Color.BLACK);
        initQuestion();
    }

    private void initQuestion() {
        currentQuestion = section.getQuestionList().get(questionNumber - 1);
        currentAnswers = currentQuestion.getAnswers();
        
        imageLabel.setIcon(new ImageIcon(this.getClass().getResource(currentQuestion.getPath())));
        this.currentQNumber.setText(this.questionNumber + "");

        switch (currentQuestion.getType()) {
            case "single":
                singleChoicePanel.setVisible(true);
                multiChoicePanel.setVisible(false);
                inputPanel.setVisible(false);
                break;
            case "multi":
                singleChoicePanel.setVisible(false);
                multiChoicePanel.setVisible(true);
                inputPanel.setVisible(false);
                break;
            default:
                singleChoicePanel.setVisible(false);
                multiChoicePanel.setVisible(false);
                inputPanel.setVisible(true);
                break;
        }
    }

    /**
     * Method for checking the single-choice questions
     *
     * @return
     */
    private double checkSingle() {
        if (singleFirst.isSelected() && currentAnswers.get(0).isRight()) {
            return 1.0;
        } else if (singleSecond.isSelected() && currentAnswers.get(1).isRight()) {
            return 1.0;
        } else if (singleThird.isSelected() && currentAnswers.get(2).isRight()) {
            return 1.0;
        } else if (singleFourth.isSelected() && currentAnswers.get(3).isRight()) {
            return 1.0;
        }
        return 0.0;
    }

    /**
     * Method for checking the multiple choice question
     *
     * @return
     */
    private double checkMulti() {
        double multiScore = 0.0;
        if(multiFirst.isSelected() && currentAnswers.get(0).isRight()) {
            multiScore += 0.25;
        } else if(!multiFirst.isSelected() && currentAnswers.get(0).isWrong()) {
            multiScore += 0.25;
        }
        
        if(multiSecond.isSelected() && currentAnswers.get(1).isRight()) {
            multiScore += 0.25;
        } else if(!multiSecond.isSelected() && currentAnswers.get(1).isWrong()) {
            multiScore += 0.25;
        }
        
        if(multiThird.isSelected() && currentAnswers.get(2).isRight()) {
            multiScore += 0.25;
        } else if(!multiThird.isSelected() && currentAnswers.get(2).isWrong()) {
            multiScore += 0.25;
        }
        
        if(multiFourth.isSelected() && currentAnswers.get(3).isRight()) {
            multiScore += 0.25;
        } else if(!multiFourth.isSelected() && currentAnswers.get(3).isWrong()) {
            multiScore += 0.25;
        }
        
        return multiScore;
    }

    /**
     * Method for checking the input value is equal to the one in xml
     *
     * @return
     */
    private double checkInput() {
        if (inputAnswer.getText().equals(currentAnswers.get(0).getValue())) {
            return 1.0;
        }
        return 0.0;
    }

    private void computeScore() {
        double questionScore;
        switch (currentQuestion.getType()) {
            case "single":
                questionScore = checkSingle();
                break;
            case "multi":
                questionScore = checkMulti();
                break;
            default:
                questionScore = checkInput();
                break;
        }
        if(questionScore == 1.0) {
            answeredQuestions[questionNumber - 1] = 1;
        }
        score += questionScore;
        tScore = tScore + 1;
        
        currentScore.setText(score.toString());
        totalScore.setText(tScore.toString());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        singleGroup = new javax.swing.ButtonGroup();
        imagePanel = new javax.swing.JPanel();
        imageScrollPane = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();
        answersPanel = new javax.swing.JPanel();
        singleChoicePanel = new javax.swing.JPanel();
        singleFirst = new javax.swing.JRadioButton();
        singleSecond = new javax.swing.JRadioButton();
        singleThird = new javax.swing.JRadioButton();
        singleFourth = new javax.swing.JRadioButton();
        singleLabel = new javax.swing.JLabel();
        multiChoicePanel = new javax.swing.JPanel();
        multiFirst = new javax.swing.JCheckBox();
        multiSecond = new javax.swing.JCheckBox();
        multiThird = new javax.swing.JCheckBox();
        multiFourth = new javax.swing.JCheckBox();
        multiLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        inputAnswer = new javax.swing.JTextField();
        inputLabel = new javax.swing.JLabel();
        selectionTypeLabel = new javax.swing.JLabel();
        checkButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        extraPanel = new javax.swing.JPanel();
        currentScoreLabel = new javax.swing.JLabel();
        currentScore = new javax.swing.JLabel();
        totalScoreLabel = new javax.swing.JLabel();
        totalScore = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        hintLabel = new javax.swing.JLabel();
        qNoLabel = new javax.swing.JLabel();
        currentQNumber = new javax.swing.JLabel();
        slashLabel = new javax.swing.JLabel();
        totalQNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/s1/q5.PNG"))); // NOI18N
        imageScrollPane.setViewportView(imageLabel);

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageScrollPane)
                .addContainerGap())
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageScrollPane)
                .addContainerGap())
        );

        answersPanel.setBackground(new java.awt.Color(255, 255, 255));

        singleGroup.add(singleFirst);
        singleFirst.setText("A");
        singleFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleFirstActionPerformed(evt);
            }
        });

        singleGroup.add(singleSecond);
        singleSecond.setText("B");

        singleGroup.add(singleThird);
        singleThird.setText("C");

        singleGroup.add(singleFourth);
        singleFourth.setText("D");

        singleLabel.setText("Single Choice");

        javax.swing.GroupLayout singleChoicePanelLayout = new javax.swing.GroupLayout(singleChoicePanel);
        singleChoicePanel.setLayout(singleChoicePanelLayout);
        singleChoicePanelLayout.setHorizontalGroup(
            singleChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(singleFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singleSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singleThird, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singleFourth, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        singleChoicePanelLayout.setVerticalGroup(
            singleChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(singleChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singleFirst)
                    .addComponent(singleSecond)
                    .addComponent(singleThird)
                    .addComponent(singleFourth)
                    .addComponent(singleLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        multiFirst.setText("A");
        multiFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiFirstActionPerformed(evt);
            }
        });

        multiSecond.setText("B");

        multiThird.setText("C");

        multiFourth.setText("D");

        multiLabel.setText("Multi Choice");

        javax.swing.GroupLayout multiChoicePanelLayout = new javax.swing.GroupLayout(multiChoicePanel);
        multiChoicePanel.setLayout(multiChoicePanelLayout);
        multiChoicePanelLayout.setHorizontalGroup(
            multiChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(multiFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(multiSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(multiThird, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(multiFourth, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(multiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        multiChoicePanelLayout.setVerticalGroup(
            multiChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multiChoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(multiChoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiFirst)
                    .addComponent(multiSecond)
                    .addComponent(multiThird)
                    .addComponent(multiFourth)
                    .addComponent(multiLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inputAnswer.setText("Answer");

        inputLabel.setText("Answer");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputAnswer)
                .addGap(18, 18, 18)
                .addComponent(inputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLabel))
                .addContainerGap())
        );

        selectionTypeLabel.setText("Selection Type:");

        checkButton.setText("Check Question");
        checkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkButtonMouseClicked(evt);
            }
        });

        nextButton.setText("Next Question");
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout answersPanelLayout = new javax.swing.GroupLayout(answersPanel);
        answersPanel.setLayout(answersPanelLayout);
        answersPanelLayout.setHorizontalGroup(
            answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(answersPanelLayout.createSequentialGroup()
                        .addGroup(answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(multiChoicePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(singleChoicePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, answersPanelLayout.createSequentialGroup()
                                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        answersPanelLayout.setVerticalGroup(
            answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, answersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectionTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singleChoicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multiChoicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkButton)
                    .addComponent(nextButton))
                .addGap(74, 74, 74))
        );

        extraPanel.setBackground(new java.awt.Color(255, 255, 255));

        currentScoreLabel.setText("Score:");

        currentScore.setText("4");

        totalScoreLabel.setText("Total Score:");

        totalScore.setText("5");

        infoTextArea.setColumns(20);
        infoTextArea.setRows(5);
        jScrollPane1.setViewportView(infoTextArea);

        hintLabel.setText("Info for Question");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(hintLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hintLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        qNoLabel.setText("Question No.");

        currentQNumber.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        currentQNumber.setText("1");

        slashLabel.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        slashLabel.setText("/");

        totalQNumber.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        totalQNumber.setText("1");

        javax.swing.GroupLayout extraPanelLayout = new javax.swing.GroupLayout(extraPanel);
        extraPanel.setLayout(extraPanelLayout);
        extraPanelLayout.setHorizontalGroup(
            extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(extraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(extraPanelLayout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(extraPanelLayout.createSequentialGroup()
                        .addGroup(extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(extraPanelLayout.createSequentialGroup()
                                .addComponent(currentScoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentScore)
                                .addGap(80, 80, 80))
                            .addGroup(extraPanelLayout.createSequentialGroup()
                                .addComponent(totalScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalScore, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(qNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentQNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalQNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        extraPanelLayout.setVerticalGroup(
            extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(extraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(extraPanelLayout.createSequentialGroup()
                        .addGroup(extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(currentScoreLabel)
                            .addComponent(currentScore))
                        .addGap(40, 40, 40)
                        .addGroup(extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalScoreLabel)
                            .addComponent(totalScore)))
                    .addComponent(qNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(extraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentQNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalQNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slashLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(answersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(extraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(answersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(extraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singleFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleFirstActionPerformed

    private void multiFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multiFirstActionPerformed

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseClicked
        computeScore();
        if(section.getQuestionList().size() != questionNumber) {
            questionNumber++;
            currentQuestion = section.getQuestionList().get(questionNumber - 1);
            currentAnswers = currentQuestion.getAnswers();
            initQuestion();
        } else {
            String message = "You obtained " + score + "/" + tScore + " points.";
            for(int i = 0; i< answeredQuestions.length; i++) {
                message += "\nQuestion " + (i+1) + " :" + (answeredQuestions[i] == 1.0? "Correct":"Incorrect");
            }
            
            JOptionPane.showMessageDialog(null, message);
        }
    }//GEN-LAST:event_nextButtonMouseClicked

    private void checkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkButtonMouseClicked
        hintLabel.setText("Info for Question: " + questionNumber);
        String message = "From A->D or the value: ";
        Map<Integer, String> shit = new HashMap<>();
        shit.put(1, "A");
        shit.put(2, "B");
        shit.put(3, "C");
        shit.put(4, "B");
        for(int i=0; i<currentQuestion.getAnswers().size(); i++) {
            if(!currentQuestion.getType().equals("input")) {
                message += "\n" + shit.get(i+1) + ") " + currentQuestion.getAnswers().get(i).getType();
            } else {
                message += "\nAnswer: " + currentQuestion.getAnswers().get(i).getValue();
            }
        }
        infoTextArea.setText(message);
    }//GEN-LAST:event_checkButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel answersPanel;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel currentQNumber;
    private javax.swing.JLabel currentScore;
    private javax.swing.JLabel currentScoreLabel;
    private javax.swing.JPanel extraPanel;
    private javax.swing.JLabel hintLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JScrollPane imageScrollPane;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JTextField inputAnswer;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel multiChoicePanel;
    private javax.swing.JCheckBox multiFirst;
    private javax.swing.JCheckBox multiFourth;
    private javax.swing.JLabel multiLabel;
    private javax.swing.JCheckBox multiSecond;
    private javax.swing.JCheckBox multiThird;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel qNoLabel;
    private javax.swing.JLabel selectionTypeLabel;
    private javax.swing.JPanel singleChoicePanel;
    private javax.swing.JRadioButton singleFirst;
    private javax.swing.JRadioButton singleFourth;
    private javax.swing.ButtonGroup singleGroup;
    private javax.swing.JLabel singleLabel;
    private javax.swing.JRadioButton singleSecond;
    private javax.swing.JRadioButton singleThird;
    private javax.swing.JLabel slashLabel;
    private javax.swing.JLabel totalQNumber;
    private javax.swing.JLabel totalScore;
    private javax.swing.JLabel totalScoreLabel;
    // End of variables declaration//GEN-END:variables
}
