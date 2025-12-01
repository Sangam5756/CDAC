
using Day001.Models;
using Day001.Services;


class Program
{
    static void Main()
    {

        StudentService StudentService = new StudentServiceImpl();

        int ch;
        do
        {

            Console.WriteLine("1. Add Student");
            Console.WriteLine("2. Display Student");
            Console.WriteLine("0.Exit Program");
            Console.WriteLine("Enter the Choice : ");
            ch = Convert.ToInt32(Console.ReadLine());

            // switch
            switch (ch)
            {
                case 1:
                    {
                        Console.WriteLine("Enter the Roll No : ");
                        string xroll = Console.ReadLine() ?? "";
                        int roll = Convert.ToInt32(xroll);

                        Console.WriteLine("Enter the Name : ");
                        string name = Console.ReadLine() ?? ""; ;

                        Console.WriteLine("Enter the Password : ");
                        string password = Console.ReadLine() ?? ""; ;

                        StudentService.RegisterStudent(new Student(roll, name, password));

                        break;
                    }

                case 2:
                    {
                        StudentService.GetAllStudents();
                        break;
                    }



                default:
                    break;
            }




        } while (ch != 0);




    }
}
