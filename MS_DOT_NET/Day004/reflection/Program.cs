using System.Reflection;
using System.Security.Cryptography.X509Certificates;
using System.Text.Json.Serialization;

public class Program
{
        


    public static void Main(string[] args)
    {
        #region Type checking
        //Console.WriteLine(t);
        ////its like checking the class full name
        //Type t = typeof(Student);
        #endregion


        Type t = typeof(Student);

        #region Accessing Public private Properites via reflection
        //Console.WriteLine(t);
        //// only the public properties will be 
        //var props = t.GetProperties(); //to get properties of the class
        //foreach (var p in props)
        //{
        //    Console.WriteLine("Property " + p.Name + "|   Type  " + p.PropertyType);

        //}

        //// to get the private properties we need to use the flag specify
        //// now we can also see the private properties of the class also
        //var fields = t.GetFields(
        //    BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Instance);
        //foreach (var item in fields)
        //{
        //    Console.WriteLine("Field Name " + item.Name + " | FieldType " + item.FieldType);
        //}

        //Console.WriteLine();


        #endregion


        #region Accessing the Public and Private , static Methods

        //Console.WriteLine("Running the code");
        //var methods = t.GetMethods(
        //    BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Instance | BindingFlags.Static);
        //foreach (var item in methods)
        //{
        //    Console.WriteLine("Method: " + item.Name);
        //}


        #endregion

        #region Accessing the Constructors

        //Console.WriteLine("Running the code");
        //var methods = t.GetConstructors( BindingFlags.Public |BindingFlags.NonPublic | BindingFlags.Instance);
        //foreach (var item in methods)
        //{
        //    Console.WriteLine("Constructor: " + item);
        //}


        #endregion


        #region Accessing Special Attributes of class

        //    var attrs = t.GetCustomAttributes();
        //foreach (var a in attrs)
        //{
        //    Console.WriteLine("Attribute: " + a.GetType());
        //}


        #endregion


        #region creating the instance of class using reflection

        //object stu = Activator.CreateInstance(t);
        //    if(stu is Student)
        //{
        //    Student student = (Student)stu;
        //    student.print();
        //}



        #endregion


        #region
               var staticMethod = t.GetMethod("print1",BindingFlags.Static| BindingFlags.Public);
        staticMethod.Invoke(null,null);
        #endregion

        Console.WriteLine();
    }
}


[Serializable]
class Student
{
    public int id { get; set; }
    private string cardNo;

    public Student()
 
    {


      
    }

    private Student(string name) { }
    public static void print1() => Console.WriteLine("print2");
    public Student(int id)
    {
        this.id = id;
    }
    public void print() => Console.WriteLine(id);
}