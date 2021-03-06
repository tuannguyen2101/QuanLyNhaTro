/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DichVuDao;
import dao.ToaNhaDao;
import helper.Auth;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DichVu;
import model.ToaNha;

/**
 *
 * @author Admin
 */
public final class DichVuWindows extends javax.swing.JPanel {

    int index;
    DichVuDao dao = new DichVuDao();
    ToaNhaDao tnDao = new ToaNhaDao();
    int id;
    Color colorDisable = new Color(143, 167, 191);
    Color colorEnable = new Color(40, 63, 85);

    /**
     * Creates new form Nha
     */
    public DichVuWindows() {
        initComponents();
        filltogridview();
        filltoCbo();
        setStatusButton(true);
        if (Auth.user.isRoles() == false) {
            pnl_Menu.setVisible(false);
        }
    }

    public void filltogridview() {
        List<DichVu> list = dao.selectAll();
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setRowCount(0);
        for (DichVu d : list) {
            Object[] row = new Object[]{d.getId(), d.getTentoanha(), d.getTendichvu(), d.getGia(), d.getDonvi(), d.getMota()};
            model.addRow(row);
        }
    }

    public void filltoCbo() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboToaNha.getModel();
        model.removeAllElements();
        List<ToaNha> list = tnDao.selectAll();
        for (ToaNha t : list) {
            model.addElement(t);
        }
    }

    public void showDetail(DichVu dichVu) {
        txtGia.setText(String.valueOf(dichVu.getGia()));
        txtTenDichVu.setText(dichVu.getTendichvu());
        txtDonViTinh.setText(dichVu.getDonvi());
        txtMoTa.setText(dichVu.getMota());
    }

    public void setStatusButton(Boolean status) {
        btnThem.setEnabled(status);
        btnCapNhat.setEnabled(!status);
        btnXoa.setEnabled(!status);
        btnMoi.setEnabled(!status);

        if (status == true) {
            pnlBtnThem.setBackground(colorEnable);
            pnlBtnCapNhat.setBackground(colorDisable);
            pnlBtnXoa.setBackground(colorDisable);
        } else {
            pnlBtnThem.setBackground(colorDisable);
            pnlBtnCapNhat.setBackground(colorEnable);
            pnlBtnXoa.setBackground(colorEnable);
        }
    }

    public void edit() {
        try {
            id = (int) tblGridView.getValueAt(index, 0);
            DichVu dv = dao.selectByID(id);
            showDetail(dv);
            setStatusButton(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean check() {
        if (txtTenDichVu.getText().equals("") || txtGia.getText().equals("") || txtDonViTinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "H??y ??i???n ????? th??ng tin");
            return false;
        }
        try {
            double gia = Double.parseDouble(txtGia.getText());
            if (gia < 0) {
                JOptionPane.showMessageDialog(this, "Nh???p l???i gi??");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nh???p l???i gi??");
            return false;
        }
        return true;
    }

    public DichVu getModelDichVu() {
        DichVu dv = new DichVu();
        dv.setId(Integer.parseInt(tblGridView.getValueAt(index, 0) + ""));
        dv.setTendichvu(txtTenDichVu.getText());
        dv.setGia(Double.parseDouble(txtGia.getText()));
        dv.setDonvi(txtDonViTinh.getText());
        dv.setMota(txtMoTa.getText());
        dv.setTrangthai(true);
        dv.setTentoanha(String.valueOf(cboToaNha.getSelectedItem()));
        return dv;
    }

    public void them() {
        if (check()) {
            DichVu dv = getModelDichVu();
            dao.insert(dv);
            filltogridview();
            JOptionPane.showMessageDialog(this, "???? th??m d???ch v???");
        }
    }

    public void capnhat() {
        if (check()) {
            DichVu dv = getModelDichVu();
            dao.update(dv);
            filltogridview();
            JOptionPane.showMessageDialog(this, "???? c???p nh???t d???ch v???");
        }
    }

    public void xoa() {
        if (JOptionPane.showConfirmDialog(this, "Bjan ch???c ch???n mu???n x??a?") == 0) {
            dao.delete(id);
            JOptionPane.showMessageDialog(this, "???? x??a d???ch v???");
            filltogridview();
            moi();
        }
    }

    public void moi() {
        showDetail(new DichVu());
        setStatusButton(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlContent = new javax.swing.JTabbedPane();
        pnlDanhSachDichVu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        pnlChiTietDichVu = new javax.swing.JPanel();
        pnlNha = new javax.swing.JPanel();
        lblNha = new javax.swing.JLabel();
        cboToaNha = new javax.swing.JComboBox<>();
        pnlTenDichVu = new javax.swing.JPanel();
        lblTenDichVu = new javax.swing.JLabel();
        txtTenDichVu = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        pnlGia = new javax.swing.JPanel();
        lblGia = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        pnlDonViTinh = new javax.swing.JPanel();
        lblDonViTinh = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        pnlMoTa = new javax.swing.JPanel();
        lblMoTa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        pnl_Menu = new javax.swing.JPanel();
        pnlBtnThem = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        pnlBtnCapNhat = new javax.swing.JPanel();
        btnCapNhat = new javax.swing.JButton();
        pnlBtnXoa = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        pnlBtnMoi = new javax.swing.JPanel();
        btnMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblSoToaNha2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 710));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlContent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlContent.setPreferredSize(new java.awt.Dimension(1010, 660));

        pnlDanhSachDichVu.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nha??", "T??n di??ch vu??", "Gia??", "????n vi?? ti??nh", "M?? ta??"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGridView.setGridColor(new java.awt.Color(204, 204, 204));
        tblGridView.setRowHeight(30);
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridViewMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGridView);

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_24px.png"))); // NOI18N
        btnTimKiem.setBorder(null);
        btnTimKiem.setContentAreaFilled(false);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout pnlDanhSachDichVuLayout = new javax.swing.GroupLayout(pnlDanhSachDichVu);
        pnlDanhSachDichVu.setLayout(pnlDanhSachDichVuLayout);
        pnlDanhSachDichVuLayout.setHorizontalGroup(
            pnlDanhSachDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDanhSachDichVuLayout.setVerticalGroup(
            pnlDanhSachDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachDichVuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pnlContent.addTab("Danh sa??ch d???ch v???", pnlDanhSachDichVu);

        pnlChiTietDichVu.setBackground(new java.awt.Color(255, 255, 255));
        pnlChiTietDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNha.setBackground(new java.awt.Color(255, 255, 255));
        pnlNha.setForeground(new java.awt.Color(255, 255, 255));

        lblNha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNha.setText("Nh??");

        javax.swing.GroupLayout pnlNhaLayout = new javax.swing.GroupLayout(pnlNha);
        pnlNha.setLayout(pnlNhaLayout);
        pnlNhaLayout.setHorizontalGroup(
            pnlNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaLayout.createSequentialGroup()
                .addComponent(lblNha, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addComponent(cboToaNha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNhaLayout.setVerticalGroup(
            pnlNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaLayout.createSequentialGroup()
                .addComponent(lblNha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboToaNha, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        pnlChiTietDichVu.add(pnlNha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 70));

        pnlTenDichVu.setBackground(new java.awt.Color(255, 255, 255));
        pnlTenDichVu.setForeground(new java.awt.Color(255, 255, 255));

        lblTenDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTenDichVu.setText("T??n d???ch v???");

        txtTenDichVu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenDichVu.setForeground(new java.awt.Color(102, 102, 102));
        txtTenDichVu.setBorder(null);

        javax.swing.GroupLayout pnlTenDichVuLayout = new javax.swing.GroupLayout(pnlTenDichVu);
        pnlTenDichVu.setLayout(pnlTenDichVuLayout);
        pnlTenDichVuLayout.setHorizontalGroup(
            pnlTenDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTenDichVu)
            .addComponent(jSeparator2)
            .addGroup(pnlTenDichVuLayout.createSequentialGroup()
                .addComponent(lblTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlTenDichVuLayout.setVerticalGroup(
            pnlTenDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTenDichVuLayout.createSequentialGroup()
                .addGroup(pnlTenDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTenDichVuLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlChiTietDichVu.add(pnlTenDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 450, 70));

        pnlGia.setBackground(new java.awt.Color(255, 255, 255));
        pnlGia.setForeground(new java.awt.Color(255, 255, 255));

        lblGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGia.setText("Gi??");

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGia.setForeground(new java.awt.Color(102, 102, 102));
        txtGia.setBorder(null);

        javax.swing.GroupLayout pnlGiaLayout = new javax.swing.GroupLayout(pnlGia);
        pnlGia.setLayout(pnlGiaLayout);
        pnlGiaLayout.setHorizontalGroup(
            pnlGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGia)
            .addComponent(jSeparator4)
            .addGroup(pnlGiaLayout.createSequentialGroup()
                .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlGiaLayout.setVerticalGroup(
            pnlGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiaLayout.createSequentialGroup()
                .addGroup(pnlGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGiaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnlChiTietDichVu.add(pnlGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        pnlDonViTinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlDonViTinh.setForeground(new java.awt.Color(255, 255, 255));

        lblDonViTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDonViTinh.setText("????n v??? t??nh");

        txtDonViTinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDonViTinh.setForeground(new java.awt.Color(102, 102, 102));
        txtDonViTinh.setBorder(null);

        javax.swing.GroupLayout pnlDonViTinhLayout = new javax.swing.GroupLayout(pnlDonViTinh);
        pnlDonViTinh.setLayout(pnlDonViTinhLayout);
        pnlDonViTinhLayout.setHorizontalGroup(
            pnlDonViTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDonViTinh)
            .addComponent(jSeparator5)
            .addGroup(pnlDonViTinhLayout.createSequentialGroup()
                .addComponent(lblDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlDonViTinhLayout.setVerticalGroup(
            pnlDonViTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDonViTinhLayout.createSequentialGroup()
                .addGroup(pnlDonViTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDonViTinhLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnlChiTietDichVu.add(pnlDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        pnlMoTa.setBackground(new java.awt.Color(255, 255, 255));

        lblMoTa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMoTa.setText("M?? t???");

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMoTa.setForeground(new java.awt.Color(102, 102, 102));
        txtMoTa.setRows(5);
        txtMoTa.setAutoscrolls(false);
        txtMoTa.setBorder(null);
        jScrollPane1.setViewportView(txtMoTa);

        javax.swing.GroupLayout pnlMoTaLayout = new javax.swing.GroupLayout(pnlMoTa);
        pnlMoTa.setLayout(pnlMoTaLayout);
        pnlMoTaLayout.setHorizontalGroup(
            pnlMoTaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoTaLayout.createSequentialGroup()
                .addComponent(lblMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        pnlMoTaLayout.setVerticalGroup(
            pnlMoTaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoTaLayout.createSequentialGroup()
                .addComponent(lblMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlChiTietDichVu.add(pnlMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 210));

        pnl_Menu.setBackground(new java.awt.Color(255, 255, 255));

        pnlBtnThem.setBackground(new java.awt.Color(40, 63, 85));

        btnThem.setBackground(new java.awt.Color(40, 63, 85));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Th??m");
        btnThem.setBorder(null);
        btnThem.setBorderPainted(false);
        btnThem.setContentAreaFilled(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnThemLayout = new javax.swing.GroupLayout(pnlBtnThem);
        pnlBtnThem.setLayout(pnlBtnThemLayout);
        pnlBtnThemLayout.setHorizontalGroup(
            pnlBtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnThemLayout.setVerticalGroup(
            pnlBtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnThemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlBtnCapNhat.setBackground(new java.awt.Color(40, 63, 85));

        btnCapNhat.setBackground(new java.awt.Color(40, 63, 85));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("C???p nh???t");
        btnCapNhat.setBorder(null);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setContentAreaFilled(false);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnCapNhatLayout = new javax.swing.GroupLayout(pnlBtnCapNhat);
        pnlBtnCapNhat.setLayout(pnlBtnCapNhatLayout);
        pnlBtnCapNhatLayout.setHorizontalGroup(
            pnlBtnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnCapNhatLayout.setVerticalGroup(
            pnlBtnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlBtnXoa.setBackground(new java.awt.Color(40, 63, 85));

        btnXoa.setBackground(new java.awt.Color(40, 63, 85));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("X??a");
        btnXoa.setBorderPainted(false);
        btnXoa.setContentAreaFilled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnXoaLayout = new javax.swing.GroupLayout(pnlBtnXoa);
        pnlBtnXoa.setLayout(pnlBtnXoaLayout);
        pnlBtnXoaLayout.setHorizontalGroup(
            pnlBtnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnXoaLayout.setVerticalGroup(
            pnlBtnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlBtnMoi.setBackground(new java.awt.Color(40, 63, 85));

        btnMoi.setBackground(new java.awt.Color(40, 63, 85));
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setText("M???i");
        btnMoi.setBorderPainted(false);
        btnMoi.setContentAreaFilled(false);
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnMoiLayout = new javax.swing.GroupLayout(pnlBtnMoi);
        pnlBtnMoi.setLayout(pnlBtnMoiLayout);
        pnlBtnMoiLayout.setHorizontalGroup(
            pnlBtnMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnMoiLayout.setVerticalGroup(
            pnlBtnMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_MenuLayout = new javax.swing.GroupLayout(pnl_Menu);
        pnl_Menu.setLayout(pnl_MenuLayout);
        pnl_MenuLayout.setHorizontalGroup(
            pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlBtnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlBtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlBtnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnl_MenuLayout.setVerticalGroup(
            pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBtnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBtnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlChiTietDichVu.add(pnl_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 460, 70));

        pnlContent.addTab("Chi ti????t d???ch v???", pnlChiTietDichVu);

        jPanel2.setBackground(new java.awt.Color(40, 63, 85));

        lblSoToaNha2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSoToaNha2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoToaNha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoToaNha2.setText("Di??ch vu??");

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1010, 710));
    }// </editor-fold>//GEN-END:initComponents
    public static int idToaNha;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        idToaNha = ((ToaNha) cboToaNha.getSelectedItem()).getIdtoanha();
        them();
        System.out.println(idToaNha);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            pnlContent.setSelectedIndex(1);
            index = tblGridView.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblGridViewMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        capnhat();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btnMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboToaNha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblDonViTinh;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblMoTa;
    private javax.swing.JLabel lblNha;
    private javax.swing.JLabel lblSoToaNha2;
    private javax.swing.JLabel lblTenDichVu;
    private javax.swing.JPanel pnlBtnCapNhat;
    private javax.swing.JPanel pnlBtnMoi;
    private javax.swing.JPanel pnlBtnThem;
    private javax.swing.JPanel pnlBtnXoa;
    private javax.swing.JPanel pnlChiTietDichVu;
    private javax.swing.JTabbedPane pnlContent;
    private javax.swing.JPanel pnlDanhSachDichVu;
    private javax.swing.JPanel pnlDonViTinh;
    private javax.swing.JPanel pnlGia;
    private javax.swing.JPanel pnlMoTa;
    private javax.swing.JPanel pnlNha;
    private javax.swing.JPanel pnlTenDichVu;
    private javax.swing.JPanel pnl_Menu;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
