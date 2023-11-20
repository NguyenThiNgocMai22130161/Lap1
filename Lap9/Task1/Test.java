package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
		public static void main(String[] args) {
	        // Tạo đối tượng Faculty
	        Facutly faculty = new Facutly();
	        faculty.setName("Khoa CNTT");
	        faculty.setAddress("Đại học Nông Lâm");

	     // Tạo danh sách học phần
	        List<Course> courses = new ArrayList<>();

	        // Học phần 1
	        Course course1 = new Course();
	        course1.setId("01");
	        course1.setTitle("Cấu trúc dữ liệu");
	        course1.setType("thực hành");
	        
	        // Thêm sinh viên vào học phần 1
	        List<Student> students1 = new ArrayList<>();
	        students1.add(new Student("22130161", "Nguyễn Thị Ngọc Mai", 2022));
	        students1.add(new Student("22130178", "Trần Thị Bình", 2022));
	        students1.add(new Student("22130123", "Lê Văn Chí", 2023));
	        course1.setStudents(students1);

	        courses.add(course1);

	        // Học phần 2
	        Course course2 = new Course();
	        course2.setId("02");
	        course2.setTitle("Nhập môn trí tuệ nhân tạo");
	        course2.setType("lý thuyết");

	        // Thêm sinh viên vào học phần 2
	        List<Student> students2 = new ArrayList<>();
	        students2.add(new Student("22130111", "Phạm Thị Diệu", 2022));
	        students2.add(new Student("22130222", "Hoàng Văn Em", 2023));
	        course2.setStudents(students2);

	        courses.add(course2);

	        // Thiết lập danh sách học phần cho khoa
	        faculty.setCourse(courses);


	        // Gọi phương thức getMaxPracticalCourse() và in thông tin học phần có nhiều sinh viên đăng ký nhất
	        Course maxPracticalCourse = faculty.getMaxPracticalCourse();

	        if (maxPracticalCourse != null) {
	            System.out.println("Học phần thực hành có nhiều sinh viên đăng ký nhất:");
	            System.out.println("Mã số: " + maxPracticalCourse.getId());
	            System.out.println("Tiêu đề: " + maxPracticalCourse.getTitle());
	        } else {
	            System.out.println("Không có học phần thực hành.");
	        }
	        System.out.println();
	     // Gọi phương thức groupStudentsByYear() và in danh sách sinh viên theo năm vào học
	        Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();

	        if (!studentsByYear.isEmpty()) {
	            System.out.println("Danh sách sinh viên theo năm vào học:");
	            for (Map.Entry<Integer, List<Student>> entry : studentsByYear.entrySet()) {
	                int year = entry.getKey();
	                List<Student> students = entry.getValue();

	                System.out.println("Năm " + year + ":");
	                for (Student student : students) {
	                	System.out.println("Mã số sinh viên: " + student.getId());
	                    System.out.println("Họ tên sinh viên: " + student.getName());
	                }
	                System.out.println();
	            }
	        } else {
	            System.out.println("Không có sinh viên.");
	        }
	     // Phương thức filterCourses(String type)
	        String type = "thực hành";
	        //String type = "lý thuyết";
	        Set<Course> filteredCourses = faculty.filterCourses(type);
	        if (!filteredCourses.isEmpty()) {
	            System.out.println("Danh sách học phần theo loại " + type + ":");
	            for (Course course : filteredCourses) {
	                System.out.println("Mã khóa học: " + course.getId());
	                System.out.println("Tên khóa học: " + course.getTitle());
	                System.out.println("Số lượng sinh viên đăng ký: " + course.getStudents().size());
	                System.out.println();
	            }
	        } else {
	            System.out.println("Không có khóa học theo loại đã cho.");
	        }
	     
	    }
}
	              