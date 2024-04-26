package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			// this is for create a student and save it to databae
			// createStudent(studentDAO);

			// this is for create multiple students and save them to database
			createMultipleStudents(studentDAO);

			// this is for create a student and retrieve it from database
			// readStudent(studentDAO);

			// this is for retrieving whole records at database
			// queryForStudent(studentDAO);

			// this is for retrieving by lastname from database
			// queryForStudentsByLastName(studentDAO);

			// this is for updating on database
			// updateStudent(studentDAO);

			// this is delete a student from database
			// deleteStudent(studentDAO);

			// this is for delete all records from database
			// deletAllStudents(studentDAO);
		};
	}

	private void deletAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete the student
		int studentId = 3;
		System.out.println("Deleting student id : " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve students based on the id : primary key
		int studentId = 4;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change firstName to "Karan"
		System.out.println("Updating student...");
		myStudent.setFirstName("Karan");    // ingilizce karakterler kullanılmalı !!!!!!
		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println("Updated student" + myStudent);   // using toSting method
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Tamer");
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Mustafa Efe", "Tamer", "efetamer8@gmail.com");
		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved student. Generated id : " + tempStudent.getId());
		// retrieve student based on the id : primary key
		System.out.println("Retrieving student with id : " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());              //*ASIL OLAY BURADA*
		// display student
		System.out.println("Found the student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Createing 3 student objects ...");
		Student tempStudent = new Student("Pinar Sena", "Kayabasi", "pinarsena@gmail.com");   // isimleri yazarken ingilizce karakter kullan sadece
		Student tempStudent2 = new Student("Ayse Nisanur", "Tamer", "zeynepsude@gmail.com");  // isimleri yazarken ingilizce karakter kullan sadece
		Student tempStudent3 = new Student("Zeynep Sude", "Tamer", "nisanur@gmail.com");      // isimleri yazarken ingilizce karakter kullan sadeces

		// save the students object to database
		System.out.println("Saving the students");
		studentDAO.save(tempStudent);        //*ASIL OLAY BURADA*
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Mustafa Efe", "Tamer", "efetamer8@gmail.com");

		// save the student object to database
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);          //*ASIL OLAY BURADA*

		// display id of the saved student
		System.out.println("Saved student. Generated id : " + tempStudent.getId());
	}
}
