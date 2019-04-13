CREATE DATABASE QLHS;

use QLHS;


CREATE TABLE tblLOP
(
	malop varchar(6) PRIMARY KEY,
	tenlop nvarchar(50) not null
);

CREATE TABLE tblGIAOVIEN
(
	tengv nvarchar(50) not null,
	magv varchar(6) PRIMARY KEY,
	pass varchar(6) default '123456',
	malop varchar(6) not null,
	CONSTRAINT fk_tblGIAOVIEN FOREIGN KEY (malop) REFERENCES tblLOP(malop) 
);

CREATE TABLE tblHOCSINH
(
	malop varchar(6) not null,
	mahs varchar(6) PRIMARY KEY,
	quequan nvarchar(50),
	gioitinh nvarchar(15),
	ngaysinh varchar(10),
	sodienthoai int,
	tenhs nvarchar(50) not null,
	CONSTRAINT fk_tblHOCSINH FOREIGN KEY (malop) REFERENCES tblLOP(malop)
);
create TABLE tblHOCKI
(
	tenhocki nvarchar(20) not null,
    mahocki varchar(6) not null primary key,
    nam char(4) not null
);

CREATE TABLE tblMONHOC
(
	tenmon nvarchar(50) not null,
	malop varchar(6) not null,
	mamon varchar(6) PRIMARY KEY,
    mahocki varchar(6) not null,
	CONSTRAINT fk_MON FOREIGN KEY (malop) REFERENCES tblLOP(malop) ,
    constraint fk_MONHOC_HOCKI foreign key(mahocki) references tblHOCKI(mahocki)
);

CREATE TABLE tblDIEM
(
	diem int default 0,
	mahs varchar(6) not null,
	mamon varchar(6) not null,
	CONSTRAINT chk_tblDIEM CHECK(diem < 11 AND diem >-1),
	CONSTRAINT fk_tblDIEM_tblHOCSINH FOREIGN KEY (mahs) REFERENCES tblHOCSINH(mahs),
	CONSTRAINT fk_tblDIEM_tblMONHOC FOREIGN KEY (mamon) REFERENCES tblMONHOC(mamon)
);

CREATE TABLE tblADMIN
(
	username varchar(6) not null primary key,
	pass varchar(6) default '123456' not null,
    lv int default 1
);


 insert into tbllop(malop,tenlop)
 Values('LOP001',N'Lớp 1');
insert into tblgiaovien(tengv,magv,malop)
values(N'Lê Thị Thu Thảo','GV0001','LOP001');

insert into tblhocsinh(malop,mahs,quequan,gioitinh,ngaysinh,sodienthoai,tenhs)
values('LOP001','HS0001',N'Kim Liên Nam Đàn Nghệ An','Nam','15-01-1997',263473623,N'Nguyễn Trọng Dương');

insert into tblHOCKI(tenhocki,mahocki,nam)
values(N'Học Kì 1','HK0001','2010');

insert into tblmonhoc(tenmon,malop,mamon,mahocki)
values(N'Lập Trình Hướng đối Tượng','LOP001','MON001','HK0001'),
(N'kĩ Thuật Lập Trình','LOP001','MON002','HK0001');

insert into tbldiem(diem,mahs,mamon)
values(8,'HS0001','MON001');
insert into tbladmin(username,lv)
values('Admin',0),
('GV0001',1);

SELECT *FROM tblHOCSINH;
SELECT *FROM tblGIAOVIEN;
SELECT *FROM tblLOP;
SELECT *FROM tblMONHOC;
select*from tbldiem;
select*from tblHOCKI;

/*Mã học sinh: HS + 4 chữ số
Mã lớp: LOP+ 3 chữ số
Mã Giáo viên: GV +4 chữ số
Mã môn: MON +3 chữ số
Phân quyền Admin(Lv ==0) Có thể tạo tài khoản user không thể thêm xóa sửa điểm
Phân quyền user(Lv== 1) không thể tạo tài khoản user khác
 */

