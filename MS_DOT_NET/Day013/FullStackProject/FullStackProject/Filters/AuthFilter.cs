using Microsoft.AspNetCore.Mvc.Filters;

namespace FullStackProject.Filters
{
    public class AuthFilter :ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            if(context.HttpContext.Session.GetString("UserName") == null)
            {
                context.HttpContext.Response.Redirect("/Login/SignIn");
            }
        }
    }
}
