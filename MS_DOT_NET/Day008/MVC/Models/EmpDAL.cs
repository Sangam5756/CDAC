using Microsoft.Data.SqlClient;
using Microsoft.Identity.Client;
namespace MVC.Models
{
    public class EmpDAL
    {
        private string connectionString = "Data Source =(LocalDB)\\MSSQLLocalDB;Initial Catalog=iacsddb ;Integrated Security=True";

        public List<Emp> getEmps()
        {
            List<Emp> emps = new List<Emp>();


            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("select * from emp", connection);

            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())

            {
                Emp emp = new Emp();
                emp.Id = Convert.ToInt32(reader["id"]);
                emp.Name = reader["Name"].ToString();
                emp.Address = reader["Address"].ToString();
                emps.Add(emp);
            }

            return emps;



        }

        public int AddEmp(Emp emp)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand cmd = new SqlCommand("insert into emp(name,address) values (@name,@address)", connection);
            cmd.Parameters.AddWithValue("Name", emp.Name);
            cmd.Parameters.AddWithValue("Address", emp.Address);

            int inserted = cmd.ExecuteNonQuery();
            return inserted;
        }


        public Emp GetEmp(int empId)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand cmd = new SqlCommand("Select * from emp where id=@id", connection);
            cmd.Parameters.AddWithValue("@id", empId);
            SqlDataReader reader = cmd.ExecuteReader();
            Emp emp = new Emp();
            while (reader.Read())
            {
                emp.Id = Convert.ToInt32(reader["Id"]);
                emp.Name = reader["Name"].ToString();
                emp.Address = reader["Address"].ToString();

            }
            return emp;
        }
    


      public int UpdateEmp(Emp emp)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand cmd = new SqlCommand("update Emp set Name=@name,Address=@address where Id=@id", connection);
            cmd.Parameters.AddWithValue("@name", emp.Name);
            cmd.Parameters.AddWithValue("@address", emp.Address);
            cmd.Parameters.AddWithValue("@id", emp.Id);
            int inserted = cmd.ExecuteNonQuery();
            return inserted;
        }

        internal int RemoveEmployee(int id)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            SqlCommand cmd = new SqlCommand("Delete From Emp where Id =@id", connection);
            cmd.Parameters.AddWithValue("@id", id);
            return cmd.ExecuteNonQuery();
        }
    }
}
