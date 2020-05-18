//******************************************************
// File: Department.cs
//
// Purpose: Contains the functionalities for Department Class. 
//          Functionalities include members, findWorker/CalculatePay methods, toString, Serailization Statements 
//          
//
// Written By: Mufrat Karim Aritra
//
// Compiler: Visual Studio 2019
//

using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Payroll_Solution
{
    [DataContract]
    public class Department
    {
        private string name;
        private List<Worker> workers;
        private List<Shift> shifts;

        public Department()
        {
            name = "Roger";
            workers = new List<Worker>();
            shifts = new List<Shift>();
        }

        /*
        Method: C# Properties

        Purpose: Serializes with DataMember, and uses C# properies with get-set
        */
        [DataMember(Name = "name")]
        public string Name { get { return name; } set { name = value; } }
        [DataMember(Name = "workers")]
        public List<Worker> Workers { get { return workers; } set { workers = value; } }
        [DataMember(Name = "shifts")]
        public List<Shift> Shifts { get { return shifts; } set { shifts = value; } }


        /*
        Method: FindWorker

        Purpose: Finds out the Worker
        */
        public Worker FindWorker(int workerId)
        {
            
            for (int i = 0; i < workers.Count; i++)
            {
                
                if (workerId == workers[i].Id)
                {
                    Console.WriteLine(workers[i] + "\n");
                    return workers[i];
                }

            }

            Console.WriteLine("Invalid Input!!!\n");
            return null;
        }

        /*
        Method: Calculate Pay

        Purpose: Calculates the total wages of the particular worker
        */
        public double CalculatePay(int workerId)
        {
            double totalHours = 0;
            double payrate = 0;

            for (int i = 0; i < workers.Count; i++)
            {
                if (workerId == workers[i].Id)
                {
                    payrate = Convert.ToDouble(workers[i].Payrate);
                }

            }

            for (int i = 0; i < shifts.Count; i++)
            {
                int z = Convert.ToInt32(shifts[i].WorkerId);
                if (workerId == z)
                {
                    totalHours += shifts[i].HoursWorked;
                }

            }

            double totalPay = payrate * totalHours;
            return totalPay;
        }

        /*
        Method: ToString Override

        Purpose: Overrides ToString upto your preference
        */
        public override string ToString()
        {
            string wrk = "";
            for (int i = 0; i < workers.Count; i++)
            {
                wrk += Convert.ToString(workers[i].Name + ", " + workers[i].Id + ", " + workers[i].Payrate + "\n");

            }

            string sft = "";
            for (int i = 0; i < shifts.Count; i++)
            {
                sft += Convert.ToString(shifts[i].WorkerId + ", " + shifts[i].HoursWorked + ", " + shifts[i].Date + "\n");

            }

            string s = name + "\n" + wrk + sft;
            return s;
        }

    }
}
