using System.ComponentModel.DataAnnotations;

namespace FullStackProject.Models
{
    public class Student
    {


        public int No { get; set; }


        [Required(ErrorMessage ="Name is Required")]
        public string Name { get; set; }
        

        [Required(ErrorMessage ="Address is Required")]
        public string Address { get; set; }


        [Required(ErrorMessage = "Email is Required")]
        public string  Email  { get; set; }

        [Required(ErrorMessage = "Age is Required")]
        [Range(20,40,ErrorMessage ="Age Should be Between 20 to 40")]
        public int Age { get; set; }


        public bool IsEmailValidated     { get; set; }

    }
}
