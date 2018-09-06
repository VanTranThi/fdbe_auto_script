# fdbe_auto_script
1. Checkout project về máy 
2. Download Eclipse http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-win32-x86_64.zip 
3. Giải nén thư mục Lib.zip, chạy file jdk (thư mục này copy ra ngoài project)
4. Setup biến môi trường: 
	- Mở Control Panel, vào mục như hình http://prntscr.com/kf8sqi
	- Chọn Enviroment Variables, ở phần System Variables add 2 biến JAVA_HOME (link dẫn tới thư mục jdk) và M2_HOME (link dẫn tới thư mục apache-maven-3.5.4 trong thư mục Lib vừa giải nén)
	- Ở line Path, add new %JAVA_HOME%\bin và %M2_HOME%\bin
	- Để kiểm tra xem đã cài đặt thành công chưa, ấn Window + R, gõ câu lệnh java -version và mvn -version nếu thành công, nó sẽ hiển thị bản version được cài đặt
5. Download firefox <= version 47 (vì selenium chưa hỗ trợ firefox mới nhất), và set không cho firefox update
6. Vào Eclipse -> Help -> Eclipse Marketplace -> search theo key TestNG, install testNG for Eclipse
7. Import maven project với Eclipse, click chuột phải vào tên project -> Maven -> Update project
8. Click chuột phải vào tên project -> Build path -> configure build path -> ở tab Libraries, click add external JARs -> Xóa hết các thư mục lỗi và mở đường link dẫn tới thư mục selenium-2.53.0 trong forder Lib vừa giải nén, select tất cả các file trong thư mục libs và file selenium-java-2.53.0.jar
8. Click Add Library, add thư viện TestNG
9. Để chạy được các testscript, chọn mysuilt.xml trong package src/main/resources click Run as with TestNG
