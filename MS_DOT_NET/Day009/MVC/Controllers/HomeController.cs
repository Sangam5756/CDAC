using Microsoft.AspNetCore.Mvc;
using MVC.Filters;
using MVC.Models;

namespace MVC.Controllers
{
    public class HomeController : BaseController
    {

        EmpDAL empObj = new EmpDAL();


        public IActionResult Create()
        {

            return View("Create");
        }


        public IActionResult AfterCreate(Emp emp)

        {
            empObj.AddEmp(emp);

            return Redirect("/");
        }

        public IActionResult Index()
        {
            List<Emp> emps = empObj.getEmps();

            return View("Index", emps);
        }

        public IActionResult Update(int Id)
        {
            Emp emp = empObj.GetEmp(Id);

            return View("Update", emp);


        }
        public IActionResult AfterUpdate(Emp emp,int Id)
        {
            
            empObj.UpdateEmp(emp);

                return Redirect("/");
            
        }

        public IActionResult Delete(int Id)
        {
            // call the method delete with empid so it will be deleted
            empObj.RemoveEmployee(Id);
            return Redirect("/");
        }
    }
}
