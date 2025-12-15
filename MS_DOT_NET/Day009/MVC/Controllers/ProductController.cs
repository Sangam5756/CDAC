using Microsoft.AspNetCore.Mvc;
using MVC.Models;

namespace MVC.Controllers
{
    public class ProductController : Controller
    {
        MyDBContext dbObject = new MyDBContext();
        public IActionResult Index()
        {
            var products = dbObject.Products.ToList();
            return View("Index",products);
        }

        public IActionResult Create()
        {
            return View("Create");
        }
        public IActionResult AfterCreate(Product p)
        {
            dbObject.Products.Add(p);
            dbObject.SaveChanges();

            return Redirect("/product/index");
        }

        public IActionResult Update(int id)
        {
            Product p =dbObject.Products.Find(id);

            return View("/product/Update", p);

        }
        public IActionResult AfterUpdate(Product p,int id)
        {
            Product UpdateProduct = dbObject.Products.Find(id);
            UpdateProduct.title = p.title;
            UpdateProduct.description = p.description;
            UpdateProduct.cost = p.cost;
            dbObject.SaveChanges();

            return View("/product/Update", p);

        }


    }
}
