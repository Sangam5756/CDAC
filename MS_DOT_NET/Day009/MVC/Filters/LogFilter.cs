using Microsoft.AspNetCore.Mvc.Filters;
using MVC.Logger;

namespace MVC.Filters { 
//               this sequence has to be match exactly

    public class LogFilter : Attribute,IActionFilter, IResultFilter
    {
        public void OnActionExecuted(ActionExecutedContext context)
        {
            FileLogger.CurrentLogger.Log("Received a call for " + context.HttpContext.Request.Path.Value);

        }

        public void OnActionExecuting(ActionExecutingContext context)
        {
            FileLogger.CurrentLogger.Log("Received a call for " + context.HttpContext.Request.Path.Value);
}

    public void OnResultExecuted(ResultExecutedContext context)
        {
            FileLogger.CurrentLogger.Log("Ui is successfull");
    }

    public void OnResultExecuting(ResultExecutingContext context)
        {
            FileLogger.CurrentLogger.Log("Ui is Being preparing");

    }
}
}
