//******************************************************
// File: Department.cs
//
// Purpose: Contains the functionalities for Department Testing Class. 
//          Through this class, you will test if Department Class works or not. 
//          
//
// Written By: Mufrat Karim Aritra
//
// Compiler: Visual Studio 2019
//


using System;
using System.IO;
using System.Runtime.Serialization.Json;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Payroll_Solution;

namespace Payroll_Testing_Project
{
    [TestClass]
    public class DepartmentTests
    {

        Department d1 = new Department();


        [TestMethod]
        public void TestFindWithGoodId()
        {

            // Arrange
            Department d2;
            int validId = 112;

            // Desereailizing
            String fileName = "dept.json";
            FileStream reader = new FileStream(fileName, FileMode.Open, FileAccess.Read);

            DataContractJsonSerializer inputSerializer;
            inputSerializer = new DataContractJsonSerializer(typeof(Department));

            // Reading the JSON File
            d2 = (Department)inputSerializer.ReadObject(reader);
            reader.Close();



            // Act With Valid Id
            if (d2.FindWorker(validId) != null)
            {
                Console.WriteLine("Testing Successful");
            }
            else
            {
                Console.WriteLine("Testing Failed!!");
            }



        }


        [TestMethod]
        public void TestFindWithBadId()
        {

            // Arrange
            Department d2 = new Department();
            int invalidId = 175;

            // Desereailizing
            String fileName = "dept.json";
            FileStream reader = new FileStream(fileName, FileMode.Open, FileAccess.Read);

            DataContractJsonSerializer inputSerializer;
            inputSerializer = new DataContractJsonSerializer(typeof(Department));

            // Reading the JSON File
            d2 = (Department)inputSerializer.ReadObject(reader);
            reader.Close();



            // Act With Valid Id
            if (d2.FindWorker(invalidId) != null)
            {
                Console.WriteLine("Testing Successful");
            }
            else
            {
                Console.WriteLine("Testing Failed!!");
            }


        }

        [TestMethod]
        public void TestCalculatePay()
        {
            // Arrange
            Department d2;
            int validId = 112;

            // Desereailizing
            String fileName = "dept.json";
            FileStream reader = new FileStream(fileName, FileMode.Open, FileAccess.Read);

            DataContractJsonSerializer inputSerializer;
            inputSerializer = new DataContractJsonSerializer(typeof(Department));

            // Reading the JSON File
            d2 = (Department)inputSerializer.ReadObject(reader);
            reader.Close();

            // ReArranging
            double expected = d2.CalculatePay(validId);

            // Act With Valid Id
            if (expected > 0)
            {
                Console.WriteLine("Total Pay: " + expected);
                Console.WriteLine("Testing Successful");
            }
            else
            {
                Console.WriteLine("Testing Failed!!");
            }


        }
    }
}
