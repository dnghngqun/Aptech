import static java.lang.System.out;

import java.util.Scanner;

/**
 * Các Hàm Chức Năng:
 * gán()
 * nhập()
 * xuất()
 * /////
 * min()
 * max()
 * tbc()
 * //////
 * xếp()
 * nhóm()
 * tìm()
 */
class AppQuanLyMang {

    static DuLieu[] mảng;

    public static void main(String[] args) {
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
            out.print("\n| (C) Java 2024.02.28 14h23  |");
            out.print("\n+----------------------------+");

            out.print("\n Chọn menu: ");
            var scan = new Scanner(System.in);
            var menu = scan.nextInt();

            switch (menu) {
                case 1:
                    // làm việc 1
                    gán();
                    break;
                case 2:
                    // làm việc 2
                    nhập();
                    break;
                case 3:
                    // làm việc 3
                    xuất();
                    break;
                case 4:
                    // làm việc 4
                    min();
                    break;
                case 5:
                    // làm việc 5
                    max();
                    break;
                case 6:
                    // làm việc 6
                    tbc();
                    break;
                case 7:
                    xếp();
                    break;
                case 8:
                    nhóm();
                    break;
                case 9:
                    tìm();
                    break;
                case 10:
                    bảng();
                    break;
                case 0:
                    out.print("\n Đang thoát...");
                    // Thread.sleep(3000);
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    out.print("\n Hãy nhập menu hợp lệ !");
                    break;
            }

            out.print("\n Bạn có muốn tiếp tục không ?");
            out.print("\n Ấn chữ 'k' để dừng chương trình: ");
            char ck = scan.next().charAt(0);
            if// nếu
(ck == 'k' || ck == 'K')// không muốn làm việc nữa
            {
                out.print("\n Cảm ơn bạn đã dùng chương trình. Tạm biệt !");
                scan.close();
                System.exit(0); // thì dừng toàn bộ chương trình
            }

        }
    }

    static void tìm() {
        var scan = new Scanner(System.in);

        out.print("\n Nhập tên: ");
        String tên = scan.nextLine();

        out.print("\n Nhập tuổi min: ");
        int min = scan.nextInt();// Nếu lỗi thì dùng cách 2 bên dưới:

        out.print("\n Nhập tuổi max: ");
        int max = scan.nextInt();// Nếu lỗi thì dùng cách 2 bên dưới:

        int đếm = 0;
        for (DuLieu dl : mảng) {
            // Điều kiện tìm kiếm
            Boolean ok = (dl.Tên.contains(tên)
                    && // và
                    dl.Tuổi >= min
                    && // và
                    dl.Tuổi <= max);

            if (ok) {
                đếm++;
                if (đếm == 1)
                    cột();
                dòng(dl, đếm);
            }
        }
    }

    /**
     * Gộp các phần tử vào các nhóm cùng tính chất.
     * Ví dụ: theo nhóm máu, theo nhóm tỉnh thành.
     */
    static void nhóm() {

        int spt = mảng.length;

        // mảng chứa dữ liệu thống kê
        int[] sl = new int[spt]; // mối phần tử = 0

        for (int i = 0; i < spt; i++) {
            sl[i] = 1;
        }

        // Tinh chỉnh dữ liệu thống kê
        for (int i = 0; i < spt; i++) {
            for (int j = i + 1; j < spt; j++) {
                var i_j_cùng_loại = mảng[i].NhómMáu == mảng[j].NhómMáu;

                if// nếu
                (i_j_cùng_loại && sl[j] != 0) {
                    sl[i]++;
                    sl[j]--;
                }
            }
        }

        // In dữ liệu thống kê, phân loại ra màn hình
        // Số phần tử của nhóm
        // Tên nhóm
        for (int i = 0; i < spt; i++) {
            if (sl[i] != 0) {
                // out.printf("Nhóm máu A có 3 bạn.");
                out.printf("\n Có %d bạn thuộc nhóm máu %c .",
                        sl[i], mảng[i].NhómMáu);
            }
        }
    }

    /**
     * Gán hằng giá trị cho các phần tử mảng.
     * (khoảng 3 phần tử)
     */
    static void gán() {
        mảng = new DuLieu[3];

        // Tạo phần tử mảng thứ nhất
        var dl0 = new DuLieu();
        dl0.Tên = "Nobita";
        dl0.Tuổi = 3;
        dl0.NhómMáu = 'A';
        mảng[0] = dl0;

        // Tạo phần tử mảng thứ hai
        var dl1 = new DuLieu();
        dl1.Tên = "Chaien";
        dl1.Tuổi = 5;
        dl1.NhómMáu = 'A';
        mảng[1] = dl1;

        // Tạo phần tử mảng thứ ba
        var dl2 = new DuLieu();
dl2.Tên = "Xeko";
        dl2.Tuổi = 4;
        dl2.NhómMáu = 'B';
        mảng[2] = dl2;
    }

    static void nhập() {
        out.println("Nhập Xuất Dữ Liệu mảng 2024.02.26 16h13");

        var scan = new Scanner(System.in);

        out.print("\n Nhập số phần tử mảng: ");
        int N = scan.nextInt();// Nếu lỗi thì dùng cách 2 bên dưới:

        mảng = new DuLieu[N]; // phần tử

        for// với mỗi
        (int i = 0; i < mảng.length; i++)// chỉ số từ [0] đến [độ_dài-1]
        {
            out.printf("\n Nhập dữ liệu cho phần tử mảng[%d]", i);
            // làm gì đó với mảng[i]
            // Khởi tạo đối tượng
            DuLieu dl = new DuLieu();

            out.print("\n Nhập tên: ");
            dl.Tên = scan.nextLine();

            out.print("\n Nhập tuổi: ");
            dl.Tuổi = scan.nextInt();// Nếu lỗi thì dùng cách 2 bên dưới:

            out.print("\n Nhập nhóm máu (A,B,O): ");
            dl.NhómMáu = scan.next().charAt(0);

            // Thêm đối tượng vào mảng
            mảng[i] = dl;
            out.print("\n---------------------");
        }
    }

    static void cột() {
        // Xuất dữ liệu bảng đẹp mắt
        out.print("\n+--------------------------------------+");
        out.print("\n| STT | TÊN THÚ CƯNG | TUỔI | NHÓM MÁU |");
        out.print("\n+--------------------------------------+");
    }

    static void dòng(DuLieu dl, int stt) {
        out.printf("\n| %3d | %-12s | %4d | %8s |",
                stt, dl.Tên, dl.Tuổi, dl.NhómMáu);
        out.print("\n+--------------------------------------+");
    }

    static void bảng() {

        cột();

        for// với mỗi
        (int i = 0; i < mảng.length; i++)// chỉ số từ [0] đến [độ_dài-1]
        {
            // làm gì đó với mảng[i]
            DuLieu dl = mảng[i];
            dòng(dl, i + 1);

        }
    }

    static void xuất() {

        cột();

        for// với mỗi
        (int i = 0; i < mảng.length; i++)// chỉ số từ [0] đến [độ_dài-1]
        {
            // làm gì đó với mảng[i]
            DuLieu dl = mảng[i];
            dòng(dl, i + 1);

        }
    }

    /**
     * Sắp xếp , đổi chỗ các phần tử
     * nếu nó không giảm dần
     */
    static void xếp() {
        out.print("\n Sắp xếp theo tuổi giảm dần: ");

        // Với mỗi phần tử mảng[i]
        for (int i = 0; i < mảng.length; i++) {
            // Với mỗi phần tử [j] đứng sau [i]
            for (int j = i + 1; j < mảng.length; j++) {
                Boolean logic = mảng[i].Tuổi > mảng[j].Tuổi;
                if// nếu
                (!logic) // dieu kien bài không thoa man
                {
                    // thì đổi chỗ i và j
                    DuLieu tam = mảng[i];
mảng[i] = mảng[j];
                    mảng[j] = tam;
                }
            }
        }

        xuất();
    }

    static void min() {
        // Giả sử phần tử đầu tiên là nhỏ nhất
        int min = mảng[0].Tuổi;

        // tinh chỉnh min: so sánh nó với từng phần
        // tử và cập nhật
        for (int i = 0; i < mảng.length; i++) {
            if (min > mảng[i].Tuổi)
                min = mảng[i].Tuổi;
        }

        out.printf("\n\n Tuổi nhỏ nhất là %d", min);

        // @todo: Hiện ra tất cả các dòng bằng với Min

    }

    static void max() {
        int max = mảng[0].Tuổi;

        for (int i = 0; i < mảng.length; i++) {
            if (max < mảng[i].Tuổi)
                max = mảng[i].Tuổi;
        }

        out.printf("\n\n Tuổi lớn nhất: %d", max);

    }

    /**
     * Tính trung bình cộng
     */
    static void tbc() {
        float tbc;
        float txm; // tổng xích ma
        int spt; // số phần tử mảng

        txm = 0;
        spt = mảng.length;

        for (int i = 0; i < spt; i++) {
            txm = txm + mảng[i].Tuổi;
        }

        tbc = txm / spt;

        out.printf("\n Tuổi trung bình là: %.2f", tbc);
    }

}