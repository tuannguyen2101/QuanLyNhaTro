CREATE DATABASE NHATRO
GO

USE NHATRO
GO

CREATE TABLE TOA_NHA
(
	IdToaNha int identity (1,1) PRIMARY KEY,
	TenToaNha nvarchar(100),
	DiaChi nvarchar(100),
	MoTa nvarchar(100),
	GhiChu nvarchar(100),
)
GO

CREATE TABLE PHONG
(
	IdPhong int identity (1,1) PRIMARY KEY,
	Phong nvarchar(10),
	Tang int,
	DienTich float,
	Gia float,
	MoTa nvarchar(100),
	TrangThai bit,
	IdToaNha int,
	constraint FK_Phong foreign key (IdToaNha) references toa_nha (IdToaNha),
)
GO

CREATE TABLE KHACH_THUE
(
	IdKhachThue int identity (1,1) PRIMARY KEY,
	HoVaTen nvarchar(50),
	NgaySinh date,
	GioiTinh bit,
	QueQuan nvarchar(100),
	DienThoai nvarchar(20),
	Email nvarchar(50),
	CMND nvarchar(20),
	GhiChu nvarchar(100)
)
GO

CREATE TABLE DICH_VU
(
	IdDichVu int identity (1,1) PRIMARY KEY,
	TenDichVu nvarchar(50),
	Gia float,
	DonVi nvarchar(10),
	MoTa nvarchar(100),
	TrangThai bit,
	IdToaNha int,
	constraint FK_DICH_VU_TOA_NHA FOREIGN KEY (IdToaNha) REFERENCES TOA_NHA(IdToaNha)
)
GO

CREATE TABLE DICH_VU_PHONG
(
	Id int identity (1,1) PRIMARY KEY,
	IdDichVu int,
	SoLuong int,
	IdPhong int
	constraint FK_DICH_VU_PHONG_PHONG FOREIGN KEY (IDPhong) REFERENCES PHONG(IDPhong),
	constraint FK_DICH_VU_PHONG_DICH_VU FOREIGN KEY (IdDichVu) REFERENCES DICH_VU(IdDichVu)
)
GO

CREATE TABLE PHONG_THUE
(
	IdPhongThue int identity (1,1) PRIMARY KEY,
	NgayThue date,
	IdKhachThue int,
	IdPhong int,
	VaiTro bit,
	constraint FK_PHONG_THUE_KHACH_THUE FOREIGN KEY (IdKhachThue) REFERENCES KHACH_THUE(IdKhachThue),
	CONSTRAINT fk_phong_thue_phong FOREIGN KEY (IdPhong) REFERENCES PHONG(IdPhong)
)
GO

CREATE TABLE HOA_DON
(
	IdHoaDon int identity (1,1) PRIMARY KEY,
	Thang int,
	Nam int,
	TrangThai bit,
	IdPhong int,
	constraint FK_HOA_DON_PHONG FOREIGN KEY (IdPhong) REFERENCES PHONG(IdPhong)
)
GO

CREATE TABLE HOA_DON_CHI_TIET
(
	IdHoaDonChiTiet int identity (1,1) PRIMARY KEY,
	IdHoaDon int,
	KhoanThu nvarchar(100),
	SoCu int,
	SoMoi int,
	SuDung int,
	Gia float,
	constraint FK_Hoa_Don_Chi_Tiet_Hoa_Don FOREIGN KEY (IdHoaDon) REFERENCES HOA_DON(IdHoaDon),
)
GO


create table Su_Co
(
	id int identity (1,1) PRIMARY KEY,
	mota nvarchar(100),
	nha nvarchar(100),
	phong nvarchar(100),
	nguoibao nvarchar(100),
	ngaybao nvarchar(100),
	ghichu nvarchar(1000),
	TrangThai bit
)
GO

CREATE TABLE KHOAN_CHI
(
	IdKhoanChi int identity (1,1) PRIMARY KEY,
	MoTa nvarchar(100),
	SoTien float
)
GO

CREATE TABLE TAI_KHOAN
(
	TaiKhoan nvarchar(20) primary key,
	MatKhau nvarchar(20),
	IdKhachThue int,
	Roles int,
	constraint FK_TAI_KHOAN_KHACH_THUE FOREIGN KEY (IdKhachThue) REFERENCES KHACH_THUE(IdKhachThue)
)
GO

create table MO_TA
(
	IdPhong int,
	Loc1 bit,
	Loc2 bit,
	Loc3 bit,
	Loc4 bit,
	Loc5 bit,
	Loc6 bit,
	Loc7 bit,
	Loc8 bit,
	Loc9 bit,
	constraint FK_Mo_Ta_Phong foreign key (IdPhong) references Phong(IdPhong)
)
GO

create table Lien_He 
(
	TenChuNha nvarchar(100),
	Tuoi int,
	SoDienThoai nvarchar(100),
	Email nvarchar(100),
)
GO




insert into TOA_NHA(TenToaNha, DiaChi, MoTa, GhiChu)
values	(N'A1',N'Ngách 44/64, Trần Thái Tông',N'Nhà mới màu trắng 7 tầng',N'Hoạt động 24/24')
		,(N'A2',N'Ngách 45/64, Trần Thái Tông',N'Nhà mới màu trắng 8 tầng',N'Hoạt động 24/24'),
		(N'A3',N'Ngách 46/64, Trần Thái Tông',N'Nhà mới màu trắng 9 tầng',N'Hoạt động 24/24'),
		(N'A4',N'Ngách 47/64, Trần Thái Tông',N'Nhà mới màu trắng 7 tầng',N'Hoạt động 24/24'),
		(N'A5',N'Ngách 48/64, Trần Thái Tông',N'Nhà mới màu trắng 8 tầng',N'Hoạt động 24/24');

insert into PHONG(Phong, Tang, DienTich, Gia, MoTa, TrangThai, IdToaNha)
values	(N'P101',1,30,3300000,N'Phòng mới',1,1),
		(N'P202',2,40,4300000,N'Phòng mới',1,1),
		(N'P303',3,50,5300000,N'Phòng mới',1,1),
		(N'P404',4,60,6300000,N'Phòng mới',1,1),
		(N'P505',5,70,7300000,N'Phòng mới',1,1)

	   ,(N'P101',1,30,3300000,N'Phòng mới',0,2),
		(N'P202',2,40,4300000,N'Phòng mới',0,2),
		(N'P303',3,50,5300000,N'Phòng mới',0,2),
		(N'P404',4,60,6300000,N'Phòng mới',0,2),
		(N'P505',5,70,7300000,N'Phòng mới',0,2),

		(N'P101',1,30,3300000,N'Phòng mới',0,3),
		(N'P202',2,40,4300000,N'Phòng mới',0,3),
		(N'P303',3,50,5300000,N'Phòng mới',0,3),
		(N'P404',4,60,6300000,N'Phòng mới',0,3),
		(N'P505',5,70,7300000,N'Phòng mới',0,3),

		(N'P101',1,30,3300000,N'Phòng mới',0,4),
		(N'P202',2,40,4300000,N'Phòng mới',0,4),
		(N'P303',3,50,5300000,N'Phòng mới',0,4),
		(N'P404',4,60,6300000,N'Phòng mới',0,4),
		(N'P505',5,70,7300000,N'Phòng mới',0,4),

		(N'P101',1,30,3300000,N'Phòng mới',0,5),
		(N'P202',2,40,4300000,N'Phòng mới',0,5),
		(N'P303',3,50,5300000,N'Phòng mới',0,5),
		(N'P404',4,60,6300000,N'Phòng mới',0,5),
		(N'P505',5,70,7300000,N'Phòng mới',0,5);


insert into KHACH_THUE(HoVaTen, NgaySinh, GioiTinh, QueQuan, DienThoai, Email, CMND, GhiChu)
values	(N'Nguyễn Văn A','01-01-2001',0,N'Hưng Yên',N'0966112738',N'tuannnph12028@fpt.edu.vn',N'033201002286',N'Khách thuê'),
		(N'Nguyễn Thị B','01-01-2001',1,N'Hưng Yên',N'0966112739',N'tuannnph12029@fpt.edu.vn',N'033201002287',N'Khách thuê'),
		(N'Nguyễn Văn C','01-01-2001',0,N'Hưng Yên',N'0966112730',N'tuannnph12020@fpt.edu.vn',N'033201002288',N'Khách thuê'),
		(N'Nguyễn Thị D','01-01-2001',1,N'Hưng Yên',N'0966112731',N'tuannnph12021@fpt.edu.vn',N'033201002289',N'Khách thuê'),
		(N'Nguyễn Văn E','01-01-2001',0,N'Hưng Yên',N'0966112732',N'tuannnph12022@fpt.edu.vn',N'033201002280',N'Khách thuê');


insert into DICH_VU(TenDichVu, Gia, DonVi, MoTa, TrangThai, IdToaNha)
values	(N'Điện', 3200, N'Số', N'Thu tiền theo tháng', 0, 1),
		(N'Nước', 25000, N'Mét khối', N'Thu tiền theo tháng', 0, 1),
		(N'Sinh hoạt chung', 150000, N'Người', N'Tháng máy, điện hành lang, vệ sinh chung, internet, bảo trì sửa chữa', 0, 1),
		(N'Máy giặt', 50000, N'Người', N'Thu tiền theo tháng', 0, 1);


insert into DICH_VU_PHONG(IdDichVu, SoLuong, IdPhong)
values	(1,1,1),
		(2,1,1),
		(3,3,1),
		(4,3,1),

		(1,1,2),
		(2,1,2),
		(3,3,2),
		(4,3,2),

		(1,1,3),
		(2,1,3),
		(3,3,3),
		(4,3,3),

		(1,1,4),
		(2,1,4),
		(3,3,4),
		(4,3,4),

		(1,1,5),
		(2,1,5),
		(3,3,5),
		(4,3,5);


insert into PHONG_THUE(NgayThue, IdKhachThue, IdPhong, VaiTro)
values	('01-01-2020',1,1,1),
		('01-01-2020',2,2,1),
		('01-01-2020',3,3,1),
		('01-01-2020',4,4,1),
		('01-01-2020',5,5,1);


insert into MO_TA(IdPhong, Loc1, Loc2, Loc3, Loc4, Loc5, Loc6, Loc7, Loc8)
values	(1, 0, 0, 0, 0, 0, 0, 0, 0),
		(2, 0, 0, 0, 0, 0, 0, 0, 0),
		(3, 0, 0, 0, 0, 0, 0, 0, 0),
		(4, 0, 0, 0, 0, 0, 0, 0, 0),
		(5, 0, 0, 0, 0, 0, 0, 0, 0),

		(6, 0, 0, 0, 0, 0, 0, 0, 0),
		(7, 0, 0, 0, 0, 0, 0, 0, 0),
		(8, 0, 0, 0, 0, 0, 0, 0, 0),
		(9, 0, 0, 0, 0, 0, 0, 0, 0),
		(10, 0, 0, 0, 0, 0, 0, 0, 0),

		(11, 0, 0, 0, 0, 0, 0, 0, 0),
		(12, 0, 0, 0, 0, 0, 0, 0, 0),
		(13, 0, 0, 0, 0, 0, 0, 0, 0),
		(14, 0, 0, 0, 0, 0, 0, 0, 0),
		(15, 0, 0, 0, 0, 0, 0, 0, 0),

		(16, 0, 0, 0, 0, 0, 0, 0, 0),
		(17, 0, 0, 0, 0, 0, 0, 0, 0),
		(18, 0, 0, 0, 0, 0, 0, 0, 0),
		(19, 0, 0, 0, 0, 0, 0, 0, 0),
		(20, 0, 0, 0, 0, 0, 0, 0, 0),

		(21, 0, 0, 0, 0, 0, 0, 0, 0),
		(22, 0, 0, 0, 0, 0, 0, 0, 0),
		(23, 0, 0, 0, 0, 0, 0, 0, 0),
		(24, 0, 0, 0, 0, 0, 0, 0, 0),
		(25, 0, 0, 0, 0, 0, 0, 0, 0);



insert into Lien_He(TenChuNha, Tuoi, SoDienThoai, Email)
values	(N'Nguyễn Ngọc Tuấn', 20, N'0966112738', N'tuannnph12028@fpt.edu.vn');


insert into SU_CO
values (N'1',N'1',N'1',N'1',N'1',N'1', 0)

insert TAI_KHOAN(TaiKhoan, MatKhau, IdKhachThue, Roles)
values (N'KhachThue1',N'12345',1,0),
(N'KhachThue2',N'12345',2,0),
(N'KhachThue3',N'12345',3,0),
(N'KhachThue4',N'12345',4,0),
(N'KhachThue5',N'12345',5,0),
(N'admin',N'12345',null,1)


select * from TAI_KHOAN
select * from Su_Co
select * from MO_TA
select * from PHONG
select * from HOA_DON