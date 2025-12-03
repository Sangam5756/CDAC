using System;
class Program
{

    public static void Main(string[] args)
    {
        IAdminPayment adminView = new PaymentProcessor();
        Console.WriteLine(adminView.CalculateTotal(1000));
        // Output: 1000

        IFinancePayment financeView = new PaymentProcessor();
        Console.WriteLine(financeView.CalculateTotal(1000));
        // Output: 1000 + 18% tax + 2% fee = 1200


    }



    public interface IAdminPayment
    {
        decimal CalculateTotal(decimal amount);
    }

    public interface IFinancePayment
    {
        decimal CalculateTotal(decimal amount);
    }

    class PaymentProcessor : IAdminPayment, IFinancePayment
    {

        // admin 
        decimal IAdminPayment.CalculateTotal(decimal amount)
        {
            return amount;
        }
        Decimal IFinancePayment.CalculateTotal(Decimal amount)
        {
            decimal tax = amount * 0.18m;
            decimal platformFee = amount * 0.02m;
            return amount + tax + platformFee;
        }
    }
}