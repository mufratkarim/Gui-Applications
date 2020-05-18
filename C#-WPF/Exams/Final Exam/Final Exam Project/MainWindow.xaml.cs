using System;
using System.Collections.Generic;
using System.Data.SqlClient;
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

namespace Final_Exam_Project
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.Title = "Final Exam - Mufrat Karim Aritra";
        }

        private void mainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            string connString = @"server = (LocalDB)\MSSQLLocalDB;" +
            "integrated security = SSPI;" +
            "database = Ingredients";

            SqlConnection sqlConn;
            sqlConn = new SqlConnection(connString);

            sqlConn.Open(); // Open the connection
            // Other code here…

            string sql = "SELECT * FROM Ingredients";
            SqlCommand command = new SqlCommand(sql, sqlConn);

            // Retrieve the data from the database
            SqlDataReader reader = command.ExecuteReader();

            Ingredient i1; 

            while (reader.Read())
            {
                i1 = new Ingredient();

                i1.Name = Convert.ToString(reader["Name"]);
                i1.Quantity = Convert.ToInt32(reader["Quantity"]);
                i1.UnitOfMeasurement = Convert.ToString(reader["UnitOfMeasurement"]);

                listBoxIngredients.Items.Add(i1);
            }

        }

        private void listBoxIngredients_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            Ingredient i = (Ingredient)e.AddedItems[0];

            textBoxName.Text = i.Name;
            textBoxQuantity.Text = Convert.ToString(i.Quantity);
            textBoxUnit.Text = i.UnitOfMeasurement;


        }

        private void exitMenu_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void jsonMenu_Click(object sender, RoutedEventArgs e)
        {
            List<Ingredient> i3 = new List<Ingredient>();

            OpenFileDialog openFileDialog1 = new OpenFileDialog
            {
                InitialDirectory = System.IO.Directory.GetCurrentDirectory(),
                Title = "Open Ingredients from JSON",

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

                // Restoring as JSON
                FileStream reader = new FileStream(fileName, FileMode.Open, FileAccess.Read);

                DataContractJsonSerializer inputSerializer;
                inputSerializer = new DataContractJsonSerializer(typeof(List<Ingredient>));

                // Reading the JSON File
                i3 = (List<Ingredient>)inputSerializer.ReadObject(reader);

                reader.Close();

            }

            // Clearing the database and WPF

            string connString = @"server = (LocalDB)\MSSQLLocalDB;" +
                                            "integrated security = SSPI;" +
                                            "database = Ingredients";

            string sql = "DELETE FROM Ingredients";

            SqlConnection sqlConn;
            sqlConn = new SqlConnection(connString);
            sqlConn.Open();

            SqlCommand command = new SqlCommand(sql, sqlConn);
            listBoxIngredients.Items.Clear();
            int rowsAffected = command.ExecuteNonQuery();

            // Importing Data from Reader into Database and WPF

            for (int j = 0; j < i3.Count; j++)
            {
                int id = j;
                string name = i3[j].Name;
                int quantity = i3[j].Quantity;
                string unit = i3[j].UnitOfMeasurement;

                string sql2 = string.Format("INSERT INTO Ingredients" +
                        "(Id, Name, Quantity, UnitOfMeasurement) Values" +
                        "(@param1, @param2, @param3, @param4)");

                string connString2 = @"server = (LocalDB)\MSSQLLocalDB;" +
                    "integrated security = SSPI;" +
                    "database = Ingredients";

                SqlConnection sqlConn2 = new SqlConnection(connString2);
                sqlConn2.Open();

                SqlCommand command2 = new SqlCommand(sql2, sqlConn2);
                command2.Parameters.Add(new SqlParameter("@param1", id));
                command2.Parameters.Add(new SqlParameter("@param2", name));
                command2.Parameters.Add(new SqlParameter("@param3", quantity));
                command2.Parameters.Add(new SqlParameter("@param4", unit));

                command2.ExecuteNonQuery();
                listBoxIngredients.Items.Add(i3[j]);

            }

        }

        private void aboutMenu_Click(object sender, RoutedEventArgs e)
        {
            string message = "Ingredients\nVersion 1.0\nWritten by: Mufrat Karim Aritra";
            string title = "About Ingredients GUI";

            System.Windows.MessageBox.Show(message, title);

        }
    }
}
