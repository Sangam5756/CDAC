using Microsoft.AspNetCore.Mvc;

using FullStackProject.Filters;
using FullStackProject.Models;
namespace FullStackProject.Controllers
{
    [LogFilter]
    public class HomeController : Controller
    {

        StudentViewModel studentViewModel = new StudentViewModel();

        [AuthFilter]
        public IActionResult Index()
        {
            ViewBag.Title = "Home";
            ViewBag.UserName = GetUserName();

            List<Student> students = studentViewModel.getAllStudents();
            return View(students);
        }

        public IActionResult Create()
        {
            return View();
        }

        public IActionResult AfterCreate(Student student)
        {
            if (ModelState.IsValid)
            {
                studentViewModel.AddStudent(student);
                return Redirect("/Home/Index");
            }
            else
            {
                ViewBag.Message = "Something Wrong With Data";
                return View("Create",student);
            }
        }


        public IActionResult Update(int Id)
        {
            Student student = studentViewModel.getStudent(Id);
            return View(student);
        }

        public IActionResult Delete(int Id)
        {
            int student = studentViewModel.RemoveStudent(Id);

            return Redirect("/Home/Index");
        }

        [AuthFilter]
        [HttpPost]
        public IActionResult AfterUpdate(Student student)
        {
            if (ModelState.IsValid)
            {

                Student updateStudent = new Student();
                updateStudent.Name = student.Name;
                updateStudent.Email = student.Email;
                    updateStudent.Address = student.Address;
                updateStudent.Age = student.Age;

                studentViewModel.UpdateStudent(student);
              return Redirect("/Home/Index");
            }
            else
            {
                return View("Update", student);

            }

           
            

        }



        public IActionResult About()
        {
            ViewBag.Title = "About Us";
            ViewBag.UserName = GetUserName();

            return View();
        }
        public IActionResult Contact()
        {
            ViewBag.Title = "Contact Us";
            ViewBag.UserName = GetUserName();

            return View();
        }


        private String GetUserName()
        {
            if (HttpContext.Session.GetString("UserName") != null && HttpContext.Session.GetString("UserName") != "")
            {
                return HttpContext.Session.GetString("UserName");
            }
            else
            {
                return "Guest";
            }
        }



    }
}
