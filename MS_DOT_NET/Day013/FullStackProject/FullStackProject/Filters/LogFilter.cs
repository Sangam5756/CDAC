using Microsoft.AspNetCore.Mvc.Filters;
using FullStackProject.Logger;
namespace FullStackProject.Filters
{
    public class LogFilter :ActionFilterAttribute
    {

        public override void OnActionExecuting(ActionExecutingContext context)
        {
            FileLogger.CurrentLogger.log("Called "+context.HttpContext.Request.Path);
            
        }

        public override void OnActionExecuted(ActionExecutedContext context)
        {
            FileLogger.CurrentLogger.log("Completed "+context.HttpContext.Request.Path);
        }

    }
}
