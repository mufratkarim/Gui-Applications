//******************************************************
// File: ShiftTests.cs
//
// Purpose: Contains the functionalities for Shift Testing Class. 
//          Through this class, you will test if Shift Class works or not. 
//          
//
// Written By: Mufrat Karim Aritra
//
// Compiler: Visual Studio 2019
//



using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Payroll_Solution;


namespace Payroll_Testing_Project
{
    [TestClass]
    public class ShiftTests
    {
        Shift s1 = new Shift();
        string t_workerId = "MKA007";
        double t_hoursWorked = 15;
        DateTime t_date = new DateTime(2020, 4, 2).AddHours(12).AddMinutes(00).AddSeconds(00).AddMilliseconds(00);



        [TestMethod]
        public void TestWorkerId()
        {
            s1.WorkerId = t_workerId;

            if (s1.WorkerId == t_workerId)
            {
                Console.WriteLine("Worker Id Property, Valid Value: Pass");
            }
            else
            {
                Console.WriteLine("Worker Id Property, Valid Value: FAIL!");
            }



        }

        [TestMethod]
        public void TestHoursWorked()
        {
            s1.HoursWorked = t_hoursWorked;

            if (s1.HoursWorked == t_hoursWorked)
            {
                Console.WriteLine("Hours Worked Property, Valid Value: Pass");
            }
            else
            {
                Console.WriteLine("Hours Worked Property, Valid Value: FAIL!");
            }



        }

        [TestMethod]
        public void TestDate()
        {
            s1.Date = t_date;

            if (s1.Date == t_date)
            {
                Console.WriteLine("Date Property, Valid Value: Pass");

            }
            else
            {
                Console.WriteLine("Date Property, Valid Value: FAIL!");

            }

        }
    }
}
