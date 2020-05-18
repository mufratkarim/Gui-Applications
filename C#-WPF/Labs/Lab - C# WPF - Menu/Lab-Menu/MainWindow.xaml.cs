using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Lab_Menu
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void OpenMenuItem_Click(object sender, RoutedEventArgs e)
        {
            string filename = "TextFile1.txt";
            StreamReader sr = new StreamReader(filename);

            string id = sr.ReadLine();
            string dept = sr.ReadLine();

            idTextBox.Text = id;
            departmentTextBox.Text = dept;

            sr.Close();


        }

        private void ExitMenuItem_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void SaveMenuItem_Click(object sender, RoutedEventArgs e)
        {
            string fileName = "TextFile2.txt";

            StreamWriter sw = new StreamWriter(fileName);

            sw.WriteLine(idTextBox.Text);
            sw.WriteLine(departmentTextBox.Text);

            sw.Close();
        }

        private void AboutMenuItem_Click(object sender, RoutedEventArgs e)
        {



        }
    }
}
