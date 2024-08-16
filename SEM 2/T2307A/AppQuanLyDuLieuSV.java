import static java.lang.System.out;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

/*
* Các hàm chức năng
* Gán();
* Nhập();
* Xuất();
* Min();
* Max();
* TBC();
* Sort();
* Group()/gộp nhóm: phân loại sinh viên theo nhóm máu;
* Search(): tìm sinh viên theo tên và khoảng điểm;
* Menu();
* Main();
* */
public class AppQuanLyDuLieuSV {
    static DuLieuSV[] array;
    static int count = 0; //biến toàn cục

    public static void main(String[] args){
      menu();
    }
    static void menu(){
        while (true) {
            out.print("\n+----------------------------+");
            out.print("\n| QUẢN LÝ MẢNG.              |");
            out.print("\n+----------------------------+");
            out.print("\n| 1. Gán | 2. Nhập | 3. Xuất |");
            out.print("\n+----------------------------+");
            out.print("\n| 4. Min | 5. Max  | 6. Tbc  |");
            out.print("\n+----------------------------+");
            out.print("\n| 7. Xếp | 8. Nhóm | 9. Tìm  |");
            out.print("\n+----------------------------+");
            out.print("\n| 10. Duyệt Bảng | 0. Thoát  |");
            out.print("\n+----------------------------+");
            out.print("\n| (C) Java                   |");
            out.print("\n+----------------------------+");

            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();

            switch (menu) {
                case 1:
                    Gán();
                    break;
                case 2:
                    nhập();
                    break;
                case 3:
                    xuất();
                    break;
                case 4:
                    min();
                    break;
                case 5:
                    max();
                    break;
                case 6:
                    tbc();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 0:
                    out.print("\n Đang thoát...");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    out.print("\n Hãy nhập menu hợp lệ !");
                    break;
            }

            out.print("\n Bạn có muốn tiếp tục không ?");
            out.print("\n Ấn chữ 'k' để dừng chương trình: ");
            char choice = scan.next().charAt(0);

            if (choice == 'k' || choice == 'K')// không muốn làm việc nữa
            {
                out.print("\n Cảm ơn bạn đã dùng chương trình. Tạm biệt !");
                scan.close();
                System.exit(0); //  dừng toàn bộ chương trình
            }
        }
    }
    /*
    * Gán khoảng 3 hằng giá trị vào các phần tử mảng
    * */
    static void Gán(){
        if(array != null){
            count = array.length;
            array = Arrays.copyOf(array, count + 3);
        }else {
            array = new DuLieuSV[3];
        }
        //tạo phần tử mảng thứ nhất
        var dl0 = new DuLieuSV();
        dl0.Ten_sv = "Ng Văn Lan";
        dl0.nam_sinh = 1995;
        dl0.diem = 9.5;
        dl0.nhom_mau = 'A';
        dl0.gioi_tinh = true;
        dl0.ngay_nhap_hoc = LocalDate.of(2015, 12, 28);
        array[count] = dl0;

        //tạo phần tử mảng thứ 2
        var dl1 = new DuLieuSV();
        dl1.Ten_sv = "Trần Minh Cương";
        dl1.nam_sinh = 1997;
        dl1.diem = 8;
        dl1.nhom_mau = 'B';
        dl1.gioi_tinh = false;
        dl1.ngay_nhap_hoc = LocalDate.of(2016, 11, 27);
        array[count + 1] = dl1;

//        tạo phần tử mảng thứ 3
        var dl2 = new DuLieuSV();
        dl2.Ten_sv = "Tô Xuân Bách";
        dl2.nam_sinh = 2005;
        dl2.diem = 8.5;
        dl2.nhom_mau = 'O';
        dl2.gioi_tinh = true;
        dl2.ngay_nhap_hoc = LocalDate.of(2020, 7, 29);
        array[count + 2] = dl2;

        out.print("\nGán thành công!!!");
        out.print("\n---------------------");

    }

    /*
    *Nhập độ dài mảng, sau đó nhập dữ liệu từng phần
    * */
    static void nhập() {
        var scan = new Scanner(System.in);
        out.println("Nhập Dữ Liệu Sinh Viên");
        if(array != null) {
            count = array.length; //lấy độ dài mảng sẵn có
            out.print(" Nhập số lượng sinh viên muốn thêm thông tin: ");
            int N = scan.nextInt();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng
            array = Arrays.copyOf(array, count + N);//tạo mảng mới với kích thước tăng thêm
        }else {
            out.print(" Nhập số lượng sinh viên muốn thêm thông tin: ");
            int N = scan.nextInt();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng
            array = new DuLieuSV[N]; // phần tử
        }
        out.printf(" Số thông tin sinh viên đã có là: %d", count);

        for (int i = count; i < array.length; i++)
        {
            out.printf(" \nNhập dữ liệu cho sinh viên thứ %d", i + 1);

            // Khởi tạo đối tượng
            DuLieuSV dl = new DuLieuSV();

            out.print("\nNhập tên: ");
            dl.Ten_sv = scan.nextLine();

            out.print("Nhập năm sinh: ");
            dl.nam_sinh = scan.nextInt();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng

            out.print("Nhập số điểm: ");
            dl.diem = scan.nextDouble();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng

            out.print("Nhập nhóm máu: ");
            dl.nhom_mau = Character.toUpperCase(scan.next().charAt(0));// lấy kí tự đầu tiên trong chuỗi nhập
            scan.nextLine(); // Tiêu diệt dấu xuống dòng

            while (true){
                out.print("Nhập giới tính(nam nhập Male, nữ nhập Female): ");
                String gender = scan.next();
                scan.nextLine(); // Tiêu diệt dấu xuống dòng
                if(Objects.equals(gender, "Male") || Objects.equals(gender,"male")){
                    dl.gioi_tinh = true;
                    break;
                }

                if(Objects.equals(gender, "Female") || Objects.equals(gender, "female")) {
                    dl.gioi_tinh = false;
                    break;
                }
                out.print("\n Dữ liệu nhập vào không đúng, vui lòng nhập lại!");

            }

            out.print(" Nhập ngày nhập trường");
            out.print("\nNhập ngày (dd): ");
            int ngay = scan.nextInt();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng


            out.print("Nhập tháng (MM): ");
            int thang = scan.nextInt();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng

            out.print("Nhập năm (yyyy): ");
            int nam = scan.nextInt();
            scan.nextLine(); // Tiêu diệt dấu xuống dòng
            dl.ngay_nhap_hoc = LocalDate.of(nam, thang, ngay);

            // Thêm đối tượng vào mảng
            array[i] = dl;
        }
        out.print("Thành Công!");
        out.print("\n---------------------");
    }

    /*
    * xuất dữ liệu mảng ra bảng
    * */
    static void xuất() {

        cột();

        for (int i = 0; i < array.length; i++)// chỉ số từ [0] đến [độ_dài-1]
        {
            // làm gì đó với mảng[i]
            DuLieuSV dl = array[i];
            dòng(dl, i + 1);

        }
    }
    static void cột() {
        // Xuất dữ liệu bảng đẹp mắt
        out.print("\n+-----------------------------------------------------------------------------------+");
        out.print("\n| STT |  TÊN SINH VIÊN  | NĂM SINH | ĐIỂM | NHÓM MÁU | GIỚI TÍNH | NGÀY NHẬP TRƯỜNG |");
        out.print("\n+-----------------------------------------------------------------------------------+");
    }

    static void dòng(DuLieuSV dl, int stt) {
        String b = "Male";
        if(!dl.gioi_tinh){
            b = "Female";
        }

        // Định dạng lại chuỗi ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngay_nhap_hoc_Formatted = dl.ngay_nhap_hoc.format(formatter);

        out.printf("\n| %3d | %-15s |   %4d   | %-4.1f |    %-2c    |   %-6s  |    %10s    |",
                stt,dl.Ten_sv , dl.nam_sinh, dl.diem, dl.nhom_mau,b , ngay_nhap_hoc_Formatted);
        out.print("\n+-----------------------------------------------------------------------------------+");


    }

    /*
    * hiển thị ra sinh viên lớn tuổi nhất
    * tính theo năm
    * */
    static void min(){
        if(array == null){
            out.println("\nChưa có dữ liệu sinh viên, vui lòng nhập vào!");
        }
        else{
            int min = array[0].nam_sinh;
            //tìm năm sinh nhỏ nhất
            for(int i = 1; i < array.length; i++){
                if(array[i].nam_sinh < min){
                    min = array[i].nam_sinh;
                }
            }
            out.println("Những sinh viên lớn tuổi gồm:");
            cột();
            //in ra thông tin sinh viên có năm sinh nhỏ nhất
            for(int i = 0; i < array.length;i++){
                if(array[i].nam_sinh == min ){
                   DuLieuSV dl = array[i];
                   dòng(dl, i + 1);
                }
            }
        }
    }
    /*
    * liệt kê những sinh viên có điểm cao nhất*/
    static void max(){
        if(array == null){
            out.println("\nChưa có dữ liệu sinh viên, vui lòng nhập vào!");
        }
        else{
            double max = array[0].diem;
            //tìm điểm số lớn nhất
            for(int i = 1; i < array.length; i++){
                if(array[i].diem > max){
                    max = array[i].diem;
                }
            }
            out.println("Những sinh viên có điểm cao nhất gồm:");
            cột();
            //in ra thông tin sinh viên có năm sinh nhỏ nhất
            for(int i = 0; i < array.length;i++){
                if(array[i].diem == max ){
                    DuLieuSV dl = array[i];
                    dòng(dl, i + 1);
                }
            }
        }
    }
    /*
    * tính điểm trung bình các sinh viên*/
    static void tbc(){
        if(array == null){
            out.println("\nChưa có dữ liệu sinh viên, vui lòng nhập vào!");
        }else {
            double sum = 0;
            //tính tổng điểm sinh viên
            for(int i = 0; i < array.length; i++){
                sum += array[i].diem;
            }

            double diem_tbc = sum / array.length;

            out.printf("Điểm trung bình của các sinh viên là: %.1f\n", diem_tbc);
        }
    }

    /*
    * sắp xếp sinh viên giảm dần theo điểm
    * */
    static void sort(){

    }
}

