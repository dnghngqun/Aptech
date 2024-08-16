package Java.OOP.QLTC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.console;
import static java.lang.System.out;

public class dulieu extends doituong{

    String Ten;
    int tuoi;
    double CanNang;
    char NhomMau;//A B O
    Boolean gioi; // true = đực, false = cái
    LocalDate NgayNhapChuong;

    //chuyển định dạng ngày theo vietnam
    public String getNgayVie(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.NgayNhapChuong);
    }

    public String getGioi(){
        return this.gioi ? "Đực" : "Cái";
    }

    @Override
    void nhap() {
        out.print("\nNhập tên: ");
        this.Ten = console().readLine();
        out.print("\nNhập tuổi: ");
        this.tuoi = Integer.parseInt(console().readLine());
        out.print("\nNhập cân nặng: ");
        this.CanNang = Double.parseDouble(console().readLine());

        out.print("\n Nhập nhóm máu (A,B,O): ");
        this.NhomMau = console().readLine().charAt(0);

        out.print("\n Giới tính (true=Đực/false=Cái): ");
        this.gioi = Integer.parseInt(console().readLine()) != 0 ? true : false;

        out.print("\n Ngày tháng (ví dụ: 30/04/1997): ");
        this.NgayNhapChuong = LocalDate.parse(console().readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    @Override
    void xuat() {

    }
}
