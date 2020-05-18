//******************************************************
// File: WorkerTests.cs
//
// Purpose: Contains the functionalities for Worker Testing Class. 
//          Through this class, you will test if Worker Class works or not. 
//          
//
// Written By: Mufrat Karim Aritra
//
// Compiler: Visual Studio 2019
//


using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Payroll_Solution;

namespace Payroll_Testing_Project
{
    [TestClass]
    public class WorkerTests
    {
        Worker h1 = new Worker();

        string t_name = "Adam Pacitti";
        int t_id = 121;
        double t_payrate = 11;

        [TestMethod]

        public void TestName()
        {
            h1.Name = t_name;

            if (h1.Name == t_name)
            {
                Console.WriteLine("Name Property, Valid Value: Pass");
            }
            else
            {
                Console.WriteLine("Name Property, Valid Value: FAIL!");
            }
        }

        [TestMethod]

        public void TestId()
        {

            h1.Id = t_id;
            if (h1.Id == t_id)
            {
                Console.WriteLine("Id Property, Valid Value: Pass");
            }
            else
            {
                Console.WriteLine("Id Property, Valid Value: FAIL!");
            }
        }

        [TestMethod]

        public void TestPayRate()
        {
            h1.Payrate = t_payrate;

            if (h1.Payrate == t_payrate)
            {
                Console.WriteLine("Payrate Property, Valid Value: Pass");
            }
            else
            {
                Console.WriteLine("Payrate Property, Valid Value: FAIL!");
            }
        }
    }
}
