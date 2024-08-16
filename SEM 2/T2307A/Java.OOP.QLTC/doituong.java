package Java.OOP.QLTC;

import java.time.LocalDate;

abstract class doituong {
    LocalDate NgayTao;
    LocalDate NgaySua;

    abstract void nhap();
    abstract void xuat();

    public doituong(){
        this.NgayTao = LocalDate.now();
    }
}
