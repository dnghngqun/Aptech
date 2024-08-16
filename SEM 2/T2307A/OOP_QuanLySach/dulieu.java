package OOP_QuanLySach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.console;
import static java.lang.System.out;

public class dulieu extends doituong{

    String Ten;
    int NamXuatBan;
    double Gia; // USD
    char Loai; //V E
    Boolean TinhTrang; //true: mới , false: cũ
    LocalDate Ngay;

    public String getTinhTrang() {
        return (this.TinhTrang ? "Mới" : "Cũ");
    }

    public String getNgayVie() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.Ngay);
    }



    @Override
    void nhap() {
        out.print("\n Nhập tên: ");
        this.Ten = console().readLine();

        out.print("\n Nhập Năm Xuất Bản: ");
        this.NamXuatBan = Integer.parseInt(console().readLine());

        out.print("\n Nhập Giá: ");
        this.Gia = Double.parseDouble(console().readLine());

        out.print("\n Nhập Loại (V,E): ");
        this.Loai = console().readLine().charAt(0);

        out.print("\n Tình Trạng (1=mới/2=cũ): ");
        this.TinhTrang = Integer.parseInt(console().readLine()) != 0 ? true : false;

        out.print("\n Ngày tháng (ví dụ: 30/04/1997): ");
        this.Ngay = LocalDate.parse(console().readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    void xuat() {
    }

    Boolean KhôngHợpLệ() {
        var khl = false;

        if (this.Ten.length() < 3) {
            khl = true;
            out.print("\n ->Tên phải từ 3 kí tự trở lên.");
        }

        if (this.Ten.length() > 30) {
            khl = true;
            out.print("\n ->Tên phải không quá 30 kí tự.");
        }

//         if (this.Điểm > 10) {
//         khl = true;
//         out.print("\n ->Điểm phải không quá 10.");
//         }
//
//         Nếu tuổi dưới 18 thì bắt lỗi
//         int tuổi = java.time.Year.now().getValue() - this.Năm;
//
//         Nếu nhóm máu khác A, B, O thì bắt lỗi

        return khl;
    }


}
