/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.LienHeDao;
import dao.PhongDao;
import dao.ToaNhaDao;
import helper.Auth;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LienHe;
import model.Phong;
import model.ToaNha;

/**
 *
 * @author Admin
 */
public final class ToaNhaWindows extends javax.swing.JPanel {

    int index;
    ToaNhaDao dao = new ToaNhaDao();
    DefaultTableModel model;
    int id;
    Color colorDisable = new Color(143, 167, 191);
    Color colorEnable = new Color(40, 63, 85);
    LienHeDao lhDao = new LienHeDao();

    /**
     * Creates new form Nha
     */
    public ToaNhaWindows() {
        initComponents();
        fillToTable();
        setStatusButton(true);
        showLienhe();
        if (Auth.user.isRoles() == false) {
            pnlContent.remove(0);
            pnlContent.remove(0);
        }

    }

    public void fillToTable() {
        model = (DefaultTableModel) tblDanhSachToaNha.getModel();
        model.setRowCount(0);
        List<ToaNha> list = dao.selectAll();
        for (ToaNha toaNha : list) {
            model.addRow(new Object[]{toaNha.getIdtoanha(), toaNha.getTentoanha(), toaNha.getDiachi(), toaNha.getMota(), toaNha.getGhichu()});
        }
    }

    public void showDetail(ToaNha toanha) {
        txtToaNha.setText(toanha.getTentoanha());
        txtDiaChi.setText(toanha.getDiachi());
        txtMoTa.setText(toanha.getMota());
        txtGhiChu.setText(toanha.getGhichu());
    }

    public void setStatusButton(Boolean status) {
        btnThem.setEnabled(status);
        btnCapNhat.setEnabled(!status);
        btnXoa.setEnabled(!status);
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
            id = (int) tblDanhSachToaNha.getValueAt(index, 0);
            ToaNha tn = dao.selectByID(id);
            showDetail(tn);
            setStatusButton(false);
            loadPhong();
            String tentoanha = tblDanhSachToaNha.getValueAt(index, 1) + "";
            lblTenToaNha.setText("Tòa nhà: " + tentoanha);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    PhongDao pDao = new PhongDao();

    public void loadPhong() {
        DefaultTableModel model = (DefaultTableModel) tblPhong_ToaNha.getModel();
        model.setRowCount(0);
        int idtoanha = Integer.parseInt(tblDanhSachToaNha.getValueAt(index, 0) + "");
        List<Object[]> list = pDao.selectByToaNha(idtoanha);
        for (Object[] p : list) {
            model.addRow(p);
        }
        List<Phong> listTrong = pDao.selectAllPhongTrongTheoToaNha(idtoanha);
        for (Phong p : listTrong) {
            Object[] row = new Object[]{
                p.getIdphong(), p.getPhong(), p.getTang(), p.getDientich(), p.getGia(), p.getMota(), p.isTrangthai() == false ? "Chưa Thuê" : "Đã thuê"
            };
            model.addRow(row);
        }
    }

    public boolean check() {
        if (txtToaNha.getText().equals("") || txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền đủ thông tin");
            return false;
        }
        return true;
    }

    public ToaNha getModelNha() {
        ToaNha tn = new ToaNha();
        tn.setTentoanha(txtToaNha.getText());
        tn.setDiachi(txtDiaChi.getText());
        tn.setMota(txtMoTa.getText());
        tn.setGhichu(txtGhiChu.getText());
        tn.setIdtoanha(id);
        //them id tòa nhà
        return tn;
    }

    public void them() {
        if (check()) {
            ToaNha tn = getModelNha();
            dao.insert(tn);
            fillToTable();
            JOptionPane.showMessageDialog(this, "Đã thêm tòa nhà");
        }
    }

    public void capnhat() {
        if (check()) {
            dao.update(getModelNha());
            fillToTable();
            JOptionPane.showMessageDialog(this, "Đã cập nhật");
        }
    }

    public void xoa() {
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?") == 0) {
            dao.delete(id);
            JOptionPane.showMessageDialog(this, "Đã xóa");
            fillToTable();
            moi();
        }
    }

    public void moi() {
        showDetail(new ToaNha());
        setStatusButton(true);
    }

    public void showLienhe() {
        List<LienHe> list = lhDao.selectAll();
        System.out.println(list);
        for (LienHe lienHe : list) {
            txtHoVaTen.setText(lienHe.getTenchunha());
            txtTuoi.setText(String.valueOf(lienHe.getTuoi()));
            txtSoDienThoai.setText(lienHe.getSodienthoai());
            txtEmail.setText(lienHe.getEmail());
        }
    }

    public void luu() {
        LienHe lienHe = new LienHe();
        lienHe.setTenchunha(txtHoVaTen.getText());
        lienHe.setTuoi(Integer.parseInt(txtTuoi.getText()));
        lienHe.setSodienthoai(txtSoDienThoai.getText());
        lienHe.setEmail(txtEmail.getText());
        lhDao.update(lienHe);
        JOptionPane.showMessageDialog(this, "Đã lưu thông tin liên hệ");
        showLienhe();
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
        pnlDachSachToaNha = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachToaNha = new javax.swing.JTable();
        pnlChiTiet = new javax.swing.JPanel();
        pnlContentChiTiet = new javax.swing.JTabbedPane();
        pnlThongTin = new javax.swing.JPanel();
        pnlDiaChi = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        pnlToaNha = new javax.swing.JPanel();
        lblToaNha = new javax.swing.JLabel();
        txtToaNha = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        pnlMoTa = new javax.swing.JPanel();
        lblMoTa = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        pnlGhiChu = new javax.swing.JPanel();
        lblGhiChu = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        pnlBtnThem = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        pnlBtnCapNhat = new javax.swing.JPanel();
        btnCapNhat = new javax.swing.JButton();
        pnlBtnXoa = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        pnlBtnMoi = new javax.swing.JPanel();
        btnMoi = new javax.swing.JButton();
        pnlDanhSach = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhong_ToaNha = new javax.swing.JTable();
        lblTenToaNha = new javax.swing.JLabel();
        pnlLienHe = new javax.swing.JPanel();
        pnlHoVaTen = new javax.swing.JPanel();
        lblToaNha1 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        pnlSoDienThoai = new javax.swing.JPanel();
        lblToaNha2 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        pnlTuoi = new javax.swing.JPanel();
        lblToaNha3 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        pnlEmail = new javax.swing.JPanel();
        lblToaNha4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        pnlLuu = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblSoToaNha2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnlDachSachToaNha.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblDanhSachToaNha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tòa nhà", "Địa chỉ", "Mô tả", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachToaNha.setGridColor(new java.awt.Color(204, 204, 204));
        tblDanhSachToaNha.setRowHeight(30);
        tblDanhSachToaNha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachToaNhaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachToaNha);

        javax.swing.GroupLayout pnlDachSachToaNhaLayout = new javax.swing.GroupLayout(pnlDachSachToaNha);
        pnlDachSachToaNha.setLayout(pnlDachSachToaNhaLayout);
        pnlDachSachToaNhaLayout.setHorizontalGroup(
            pnlDachSachToaNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDachSachToaNhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlDachSachToaNhaLayout.setVerticalGroup(
            pnlDachSachToaNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDachSachToaNhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlContent.addTab("Danh sách tòa nhà", pnlDachSachToaNha);

        pnlContentChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pnlContentChiTiet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pnlThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDiaChi.setBackground(new java.awt.Color(255, 255, 255));
        pnlDiaChi.setForeground(new java.awt.Color(255, 255, 255));

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDiaChi.setText("Địa chỉ");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(102, 102, 102));
        txtDiaChi.setBorder(null);

        javax.swing.GroupLayout pnlDiaChiLayout = new javax.swing.GroupLayout(pnlDiaChi);
        pnlDiaChi.setLayout(pnlDiaChiLayout);
        pnlDiaChiLayout.setHorizontalGroup(
            pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDiaChi)
            .addComponent(jSeparator6)
            .addGroup(pnlDiaChiLayout.createSequentialGroup()
                .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlDiaChiLayout.setVerticalGroup(
            pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiaChiLayout.createSequentialGroup()
                .addGroup(pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDiaChiLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 450, 70));

        pnlToaNha.setBackground(new java.awt.Color(255, 255, 255));
        pnlToaNha.setForeground(new java.awt.Color(255, 255, 255));

        lblToaNha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblToaNha.setText("Tòa nhà");

        txtToaNha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtToaNha.setForeground(new java.awt.Color(102, 102, 102));
        txtToaNha.setBorder(null);

        javax.swing.GroupLayout pnlToaNhaLayout = new javax.swing.GroupLayout(pnlToaNha);
        pnlToaNha.setLayout(pnlToaNhaLayout);
        pnlToaNhaLayout.setHorizontalGroup(
            pnlToaNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtToaNha)
            .addComponent(jSeparator3)
            .addGroup(pnlToaNhaLayout.createSequentialGroup()
                .addComponent(lblToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlToaNhaLayout.setVerticalGroup(
            pnlToaNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToaNhaLayout.createSequentialGroup()
                .addGroup(pnlToaNhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlToaNhaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtToaNha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlToaNha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 70));

        pnlMoTa.setBackground(new java.awt.Color(255, 255, 255));
        pnlMoTa.setForeground(new java.awt.Color(255, 255, 255));

        lblMoTa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMoTa.setText("Ghi chú");

        txtGhiChu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(102, 102, 102));
        txtGhiChu.setBorder(null);

        javax.swing.GroupLayout pnlMoTaLayout = new javax.swing.GroupLayout(pnlMoTa);
        pnlMoTa.setLayout(pnlMoTaLayout);
        pnlMoTaLayout.setHorizontalGroup(
            pnlMoTaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoTaLayout.createSequentialGroup()
                .addComponent(lblMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addComponent(txtGhiChu)
            .addComponent(jSeparator5)
        );
        pnlMoTaLayout.setVerticalGroup(
            pnlMoTaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoTaLayout.createSequentialGroup()
                .addComponent(lblMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, 90));

        pnlGhiChu.setBackground(new java.awt.Color(255, 255, 255));

        lblGhiChu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGhiChu.setText("Mô tả");

        txtMoTa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMoTa.setForeground(new java.awt.Color(102, 102, 102));
        txtMoTa.setBorder(null);

        javax.swing.GroupLayout pnlGhiChuLayout = new javax.swing.GroupLayout(pnlGhiChu);
        pnlGhiChu.setLayout(pnlGhiChuLayout);
        pnlGhiChuLayout.setHorizontalGroup(
            pnlGhiChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGhiChuLayout.createSequentialGroup()
                .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addComponent(txtMoTa)
            .addComponent(jSeparator7)
        );
        pnlGhiChuLayout.setVerticalGroup(
            pnlGhiChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGhiChuLayout.createSequentialGroup()
                .addComponent(lblGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 90));

        pnlBtnThem.setBackground(new java.awt.Color(40, 63, 85));

        btnThem.setBackground(new java.awt.Color(40, 63, 85));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnThemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBtnThemLayout.setVerticalGroup(
            pnlBtnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnThemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlThongTin.add(pnlBtnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        pnlBtnCapNhat.setBackground(new java.awt.Color(40, 63, 85));

        btnCapNhat.setBackground(new java.awt.Color(40, 63, 85));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
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
            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnCapNhatLayout.setVerticalGroup(
            pnlBtnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlThongTin.add(pnlBtnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        pnlBtnXoa.setBackground(new java.awt.Color(40, 63, 85));

        btnXoa.setBackground(new java.awt.Color(40, 63, 85));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
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
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnXoaLayout.setVerticalGroup(
            pnlBtnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlThongTin.add(pnlBtnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

        pnlBtnMoi.setBackground(new java.awt.Color(40, 63, 85));

        btnMoi.setBackground(new java.awt.Color(40, 63, 85));
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setText("Mới");
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
            .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnMoiLayout.setVerticalGroup(
            pnlBtnMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlThongTin.add(pnlBtnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));

        pnlContentChiTiet.addTab("Thông tin tòa nhà", pnlThongTin);

        pnlDanhSach.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblPhong_ToaNha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Phòng", "Tầng", "Diện tích", "Giá", "Mô tả", "Trạng thái", "Người đại diện thuê"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong_ToaNha.setGridColor(new java.awt.Color(204, 204, 204));
        tblPhong_ToaNha.setRowHeight(30);
        tblPhong_ToaNha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhong_ToaNhaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPhong_ToaNha);
        if (tblPhong_ToaNha.getColumnModel().getColumnCount() > 0) {
            tblPhong_ToaNha.getColumnModel().getColumn(0).setMinWidth(32);
            tblPhong_ToaNha.getColumnModel().getColumn(0).setPreferredWidth(32);
            tblPhong_ToaNha.getColumnModel().getColumn(0).setMaxWidth(32);
            tblPhong_ToaNha.getColumnModel().getColumn(2).setMinWidth(40);
            tblPhong_ToaNha.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblPhong_ToaNha.getColumnModel().getColumn(2).setMaxWidth(40);
        }

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlContentChiTiet.addTab("Danh sách phòng", pnlDanhSach);

        lblTenToaNha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTenToaNha.setText("Tòa nhà");

        javax.swing.GroupLayout pnlChiTietLayout = new javax.swing.GroupLayout(pnlChiTiet);
        pnlChiTiet.setLayout(pnlChiTietLayout);
        pnlChiTietLayout.setHorizontalGroup(
            pnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContentChiTiet)
            .addGroup(pnlChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenToaNha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlChiTietLayout.setVerticalGroup(
            pnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(lblTenToaNha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContentChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlContent.addTab("Chi tiết", pnlChiTiet);

        pnlLienHe.setBackground(new java.awt.Color(255, 255, 255));

        pnlHoVaTen.setBackground(new java.awt.Color(255, 255, 255));
        pnlHoVaTen.setForeground(new java.awt.Color(255, 255, 255));

        lblToaNha1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblToaNha1.setText("Họ và tên");

        txtHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHoVaTen.setForeground(new java.awt.Color(102, 102, 102));
        txtHoVaTen.setBorder(null);

        javax.swing.GroupLayout pnlHoVaTenLayout = new javax.swing.GroupLayout(pnlHoVaTen);
        pnlHoVaTen.setLayout(pnlHoVaTenLayout);
        pnlHoVaTenLayout.setHorizontalGroup(
            pnlHoVaTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHoVaTen)
            .addComponent(jSeparator4)
            .addGroup(pnlHoVaTenLayout.createSequentialGroup()
                .addComponent(lblToaNha1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlHoVaTenLayout.setVerticalGroup(
            pnlHoVaTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoVaTenLayout.createSequentialGroup()
                .addGroup(pnlHoVaTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblToaNha1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHoVaTenLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnlSoDienThoai.setBackground(new java.awt.Color(255, 255, 255));
        pnlSoDienThoai.setForeground(new java.awt.Color(255, 255, 255));

        lblToaNha2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblToaNha2.setText("Số điện thoại");

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSoDienThoai.setForeground(new java.awt.Color(102, 102, 102));
        txtSoDienThoai.setBorder(null);

        javax.swing.GroupLayout pnlSoDienThoaiLayout = new javax.swing.GroupLayout(pnlSoDienThoai);
        pnlSoDienThoai.setLayout(pnlSoDienThoaiLayout);
        pnlSoDienThoaiLayout.setHorizontalGroup(
            pnlSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoDienThoai)
            .addComponent(jSeparator8)
            .addGroup(pnlSoDienThoaiLayout.createSequentialGroup()
                .addComponent(lblToaNha2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlSoDienThoaiLayout.setVerticalGroup(
            pnlSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoDienThoaiLayout.createSequentialGroup()
                .addGroup(pnlSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblToaNha2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSoDienThoaiLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnlTuoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlTuoi.setForeground(new java.awt.Color(255, 255, 255));

        lblToaNha3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblToaNha3.setText("Tuổi");

        txtTuoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTuoi.setForeground(new java.awt.Color(102, 102, 102));
        txtTuoi.setBorder(null);

        javax.swing.GroupLayout pnlTuoiLayout = new javax.swing.GroupLayout(pnlTuoi);
        pnlTuoi.setLayout(pnlTuoiLayout);
        pnlTuoiLayout.setHorizontalGroup(
            pnlTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTuoi)
            .addComponent(jSeparator9)
            .addGroup(pnlTuoiLayout.createSequentialGroup()
                .addComponent(lblToaNha3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlTuoiLayout.setVerticalGroup(
            pnlTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTuoiLayout.createSequentialGroup()
                .addGroup(pnlTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblToaNha3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTuoiLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnlEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmail.setForeground(new java.awt.Color(255, 255, 255));

        lblToaNha4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblToaNha4.setText("Email");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setBorder(null);

        javax.swing.GroupLayout pnlEmailLayout = new javax.swing.GroupLayout(pnlEmail);
        pnlEmail.setLayout(pnlEmailLayout);
        pnlEmailLayout.setHorizontalGroup(
            pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail)
            .addComponent(jSeparator10)
            .addGroup(pnlEmailLayout.createSequentialGroup()
                .addComponent(lblToaNha4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        pnlEmailLayout.setVerticalGroup(
            pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmailLayout.createSequentialGroup()
                .addGroup(pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblToaNha4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEmailLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlLuu.setBackground(new java.awt.Color(40, 63, 85));

        btnLuu.setBackground(new java.awt.Color(40, 63, 85));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.setBorder(null);
        btnLuu.setBorderPainted(false);
        btnLuu.setContentAreaFilled(false);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLuuLayout = new javax.swing.GroupLayout(pnlLuu);
        pnlLuu.setLayout(pnlLuuLayout);
        pnlLuuLayout.setHorizontalGroup(
            pnlLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLuuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLuuLayout.setVerticalGroup(
            pnlLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLuuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlLienHeLayout = new javax.swing.GroupLayout(pnlLienHe);
        pnlLienHe.setLayout(pnlLienHeLayout);
        pnlLienHeLayout.setHorizontalGroup(
            pnlLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLienHeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLienHeLayout.createSequentialGroup()
                            .addComponent(pnlHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(pnlTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlLienHeLayout.createSequentialGroup()
                            .addComponent(pnlSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnlLienHeLayout.setVerticalGroup(
            pnlLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLienHeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        pnlContent.addTab("Liên hệ", pnlLienHe);

        jPanel2.setBackground(new java.awt.Color(40, 63, 85));

        lblSoToaNha2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSoToaNha2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoToaNha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoToaNha2.setText("Tòa nhà");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoToaNha2)
                .addContainerGap(909, Short.MAX_VALUE))
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
            .addComponent(pnlContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1010, 710));
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThemActionPerformed

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

    private void tblDanhSachToaNhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachToaNhaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            pnlContent.setSelectedIndex(0);
            index = tblDanhSachToaNha.getSelectedRow();
            edit();
            pnlContent.setSelectedIndex(1);
//            filltodanhsachphong();
        }
    }//GEN-LAST:event_tblDanhSachToaNhaMouseClicked


    private void tblPhong_ToaNhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhong_ToaNhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPhong_ToaNhaMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        luu();
    }//GEN-LAST:event_btnLuuActionPerformed

    PhongDao pdao = new PhongDao();

    public void filltodanhsachphong() {
        model = (DefaultTableModel) tblPhong_ToaNha.getModel();
        model.setRowCount(0);
        int idtoanha = Integer.parseInt(tblDanhSachToaNha.getValueAt(index, 0) + "");
        List<Object[]> list = pdao.selectByToaNha(idtoanha);
        for (Object[] p : list) {
            model.addRow(p);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblMoTa;
    private javax.swing.JLabel lblSoToaNha2;
    private javax.swing.JLabel lblTenToaNha;
    private javax.swing.JLabel lblToaNha;
    private javax.swing.JLabel lblToaNha1;
    private javax.swing.JLabel lblToaNha2;
    private javax.swing.JLabel lblToaNha3;
    private javax.swing.JLabel lblToaNha4;
    private javax.swing.JPanel pnlBtnCapNhat;
    private javax.swing.JPanel pnlBtnMoi;
    private javax.swing.JPanel pnlBtnThem;
    private javax.swing.JPanel pnlBtnXoa;
    private javax.swing.JPanel pnlChiTiet;
    private javax.swing.JTabbedPane pnlContent;
    private javax.swing.JTabbedPane pnlContentChiTiet;
    private javax.swing.JPanel pnlDachSachToaNha;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDiaChi;
    private javax.swing.JPanel pnlEmail;
    private javax.swing.JPanel pnlGhiChu;
    private javax.swing.JPanel pnlHoVaTen;
    private javax.swing.JPanel pnlLienHe;
    private javax.swing.JPanel pnlLuu;
    private javax.swing.JPanel pnlMoTa;
    private javax.swing.JPanel pnlSoDienThoai;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPanel pnlToaNha;
    private javax.swing.JPanel pnlTuoi;
    private javax.swing.JTable tblDanhSachToaNha;
    public static javax.swing.JTable tblPhong_ToaNha;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtToaNha;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
