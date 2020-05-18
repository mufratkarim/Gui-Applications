using Payroll_Solution;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace PayrollGUI_v1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {            
            InitializeComponent();
            this.Title = "Hwk4-PayrollGUI-v1 - Mufrat Karim Aritra";
        }

        Department d1 = new Department();

        private void openDptJSONbtn_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog
            {
                InitialDirectory = System.IO.Directory.GetCurrentDirectory(),
                Title = "Open Department from JSON",

                CheckFileExists = true,
                CheckPathExists = true,

                DefaultExt = "json",
                Filter = "json files (*.json)|*.json|All files (*.*)|*.*",
                FilterIndex = 1,
                RestoreDirectory = true,

                ReadOnlyChecked = true,
                ShowReadOnly = true
            };

            if (openFileDialog1.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                string fileName = openFileDialog1.FileName;
                textBoxFileName.Text = fileName;

                // Restoring as JSON
                FileStream reader = new FileStream(fileName, FileMode.Open, FileAccess.Read);

                DataContractJsonSerializer inputSerializer;
                inputSerializer = new DataContractJsonSerializer(typeof(Department));

                // Reading the JSON File
                d1 = (Department)inputSerializer.ReadObject(reader);
                reader.Close();

                textBoxDptName.Text = d1.Name;
                double totalHours = 0;
                double totalPay = 0;

                for (int i = 0; i < d1.Shifts.Count; i++)
                {
                    totalHours += d1.Shifts[i].HoursWorked;
                    d1.Shifts[i].Date.ToShortDateString();
                    listViewShifts.Items.Add(d1.Shifts[i]);


                }

                for (int i = 0; i < d1.Workers.Count; i++)
                {
                    totalPay += Convert.ToDouble(d1.CalculatePay(d1.Workers[i].Id));

                    listViewWorkers.Items.Add(d1.Workers[i]);

                }

                textBoxTotalWorkerHours.Text = Convert.ToString(totalHours);
                textBoxTotalWorkerPay.Text = Convert.ToString(totalPay);
                


            }




        }

        private void mainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            textBoxFileName.IsReadOnly = true;
            textBoxDptName.IsReadOnly = true;
            textBoxTotalWorkerHours.IsReadOnly = true;
            textBoxTotalWorkerPay.IsReadOnly = true;
            textBoxWorkerHours.IsReadOnly = true;
            textBoxWorkerName.IsReadOnly = true;
            textBoxWorkerId.IsReadOnly = true;
            textBoxWorkerPayRate.IsReadOnly = true;
            textBoxWorkerPay.IsReadOnly = true;

        }

        private void buttonFindWorker_Click(object sender, RoutedEventArgs e)
        {

            int workerId = Convert.ToInt32(textBoxTargetId.Text);
   
            if (d1.FindWorker(workerId) != null) {

                Worker w2 = d1.FindWorker(workerId);

                double WorkerHours = 0;
                for (int i = 0; i < d1.Shifts.Count; i++)
                {
                    int ShiftsWorkId = Convert.ToInt32(d1.Shifts[i].WorkerId);

                    if (ShiftsWorkId == workerId)
                    {
                        WorkerHours += d1.Shifts[i].HoursWorked;

                    }

                }


                textBoxWorkerName.Text = w2.Name;
                textBoxWorkerId.Text = Convert.ToString(w2.Id);
                textBoxWorkerPayRate.Text = Convert.ToString(w2.Payrate);
                textBoxWorkerHours.Text = Convert.ToString(WorkerHours);
                textBoxWorkerPay.Text = Convert.ToString(d1.CalculatePay(workerId));
            
            }
                
            else
            {
                textBoxTargetId.Text = "";
                textBoxWorkerName.Text = "";
                textBoxWorkerId.Text = "";
                textBoxWorkerPayRate.Text = "";
                textBoxWorkerHours.Text = "";
                textBoxWorkerPay.Text = "";
            }




        }
    }
}
