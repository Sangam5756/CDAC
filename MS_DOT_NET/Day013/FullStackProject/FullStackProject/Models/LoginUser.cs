using System.ComponentModel.DataAnnotations;

namespace FullStackProject.Models
{
    public class LoginUser
    {
        [Required(ErrorMessage ="Username is Required")]
        public string UserName { get; set; }

        [Required(ErrorMessage ="Password is Required")]
        public string Password { get; set; }
    }
}
