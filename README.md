# Tic Tac Toe Game

## Giới thiệu

Đây là một trò chơi Tic Tac Toe đơn giản được viết bằng Java và JavaSwing. Trò chơi cho phép hai người chơi lần lượt điền ký tự 'X' và 'O' vào các ô trống của bàn cờ 3x3. Trò chơi kiểm tra và thông báo người chiến thắng hoặc hòa sau mỗi lượt chơi.

## Các thành phần chính

### Các class

1. **Board**: Quản lý trạng thái của bàn cờ Tic Tac Toe.

2. **Move**: Đại diện cho một nước đi trên bàn cờ (dự án có thể không sử dụng lớp này).

3. **Player**: Đại diện cho người chơi với ký tự 'X' hoặc 'O'.

4. **Game**: Class chính quản lý UI và luồng của trò chơi.

### Các phương thức trong class Game

- **Khởi tạo UI**: Tạo JFrame và các JButton để hiển thị bàn cờ Tic Tac Toe.

- **Xử lý sự kiện khi click vào JButton**: Người dùng click vào ô trên bàn cờ để đặt 'X' hoặc 'O'. Class này xử lý nước đi, cập nhật giao diện và kiểm tra kết quả trò chơi.

- **updateButton()**: Cập nhật trạng thái của JButton sau khi người dùng click (đã được click và chứa ký tự 'X' hoặc 'O').

- **updateStatusLabel()**: Cập nhật label hiển thị lượt chơi của người chơi hiện tại ('X' hoặc 'O').

- **checkForWin()**: Kiểm tra xem người chơi hiện tại đã chiến thắng hay chưa bằng cách kiểm tra các hàng, cột và đường chéo trên bàn cờ.

- **checkForDraw()**: Kiểm tra xem trò chơi đã hòa hay chưa bằng cách kiểm tra xem còn ô trống nào trên bàn cờ không.

- **resetGame()**: Khởi tạo lại trò chơi sau khi có kết quả (thắng hoặc hòa).

- **showWinMessage()**: Hiển thị thông báo chúc mừng khi có người chơi chiến thắng bằng cách sử dụng `JOptionPane.showMessageDialog()`.

## Hướng dẫn cài đặt và chạy

1. Clone repo này về máy tính của bạn.

2. Mở dự án bằng IDE IntelliJ IDEA hoặc bất kỳ IDE Java nào.

3. Chạy file `Game.java` để bắt đầu trò chơi Tic Tac Toe.

## Yêu cầu

- Java Development Kit (JDK) phiên bản 8 trở lên.

## Tác giả

- Tên: Phuong Dai Thang
- GitHub:https://github.com/PhuongDaiThang

