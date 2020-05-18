using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_MasterDetail
{
    public class Movie
    {
        public string Name { get; set; }
        public int RotTmtScore { get; set; }
        public string Review { get; set; }
        public string picName { get; set; }
        public List<Actor> Actors { get; set; }

        public override string ToString()
        {
            return Name;
        }
    }
}
