package Java.OOP.QLTC;

import java.util.Scanner;

import static java.lang.System.out;

public class App {
    public static void menu(){
        out.print("\n+----------------------------+");
        out.print("\n| QUẢN LÝ THÚ CƯNG.          |");
        out.print("\n+----------------------------+");
        out.print("\n| 1. Thêm | 2. Sửa | 3. Xoá  |");
        out.print("\n+----------------------------+");
        out.print("\n| 4. Min | 5. Max  | 6. Tbc  |");
        out.print("\n+----------------------------+");
        out.print("\n| 7. Xếp | 8. Nhóm | 9. Tìm  |");
        out.print("\n+----------------------------+");
        out.print("\n| 10. Duyệt | 11.Lưu | 9.Mở  |");
        out.print("\n+----------------------------+");
        out.print("\n| 0. Thoát  |    (C) Java    |");
        out.print("\n+----------------------------+");
    }

    public static void run(){
        while (true){
            menu();
            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();

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
}
