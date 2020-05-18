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

namespace Lab_Task_WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private Object myLock = new Object();

        public MainWindow()
        {
            InitializeComponent();
        }

        private void CalculateFileSum(string filename)
        {

            int fileSum = 0;
            int num;

            // Adding all the numbers
            using (StreamReader sr = new StreamReader(filename))
            {
                while (!sr.EndOfStream)
                {
                    num = Convert.ToInt32(sr.ReadLine());
                    fileSum += num;
                }


            }

            lock(myLock)
            {
                int grandTotal = 0;

                // Gets the grand total
                Action getGrandTotalAction = delegate ()
                {
                    grandTotal = Convert.ToInt32(textBoxTotal.Text);
                };
                textBoxTotal.Dispatcher.Invoke(getGrandTotalAction);

                // Update the grand total
                grandTotal += fileSum;

                // Set the new Grand total
                Action setGrandTotalAction = delegate ()
                {
                    textBoxTotal.Text = grandTotal.ToString();
                };
                textBoxTotal.Dispatcher.Invoke(setGrandTotalAction);

            }
        }

        private void buttonCalculateTotal_Click(object sender, RoutedEventArgs e)
        {
            string fileName1 = textBoxFile1.Text;
            string fileName2 = textBoxFile2.Text;

            Action a1 = delegate (){ CalculateFileSum(fileName1);};
            Action a2 = delegate () { CalculateFileSum(fileName2); };

            Task t1 = new Task(a1);
            Task t2 = new Task(a2);

            t1.Start();
            t2.Start();
        }
    }
}
