//******************************************************
// File: Worker.cs
//
// Purpose: Contains the functionalities for Workers Class. 
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
    public class Worker
    {

        private string name;
        private int id;
        private double payrate;

        public Worker()
        {
            name = "Stephen King";
            id = 2012;
            payrate = 18;


        }


        /*
        Method: C# Properties

        Purpose: Seriealizes with DataMember, and uses C# properies with get-set
        */

        [DataMember(Name = "id")]
        public int Id { get { return id; } set { id = value; } }
        [DataMember(Name = "name")]
        public string Name { get { return name; } set { name = value; } }
        [DataMember(Name = "payrate")]
        public double Payrate { get { return payrate; } set { payrate = value; } }

        /*
        Method: ToString Override

        Purpose: Overrides ToString upto your preference
        */
        override
            public string ToString()
        {
            string s = name + ", " + id + ", " + payrate + "\n";
            return s;

        }
    }
}
