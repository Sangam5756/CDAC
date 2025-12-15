using Microsoft.AspNetCore.Mvc;
using MVC.Filters;

namespace MVC.Controllers
{
    [LogFilter]
    public class BaseController :Controller
    {

    }
}
