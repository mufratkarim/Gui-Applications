using System;
using System.Collections.Generic;
using System.Data.SqlClient;
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

namespace LabDBInsert
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

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            string connString = @"server = (LocalDB)\MSSQLLocalDB;" +
			"integrated security = SSPI;" +
			"database = AdminDB";

            SqlConnection sqlConn;
            sqlConn = new SqlConnection(connString);

            sqlConn.Open(); // Open the connection
                            // Other code here…

            // Setup the SQL command
            string sql = "SELECT * FROM Users";
            SqlCommand command = new SqlCommand(sql, sqlConn);

            // Retrieve the data from the database
            SqlDataReader reader = command.ExecuteReader();

            //*************************************************
            // Associate the DataGrid with the SqlDataReader.
            // This will automatically populate the DataGrid.
            //*************************************************
            dataGridUsers.ItemsSource = reader;

        }

        private void buttonAdd_Click(object sender, RoutedEventArgs e)
        {
/*            string first = textBoxFirst.Text;
            string last = textBoxLast.Text;
            string email = textBoxEmail.Text;
            string sql = string.Format("INSERT INTO USERS" + "(First, Last, Email) Values" + "('{0}', '{1}', '{2}')", first, last, email);*/

        }
    }
}
