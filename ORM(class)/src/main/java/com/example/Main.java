package com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
// docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=school -p 3306:3306 -d mysql:8
// mvn compile exec:java -Dexec.mainClass="com.example.Main"

public class Main {

	public static void main(String[] args) {
		System.out.println("hello");

		//createStudents();
		//enrollStudents();
		//getStudents();
		//getStudentEnrollments();
		getStudentEnrollmentsByAge();

	}
	@SuppressWarnings("ConvertToTryWithResources")
	public static void createStudents() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Student susan = new Student();
			susan.setName("Susan");
			susan.setAge(49);

			Student bob = new Student();
			bob.setName("Bob");
			bob.setAge(34);

			em.persist(susan);
			em.persist(bob);

			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());

		} finally {
			em.close();
			emf.close();
		}
	}
	@SuppressWarnings("ConvertToTryWithResources")
	public static void enrollStudents() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
		EntityManager em = emf.createEntityManager();

		try {
			// ManyToMany
			em.getTransaction().begin();

			Course courseDB = new Course();
            courseDB.setTitle("Databases");
 
            Course courseJava = new Course();
            courseJava.setTitle("Java II");
 
            em.persist(courseDB);
            em.persist(courseJava);
 
            Student susan = em.find(Student.class, 9);
            if (susan != null) {
                System.out.println(susan.getName() + " (age " + susan.getAge() + ")");
            } else {
                System.out.println("No student with id=9");
            }
 
            Student bob = em.find(Student.class, 10);
            if (bob != null) {
                System.out.println(bob.getName() + " (age " + bob.getAge() + ")");
            } else {
                System.out.println("No student with id=10");
            }
 
            susan.enroll(courseDB);
           
            bob.enroll(courseDB);
            bob.enroll(courseJava);

			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());

		} finally {
			em.close();
			emf.close();
		}

	}

    @SuppressWarnings("ConvertToTryWithResources")
	public static void getStudents() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			List<Student> students = em.createQuery("SELECT s FROM Student s ORDER BY s.name", Student.class)
                    .getResultList();
 
            System.out.println("\nStudents:");
            students.forEach(
                    s -> System.out.println(" - [" + s.getId() + "] " + s.getName() + " (age " + s.getAge() + ")"));
			
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());

		} finally {
			em.close();
			emf.close();
		}
	}

    @SuppressWarnings("ConvertToTryWithResources")
	public static void getStudentEnrollments() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			System.out.println("\nStudent Enrollments:");
            List<Student> allStudents = em.createQuery("SELECT s FROM Student s ORDER BY s.name", Student.class)
                    .getResultList();
 
            for (Student s : allStudents) {
                System.out.println(s.getName() + " enrolled in:");
                for (Course c : s.getCourses()) {
                    System.out.println("  - " + c.getTitle());
                }
            }

			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());

		} finally {
			em.close();
			emf.close();
		}
	}
	@SuppressWarnings("ConvertToTryWithResources")
	public static void getStudentEnrollmentsByAge() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			System.out.println("\nStudents > 35 enrolled in 'Databases':");
            List<Student> students35 = em.createQuery(
                    "SELECT DISTINCT s FROM Student s JOIN s.courses c WHERE c.title = :title AND s.age > :age",
                    Student.class)
                    .setParameter("title", "Databases")
                    .setParameter("age", 35)
                    .getResultList();
            students35.forEach(s -> System.out.println(" - " + s.getName()));

			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());

		} finally {
			em.close();
			emf.close();
		}
	}

}
