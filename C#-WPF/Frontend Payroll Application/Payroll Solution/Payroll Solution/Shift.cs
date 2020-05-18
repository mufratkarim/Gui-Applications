//******************************************************
// File: Shift.cs
//
// Purpose: Contains the functionalities for Shift Class. 
//          Functionalities include members, get/set methods and to String Statements 
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
    public class Shift
    {
        private string workerId;
        private double hoursWorked;
        private DateTime date;

        public Shift()
        {
            workerId = "007";
            hoursWorked = 35;
            date = new DateTime(2020, 4, 2).AddHours(12).AddMinutes(00).AddSeconds(00).AddMilliseconds(00);
        }

        /*
        Method: C# Properties

        Purpose: Seriealizes with DataMember, and uses C# properies with get-set
        */


        [DataMember(Name = "workid")]
        public string WorkerId { get { return workerId; } set { workerId = value; } }
        [DataMember(Name = "hoursworked")]
        public double HoursWorked { get { return hoursWorked; } set { hoursWorked = value; } }
        [DataMember(Name = "date")]
        public DateTime Date { get { return date; } set { date = value; } }


        /*
        Method: ToString Override

        Purpose: Overrides ToString upto your preference
        */
        override
            public string ToString()
        {
            string s = workerId + ", " + hoursWorked + ", " + date.Year + ", " + date.Month + ", " +
                date.Day + ", " + date.Hour + ", " + date.Minute + ", " + date.Second + ", " + 
                date.Millisecond + "\n";
            return s;

        }
    }
}
