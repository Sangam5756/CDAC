using System;

namespace Day001.Models
{


   public  class Student
    {

        private string _name;
        private int _roll;

        private string _password;


        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public int Roll
        {
            get { return _roll; }
            set { _roll = value; }
        }

        public string Password
        {
            get { return _password; }
        }


        public Student(int rollno, string name, string password)
        {
            _roll = rollno;
            _name = name;
            _password = password;
        }


        // tostring method same as in java
        public override string ToString()
        {
            return "Name : "+Name+" RollNo "+Roll;
        }

    }
}