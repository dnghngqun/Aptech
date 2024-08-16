package OOP_QuanLySach;

import java.time.LocalDate;
    abstract class doituong {
        LocalDate NgayNhap;

        abstract void nhap();
        abstract void xuat();

        public doituong(){
            this.NgayNhap = LocalDate.now();
        }
    }
