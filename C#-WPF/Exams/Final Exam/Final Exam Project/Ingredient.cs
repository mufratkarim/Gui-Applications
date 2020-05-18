using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Final_Exam_Project
{
    [DataContract]
    public class Ingredient
    {
        private string name;
        private int quantity;
        private string unit;
        public Ingredient()
        {
            name = "Krispies";
            quantity = 10;
            unit = "cups";

        }
        [DataMember(Name = "name")]
        public string Name { get { return name; } set { name = value; } }
        [DataMember(Name = "quantity")]
        public int Quantity { get { return quantity; } set { quantity = value; } }
        [DataMember(Name = "unitofmeasurement")]
        public string UnitOfMeasurement { get { return unit; } set { unit = value; } }

        public override string ToString()
        {
            return name;
        }

    }
}
