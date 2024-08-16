package OOP_QuanLySach;

import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import static java.lang.System.out;
import static java.lang.System.console;

class App implements chucnang<dulieu> {

    // Khai báo biến chứa danh sách
    List<dulieu> ds;

    public App() {
        // khởi tạo danh sách để chống lỗi NullPointerException
        ds = new ArrayList<dulieu>();

        /* Khởi tạo đối tượng 1 */
        var dl1 = new dulieu();
        dl1.Ten= "Nobita";
        dl1.NamXuatBan = 1995;
        dl1.Gia = 6.5;
        dl1.Loai = 'V';
        dl1.TinhTrang = true;
        dl1.Ngay = LocalDate.of(2001, 12, 22);

        /* Khởi tạo đối tượng 2 */
        var dl2 = new dulieu();
        dl2.Ten= "OnePiece";
        dl2.NamXuatBan = 1995;
        dl2.Gia = 10;
        dl2.Loai = 'V';
        dl2.TinhTrang = true;
        dl2.Ngay = LocalDate.of(2001, 12, 22);

        // @todo kiểm duyệt dữ liệu
        // trước khi đưa vào danh sách

        ds.add(dl1);
        ds.add(dl2);
    }

    public void run() {

        while (true)// vòng lặp
        {

            Menu();

            out.print("\n Bạn có muốn tiếp tục không ?");
            out.print("\n Ấn chữ 'k' để dừng chương trình: ");
            char ck = console().readLine().charAt(0);
            if (ck == 'k' || ck == 'K') {
                System.exit(0);
            } else// ngược lại thì
                continue; // tiếp tục hiện menu

        } // kết thúc vòng lặp menu
    }

    public void Menu() {
        out.print("\n+-----------------------------------------+");
        out.print("\n| QUẢN LÝ DANH SÁCH.                      |");
        out.print("\n+-----------------------------------------+");
        out.print("\n| 1.Thêm Mới  | 2.Cập Nhật  | 3.Xoá Bỏ    |");
        out.print("\n+-----------------------------------------+");
        out.print("\n| 4. Min      | 5. Max      | 6. tbc      |");
        out.print("\n+-----------------------------------------+");
        out.print("\n| 7.Sắp Xếp   | 8.Phân Loại | 9.Tìm Kiếm  |");
        out.print("\n+-----------------------------------------+");
        out.print("\n| 10.Ghi File | 11.Đọc File | 12.Hiện Bảng|");
        out.print("\n+-----------------------------------------+");
        out.print("\n| 0.Thoát                                 |");
        out.print("\n+-----------------------------------------+");
        out.print("\n| (c) Java                                |");
        out.print("\n+-----------------------------------------+");

        out.print("\n Chọn menu: ");
        var menu = Integer.parseInt(console().readLine());

        switch (menu) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 0:
                out.print("\n Đang thoát...");
                // Thread.sleep(3000);
                System.exit(0);
                break;
            default:
                out.print("\n Hãy nhập menu hợp lệ !");
                break;
        }// kết thúc switch

    }

    // dl=dữ liệu
    @Override
    public void them() {
        var dl = new DữLiệu();
        // Tạo mới đối tượng

        dl.Nhập();
        // yêu cầu đối tượng nhập dữ liệu

        // kiểm duyệt dữ liệu
        if// nếu
        (dl.KhôngHợpLệ()) {
            // chấm dứt ở đây, không cho phép thêm đối tượng mới vào danh sách
            return;
        }

        ds.add(dl);// thêm

        out.print("\n Đã hoàn tất việc thêm mới.");

        Duyệt(); // lại danh sách
    }

    // dl=dữ liệu
    @Override
    public void update() {

        int chỉ_số = 0;
        // vị trí của phần tử cần sửa trong danh sách

        // hiện
        Bảng(); // để người dùng lựa chọn đối tượng cần sửa

        out.print("\n Nhập số thứ tự để sửa: ");
        int stt = Integer.parseInt(console().readLine());

        chỉ_số = stt - 1;
        // @todo: Kiểm duyệt chỉ số, đảm bảo chắc chắn nó nằm trong
        // phạm vi cho phép

        var dl = new DữLiệu();
        // Tạo đối tượng mới

        dl.Nhập();
        // yêu cầu đối tượng nhập liệu

        // kiểm duyệt dữ liệu
        if// nếu
        (dl.KhôngHợpLệ()) {
            // chấm dứt ở đây, không cho phép sửa đối tượng cũ trong danh sách
            return;
        }

        ds.set(chỉ_số, dl);

        out.print("\n Đã hoàn tất việc sửa.");

        Duyệt(); // lại danh sách

    }
     public void Xuất(List<dulieu> ds) {
     if// nếu
     (ds == null || ds.size() == 0)// danh sách trống rỗng
     {
     out.print("\n Lỗi-Không thể hiển thị danh sách rỗng !");
     return;
     }

     int đếm = 0;
     for// với mỗi
     (var dl : ds) { // dòng dữ liệu trong danh sách
     đếm++;
     if (đếm == 1)
     Cột();
     Dòng(dl, đếm);
     }
     }

    @Override
    public void xoa() {

        int chỉ_số = 0;
        // vị trí của phần tử cần sửa trong danh sách
        // Kiểm tra chỉ số để xóa xem có hợp lệ

        // hiện
        Bảng(); // để người dùng chọn đối tượng muốn xóa

        out.print("\n Nhập số thứ tự để xóa: ");
        int stt = Integer.parseInt(
                console().readLine());// Nếu lỗi thì dùng cách 2 bên dưới:

        chỉ_số = stt - 1;
        // @todo: Kiểm duyệt chỉ số, đảm bảo chắc chắn nó nằm trong
        // phạm vi cho phép

        ds.remove(chỉ_số);

        out.print("\n Đã hoàn tất việc xóa.");

    }

    @Override
    public void Hienbang() {
        Bảng();
    }

    // public void Xuất(List<DữLiệu> ds) {
    // if// nếu
    // (ds == null || ds.size() == 0)// danh sách trống rỗng
    // {
    // out.print("\n Lỗi-Không thể hiển thị danh sách rỗng !");
    // return;
    // }

    // int đếm = 0;
    // for// với mỗi
    // (var dl : ds) { // dòng dữ liệu trong danh sách
    // đếm++;
    // if (đếm == 1)
    // Cột();
    // Dòng(dl, đếm);
    // }
    // }

    /**
     * @abstract Lưu dữ liệu mảng vào tệp, với định dạng DAT
     *           Các dị thường có thể xảy ra:
     *           -UnsupportedEncodingException: Chuỗi kí tự sử dụng lược đồ mã hóa
     *           không hỗ trợ
     *           -FileNotFoundException: Không tìm thấy tệp trên ổ cứng
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *
     */
    @Override
    public void Lưu()// vào tệp file
    {
        try {

            // Đường dẫn tĩnh để test nhanh
            var filePath = "C:/Users/Public/ds.dat";

            // Đường dẫn động nhập từ bàn phím:
            // ví dụ: c:/users/public/mang.dat
            out.print("\n Nhập đường dẫn tệp file cần ghi dữ liệu: ");
            filePath = console().readLine();

            var fos = new FileOutputStream(filePath); // FileNotFoundException
            var oos = new ObjectOutputStream(fos); // IOException
            oos.writeObject(ds);
            oos.close();

        } catch (Exception ex) {
            out.print("\n Lỗi tệp file hoặc vào ra dữ liệu: ");
            ex.printStackTrace();
        } finally {

        }

        out.println("\n Đã hoàn tất việc ghi file.");
    }

    /**
     * @abstract Đọc dữ liệu tệp nhị phân DAT và chuyển đổi nó thành mảng
     *           Các dị thường có thể xảy ra:
     *           -IOException: Lỗi vào ra dữ liệu
     *           không hỗ trợ
     *           -FileNotFoundException: Lỗi Không tìm thấy tệp trên ổ cứng
     *
     *           Khi nhập đường dẫn tệp file từ Terminal/Console thì nên
     *           dùng dấu suộc trái '/' để biểu diễn. Đỡ bị lỗi
     *           FileNotFoundException
     *
     *           Lỗi tệp file hoặc mã hóa bộ kí tự UTF8:
     *           java.lang.NullPointerException: Cannot invoke
     *           "java.lang.Boolean.boolea
     *           ava.lang.Boolean.booleanValue()" because "dt.Giới" is null
     */
    @SuppressWarnings("unchecked") // loại bỏ cảnh báo chỗ: ois.readObject();
    public void Mở() {

        try {

            // Đường dẫn tĩnh để test nhanh
            var filePath = "C:/Users/Public/ds.dat";

            // Đường dẫn động nhập từ bàn phím:
            // ví dụ: c:/users/public/mang.dat
            out.print("\n Nhập đường dẫn tệp file cần đọc dữ liệu: ");
            filePath = console().readLine();

            var fis = new FileInputStream(filePath); // FileNotFoundException
            var ois = new ObjectInputStream(fis); // IOException

            ds = (List<DữLiệu>) ois.readObject();
            ois.close();

//            Duyệt();
        } catch (Exception e) {
            out.print("\n Lỗi tệp file hoặc mã hóa bộ kí tự UTF8: ");
            e.printStackTrace();
        }

    }// kết thúc hàm

    public void Cột() {
        out.print("\n+--------------------------------------------------------------------------------+");
        out.print("\n| STT | TÊN THÚ CƯNG | TUỔI | CÂN NẶNG | NHÓM MÁU | GIỚI TÍNH | NGÀY NHẬP CHUỒNG |");
        out.print("\n+--------------------------------------------------------------------------------+");
    }

    // dl=dữ liệu
    /**
     * @param dl  DữLiệu Dư liệu của đối tượng cần hiện chi tiết
     * @param stt int Số thứ tự của đối tượng.
     * @abstract Hàm hiển thị chi tiết dữ liệu của 1 dòng bản ghi.
     *           Hàm này tôi tốn nhiều công sức để làm.
     *           Bạn vui lòng dùng nhiều vào.
     */
    public void Dòng(dulieu dl, int stt) {

        out.printf("\n| %3d | %-12s | %4d | %5.2f kg| %8s | %9s | %16s |",
                stt, dl.Tên, dl.Tuổi, dl.CânNặng, dl.NhómMáu,
                dl.getGiớiTính(),
                dl.getNgàyVi());
        out.print("\n+--------------------------------------------------------------------------------+");
    }

    public void Bảng() {

        if// nếu
        (ds == null || ds.size() == 0)// danh sách trống rỗng
        {
            out.print("\n Lỗi-Không thể hiển thị danh sách rỗng !");
            return;
        }

        out.print("\n Bảng Dữ Liệu :");
         Xuất(ds);

        Cột();
        int stt = 0;
        for// với mỗi
        (var dl : ds) { // dòng dữ liệu trong danh sách
            stt++;
            Dòng(dl, stt);
        }

    }

}// kết thúc lớp