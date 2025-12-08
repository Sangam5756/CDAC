using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DBCrud.model
{
    internal class Course
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Price{ get; set; }

        public override string ToString()
        {
            return string.Format("id = {0}, name = {1}, price={2}", Id, Name, Price);

        }
    }
}
