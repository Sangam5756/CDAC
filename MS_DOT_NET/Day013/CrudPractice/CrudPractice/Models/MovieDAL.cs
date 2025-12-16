using Microsoft.Data.SqlClient;

namespace CrudPractice.Models
{
    public class MovieDAL
    {

        private string conectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=labDb;Integrated Security=True;Pooling=False;Encrypt=True;Trust Server Certificate=False";


        public List<Movie> getAllMovies()
        {

            List<Movie> movies = new List<Movie>();

            SqlConnection connection = new SqlConnection(conectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("select * from movie", connection);
            SqlDataReader read = cmd.ExecuteReader();

            while (read.Read())
            {
                Movie movie = new Movie();
                movie.Id = Convert.ToInt32(read["Id"]);
                movie.Name = read["name"].ToString();
                movie.Price= Convert.ToInt32(read["price"]);
                movie.Date = Convert.ToDateTime(read["date"]);

                movies.Add(movie);


            }



            return movies;

        }


        public Movie getMovieById(int id)
        {
            SqlConnection connection = new SqlConnection(conectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("select * from movie where id=@id", connection);
            cmd.Parameters.AddWithValue("@id", id);

            SqlDataReader read = cmd.ExecuteReader();

                Movie movie = new Movie();
            while (read.Read())
            {
                movie.Id = Convert.ToInt32(read["Id"]);
                movie.Name = read["name"].ToString();
                movie.Price = Convert.ToInt32(read["price"]);
                movie.Date = Convert.ToDateTime(read["date"]);

            


            }

            return movie;

        }



        public int RemoveMovieById(int id)
        {
            SqlConnection connection = new SqlConnection(conectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("delete from movie where id=@id", connection);
            cmd.Parameters.AddWithValue("@id", id);

            int rowsAffectd= cmd.ExecuteNonQuery();

          
            return rowsAffectd;

        }

        public int AddMovie(Movie movie)
        {

            SqlConnection connection = new SqlConnection(conectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("insert into movie(name,price,date) values(@name,@price,@date)", connection);
            cmd.Parameters.AddWithValue("@name", movie.Name);
            cmd.Parameters.AddWithValue("@price", movie.Price);
            cmd.Parameters.AddWithValue("@date", movie.Date);

            int row = cmd.ExecuteNonQuery();

            return row;

        }



        public int UpdateMovie(Movie movie)
        {

            SqlConnection connection = new SqlConnection(conectionString);
            connection.Open();

            SqlCommand cmd = new SqlCommand("update movie set name=@name,price=@price,date=@date where id=@id", connection);
            cmd.Parameters.AddWithValue("@name", movie.Name);
            cmd.Parameters.AddWithValue("@price", movie.Price);
            cmd.Parameters.AddWithValue("@date", movie.Date);
            cmd.Parameters.AddWithValue("@id", movie.Id);


            int row = cmd.ExecuteNonQuery();

            return row;

        }



    }
}
