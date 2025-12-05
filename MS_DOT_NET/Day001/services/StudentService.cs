using System;
using Day001.Models;


namespace Day001.Services
{

    public interface StudentService
    {
        void RegisterStudent(Student s);

        List<Student> GetAllStudents();


    }


}