Các class Board, Move, và Player: Được định nghĩa như trên để quản lý trạng thái của bàn cờ, các nước đi và các người chơi.

Class Game: Đây là class chính quản lý UI và luồng của trò chơi Tic Tac Toe. Các điểm chính của class này bao gồm:

Khởi tạo UI: Tạo ra JFrame và các JButton để đại diện cho bàn cờ Tic Tac Toe.
Xử lý sự kiện khi click vào JButton: Khi người dùng click vào một ô trên bàn cờ, class xử lý nước đi, cập nhật giao diện và kiểm tra xem có người chơi nào chiến thắng hay hòa.
Các phương thức hỗ trợ:
updateButton(): Cập nhật trạng thái của JButton (đã được click và chứa ký tự X hoặc O).
updateStatusLabel(): Cập nhật label hiển thị lượt chơi của người chơi hiện tại.
checkForWin(): Kiểm tra xem người chơi hiện tại có chiến thắng không bằng cách kiểm tra các hàng, cột và đường chéo trên bàn cờ.
checkForDraw(): Kiểm tra xem trò chơi có hòa không bằng cách kiểm tra xem còn ô trống nào trên bàn cờ không.
resetGame(): Khởi tạo lại trò chơi sau khi có kết quả (thắng hoặc hòa).
showWinMessage(): Hiển thị thông báo chúc mừng khi có người chơi chiến thắng bằng cách sử dụng JOptionPane.showMessageDialog().
