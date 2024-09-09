public class ThanhVien {
    private String name;
    private GoiDangKy goiDangKy;
    // Dùng loose coupling
    public ThanhVien(GoiDangKy b) {
        goiDangKy = b;
    }

    // Dùng tight coupling
    public ThanhVien(){
        goiDangKy = new NonMember();
    }

    public void thongtinThanhVien(){
        System.out.println("Name: Nèo");
        goiDangKy.thongTin();
    }
}
