

using DBCrud.model;
using Microsoft.Data.SqlClient;

namespace DBCrud.DAL
{
    internal class CourseDAL
    {

        public int AddCourse(Course course)
        {

            //get connection string
            String connectionString = "Data Source = (LocalDB)\\MSSQLLocalDB;Initial Catalog =iacsddb; Integrated Security=True";
            SqlConnection connection  = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand cmd = new SqlCommand("insert into course(name,price) values (@name,@price)", connection);

            cmd.Parameters.AddWithValue("@name", course.Name);
            cmd.Parameters.AddWithValue("@price", course.Price);



            int  rowsAffected=cmd.ExecuteNonQuery();

            return rowsAffected;
        }


        public int UpdateCourse(Course course)
        {

            //get connection string
            String connectionString = "Data Source = (LocalDB)\\MSSQLLocalDB;Initial Catalog =iacsddb; Integrated Security=True";
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand cmd = new SqlCommand("Update course set name=@name,price=@price where id =@id", connection);

            cmd.Parameters.AddWithValue("@name", course.Name);
            cmd.Parameters.AddWithValue("@price", course.Price);
            cmd.Parameters.AddWithValue("@Id", course.Id);



            int rowsAffected = cmd.ExecuteNonQuery();

            return rowsAffected;
        }

        public List<Course> GetCourse()
        {
            List<Course> courses = new List<Course>();
            // create the connection with db
            string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=IACSDDB;Integrated Security=True";

            //string ConnectionString= "Data Source =(LocalDB)\\MSSQLLocalDB;Initial Catalog=iacsddb;Integrated Security=True";
            SqlConnection connection1 = new SqlConnection(connectionString);
            connection1.Open();

            SqlCommand command = new SqlCommand("select * from course",connection1);

            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read()) { 
                Course course2 = new Course();

                course2.Id = Convert.ToInt32(reader["id"]);
                course2.Name=reader["name"].ToString();
                course2.Price =Convert.ToInt32(reader["price"]);
                courses.Add(course2);
            }

            return courses;



        }

        public string DeleteCourseById(int id)
        {
            

            //get connection string
            string connectionString = "Data Source = (LocalDB)\\MSSQLLocalDB;Initial Catalog =iacsddb; Integrated Security=True";
            SqlConnection connection  = new SqlConnection(connectionString);

            connection.Open();

            SqlCommand cmd = new SqlCommand("delete from course where id = @id",connection);

            cmd.Parameters.AddWithValue("@id", id);

            int rowsAffected = cmd.ExecuteNonQuery();
            return "Course Successfully Deleted " + rowsAffected;




        }

    }
}
