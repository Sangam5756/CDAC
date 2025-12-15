using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MVC.Models
{
    [Table("Product")]
    public class Product
    {
        [Column("id",TypeName ="int")]
        [Key]
        public int Id { get; set; }


        [Column("title",TypeName ="varchar")]
        [MaxLength(50)]
        public string title { get; set; }

        [Column("description",TypeName="varchar")]
        [MaxLength(50)]

        public string description { get; set; }
       
        
        [Column("cost", TypeName = "int")]
        public int cost{ get; set; }
            
    
    }

    public class MyDBContext : DbContext
    {
        public DbSet<Product> Products { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=iacsddb ;Integrated Security=True");

        }

    }
}
