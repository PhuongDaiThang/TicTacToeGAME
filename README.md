# Tic Tac Toe Game

## Giới thiệu

Đây là một trò chơi Tic Tac Toe đơn giản được viết bằng Java và JavaSwing. Trò chơi cho phép hai người chơi lần lượt điền ký tự 'X' và 'O' vào các ô trống của bàn cờ 3x3. Trò chơi kiểm tra và thông báo người chiến thắng hoặc hòa sau mỗi lượt chơi.

## Công nghệ sử dụng

Trò chơi Tic Tac Toe được viết bằng ngôn ngữ lập trình Java và sử dụng thư viện đồ họa JavaSwing để xây dựng giao diện người dùng. Các tính năng chính của trò chơi được triển khai qua các lớp và phương thức trong Java để quản lý trạng thái của bàn cờ, xử lý luồng chơi, và tương tác với người dùng thông qua các thành phần như JButton và JLabel.

### Chi tiết công nghệ

- **Java**: Ngôn ngữ lập trình chính để phát triển toàn bộ trò chơi.
- **JavaSwing**: Thư viện đồ họa được sử dụng để tạo giao diện người dùng đơn giản và nhanh chóng.
- **Git**: Sử dụng để quản lý mã nguồn và phiên bản của dự án trên GitHub.
- **IDE**: Được thiết lập và chạy dự án bằng IntelliJ IDEA để phát triển và kiểm tra trò chơi.

Đây là một giải pháp đơn giản và hiệu quả để xây dựng một trò chơi nhỏ và thực hành các kỹ năng lập trình Java cơ bản.

## Các tính năng

- Hai chế độ chơi: Chơi với bạn bè và chơi với bot.
- Luân phiên lượt bắt đầu giữa hai người chơi hoặc giữa người chơi và bot.
- Người chơi nhập tên của mình khi bắt đầu trò chơi.
- Hiển thị tỷ số người chơi 1 - người chơi 2.
- Hiển thị thông báo khi có người chơi chiến thắng hoặc hòa.
- Nút Finish để kết thúc trò chơi và đặt lại bàn cờ.
- Giao diện đơn giản và thân thiện với người dùng.
## Các lớp trong dự án

Dưới đây là một số lớp chính trong dự án Tic Tac Toe và vai trò của từng lớp:

### Board

Lớp `Board` quản lý trạng thái của bàn cờ Tic Tac Toe và cung cấp các phương thức để kiểm tra ô trống, đặt ký tự 'X' hoặc 'O' vào ô cờ.

### Player

Lớp `Player` đại diện cho người chơi trong trò chơi. Mỗi người chơi có một ký tự duy nhất ('X' hoặc 'O') và có thể có tên người chơi.

### Game

Lớp `Game` là lớp chính điều khiển luồng chính của trò chơi Tic Tac Toe. Nó quản lý giao diện người dùng, lượt chơi của người chơi và kiểm tra kết quả của mỗi lượt chơi.

### Views

Lớp `Views` quản lý giao diện người dùng của trò chơi, bao gồm hiển thị thông tin người chơi và điểm số.

### GameLauncher

Lớp `GameLauncher` là lớp để chạy trò chơi. Nó khởi tạo và hiển thị giao diện người dùng chính của trò chơi, cho phép người chơi chọn chế độ chơi với bạn bè hoặc với bot.

Mỗi lớp trong dự án có trách nhiệm cụ thể và được thiết kế để tối ưu hóa quản lý trạng thái và tương tác người dùng trong trò chơi Tic Tac Toe.

## Cài đặt và chạy

1. Clone repo này về máy tính của bạn.

    ```bash
    git clone https://github.com/PhuongDaiThang/TicTacToeGAME.git
    ```

2. Mở dự án bằng IDE IntelliJ IDEA hoặc bất kỳ IDE Java nào.

3. Chạy file `GameLauncher.java` để bắt đầu trò chơi Tic Tac Toe.

## Yêu cầu

- Java Development Kit (JDK) phiên bản 8 trở lên.

## Hướng dẫn sử dụng

1. Khi chạy file `GameLauncher.java`, bạn sẽ thấy hai nút: "Play with a Friend" và "Play with a Bot". Chọn chế độ bạn muốn chơi.

2. Nếu chọn chế độ chơi với bạn, bạn sẽ được yêu cầu nhập tên cho Người chơi 1 và Người chơi 2. Nếu chọn chế độ chơi với bot, bạn sẽ chỉ cần nhập tên cho Người chơi 1.

3. Sau khi nhập tên, trò chơi sẽ bắt đầu và hiển thị lượt của người chơi đầu tiên hoặc bot.

4. Người chơi lần lượt click vào các ô trống trên bàn cờ để đặt 'X' hoặc 'O'. Nếu chơi với bot, bot sẽ tự động thực hiện lượt của mình.

5. Trò chơi sẽ kiểm tra kết quả sau mỗi lượt và thông báo nếu có người chơi chiến thắng hoặc hòa.

6. Sau mỗi trò chơi, bàn cờ sẽ được khởi tạo lại và lượt bắt đầu sẽ luân phiên giữa hai người chơi hoặc giữa người chơi và bot.

7. Tỉ số của hai người chơi sẽ được hiển thị ở phía trên cùng của cửa sổ trò chơi.

8. Bạn có thể nhấn nút "Finish" để kết thúc trò chơi và đóng cửa sổ.

## Tác giả

- Tên: Phuong Dai Thang
- GitHub: [PhuongDaiThang](https://github.com/PhuongDaiThang)

