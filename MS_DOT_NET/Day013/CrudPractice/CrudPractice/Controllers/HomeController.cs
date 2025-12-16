using Microsoft.AspNetCore.Mvc;
using CrudPractice.Models;
namespace CrudPractice.Controllers
{


    
    public class HomeController : Controller
    {

        MovieDAL md = new MovieDAL();
        
        public IActionResult Index()
        {
            List<Movie> movies = md.getAllMovies();
            return View(movies);
        }
            

        public IActionResult Create()
        {
            return View();
        }


        public IActionResult AfterCreate(Movie movie)
        {
            int v = md.AddMovie(movie);

            return Redirect("/Home/Index");
        }

        public IActionResult Update(int id)
        {
            Movie movie = md.getMovieById(id);
            return View(movie);

        }

        public IActionResult AfterUpdate(Movie movie)
        {
            int row = md.UpdateMovie(movie);
            return Redirect("/Home/Index");

        }
        public IActionResult Delete(int id)
        {
            int v = md.RemoveMovieById(id);
            return Redirect("/Home/Index");
        }



    }
}
