
using DBCrud.DAL;
using DBCrud.model;
namespace DBCrud
{



class Program
{
        public static void Main(String[] args)
    {
        CourseDAL courseDal = new CourseDAL();

            int ch;
            do
            {
                
            Console.WriteLine("1.Add Course:");
            Console.WriteLine("2.Display Course:");
            Console.WriteLine("3.Delete Course:");
            Console.WriteLine("4.Update Course:");
            Console.WriteLine("0. Exit System:");

            Console.WriteLine("Enter the Choice :");
             ch =Convert.ToInt32(Console.ReadLine());

                switch (ch)
                {
                    case 1:
                        {
                            Course newCourse = new Course();
;                            Console.WriteLine("--------------------------------------");
                            Console.WriteLine("Enter the Course Name");
                            newCourse.Name =Console.ReadLine();
                            Console.WriteLine("Enter the Course Price");
                            newCourse.Price=Convert.ToInt32(Console.ReadLine());
                            courseDal.AddCourse(newCourse);
;                            Console.WriteLine("--------------------------------------");
                            break;
                        }
                    case 2:
                        {

                            Console.WriteLine("Displaying  course");
                            List<Course> courses = courseDal.GetCourse();
                            foreach (var item in courses)
                            {
                                Console.WriteLine(item.ToString());
                            }
                            break;
                        }
                    case 3:
                        {

                            Console.WriteLine("Deleting course");
                            int id = Convert.ToInt32(Console.ReadLine());
                            Console.WriteLine(courseDal.DeleteCourseById(id));
                            break;
                        }
                    case 4:
                        {
                            Course newCourse = new Course();
                            ; Console.WriteLine("--------------------------------------");
                            Console.WriteLine("Enter the CourseId to Update Course");
                            newCourse.Id = Convert.ToInt32(Console.ReadLine());
                            Console.WriteLine("Enter the NewCourse Name");
                            newCourse.Name = Console.ReadLine();
                            Console.WriteLine("Enter the NewCourse Price");
                            newCourse.Price = Convert.ToInt32(Console.ReadLine());
                            courseDal.UpdateCourse(newCourse);
                            ; Console.WriteLine("--------------------------------------");
                            break;
                        }
                    case 0:
                        {

                            Console.WriteLine("Exit");
                            break;
                        }


                }



            }
            while (ch != 0);

            
           

        }

}

    


}