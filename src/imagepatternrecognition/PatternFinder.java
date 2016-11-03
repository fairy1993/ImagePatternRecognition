/*
 * Copyright (C) 2016 Felipe Roscoche
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Felipe Roscoche
 * @website roscoche.com
 * 
 */
package imagepatternrecognition;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImageM;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class PatternFinder extends javax.swing.JFrame {

    public PatternFinder() {
        this.setIconImage(icone);
        initComponents();
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDExtractCharacteristics = new javax.swing.JDialog();
        BExtrairCaracteristicas = new javax.swing.JButton();
        BExtrairSelecionarImagens = new javax.swing.JButton();
        BExtrairExcluirImagem = new javax.swing.JButton();
        ExtrairQX = new javax.swing.JSpinner();
        ExtrairQY = new javax.swing.JSpinner();
        LExtrairQX = new javax.swing.JLabel();
        LExtrairQY = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TExtrairCaracteristicas = new javax.swing.JTable();
        LBMetodo = new javax.swing.JLabel();
        CBExtrairPercentis = new javax.swing.JCheckBox();
        CBExtrairLBP = new javax.swing.JCheckBox();
        JDFindSimilarImage = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        TSimilares = new javax.swing.JTable();
        TFLocalizarImagem = new javax.swing.JTextField();
        LImagemEntrada = new javax.swing.JLabel();
        LTamanhoRanking = new javax.swing.JLabel();
        LDescartarRanking = new javax.swing.JLabel();
        LMetodos = new javax.swing.JLabel();
        SpinnerTamanhoRanking = new javax.swing.JSpinner();
        SpinnerDescartarRanking = new javax.swing.JSpinner();
        BLocalizarImagem = new javax.swing.JButton();
        BAbrirSimilares = new javax.swing.JButton();
        BProcurarSimilar = new javax.swing.JButton();
        CBPercentil = new javax.swing.JCheckBox();
        CBLBP = new javax.swing.JCheckBox();
        MainPanel = new javax.swing.JTabbedPane();
        PanelPercentile = new javax.swing.JPanel();
        SPPercentis = new javax.swing.JScrollPane();
        TPercentil = new javax.swing.JTable();
        BPercentilCarregarImagem = new javax.swing.JButton();
        BPercentilExcluirCaracteristicas = new javax.swing.JButton();
        BPercentilCarregarTabela = new javax.swing.JButton();
        BPercentilSalvarTabela = new javax.swing.JButton();
        BPercentilAcharImagemSimilar = new javax.swing.JButton();
        LabelPercentilLQX = new javax.swing.JLabel();
        LabelPercentilLQY = new javax.swing.JLabel();
        LPercentilQX = new javax.swing.JLabel();
        LPercentilQY = new javax.swing.JLabel();
        PanelLBP = new javax.swing.JPanel();
        SPLBP = new javax.swing.JScrollPane();
        TLBP = new javax.swing.JTable();
        BLBPCarregarImagem = new javax.swing.JButton();
        BLBPExcluirCaracteristicas = new javax.swing.JButton();
        BLBPCarregarTabela = new javax.swing.JButton();
        BLBPSalvarTabela = new javax.swing.JButton();
        BLBPAcharImagemSimilar = new javax.swing.JButton();
        LabelLBPQX3 = new javax.swing.JLabel();
        LabelLBPQY = new javax.swing.JLabel();
        LLBPQX = new javax.swing.JLabel();
        LLBPQY = new javax.swing.JLabel();

        JDExtractCharacteristics.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        JDExtractCharacteristics.setTitle("Extract Characteristics");

        BExtrairCaracteristicas.setText("Extract Characteristics");
        BExtrairCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExtrairCaracteristicasActionPerformed(evt);
            }
        });

        BExtrairSelecionarImagens.setText("Load Images");
        BExtrairSelecionarImagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExtrairSelecionarImagensActionPerformed(evt);
            }
        });

        BExtrairExcluirImagem.setText("Delete Row");
        BExtrairExcluirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExtrairExcluirImagemActionPerformed(evt);
            }
        });

        ExtrairQX.setModel(new javax.swing.SpinnerNumberModel(2, 1, 10, 1));

        ExtrairQY.setModel(new javax.swing.SpinnerNumberModel(2, 1, 10, 1));

        LExtrairQX.setText("X Quadrants:");

        LExtrairQY.setText("Y Quadrants:");

        TExtrairCaracteristicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Process", "Image Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TExtrairCaracteristicas);

        LBMetodo.setText("Method:");

        CBExtrairPercentis.setText("Percentile");

        CBExtrairLBP.setText("LBP");

        javax.swing.GroupLayout JDExtractCharacteristicsLayout = new javax.swing.GroupLayout(JDExtractCharacteristics.getContentPane());
        JDExtractCharacteristics.getContentPane().setLayout(JDExtractCharacteristicsLayout);
        JDExtractCharacteristicsLayout.setHorizontalGroup(
            JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDExtractCharacteristicsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BExtrairExcluirImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JDExtractCharacteristicsLayout.createSequentialGroup()
                        .addComponent(LExtrairQX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExtrairQX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BExtrairCaracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BExtrairSelecionarImagens, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JDExtractCharacteristicsLayout.createSequentialGroup()
                        .addComponent(LExtrairQY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExtrairQY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JDExtractCharacteristicsLayout.createSequentialGroup()
                        .addComponent(LBMetodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBExtrairLBP)
                            .addComponent(CBExtrairPercentis))))
                .addContainerGap())
        );
        JDExtractCharacteristicsLayout.setVerticalGroup(
            JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDExtractCharacteristicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDExtractCharacteristicsLayout.createSequentialGroup()
                        .addComponent(BExtrairSelecionarImagens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BExtrairExcluirImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExtrairQX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LExtrairQX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExtrairQY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LExtrairQY))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDExtractCharacteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBMetodo)
                            .addComponent(CBExtrairPercentis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBExtrairLBP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BExtrairCaracteristicas))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        JDFindSimilarImage.setTitle("Find Similar Images");

        TSimilares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ranking Position", "Image Path", "Euclidean Distance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TSimilares);

        TFLocalizarImagem.setEditable(false);

        LImagemEntrada.setText("Image to search:");

        LTamanhoRanking.setText("Ranking Size");

        LDescartarRanking.setText("Discard");

        LMetodos.setText("Method");

        SpinnerTamanhoRanking.setModel(new javax.swing.SpinnerNumberModel(10, 1, 30, 1));

        SpinnerDescartarRanking.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        BLocalizarImagem.setText("Load Image");
        BLocalizarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLocalizarImagemActionPerformed(evt);
            }
        });

        BAbrirSimilares.setText("Open Images");
        BAbrirSimilares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAbrirSimilaresActionPerformed(evt);
            }
        });

        BProcurarSimilar.setText("Search");
        BProcurarSimilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BProcurarSimilarActionPerformed(evt);
            }
        });

        CBPercentil.setSelected(true);
        CBPercentil.setText("Percentil");

        CBLBP.setText("LBP");

        javax.swing.GroupLayout JDFindSimilarImageLayout = new javax.swing.GroupLayout(JDFindSimilarImage.getContentPane());
        JDFindSimilarImage.getContentPane().setLayout(JDFindSimilarImageLayout);
        JDFindSimilarImageLayout.setHorizontalGroup(
            JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDFindSimilarImageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addGroup(JDFindSimilarImageLayout.createSequentialGroup()
                        .addComponent(LImagemEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFLocalizarImagem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BLocalizarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BProcurarSimilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDFindSimilarImageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDFindSimilarImageLayout.createSequentialGroup()
                                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LDescartarRanking)
                                    .addComponent(LTamanhoRanking))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SpinnerTamanhoRanking)
                                    .addComponent(SpinnerDescartarRanking)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDFindSimilarImageLayout.createSequentialGroup()
                                .addComponent(LMetodos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBLBP)
                                    .addComponent(CBPercentil)))))
                    .addComponent(BAbrirSimilares, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JDFindSimilarImageLayout.setVerticalGroup(
            JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDFindSimilarImageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LImagemEntrada)
                    .addComponent(TFLocalizarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BLocalizarImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDFindSimilarImageLayout.createSequentialGroup()
                        .addComponent(BProcurarSimilar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LTamanhoRanking)
                            .addComponent(SpinnerTamanhoRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LDescartarRanking)
                            .addComponent(SpinnerDescartarRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDFindSimilarImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LMetodos)
                            .addComponent(CBPercentil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBLBP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BAbrirSimilares))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Pattern Recognition");

        TPercentil.setAutoCreateRowSorter(true);
        TPercentil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image Path", "Analized Channel(s)", "Percentile"
            }
        ));
        SPPercentis.setViewportView(TPercentil);

        BPercentilCarregarImagem.setText("Load Images");
        BPercentilCarregarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPercentilCarregarImagemActionPerformed(evt);
            }
        });

        BPercentilExcluirCaracteristicas.setText("Delete Row");
        BPercentilExcluirCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPercentilExcluirCaracteristicasActionPerformed(evt);
            }
        });

        BPercentilCarregarTabela.setText("Load Table");
        BPercentilCarregarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPercentilCarregarTabelaActionPerformed(evt);
            }
        });

        BPercentilSalvarTabela.setText("Save Table");
        BPercentilSalvarTabela.setEnabled(false);
        BPercentilSalvarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPercentilSalvarTabelaActionPerformed(evt);
            }
        });

        BPercentilAcharImagemSimilar.setText("Find Similar Image");
        BPercentilAcharImagemSimilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPercentilAcharImagemSimilarActionPerformed(evt);
            }
        });

        LabelPercentilLQX.setText("X Quadrants:");

        LabelPercentilLQY.setText("Y Quadrants:");

        LPercentilQX.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LPercentilQX.setText("QX");

        LPercentilQY.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LPercentilQY.setText("QY");

        javax.swing.GroupLayout PanelPercentileLayout = new javax.swing.GroupLayout(PanelPercentile);
        PanelPercentile.setLayout(PanelPercentileLayout);
        PanelPercentileLayout.setHorizontalGroup(
            PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPercentileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SPPercentis, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPercentileLayout.createSequentialGroup()
                        .addGroup(PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelPercentilLQX, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelPercentilLQY, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LPercentilQY)
                            .addComponent(LPercentilQX, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(BPercentilSalvarTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BPercentilCarregarTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BPercentilExcluirCaracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BPercentilCarregarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BPercentilAcharImagemSimilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelPercentileLayout.setVerticalGroup(
            PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPercentileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPPercentis, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(PanelPercentileLayout.createSequentialGroup()
                        .addComponent(BPercentilCarregarImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BPercentilExcluirCaracteristicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BPercentilCarregarTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BPercentilSalvarTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BPercentilAcharImagemSimilar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPercentilLQX)
                            .addComponent(LPercentilQX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPercentileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPercentilLQY)
                            .addComponent(LPercentilQY))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        MainPanel.addTab("Percentile", PanelPercentile);

        TLBP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image Path", "LBP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        SPLBP.setViewportView(TLBP);

        BLBPCarregarImagem.setText("Load Images");
        BLBPCarregarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLBPCarregarImagemActionPerformed(evt);
            }
        });

        BLBPExcluirCaracteristicas.setText("Delete Row");
        BLBPExcluirCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLBPExcluirCaracteristicasActionPerformed(evt);
            }
        });

        BLBPCarregarTabela.setText("Load Table");
        BLBPCarregarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLBPCarregarTabelaActionPerformed(evt);
            }
        });

        BLBPSalvarTabela.setText("Save Table");
        BLBPSalvarTabela.setEnabled(false);
        BLBPSalvarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLBPSalvarTabelaActionPerformed(evt);
            }
        });

        BLBPAcharImagemSimilar.setText("Find Similar Image");
        BLBPAcharImagemSimilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLBPAcharImagemSimilarActionPerformed(evt);
            }
        });

        LabelLBPQX3.setText("X Quadrants:");

        LabelLBPQY.setText("Y Quadrants:");

        LLBPQX.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LLBPQX.setText("QX");

        LLBPQY.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LLBPQY.setText("QY");

        javax.swing.GroupLayout PanelLBPLayout = new javax.swing.GroupLayout(PanelLBP);
        PanelLBP.setLayout(PanelLBPLayout);
        PanelLBPLayout.setHorizontalGroup(
            PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLBPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SPLBP, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BLBPAcharImagemSimilar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BLBPSalvarTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BLBPCarregarTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BLBPCarregarImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BLBPExcluirCaracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLBPLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLBPLayout.createSequentialGroup()
                                .addComponent(LabelLBPQY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LLBPQY))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLBPLayout.createSequentialGroup()
                                .addComponent(LabelLBPQX3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LLBPQX)))))
                .addContainerGap())
        );
        PanelLBPLayout.setVerticalGroup(
            PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLBPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPLBP, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addGroup(PanelLBPLayout.createSequentialGroup()
                        .addComponent(BLBPCarregarImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLBPExcluirCaracteristicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLBPCarregarTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLBPSalvarTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLBPAcharImagemSimilar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelLBPQX3)
                            .addComponent(LLBPQX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLBPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelLBPQY)
                            .addComponent(LLBPQY))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        MainPanel.addTab("Local Binary Pattern (LBP)", PanelLBP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPercentilCarregarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPercentilCarregarImagemActionPerformed
        abrirJanelaExtrairCaracteristicas();
    }//GEN-LAST:event_BPercentilCarregarImagemActionPerformed

    public void escolherImagens(DefaultTableModel model){
    JFileChooser fo=new JFileChooser();
    
    Path absolute = Paths.get(System.getProperty("user.dir"));
    Path relative;
    
    fo.setCurrentDirectory(absolute.toFile());
    fo.setMultiSelectionEnabled(true);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Imagem", "bmp", "png","jpg");
    fo.setFileFilter(filter);
    int choosen;
        choosen = fo.showOpenDialog(null);
    File[] files=fo.getSelectedFiles();
    Path[] nameFiles = new Path[files.length];
    
    for(int i=0;i<files.length;i++){   
        relative=absolute.relativize(Paths.get(files[i].getAbsolutePath()));
        nameFiles[i]=relative;
    }
    int tamanholistaatual=files.length;
    int tamanholistavelha=model.getRowCount();
    int tamanholistanova=tamanholistaatual+tamanholistavelha;
    Path[] nameFilesnew=new Path[tamanholistanova];
    
    for(int i=0;i<tamanholistanova;i++){
        if(i<tamanholistavelha)nameFilesnew[i]=(Path) model.getValueAt(i,1);
        else {
            nameFilesnew[i]=nameFiles[i-tamanholistavelha];
            model.insertRow(i, (Object[]) (Object) null);
            model.setValueAt(true, i, 0);
            model.setValueAt(nameFilesnew[i], i, 1);
        }
    }
}

    
    private void BExtrairSelecionarImagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExtrairSelecionarImagensActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)TExtrairCaracteristicas.getModel();
        escolherImagens(model);        
    }//GEN-LAST:event_BExtrairSelecionarImagensActionPerformed

    private void BExtrairExcluirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExtrairExcluirImagemActionPerformed
        //Exclusao de imagens selecionadas na tabela de extrair caracteristicas
        excluirLinhasTabela(TExtrairCaracteristicas);
    }//GEN-LAST:event_BExtrairExcluirImagemActionPerformed

    
    private void BExtrairCaracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExtrairCaracteristicasActionPerformed
        DefaultTableModel modelExtrair=(DefaultTableModel) TExtrairCaracteristicas.getModel();
        
        boolean extrairPercentil=CBExtrairPercentis.getModel().isSelected();
        boolean extrairLBP=CBExtrairLBP.getModel().isSelected();
        
        PatternRecognition pr=new PatternRecognition();
        int tamanholista=modelExtrair.getRowCount();
        int qx=(int) ExtrairQX.getModel().getValue();
        int qy=(int) ExtrairQY.getModel().getValue();
        
        double[] caracAll;
        CvMat imagem;
        Path imgpath;
        if(extrairPercentil){
            DefaultTableModel modelPercentil=(DefaultTableModel) TPercentil.getModel();
            //modelPercentil.setRowCount(0);
            ImageChannel imgcanal;
            int listaAntiga=modelPercentil.getRowCount();
            int naoprocessar=0;
            for(int i=listaAntiga;i<tamanholista+listaAntiga;i++){
                if((boolean)modelExtrair.getValueAt(i-listaAntiga,0)){
                    imgpath=(Path)modelExtrair.getValueAt(i-listaAntiga,1);
                    String imgsrc=imgpath.toString();
                    imagem=cvLoadImageM(imgsrc);
                    //Carrega imagem e calcula percentil
                    caracAll=pr.calculaPercentil(imagem,qx,qy);
                    //Insere linhas na tabela de Percentil e define os valores
                    modelPercentil.insertRow(i-naoprocessar, (Object[]) (Object) null);
                    modelPercentil.setValueAt(imgpath.toString(), i-naoprocessar, 0);
                    modelPercentil.setValueAt(Arrays.toString(caracAll), i-naoprocessar, 2);
                    if(imagem.channels()==1){
                        modelPercentil.setValueAt("GRAYSCALE", i-naoprocessar, 1);
                        imgcanal=new ImageChannel(imgsrc,"GRAYSCALE");
                    }
                    else{
                        modelPercentil.setValueAt("RGB", i-naoprocessar, 1);
                        imgcanal=new ImageChannel(imgsrc,"RGB");
                    }
                    mapapercentil.put(imgcanal, caracAll);
                    if(!extrairLBP) modelExtrair.setValueAt(false, i-listaAntiga, 0);
                }
                else naoprocessar++;
            }
            LPercentilQX.setText(""+qx);
            LPercentilQY.setText(""+qy);
            
            BPercentilSalvarTabela.setEnabled(true);
        }
        if(extrairLBP){
            DefaultTableModel modelLBP=(DefaultTableModel) TLBP.getModel();
            //Limpando tabela para repopulá-la
            int listaAntiga=modelLBP.getRowCount();
            
            int naoprocessar=0;
            for(int i=listaAntiga;i<tamanholista+listaAntiga;i++){
                if((boolean)modelExtrair.getValueAt(i-listaAntiga,0)){
                    //Carrega a imagem, e calcula suas caracteristicas
                    imgpath=(Path)modelExtrair.getValueAt(i-listaAntiga,1);
                    String imgsrc=imgpath.toString();
                    imagem=cvLoadImageM(imgsrc);
                    caracAll=pr.calculaLBP(imagem,qx,qy);
                    //Insere linha na tabela e define os valores de cada coluna
                    modelLBP.insertRow(i-naoprocessar, (Object[]) (Object) null);
                    modelLBP.setValueAt(imgsrc, i-naoprocessar, 0);
                    modelLBP.setValueAt(Arrays.toString(caracAll), i-naoprocessar, 1);
                    mapalbp.put(imgsrc,caracAll);
                    modelExtrair.setValueAt(false,i-listaAntiga, 0);
                }
                else naoprocessar++;
            }
            LLBPQX.setText(""+qx);
            LLBPQY.setText(""+qy);
            BLBPSalvarTabela.setEnabled(true);
        }
        JDExtractCharacteristics.dispose();
    }//GEN-LAST:event_BExtrairCaracteristicasActionPerformed

    private void BLBPCarregarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLBPCarregarImagemActionPerformed
        // TODO add your handling code here:
        abrirJanelaExtrairCaracteristicas();
    }//GEN-LAST:event_BLBPCarregarImagemActionPerformed

    private void BPercentilSalvarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPercentilSalvarTabelaActionPerformed
        // TODO add your handling code here:
        int qx=Integer.parseInt(LPercentilQX.getText());
        int qy=Integer.parseInt(LPercentilQY.getText());
        double[] quadrantes={(double)qx,(double)qy};
        ImageChannel imgquadrantes=new ImageChannel("QXQY","QXQY");
        mapapercentil.put(imgquadrantes, quadrantes);
        
        JFileChooser fs=new JFileChooser();
        Path absolute = Paths.get(System.getProperty("user.dir"));
        fs.setCurrentDirectory(absolute.toFile());
        fs.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tabelas de Percentil (.TabelaPercentil)", "TabelaPercentil","TabelaPercentil");
        fs.addChoosableFileFilter(filter);
        fs.setFileFilter(filter);
        int choosen= fs.showSaveDialog(null);
        File file=fs.getSelectedFile();
        file=new File(file.getParent()+"\\"+file.getName()+".TabelaPercentil");
        
        try {
            try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(mapapercentil);
                oos.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(PatternFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        mapapercentil.remove(imgquadrantes);
    }//GEN-LAST:event_BPercentilSalvarTabelaActionPerformed

    private void BPercentilCarregarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPercentilCarregarTabelaActionPerformed
        // TODO add your handling code here:
        JFileChooser fs=new JFileChooser();
        Path absolute = Paths.get(System.getProperty("user.dir"));
        fs.setCurrentDirectory(absolute.toFile());
        fs.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tabelas de Percentil (.TabelaPercentil)", "TabelaPercentil", "TabelaPercentil");
        fs.addChoosableFileFilter(filter);
        fs.setFileFilter(filter);
        int choosen= fs.showOpenDialog(null);
        File file=fs.getSelectedFile();
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapapercentil=(HashMap<ImageChannel,double[]>)ois.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PatternFinder.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        ImageChannel quadrantes=new ImageChannel("QXQY","QXQY");
        double[] configs=mapapercentil.get(quadrantes);
        LPercentilQX.setText(""+configs[0]);
        LPercentilQY.setText(""+configs[1]);
        mapapercentil.remove(quadrantes);
        
        Iterator<ImageChannel> it=mapapercentil.keySet().iterator();
        DefaultTableModel model=(DefaultTableModel) TPercentil.getModel();
        ImageChannel atual;
        double[] valores;
        int looper=0;
        while(it.hasNext()){
            atual=it.next();
            valores=mapapercentil.get(atual);
            model.insertRow(looper,(Object[])(Object)null);
            model.setValueAt(atual.getImgsrc(),looper,0);
            model.setValueAt(atual.getCanal(),looper,1);
            model.setValueAt(Arrays.toString(valores),looper,2);
            looper++;
        }
        SPPercentis.repaint();
        SPPercentis.revalidate();
        SPPercentis.repaint();
    }//GEN-LAST:event_BPercentilCarregarTabelaActionPerformed

    private void BAbrirSimilaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAbrirSimilaresActionPerformed
        // Essa função serve para abrir as imagens do Ranking, com uma thread
        // por imagem
        DefaultTableModel model=(DefaultTableModel) TSimilares.getModel();
        String imgsrc;
        ShowImage[] processos=new ShowImage[model.getRowCount()];
        for(int i=0;i<model.getRowCount();i++){
            imgsrc=(String)model.getValueAt(i,1);
            processos[i]=new ShowImage(i+1,imgsrc);
            new Thread(processos[i]).start();    
        }
    }//GEN-LAST:event_BAbrirSimilaresActionPerformed

    private void BLocalizarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLocalizarImagemActionPerformed
        // TODO add your handling code here:
        JFileChooser fs=new JFileChooser();
        Path absolute = Paths.get(System.getProperty("user.dir"));
        fs.setCurrentDirectory(absolute.toFile());
        fs.setMultiSelectionEnabled(false);
        int choosen= fs.showOpenDialog(null);
        File file=fs.getSelectedFile();
        if(file!=null) TFLocalizarImagem.setText(file.getAbsolutePath());
    }//GEN-LAST:event_BLocalizarImagemActionPerformed

    private void BPercentilAcharImagemSimilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPercentilAcharImagemSimilarActionPerformed
        //calculaAcerto();
        abrirJanelaProcurarSimilaridade();
    }//GEN-LAST:event_BPercentilAcharImagemSimilarActionPerformed

    private void BLBPAcharImagemSimilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLBPAcharImagemSimilarActionPerformed
        abrirJanelaProcurarSimilaridade();
    }//GEN-LAST:event_BLBPAcharImagemSimilarActionPerformed
    public static int randInt(int min, int max) {
    Random rand = new Random();
    return rand.nextInt((max - min) + 1) + min;

}
    private void calculaAcerto(){
        PatternRecognition pr=new PatternRecognition();
        int[] classes=new int[10];
        int[] acertoClasses=new int[10];
        boolean avaliacaoCompleta=false;
        boolean jaFoi[]=new boolean[1000];
        int tamanhoRanking=11;
        int descartarRanking=1;
        
        boolean compararPercentil=true;
        boolean compararLBP=true;
        
        while(!avaliacaoCompleta){
            CvMat src;
            int min=0,classe,numerosrc;
            int max=999;
            int random;
            String pathinput,pathsrc;
            do{ 
                random=randInt(min,max);
                
                pathinput=(String) TLBP.getModel().getValueAt(random,0);
                pathsrc=pathinput.replaceAll("\\\\", ".");
                String[] splitsrc=pathsrc.split("[.]{1}");
                numerosrc=Integer.parseInt(splitsrc[splitsrc.length-2]);
                //if(!jaFoi[400]) numerosrc=400;
                classe=((int)numerosrc/100);
                }while(classes[classe]>tamanhoRanking-2||jaFoi[numerosrc]);
            src=cvLoadImageM(pathinput);
            classes[classe]++;
            jaFoi[numerosrc]=true;
            int qx=2,qy=2;
            double[] procurandoAll,caracAll;
            double finalAll;

            if(compararPercentil&&compararLBP){
                procurandoAll=pr.calculaPercentileLBP(src,qx,qy);
                int numValores=(qx*qy*(10*src.channels()+256));
                double[] caracPercentil,caracLBP;
                caracAll=new double[numValores];
                Set<ImageChannel> keyset = mapapercentil.keySet();
                Iterator<ImageChannel> it=keyset.iterator();
                ImageChannel icAtual;
                while(it.hasNext()){
                    icAtual=it.next();
                    caracPercentil=mapapercentil.get(icAtual);
                    caracLBP=mapalbp.get(icAtual.getImgsrc());
                    System.arraycopy(caracPercentil,0, caracAll, 0, caracPercentil.length);
                    System.arraycopy(caracLBP,0, caracAll, caracPercentil.length,caracLBP.length);
                    finalAll=pr.calculaDistanciaEuclidiana(caracAll, procurandoAll);
                    maparanking.put(icAtual.getImgsrc(),(Double) finalAll);
                }
            }
            else if(compararPercentil){
                procurandoAll=pr.calculaPercentil(src,qx,qy);
                //numValores=qx*qy*src.channels()*10;
                Set<ImageChannel> keyset = mapapercentil.keySet();
                Iterator<ImageChannel> it=keyset.iterator();
                ImageChannel icAtual;
                while(it.hasNext()){
                    icAtual=it.next();
                    caracAll=mapapercentil.get(icAtual);
                    finalAll=pr.calculaDistanciaEuclidiana(caracAll, procurandoAll);
                    maparanking.put(icAtual.getImgsrc(),(Double) finalAll);
                }
            }
            else if(compararLBP){
                procurandoAll=pr.calculaLBP(src,qx,qy);
                //numValores=qx*qy*256;
                Set<String> keyset=mapalbp.keySet();
                Iterator it=keyset.iterator();
                String imgsrc;
                while(it.hasNext()){
                    imgsrc=(String) it.next();
                    caracAll=mapalbp.get(imgsrc);
                    finalAll=pr.calculaDistanciaEuclidiana(caracAll, procurandoAll);
                    maparanking.put(imgsrc,(Double) finalAll);
                }
            }

            //Aqui ordena a HashMap do Ranking, com o tamanho maximo definido pelo
            //usuário, descartando ou não resultados, prossegue então a popular a tabela
            List values = new ArrayList(maparanking.values());
            DefaultTableModel model=(DefaultTableModel) TSimilares.getModel();
            model.setRowCount(0);
            Collections.sort(values);
            Map<String, Double> sortedMap = sortByComparator(maparanking,true);
            Iterator<String> iteradorRanking=sortedMap.keySet().iterator();

            int ranking;
            int looper=0;
            int hit=0;
            while(looper<tamanhoRanking&&iteradorRanking.hasNext()){
                String imagem=iteradorRanking.next();
                if(looper>=descartarRanking){
                    imagem=imagem.replaceAll("\\\\", ".");
                    String[] splitimagem=imagem.split("[.]{1}");
                    int numeroimagem=Integer.parseInt(splitimagem[splitimagem.length-2]);
                    if(((int)numerosrc/100)==((int)numeroimagem/100)) hit++;
                    ranking=looper-descartarRanking;
                    model.insertRow(ranking,(Object[])(Object)null);
                    model.setValueAt(ranking+1, ranking, 0);
                    model.setValueAt(imagem, ranking, 1);
                    model.setValueAt(maparanking.get(imagem), ranking, 2);
                }
                looper++;
            }
            acertoClasses[classe]+=hit;
            System.out.println(
                    pathinput
                    +"\t"+classe
                    +"\t"+hit
                    //+"\tSemelhantes: \t"+sortedMap.toString()
                    
                    //+"\tRanking"+maparanking.entrySet().toString()
            );
            for(int i=0;i<classes.length;i++){
                if(classes[i]<10) {
                    avaliacaoCompleta=false;
                    i=classes.length;
                }
                else {
                    avaliacaoCompleta=true;
                    
                }
            }
            
            maparanking=new HashMap();
            
        }
        for(int i=0;i<acertoClasses.length;i++) System.out.println("\t"+i+"\t"+acertoClasses[i]+"%");
    }
    
    private void BProcurarSimilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BProcurarSimilarActionPerformed
        // TODO add your handling code here:
        
        PatternRecognition pr=new PatternRecognition();
        CvMat src;
        src=cvLoadImageM(TFLocalizarImagem.getText());
        boolean compararPercentil=CBPercentil.getModel().isSelected();
        boolean compararLBP=CBLBP.getModel().isSelected();
        
        int qx=(int) ExtrairQX.getModel().getValue();
        int qy=(int) ExtrairQY.getModel().getValue();
        
        double[] procurandoAll,caracAll;
        double finalAll;
        
        if(compararPercentil&&compararLBP){
            procurandoAll=pr.calculaPercentileLBP(src,qx,qy);
            int numValores=(qx*qy*(10*src.channels()+256));
            double[] caracPercentil,caracLBP;
            caracAll=new double[numValores];
            Set<ImageChannel> keyset = mapapercentil.keySet();
            Iterator<ImageChannel> it=keyset.iterator();
            ImageChannel icAtual;
            while(it.hasNext()){
                icAtual=it.next();
                caracPercentil=mapapercentil.get(icAtual);
                caracLBP=mapalbp.get(icAtual.getImgsrc());
                System.arraycopy(caracPercentil,0, caracAll, 0, caracPercentil.length);
                System.arraycopy(caracLBP,0, caracAll, caracPercentil.length,caracLBP.length);
                finalAll=pr.calculaDistanciaEuclidiana(caracAll, procurandoAll);
                maparanking.put(icAtual.getImgsrc(),(Double) finalAll);
            }
        }
        else if(compararPercentil){
            procurandoAll=pr.calculaPercentil(src,qx,qy);
            //numValores=qx*qy*src.channels()*10;
            Set<ImageChannel> keyset = mapapercentil.keySet();
            Iterator<ImageChannel> it=keyset.iterator();
            ImageChannel icAtual;
            while(it.hasNext()){
                icAtual=it.next();
                caracAll=mapapercentil.get(icAtual);
                finalAll=pr.calculaDistanciaEuclidiana(caracAll, procurandoAll);
                maparanking.put(icAtual.getImgsrc(),(Double) finalAll);
            }
        }
        else if(compararLBP){
            procurandoAll=pr.calculaLBP(src,qx,qy);
            //numValores=qx*qy*256;
            Set<String> keyset=mapalbp.keySet();
            Iterator it=keyset.iterator();
            String imgsrc;
            while(it.hasNext()){
                imgsrc=(String) it.next();
                caracAll=mapalbp.get(imgsrc);
                finalAll=pr.calculaDistanciaEuclidiana(caracAll, procurandoAll);
                maparanking.put(imgsrc,(Double) finalAll);
            }
        }
        
        //Aqui ordena a HashMap do Ranking, com o tamanho maximo definido pelo
        //usuário, descartando ou não resultados, prossegue então a popular a tabela
        List values = new ArrayList(maparanking.values());
        DefaultTableModel model=(DefaultTableModel) TSimilares.getModel();
        model.setRowCount(0);
        Collections.sort(values);
        Map<String, Double> sortedMap = sortByComparator(maparanking,true);
        Iterator<String> iteradorRanking=sortedMap.keySet().iterator();
        
        int descartarRanking=(int)SpinnerDescartarRanking.getModel().getValue();
        int tamanhoRanking=(int)SpinnerTamanhoRanking.getModel().getValue()+descartarRanking;
        int ranking;
        int looper=0;
        while(looper<tamanhoRanking&&iteradorRanking.hasNext()){
            String imagem=iteradorRanking.next();
            if(looper>=descartarRanking){
            ranking=looper-descartarRanking;
            model.insertRow(ranking,(Object[])(Object)null);
            model.setValueAt(ranking+1, ranking, 0);
            model.setValueAt(imagem, ranking, 1);
            model.setValueAt(maparanking.get(imagem), ranking, 2);
            }
            looper++;
        }
        maparanking.clear();
    }//GEN-LAST:event_BProcurarSimilarActionPerformed

    private void BLBPSalvarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLBPSalvarTabelaActionPerformed
        // TODO add your handling code here:
        int qx=Integer.parseInt(LLBPQX.getText());
        int qy=Integer.parseInt(LLBPQY.getText());
        double[] quadrantes={(double)qx,(double)qy};
        String quadrantesString="QXQY";
        mapalbp.put(quadrantesString, quadrantes);
        
        JFileChooser fs=new JFileChooser();
        Path absolute = absolute = Paths.get(System.getProperty("user.dir"));
        fs.setCurrentDirectory(absolute.toFile());
        fs.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tabelas de LBP (.TabelaLBP)", "TabelaLBP","TabelaLBP");
        fs.addChoosableFileFilter(filter);
        fs.setFileFilter(filter);
        int choosen= fs.showSaveDialog(null);
        File file=fs.getSelectedFile();
        file=new File(file.getParent()+"\\"+file.getName()+".TabelaLBP");
        
        try {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(mapalbp);
                oos.flush();
                oos.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(PatternFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        mapalbp.remove(quadrantesString);
    }//GEN-LAST:event_BLBPSalvarTabelaActionPerformed

    private void BLBPCarregarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLBPCarregarTabelaActionPerformed
        // TODO add your handling code here:
        JFileChooser fs=new JFileChooser();
        Path absolute = absolute = Paths.get(System.getProperty("user.dir"));
        fs.setCurrentDirectory(absolute.toFile());
        fs.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tabelas de LBP (.TabelaLBP)", "TabelaLBP", "TabelaLBP");
        fs.addChoosableFileFilter(filter);
        fs.setFileFilter(filter);
        int choosen= fs.showOpenDialog(null);
        File file=fs.getSelectedFile();
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapalbp=(HashMap<String,double[]>)ois.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PatternFinder.class.getName()).log(Level.SEVERE, null, ex);
        }

        double[] configs=mapalbp.get("QXQY");
        LLBPQX.setText(""+configs[0]);
        LLBPQY.setText(""+configs[1]);
        mapalbp.remove("QXQY");
        
        Iterator it=mapalbp.keySet().iterator();
        DefaultTableModel model=(DefaultTableModel) TLBP.getModel();
        double[] valores;
        int looper=0;
        String atual;
        while(it.hasNext()){
            atual=(String) it.next();
            valores=mapalbp.get(atual);
            model.insertRow(looper,(Object[])(Object)null);
            model.setValueAt(atual,looper,0);
            model.setValueAt(Arrays.toString(valores),looper,1);
            looper++;
        }
    }//GEN-LAST:event_BLBPCarregarTabelaActionPerformed

    private void BPercentilExcluirCaracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPercentilExcluirCaracteristicasActionPerformed
        excluirLinhasTabela(TPercentil);
    }//GEN-LAST:event_BPercentilExcluirCaracteristicasActionPerformed

    private void BLBPExcluirCaracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLBPExcluirCaracteristicasActionPerformed
        excluirLinhasTabela(TLBP);
    }//GEN-LAST:event_BLBPExcluirCaracteristicasActionPerformed
    
    private static Map<String, Double> sortByComparator(HashMap<String, Double> unsortMap, final boolean order){
        List<Entry<String, Double>> list = new LinkedList<>(unsortMap.entrySet());
        //Ordenando Collection
        Collections.sort(list, (Entry<String, Double> o1, Entry<String, Double> o2) -> {
            if (order) return o1.getValue().compareTo(o2.getValue());
            else return o2.getValue().compareTo(o1.getValue());
        });
        //Mantendo ordem utilizando-se de LinkedHashMap
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        list.stream().forEach((entry) -> {
            sortedMap.put(entry.getKey(), entry.getValue());
        });
        return sortedMap;
    }
    
    private void abrirJanelaExtrairCaracteristicas(){
        JDExtractCharacteristics.setVisible(true);
        JDExtractCharacteristics.setEnabled(true);
        JDExtractCharacteristics.setLocationRelativeTo(MainPanel);
        JDExtractCharacteristics.pack();
    }
    
    private void abrirJanelaProcurarSimilaridade(){
        JDFindSimilarImage.setVisible(true);
        JDFindSimilarImage.setEnabled(true);
        JDFindSimilarImage.setLocationRelativeTo(MainPanel);
        JDFindSimilarImage.pack();
    }
    
    private void excluirLinhasTabela(JTable tabela){
        while(tabela.getSelectedRowCount()>0) ((DefaultTableModel)tabela.getModel()).removeRow(tabela.getSelectedRow());
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatternFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PatternFinder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAbrirSimilares;
    private javax.swing.JButton BExtrairCaracteristicas;
    private javax.swing.JButton BExtrairExcluirImagem;
    private javax.swing.JButton BExtrairSelecionarImagens;
    private javax.swing.JButton BLBPAcharImagemSimilar;
    private javax.swing.JButton BLBPCarregarImagem;
    private javax.swing.JButton BLBPCarregarTabela;
    private javax.swing.JButton BLBPExcluirCaracteristicas;
    private javax.swing.JButton BLBPSalvarTabela;
    private javax.swing.JButton BLocalizarImagem;
    private javax.swing.JButton BPercentilAcharImagemSimilar;
    private javax.swing.JButton BPercentilCarregarImagem;
    private javax.swing.JButton BPercentilCarregarTabela;
    private javax.swing.JButton BPercentilExcluirCaracteristicas;
    private javax.swing.JButton BPercentilSalvarTabela;
    private javax.swing.JButton BProcurarSimilar;
    private javax.swing.JCheckBox CBExtrairLBP;
    private javax.swing.JCheckBox CBExtrairPercentis;
    private javax.swing.JCheckBox CBLBP;
    private javax.swing.JCheckBox CBPercentil;
    private javax.swing.JSpinner ExtrairQX;
    private javax.swing.JSpinner ExtrairQY;
    private javax.swing.JDialog JDExtractCharacteristics;
    private javax.swing.JDialog JDFindSimilarImage;
    private javax.swing.JLabel LBMetodo;
    private javax.swing.JLabel LDescartarRanking;
    private javax.swing.JLabel LExtrairQX;
    private javax.swing.JLabel LExtrairQY;
    private javax.swing.JLabel LImagemEntrada;
    private javax.swing.JLabel LLBPQX;
    private javax.swing.JLabel LLBPQY;
    private javax.swing.JLabel LMetodos;
    private javax.swing.JLabel LPercentilQX;
    private javax.swing.JLabel LPercentilQY;
    private javax.swing.JLabel LTamanhoRanking;
    private javax.swing.JLabel LabelLBPQX3;
    private javax.swing.JLabel LabelLBPQY;
    private javax.swing.JLabel LabelPercentilLQX;
    private javax.swing.JLabel LabelPercentilLQY;
    private javax.swing.JTabbedPane MainPanel;
    private javax.swing.JPanel PanelLBP;
    private javax.swing.JPanel PanelPercentile;
    private javax.swing.JScrollPane SPLBP;
    private javax.swing.JScrollPane SPPercentis;
    private javax.swing.JSpinner SpinnerDescartarRanking;
    private javax.swing.JSpinner SpinnerTamanhoRanking;
    private javax.swing.JTable TExtrairCaracteristicas;
    private javax.swing.JTextField TFLocalizarImagem;
    private javax.swing.JTable TLBP;
    private javax.swing.JTable TPercentil;
    private javax.swing.JTable TSimilares;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
    
    
    HashMap<ImageChannel,double[]> mapapercentil= new HashMap<>();
    HashMap<String,double[]> mapalbp= new HashMap<>();
    HashMap<String,Double> maparanking=new HashMap<>();
    private final ImageIcon iconeaux = new ImageIcon(PatternFinder.class.getResource("../resources/icon.png"));
    private final Image icone=iconeaux.getImage();
   
    
    
}
