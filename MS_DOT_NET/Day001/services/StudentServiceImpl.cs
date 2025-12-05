using System;
using Day001.Models;



namespace Day001.Services
{


    public class StudentServiceImpl : StudentService
    {

        List<Student> students = new List<Student>();


        public List<Student> GetAllStudents()
        {

            foreach (Student s in students)
            {
                    Console.WriteLine(s);
            }

            return students;
        }


        public void RegisterStudent(Student s)
        {
            // students.Add(new Student(1, "Sangam", "password"));
            students.Add(s);

            Console.WriteLine("Student Registered Successfully");

        }

    }
}