using FullStackProject.Filters;
using FullStackProject.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace FullStackProject.Controllers
{
    [LogFilter]
    public class LoginController : Controller
    {
        public IActionResult SignIn(LoginUser user)
        {
            if (ModelState.IsValid)
            {
                if (user.UserName == "test" && user.Password == "test@123")
                {
                    HttpContext.Session.SetString("UserName", user.UserName);
                   return Redirect("/Home/Index");
                }
                else
                {
                    ViewBag.Message = "Invalid Credentials";
                    return View(user);
                }
            }
            else
            {

                return View(user);

            }
        }

        public IActionResult SignOut()
        {
            HttpContext.Session.Remove("UserName");
            return Redirect("/Login/SignIn");
        }


    }





}
