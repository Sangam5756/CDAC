using Microsoft.Data.SqlClient;

namespace FullStackProject.Models
{
    public class StudentViewModel
    {

        private string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=labDb;Integrated Security=True";

        public List<Student> getAllStudents()
        {

            List<Student> students = new List<Student>();

            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("select * from Student", connection);

            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Student student = new Student();
                student.No = Convert.ToInt32(reader["No"]);
                student.Name = reader["Name"].ToString();
                student.Address = reader["Address"].ToString();
                student.Email = reader["Email"].ToString();
                student.Age = Convert.ToInt32(reader["Age"]);
                student.IsEmailValidated = Convert.ToBoolean(reader["IsEmailValidated"]);

                students.Add(student);
            }

            connection.Close();




            return students;


        }



        public Student getStudent(int No)
        {
            List<Student> students = getAllStudents();

            Student filteredStudent = (from student in students where student.No == No select student).First();
            return filteredStudent;
        }
    


    public int AddStudent(Student student)
        {
            SqlConnection connection = new SqlConnection(connectionString);

            connection.Open();
            SqlCommand cmd = new SqlCommand("insert into Student(Name,Address,Age,Email,IsEmailValidated) Values(@name,@adr,@age,@email,@isValid)", connection);
            cmd.Parameters.AddWithValue("@name", student.Name);
            cmd.Parameters.AddWithValue("@adr", student.Address);
            cmd.Parameters.AddWithValue("@age", student.Age);
            cmd.Parameters.AddWithValue("@email", student.Email);
            cmd.Parameters.AddWithValue("@isValid", false);

            int count = cmd.ExecuteNonQuery();


            return count;


        }

        public int UpdateStudent(Student student)
        {
            SqlConnection connection = new SqlConnection(connectionString);

            connection.Open();
            SqlCommand cmd = new SqlCommand("Update Student SET Name=@name,Address=@adr,Age=@age,Email=@email,IsEmailValidated=@IsValid where No=@no", connection);
           
            cmd.Parameters.AddWithValue("@name", student.Name);
            cmd.Parameters.AddWithValue("@adr", student.Address);
            cmd.Parameters.AddWithValue("@age", student.Age);
            cmd.Parameters.AddWithValue("@email", student.Email);
            cmd.Parameters.AddWithValue("@isValid", false);
            cmd.Parameters.AddWithValue("@no", student.No);

            int count = cmd.ExecuteNonQuery();


            return count;


        }

        public int RemoveStudent(int Id)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("Delete Student where No=@no", connection);
            cmd.Parameters.AddWithValue("@no", Id);

            int count = cmd.ExecuteNonQuery();

            return count;


        }





    }


}
