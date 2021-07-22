/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.PhongDao;
import dao.ThongKeDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Phong;

public final class TrangChuWindows extends javax.swing.JPanel {

    public TrangChuWindows() {
        initComponents();
        filter();
        thongke();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDanhSachPhongTrong = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhongTrong = new javax.swing.JTable();
        lblDanhSachPhongTrong = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        chkLoc1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        chkLoc2 = new javax.swing.JCheckBox();
        chkLoc3 = new javax.swing.JCheckBox();
        chkLoc4 = new javax.swing.JCheckBox();
        chkLoc9 = new javax.swing.JCheckBox();
        chkLoc5 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        chkLoc6 = new javax.swing.JCheckBox();
        chkLoc7 = new javax.swing.JCheckBox();
        chkLoc8 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        txtGiaMin = new javax.swing.JTextField();
        txtGiaMax = new javax.swing.JTextField();
        txtGia = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlXemNhanh1 = new javax.swing.JPanel();
        pnlToaNha1 = new javax.swing.JPanel();
        lblIconToaNha1 = new javax.swing.JLabel();
        lblSoToaNha = new javax.swing.JLabel();
        pnlKhachThue = new javax.swing.JPanel();
        lblIconKhachThue = new javax.swing.JLabel();
        lblSoKhachThue = new javax.swing.JLabel();
        pnlPhongDaThue = new javax.swing.JPanel();
        lblIconPhongDaThue = new javax.swing.JLabel();
        lblSoPhongDaThue = new javax.swing.JLabel();
        pnlPhongTrong = new javax.swing.JPanel();
        lblIconPhongTrong = new javax.swing.JLabel();
        lblSoPhongTrong = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblSoToaNha2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDanhSachPhongTrong.setBackground(new java.awt.Color(255, 255, 255));
        pnlDanhSachPhongTrong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblPhongTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nhà", "Phòng", "Tầng", "Diện tích", "Giá", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhongTrong.setGridColor(new java.awt.Color(204, 204, 204));
        tblPhongTrong.setRowHeight(30);
        tblPhongTrong.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblPhongTrong.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblPhongTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongTrongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhongTrong);
        if (tblPhongTrong.getColumnModel().getColumnCount() > 0) {
            tblPhongTrong.getColumnModel().getColumn(6).setMaxWidth(500);
        }

        lblDanhSachPhongTrong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDanhSachPhongTrong.setText("Danh sách phòng trống");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        chkLoc1.setText("Có sẵn điều hòa");
        chkLoc1.setToolTipText("DieuHoa");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bộ lọc");

        chkLoc2.setText("Có bình nước nóng lạnh");
        chkLoc2.setToolTipText("KhepKin");

        chkLoc3.setText("Có chỗ để xe");
        chkLoc3.setToolTipText("ChoDeXe");

        chkLoc4.setText("Ở chung chủ");
        chkLoc4.setToolTipText("ChungChu");

        chkLoc9.setText("Có khu phơi đồ riêng");
        chkLoc9.setToolTipText("ChoPhoiDoRieng");

        chkLoc5.setText("Được nấu ăn trong phòng");
        chkLoc5.setToolTipText("Camera");

        jButton1.setText("Áp dụng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chkLoc6.setText("Nhà vệ sinh khép kín");

        chkLoc7.setText("Giờ ra vào tự do");

        chkLoc8.setText("Đồng hồ điện nước riêng");

        jLabel2.setText("Giá min:");

        txtGia.setText("Giá max:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chkLoc2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkLoc3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkLoc4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkLoc1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkLoc6)
                            .addComponent(chkLoc7)
                            .addComponent(chkLoc8)
                            .addComponent(chkLoc9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(txtGiaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia))))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkLoc5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLoc1)
                    .addComponent(chkLoc6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLoc2)
                    .addComponent(chkLoc7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLoc3)
                    .addComponent(chkLoc8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLoc4)
                    .addComponent(chkLoc9))
                .addGap(18, 18, 18)
                .addComponent(chkLoc5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaMin, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtGiaMax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDanhSachPhongTrongLayout = new javax.swing.GroupLayout(pnlDanhSachPhongTrong);
        pnlDanhSachPhongTrong.setLayout(pnlDanhSachPhongTrongLayout);
        pnlDanhSachPhongTrongLayout.setHorizontalGroup(
            pnlDanhSachPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachPhongTrongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDanhSachPhongTrongLayout.createSequentialGroup()
                        .addComponent(lblDanhSachPhongTrong)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDanhSachPhongTrongLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDanhSachPhongTrongLayout.setVerticalGroup(
            pnlDanhSachPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachPhongTrongLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblDanhSachPhongTrong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDanhSachPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(pnlDanhSachPhongTrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1010, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        pnlXemNhanh1.setBackground(new java.awt.Color(255, 255, 255));
        pnlXemNhanh1.setLayout(new java.awt.GridLayout(1, 0));

        pnlToaNha1.setBackground(new java.awt.Color(255, 255, 255));
        pnlToaNha1.setPreferredSize(new java.awt.Dimension(140, 122));

        lblIconToaNha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconToaNha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/city_64px.png"))); // NOI18N

        lblSoToaNha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoToaNha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoToaNha.setText("Tòa nhà: 3");

        javax.swing.GroupLayout pnlToaNha1Layout = new javax.swing.GroupLayout(pnlToaNha1);
        pnlToaNha1.setLayout(pnlToaNha1Layout);
        pnlToaNha1Layout.setHorizontalGroup(
            pnlToaNha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSoToaNha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(lblIconToaNha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlToaNha1Layout.setVerticalGroup(
            pnlToaNha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToaNha1Layout.createSequentialGroup()
                .addComponent(lblIconToaNha1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlXemNhanh1.add(pnlToaNha1);

        pnlKhachThue.setBackground(new java.awt.Color(255, 255, 255));

        lblIconKhachThue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconKhachThue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/people_64px.png"))); // NOI18N

        lblSoKhachThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoKhachThue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoKhachThue.setText("Khách thuê: 50");

        javax.swing.GroupLayout pnlKhachThueLayout = new javax.swing.GroupLayout(pnlKhachThue);
        pnlKhachThue.setLayout(pnlKhachThueLayout);
        pnlKhachThueLayout.setHorizontalGroup(
            pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSoKhachThue, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(lblIconKhachThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKhachThueLayout.setVerticalGroup(
            pnlKhachThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachThueLayout.createSequentialGroup()
                .addComponent(lblIconKhachThue, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoKhachThue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlXemNhanh1.add(pnlKhachThue);

        pnlPhongDaThue.setBackground(new java.awt.Color(255, 255, 255));
        pnlPhongDaThue.setPreferredSize(new java.awt.Dimension(140, 122));

        lblIconPhongDaThue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPhongDaThue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/room_64px.png"))); // NOI18N

        lblSoPhongDaThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoPhongDaThue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoPhongDaThue.setText("Phòng đã thuê: 3");

        javax.swing.GroupLayout pnlPhongDaThueLayout = new javax.swing.GroupLayout(pnlPhongDaThue);
        pnlPhongDaThue.setLayout(pnlPhongDaThueLayout);
        pnlPhongDaThueLayout.setHorizontalGroup(
            pnlPhongDaThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSoPhongDaThue, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(lblIconPhongDaThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPhongDaThueLayout.setVerticalGroup(
            pnlPhongDaThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongDaThueLayout.createSequentialGroup()
                .addComponent(lblIconPhongDaThue, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoPhongDaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlXemNhanh1.add(pnlPhongDaThue);

        pnlPhongTrong.setBackground(new java.awt.Color(255, 255, 255));
        pnlPhongTrong.setPreferredSize(new java.awt.Dimension(140, 122));

        lblIconPhongTrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconPhongTrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/room2_64px.png"))); // NOI18N

        lblSoPhongTrong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoPhongTrong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoPhongTrong.setText("Phòng trống: 0");

        javax.swing.GroupLayout pnlPhongTrongLayout = new javax.swing.GroupLayout(pnlPhongTrong);
        pnlPhongTrong.setLayout(pnlPhongTrongLayout);
        pnlPhongTrongLayout.setHorizontalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSoPhongTrong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(lblIconPhongTrong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPhongTrongLayout.setVerticalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhongTrongLayout.createSequentialGroup()
                .addComponent(lblIconPhongTrong, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlXemNhanh1.add(pnlPhongTrong);

        jPanel2.setBackground(new java.awt.Color(40, 63, 85));

        lblSoToaNha2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSoToaNha2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoToaNha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoToaNha2.setText("Trang chủ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoToaNha2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoToaNha2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlXemNhanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlXemNhanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1010, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhongTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongTrongMouseClicked
        if (evt.getClickCount() == 2) {
            index1 = tblPhongTrong.getSelectedRow();
            MoTaWindows dialog = new MoTaWindows(new javax.swing.JFrame(), true);
            
        }
    }//GEN-LAST:event_tblPhongTrongMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static int index1 = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkLoc1;
    private javax.swing.JCheckBox chkLoc2;
    private javax.swing.JCheckBox chkLoc3;
    private javax.swing.JCheckBox chkLoc4;
    private javax.swing.JCheckBox chkLoc5;
    private javax.swing.JCheckBox chkLoc6;
    private javax.swing.JCheckBox chkLoc7;
    private javax.swing.JCheckBox chkLoc8;
    private javax.swing.JCheckBox chkLoc9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDanhSachPhongTrong;
    private javax.swing.JLabel lblIconKhachThue;
    private javax.swing.JLabel lblIconPhongDaThue;
    private javax.swing.JLabel lblIconPhongTrong;
    private javax.swing.JLabel lblIconToaNha1;
    private javax.swing.JLabel lblSoKhachThue;
    private javax.swing.JLabel lblSoPhongDaThue;
    private javax.swing.JLabel lblSoPhongTrong;
    private javax.swing.JLabel lblSoToaNha;
    private javax.swing.JLabel lblSoToaNha2;
    private javax.swing.JPanel pnlDanhSachPhongTrong;
    private javax.swing.JPanel pnlKhachThue;
    private javax.swing.JPanel pnlPhongDaThue;
    private javax.swing.JPanel pnlPhongTrong;
    private javax.swing.JPanel pnlToaNha1;
    private javax.swing.JPanel pnlXemNhanh1;
    public static javax.swing.JTable tblPhongTrong;
    private javax.swing.JLabel txtGia;
    private javax.swing.JTextField txtGiaMax;
    private javax.swing.JTextField txtGiaMin;
    // End of variables declaration//GEN-END:variables
    List<String> loc;
    PhongDao pdao = new PhongDao();
    public static String sql = "";

    public void filter() {
        sql = "select PHONG.IdPhong From PHONG inner join MO_TA on PHONG.IdPhong = MO_TA.IdPhong Where ";
        loc = new ArrayList<>();
        if (chkLoc1.isSelected()) {
            loc.add("Loc1");
        }
        if (chkLoc2.isSelected()) {
            loc.add("Loc2");
        }
        if (chkLoc3.isSelected()) {
            loc.add("Loc3");
        }
        if (chkLoc4.isSelected()) {
            loc.add("Loc4");
        }
        if (chkLoc5.isSelected()) {
            loc.add("Loc5");
        }
        if (chkLoc6.isSelected()) {
            loc.add("Loc6");
        }
        if (chkLoc7.isSelected()) {
            loc.add("Loc7");
        }
        if (chkLoc8.isSelected()) {
            loc.add("Loc8");
        }
        if (chkLoc9.isSelected()) {
            loc.add("Loc9");
        }
        if (loc.size() == 1) {
            sql = sql + loc.get(0) + " = 1";
        } else {
            for (String f : loc) {
                sql = sql + f + " = 1 and ";
            }
            sql = sql.substring(0, sql.length() - 4);
        }
        sql = "select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where IdPhong in (" + sql + " )";
        if (loc.isEmpty()) {
            sql = "select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha";
        }

        if (txtGiaMin.getText().length() > 0 && txtGia.getText().length() > 0) {
            try {
                double giaMin = Double.parseDouble(txtGiaMin.getText());
                double giaMax = Double.parseDouble(txtGiaMax.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Nhập lại khoảng giá");
                return;
            }
            if (loc.isEmpty()) {
                sql = "select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where Gia between " + txtGiaMin.getText() + " and " + txtGiaMax.getText();
            } else {
                sql = sql + " and Gia between " + txtGiaMin.getText() + " and " + txtGiaMax.getText();
            }
        }
        sql = sql + " and TrangThai = 0";

        DefaultTableModel model = (DefaultTableModel) tblPhongTrong.getModel();
        model.setRowCount(0);
        List<Phong> list = pdao.selectbyfilterTrangChu();
        for (Phong p : list) {
            Object[] row = new Object[]{p.getIdphong(), p.getTentoanha(), p.getPhong(), p.getTang(), p.getDientich(), p.getGia(), p.getMota()};
            model.addRow(row);
        }
    }
    ThongKeDao tkDao = new ThongKeDao();

    public void thongke() {
        lblSoToaNha.setText("Tòa nhà: " + tkDao.demSoToaNha());
        lblSoKhachThue.setText("Khách thuê: " + tkDao.demSoKhachThue());
        lblSoPhongTrong.setText("Phòng trống: " + tkDao.demSoPhong(0));
        lblSoPhongDaThue.setText("Phòng đã thuê: " + tkDao.demSoPhong(1));
    }

}
